package com.akulinski.quickquestionnaire.core.repository;

import com.akulinski.quickquestionnaire.core.domain.Option;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IOptionRepository {
  Mono<Long> save(Option option);

  Flux<Option> findByQuestionId(Long questionId);
}
