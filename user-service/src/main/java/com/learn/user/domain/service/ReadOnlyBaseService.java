package com.learn.user.domain.service;

import com.learn.user.domain.repository.ReadOnlyRepository;

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
