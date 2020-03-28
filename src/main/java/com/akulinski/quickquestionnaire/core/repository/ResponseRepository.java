package com.akulinski.quickquestionnaire.core.repository;

import com.akulinski.quickquestionnaire.core.domain.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.data.r2dbc.core.DatabaseClient;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ResponseRepository implements IResponseRepository {
  private final DatabaseClient databaseClient;

  @Override
  public void save(Response response) {
    databaseClient.insert().into(Response.class).using(response);
  }
}
