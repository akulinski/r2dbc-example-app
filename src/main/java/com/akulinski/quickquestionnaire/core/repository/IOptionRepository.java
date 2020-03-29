package com.akulinski.quickquestionnaire.core.repository;

import com.akulinski.quickquestionnaire.core.domain.Option;
import reactor.core.publisher.Flux;

public interface IOptionRepository extends BaseApplicationRepository<Option> {

  Flux<Option> findByQuestionId(Long questionId);
}
