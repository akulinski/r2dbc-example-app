package com.akulinski.quickquestionnaire.core.repository;

import com.akulinski.quickquestionnaire.core.domain.Question;
import com.akulinski.quickquestionnaire.core.domain.Questionnaire;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IQuestionRepository {
    Mono<Question> findById(Long id);

    Flux<Question> findByQuestionnaireId(Long id);

    Mono<Long> save(Question question);
}
