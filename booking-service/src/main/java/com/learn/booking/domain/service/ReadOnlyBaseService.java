package com.learn.booking.domain.service;

import com.learn.booking.domain.repository.ReadOnlyRepository;

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
