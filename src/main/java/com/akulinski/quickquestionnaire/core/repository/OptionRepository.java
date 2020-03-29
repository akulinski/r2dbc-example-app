package com.akulinski.quickquestionnaire.core.repository;

import com.akulinski.quickquestionnaire.core.domain.Option;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.r2dbc.core.DatabaseClient;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.springframework.data.r2dbc.query.Criteria.where;

@Repository
@Slf4j
@RequiredArgsConstructor
public class OptionRepository implements IOptionRepository {

  private final DatabaseClient databaseClient;

  @Override
  public Mono<Long> save(Option option) {
    return databaseClient
        .insert()
        .into(Option.class)
        .using(option)
        .fetch()
        .one()
        .map(q -> (Long) q.get("id"));
  }

  @Override
  public Flux<Option> findByQuestionId(Long questionId) {
    return databaseClient
        .select()
        .from(Option.class)
        .matching(where("question_id").is(questionId))
        .fetch()
        .all();
  }
}
