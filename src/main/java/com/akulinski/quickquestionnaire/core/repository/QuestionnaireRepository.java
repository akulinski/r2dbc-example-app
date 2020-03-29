package com.akulinski.quickquestionnaire.core.repository;

import com.akulinski.quickquestionnaire.core.domain.Questionnaire;
import lombok.RequiredArgsConstructor;
import org.springframework.data.r2dbc.core.DatabaseClient;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.springframework.data.r2dbc.query.Criteria.where;

@Repository
@RequiredArgsConstructor
public class QuestionnaireRepository implements IQuestionnaireRepository {

  private final DatabaseClient databaseClient;

  @Override
  public Mono<Questionnaire> findById(Long id) {
    return databaseClient
        .select()
        .from(Questionnaire.class)
        .matching(where("id").is(id))
        .fetch()
        .first();
  }

  @Override
  public Flux<Questionnaire> findByPoster(String poster) {
    return databaseClient
        .select()
        .from(Questionnaire.class)
        .matching(where("poster").like(poster))
        .fetch()
        .all();
  }

  @Override
  public Mono<Long> save(Questionnaire questionnaire) {
    return databaseClient
        .insert()
        .into(Questionnaire.class)
        .using(questionnaire)
        .fetch()
        .one()
        .map(q -> (Long) q.get("id"));
  }

  @Override
  public void delete(Questionnaire questionnaire) {
    databaseClient
        .delete()
        .from(Questionnaire.class)
        .matching(where("id").is(questionnaire.getId()))
        .fetch()
        .rowsUpdated()
        .subscribe();
  }
}
