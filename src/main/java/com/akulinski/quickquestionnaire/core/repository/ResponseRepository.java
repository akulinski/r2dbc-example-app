package com.akulinski.quickquestionnaire.core.repository;

import com.akulinski.quickquestionnaire.core.domain.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.data.r2dbc.core.DatabaseClient;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
@RequiredArgsConstructor
public class ResponseRepository implements IResponseRepository {
  private final DatabaseClient databaseClient;

  @Override
  public Mono<Long> save(Response response) {
    return databaseClient
        .insert()
        .into(Response.class)
        .using(response)
        .fetch()
        .one()
        .map(q -> (Long) q.get("id"));
  }
}
