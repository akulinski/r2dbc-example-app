package com.akulinski.quickquestionnaire;

import lombok.extern.slf4j.Slf4j;
import org.junit.runner.Description;
import org.junit.runner.Result;
import org.junit.runner.notification.RunListener;

@Slf4j
public class PrintOutCurrentTestRunListener extends RunListener {

  @Override
  public void testRunStarted(Description description) throws Exception {
    log.info(
        String.format(
            "testRunStarted %s %s %s",
            description.getClassName(), description.getDisplayName(), description.toString()));
  }

  public void testStarted(Description description) throws Exception {
    log.info(String.format("testStarted %s", description.toString()));
  }

  public void testFinished(Description description) throws Exception {
    log.info(String.format("testFinished %s", description.toString()));
  }

  public void testRunFinished(Result result) throws Exception {
    log.info(
        String.format(
            "testRunFinished %s time:%d R%d F%d I%d",
            result.toString(),
            result.getRunTime(),
            result.getRunCount(),
            result.getFailureCount(),
            result.getIgnoreCount()));
  }
}
