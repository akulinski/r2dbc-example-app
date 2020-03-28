package com.akulinski.quickquestionnaire.core.repository;

import com.akulinski.quickquestionnaire.core.domain.Questionnaire;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface QuestionnaireRepository extends ReactiveMongoRepository<Questionnaire, String> {
  Flux<Questionnaire> findByPoster(String poster);
}
