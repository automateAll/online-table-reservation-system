package com.learn.user.domain.repository;

import com.learn.user.common.UserNotFoundException;
import com.learn.user.domain.model.entity.User;
import org.springframework.stereotype.Repository;

import java.util.AbstractMap;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static java.util.stream.Collectors.toList;

/**
 * @author Amandeep Singh
 */
@Repository("userRepository")
public class InMemUserRepository implements UserRepository<User, String> {

  private static final Map<String, User> entities;

  /**
   * Initialize the in-memory User Map
   */
  static {
    entities = new ConcurrentHashMap(Map.ofEntries(
        new AbstractMap
            .SimpleEntry("1", new User("1", "User Name 1", "Address 1", "City 1", "9999911111")),
        new AbstractMap
            .SimpleEntry("2", new User("1", "User Name 2", "Address 2", "City 2", "9999922222"))
    ));
  }

  /**
   * Check if given user name already exist.
   *
   * @param name
   * @return true if already exist, else false
   */
  @Override
  public boolean containsName(String name) {
    try {
      return !this.findByName(name).isEmpty();
    } catch (UserNotFoundException ex) {
      return false;
    } catch (Exception ex) {
      //Exception Handler
    }
    return false;
  }

  /**
   * @param entity
   */
  @Override
  public void add(User entity) {
    entities.put(entity.getId(), entity);
  }

  /**
   * @param id
   */
  @Override
  public void remove(String id) {
    if (entities.containsKey(id)) {
      entities.remove(id);
    }
  }

  /**
   * @param entity
   */
  @Override
  public void update(User entity) {
    if (entities.containsKey(entity.getId())) {
      entities.put(entity.getId(), entity);
    }
  }

  /**
   * @param id
   */
  @Override
  public boolean contains(String id) {
    throw new UnsupportedOperationException(
        "Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  /**
   * @param id
   */
  @Override
  public User get(String id) {
    return entities.get(id);
  }

  /**
   *
   * @return
   */
  @Override
  public Collection<User> getAll() {
    return entities.values();
  }

  /**
   * @param name
   */
  @Override
  public Collection<User> findByName(String name) throws Exception {
    int noOfChars = name.length();
    Collection<User> users = entities.entrySet()
        .stream()
        .filter(u -> u.getValue().getName().toLowerCase()
            .contains(name.toLowerCase().subSequence(0, noOfChars)))
        .collect(toList())
        .stream()
        .map(k -> k.getValue())
        .collect(toList());
    if (users != null && users.isEmpty()) {
      Object[] args = {name};
      throw new UserNotFoundException("userNotFound", args);
    }
    return users;
  }
}
