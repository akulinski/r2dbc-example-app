package com.akulinski.quickquestionnaire.core.repository;

import com.akulinski.quickquestionnaire.core.domain.Question;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.r2dbc.core.DatabaseClient;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.springframework.data.r2dbc.query.Criteria.where;

@Repository
@RequiredArgsConstructor
@Slf4j
public class QuestionRepository implements IQuestionRepository {
  private final DatabaseClient databaseClient;

  @Override
  public Mono<Question> findById(Long id) {
    return databaseClient
        .select()
        .from(Question.class)
        .matching(where("id").is(id))
        .fetch()
        .first();
  }

  @Override
  public Flux<Question> findByQuestionnaireId(Long id) {
    return databaseClient
        .select()
        .from(Question.class)
        .matching(where("questionnaireId").is(id))
        .fetch()
        .all();
  }

  @Override
  public Mono<Long> save(Question question) {
    return databaseClient
        .insert()
        .into(Question.class)
        .using(question)
        .fetch()
        .one()
        .map(q -> (Long) q.get("id"));
  }
}
