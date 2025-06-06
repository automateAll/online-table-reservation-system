package com.learn.user.domain.service;

import com.learn.user.domain.model.entity.Entity;
import com.learn.user.domain.model.entity.User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/**
 * @author Amandeep Singh
 */
public interface UserService {

  /**
   * @param booking
   */
  public void add(User booking) throws Exception;

  /**
   * @param booking
   */
  public void update(User booking) throws Exception;

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
  public Collection<User> findByName(String name) throws Exception;

  /**
   * @param name
   */
  public Collection<User> findByCriteria(Map<String, ArrayList<String>> name) throws Exception;
}
