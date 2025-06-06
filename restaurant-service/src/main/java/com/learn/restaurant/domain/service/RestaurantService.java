package com.learn.restaurant.domain.service;

import com.learn.restaurant.domain.model.entity.Entity;
import com.learn.restaurant.domain.model.entity.Restaurant;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/**
 * @author Amandeep Singh
 */
public interface RestaurantService {

  /**
   * @param restaurant
   */
  public void add(Restaurant restaurant) throws Exception;

  /**
   * @param restaurant
   */
  public void update(Restaurant restaurant) throws Exception;

  /**
   * @param id
   */
  public void delete(String id) throws Exception;

  /**
   * @param restaurantId
   */
  public Entity findById(String restaurantId) throws Exception;

  /**
   * @param name
   */
  public Collection<Restaurant> findByName(String name) throws Exception;

  /**
   * @param name
   */
  public Collection<Restaurant> findByCriteria(Map<String, ArrayList<String>> name)
      throws Exception;
}
