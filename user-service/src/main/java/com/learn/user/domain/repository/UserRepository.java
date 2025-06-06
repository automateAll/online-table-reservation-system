package com.learn.user.domain.repository;

import java.util.Collection;

/**
 * @param <User>
 * @param <String>
 * @author Amandeep Singh
 */
public interface UserRepository<Booking, String> extends Repository<Booking, String> {

  /**
   * @param name
   */
  boolean containsName(String name);

  /**
   * @param name
   */
  public Collection<Booking> findByName(String name) throws Exception;
}
