package com.akulinski.quickquestionnaire;

import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.testcontainers.containers.GenericContainer;

import java.util.concurrent.atomic.AtomicBoolean;

public class PostgresqlContainerExtension implements BeforeAllCallback {

  private static AtomicBoolean started = new AtomicBoolean(false);

  @Override
  public void beforeAll(ExtensionContext extensionContext) throws Exception {
    if (!started.get()) {

        GenericContainer postgres =
          new GenericContainer("postgres:12.2")
              .withExposedPorts(5432)
              .withEnv("POSTGRES_USER", "quickquestionnaire")
              .withEnv("POSTGRES_PASSWORD", "quickquestionnaire");

      postgres.start();

      System.setProperty(
          "spring.r2dbc.url",
          "r2dbc:postgresql://" + postgres.getContainerIpAddress() + "/quickquestionnaire");

      started.set(true);
    }
  }
}
