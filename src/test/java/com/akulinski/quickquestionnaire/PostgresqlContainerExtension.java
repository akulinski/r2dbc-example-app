package com.akulinski.quickquestionnaire;

import liquibase.Liquibase;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.testcontainers.containers.GenericContainer;

import java.util.concurrent.atomic.AtomicBoolean;

@Slf4j
public class PostgresqlContainerExtension implements BeforeAllCallback {

  private static AtomicBoolean started = new AtomicBoolean(false);

  @Override
  public void beforeAll(ExtensionContext extensionContext) {
    if (!started.get()) {

      log.info("Starting POSTGERES container");

      GenericContainer postgres =
          new GenericContainer("postgres:12.2")
              .withExposedPorts(5432)
              .withEnv("POSTGRES_USER", "quickquestionnaire")
              .withEnv("POSTGRES_PASSWORD", "quickquestionnaire")
              .withEnv("POSTGRES_DB", "quickquestionnaire");

      postgres.start();

      log.info("POSTGERES started with ip {}", postgres.getContainerIpAddress());

      final var address =
          "r2dbc:postgresql://" + postgres.getContainerIpAddress() + "/quickquestionnaire";

      log.info("Address {}", address);
      System.setProperty("spring.r2dbc.url", address);
      started.set(true);
    }
  }
}
