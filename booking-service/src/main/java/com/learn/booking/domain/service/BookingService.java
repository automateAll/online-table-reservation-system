package com.learn.booking.domain.service;

import com.learn.booking.domain.model.entity.Booking;
import com.learn.booking.domain.model.entity.Entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/**
 * @author Amandeep Singh
 */
public interface BookingService {

  /**
   * @param booking
   */
  public void add(Booking booking) throws Exception;

  /**
   * @param booking
   */
  public void update(Booking booking) throws Exception;

  /**
   * @param id
   */
  public void delete(String id) throws Exception;

  /**
   * @param id
   */
  public Entity findById(String id) throws Exception;

  /**
   * @param name
   */
  public Collection<Booking> findByName(String name) throws Exception;

  /**
   * @param name
   */
  public Collection<Booking> findByCriteria(Map<String, ArrayList<String>> name) throws Exception;
}
