package com.learn.booking.resources;

import com.learn.booking.common.BookingNotFoundException;
import com.learn.booking.common.DuplicateBookingException;
import com.learn.booking.common.InvalidBookingException;
import com.learn.booking.domain.model.entity.Booking;
import com.learn.booking.domain.model.entity.Entity;
import com.learn.booking.domain.service.BookingService;
import com.learn.booking.domain.valueobject.BookingVO;
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
@RequestMapping("/v1/booking")
public class BookingController {

  /**
   *
   */
  protected static final Logger logger = Logger.getLogger(BookingController.class.getName());

  /**
   *
   */
  protected BookingService bookingService;

  /**
   * @param bookingService
   */
  @Autowired
  public BookingController(BookingService bookingService) {
    this.bookingService = bookingService;
  }

  /**
   * Fetch bookings with the specified name. A partial case-insensitive match is supported. So
   * <code>http://.../booking/rest</code> will find any bookings with upper or lower case 'rest' in
   * their name.
   *
   * @param name
   * @return A non-null, non-empty collection of bookings.
   */
  @RequestMapping(method = RequestMethod.GET)
  public ResponseEntity<Collection<Booking>> findByName(@RequestParam("name") String name)
      throws Exception {
    logger.info(String.format("booking-service findByName() invoked:{} for {} ",
        bookingService.getClass().getName(), name));
    name = name.trim().toLowerCase();
    Collection<Booking> bookings;
    try {
      bookings = bookingService.findByName(name);
    } catch (BookingNotFoundException ex) {
      logger.log(Level.WARNING, "Exception raised findByName REST Call", ex);
      throw ex;
    } catch (Exception ex) {
      logger.log(Level.SEVERE, "Exception raised findByName REST Call", ex);
      throw ex;
    }
    return bookings.size() > 0 ? new ResponseEntity<>(bookings, HttpStatus.OK)
        : new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }

  /**
   * Fetch bookings with the given id.
   * <code>http://.../v1/bookings/{id}</code> will return booking with given
   * id.
   *
   * @param id
   * @return A non-null, non-empty collection of bookings.
   */
  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public ResponseEntity<Entity> findById(@PathVariable("id") String id) throws Exception {
    logger.info(String.format("booking-service findById() invoked:{} for {} ",
        bookingService.getClass().getName(), id));
    id = id.trim();
    Entity booking;
    try {
      booking = bookingService.findById(id);
    } catch (Exception ex) {
      logger.log(Level.SEVERE, "Exception raised findById REST Call {0}", ex);
      throw ex;
    }
    return booking != null ? new ResponseEntity<>(booking, HttpStatus.OK)
        : new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }

  /**
   * Add booking with the specified information.
   *
   * @param bookingVO
   * @return A non-null booking.
   */
  @RequestMapping(method = RequestMethod.POST)
  public ResponseEntity<Booking> add(@RequestBody BookingVO bookingVO) throws Exception {
    logger.info(String
        .format("booking-service add() invoked: %s for %s", bookingService.getClass().getName(),
            bookingVO.getName()));
    System.out.println(bookingVO);
    Booking booking = Booking.getDummyBooking();
    BeanUtils.copyProperties(bookingVO, booking);
    try {
      bookingService.add(booking);
    } catch (DuplicateBookingException | InvalidBookingException ex) {
      logger.log(Level.WARNING, "Exception raised add Restaurant REST Call {0}", ex);
      throw ex;
    } catch (Exception ex) {
      logger.log(Level.SEVERE, "Exception raised add Booking REST Call {0}", ex);
      throw ex;
    }
    return new ResponseEntity<>(booking,HttpStatus.CREATED);
  }
}
