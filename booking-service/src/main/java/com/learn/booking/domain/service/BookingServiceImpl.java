package com.learn.booking.domain.service;

import com.learn.booking.common.DuplicateBookingException;
import com.learn.booking.common.InvalidBookingException;
import com.learn.booking.domain.model.entity.Booking;
import com.learn.booking.domain.model.entity.Entity;
import com.learn.booking.domain.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/**
 * @author Amandeep Singh
 */
@Service("bookingService")
public class BookingServiceImpl extends BaseService<Booking, String>
    implements BookingService {

  private BookingRepository<Booking, String> bookingRepository;

  /**
   * @param bookingRepository
   */
  @Autowired
  public BookingServiceImpl(BookingRepository<Booking, String> bookingRepository) {
    super(bookingRepository);
    this.bookingRepository = bookingRepository;
  }

  @Override
  public void add(Booking booking) throws Exception {
    Collection<Booking> existingBookings = bookingRepository.getAll();
    for (Booking existing : existingBookings) {
      if (existing.getName().equals(booking.getName()) &&
              existing.getRestaurantId().equals(booking.getRestaurantId()) &&
              existing.getDate().equals(booking.getDate()) &&
              existing.getTime().equals(booking.getTime())) {
        throw new DuplicateBookingException("duplicateBooking");
      }
    }

    if (booking.getName() == null || "".equals(booking.getName())) {
      Object[] args = {"Booking with null or empty name"};
      throw new InvalidBookingException("invalidBooking", args);
    }
    super.add(booking);
  }

  /**
   * @param name
   */
  @Override
  public Collection<Booking> findByName(String name) throws Exception {
    return bookingRepository.findByName(name);
  }

  /**
   * @param booking
   */
  @Override
  public void update(Booking booking) throws Exception {
    bookingRepository.update(booking);
  }

  /**
   * @param id
   */
  @Override
  public void delete(String id) throws Exception {
    bookingRepository.remove(id);
  }

  /**
   * @param id
   */
  @Override
  public Entity findById(String id) throws Exception {
    return bookingRepository.get(id);
  }

  /**
   * @param name
   */
  @Override
  public Collection<Booking> findByCriteria(Map<String, ArrayList<String>> name) throws Exception {
    throw new UnsupportedOperationException(
        "Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }
}
