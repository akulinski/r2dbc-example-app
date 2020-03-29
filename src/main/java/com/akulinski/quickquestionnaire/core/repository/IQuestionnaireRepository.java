package com.akulinski.quickquestionnaire.core.repository;

import com.akulinski.quickquestionnaire.core.domain.Questionnaire;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IQuestionnaireRepository extends BaseApplicationRepository<Questionnaire> {
  Mono<Questionnaire> findById(Long id);

  Flux<Questionnaire> findByPoster(String poster);

  Mono<Long> save(Questionnaire questionnaire);
}
