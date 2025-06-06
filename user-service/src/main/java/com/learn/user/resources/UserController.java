package com.learn.user.resources;

import com.learn.user.common.DuplicateUserException;
import com.learn.user.common.InvalidUserException;
import com.learn.user.common.UserNotFoundException;
import com.learn.user.domain.model.entity.Entity;
import com.learn.user.domain.model.entity.User;
import com.learn.user.domain.service.UserService;
import com.learn.user.domain.valueobject.UserVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Amandeep Singh
 */
@RestController
@RequestMapping("/v1/user")
public class UserController {

  /**
   *
   */
  protected static final Logger logger = Logger.getLogger(UserController.class.getName());

  /**
   *
   */
  protected UserService userService;

  /**
   * @param userService
   */
  @Autowired
  public UserController(UserService userService) {
    this.userService = userService;
  }

  /**
   * Fetch users with the specified name. A partial case-insensitive match is supported. So
   * <code>http://.../user/rest</code> will find any users with upper or lower case 'rest' in their
   * name.
   *
   * @param name
   * @return A non-null, non-empty collection of users.
   */
  @RequestMapping(method = RequestMethod.GET)
  public ResponseEntity<Collection<User>> findByName(@RequestParam("name") String name)
      throws Exception {
    logger.info(String
        .format("user-service findByName() invoked:{} for {} ", userService.getClass().getName(),
            name));
    name = name.trim().toLowerCase();
    Collection<User> users;
    try {
      users = userService.findByName(name);
    } catch (UserNotFoundException ex) {
      logger.log(Level.WARNING, "Exception raised findByName REST Call", ex);
      throw ex;
    } catch (Exception ex) {
      logger.log(Level.SEVERE, "Exception raised findByName REST Call", ex);
      throw ex;
    }
    return users.size() > 0 ? new ResponseEntity<>(users, HttpStatus.OK)
        : new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }

  /**
   * Fetch users with the given id. <code>http://.../v1/users/{id}</code> will return user with
   * given id.
   *
   * @param id
   * @return A non-null, non-empty collection of users.
   */
  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public ResponseEntity<Entity> findById(@PathVariable("id") String id) throws Exception {
    logger.info(String
        .format("user-service findById() invoked:{} for {} ", userService.getClass().getName(),
            id));
    id = id.trim();
    Entity user;
    try {
      user = userService.findById(id);
    } catch (Exception ex) {
      logger.log(Level.WARNING, "Exception raised findById REST Call {0}", ex);
      throw ex;
    }
    return user != null ? new ResponseEntity<>(user, HttpStatus.OK)
        : new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }

  /**
   * Add user with the specified information.
   *
   * @param userVO
   * @return A non-null user.
   */
  @RequestMapping(method = RequestMethod.POST)
  public ResponseEntity<User> add(@RequestBody UserVO userVO) throws Exception {
    logger.info(String
        .format("user-service add() invoked: %s for %s", userService.getClass().getName(),
            userVO.getName()));
    System.out.println(userVO);
    User user = User.getDummyUser();
    BeanUtils.copyProperties(userVO, user);
    try {
      userService.add(user);
    } catch (DuplicateUserException | InvalidUserException ex) {
      logger.log(Level.WARNING, "Exception raised add Restaurant REST Call {0}", ex);
      throw ex;
    } catch (Exception ex) {
      logger.log(Level.SEVERE, "Exception raised add Booking REST Call {0}", ex);
      throw ex;
    }
    return new ResponseEntity<>(HttpStatus.CREATED);
  }
}
