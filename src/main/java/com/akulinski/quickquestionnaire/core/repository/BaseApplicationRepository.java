package com.akulinski.quickquestionnaire.core.repository;

import reactor.core.publisher.Mono;

public interface BaseApplicationRepository<T> {

  Mono<Long> save(T t);

  void delete(T t);

  Mono<T> findById(Long id);
}
