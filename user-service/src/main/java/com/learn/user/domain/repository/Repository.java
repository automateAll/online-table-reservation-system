package com.learn.user.domain.repository;

/**
 * @param <TE>
 * @param <T>
 * @author Amandeep Singh
 */
public interface Repository<TE, T> extends ReadOnlyRepository<TE, T> {

  /**
   * @param entity
   */
  void add(TE entity);

  /**
   * @param id
   */
  void remove(T id);

  /**
   * @param entity
   */
  void update(TE entity);
}
