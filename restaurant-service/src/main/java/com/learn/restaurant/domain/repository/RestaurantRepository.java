package com.learn.restaurant.domain.repository;

import java.util.Collection;

/**
 * @param <Restaurant>
 * @param <String>
 * @author Amandeep Singh
 */
public interface RestaurantRepository<Restaurant, String> extends Repository<Restaurant, String> {

  /**
   * @param name
   */
  boolean containsName(String name);

  /**
   * @param name
   */
  public Collection<Restaurant> findByName(String name) throws Exception;
}
