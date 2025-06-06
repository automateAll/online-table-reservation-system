package com.learn.restaurant.domain.model.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigInteger;

/**
 * @author Amandeep Singh
 */
public class Table extends BaseEntity<BigInteger> {

  private int capacity;

  /**
   * @param name
   * @param id
   * @param capacity
   */
  public Table(@JsonProperty("name") String name, @JsonProperty("id") BigInteger id,
      @JsonProperty("capacity") int capacity) {
    super(id, name);
    this.capacity = capacity;
  }

  /**
   *
   * @return
   */
  public int getCapacity() {
    return capacity;
  }

  /**
   * @param capacity
   */
  public void setCapacity(int capacity) {
    this.capacity = capacity;
  }

  /**
   * Overridden toString() method that return String presentation of the Object
   */
  @Override
  public String toString() {
    return String.format("{id: %s, name: %s, capacity: %s}",
        this.getId(), this.getName(), this.getCapacity());
  }

}
