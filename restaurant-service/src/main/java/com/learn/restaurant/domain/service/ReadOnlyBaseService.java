package com.learn.restaurant.domain.service;

import com.learn.restaurant.domain.repository.ReadOnlyRepository;

/**
 * @param <TE>
 * @param <T>
 * @author Amandeep Singh
 */
public abstract class ReadOnlyBaseService<TE, T> {

  private ReadOnlyRepository<TE, T> repository;

  ReadOnlyBaseService(ReadOnlyRepository<TE, T> repository) {
    this.repository = repository;
  }
}
