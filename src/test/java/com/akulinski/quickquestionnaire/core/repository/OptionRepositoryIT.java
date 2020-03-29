package com.akulinski.quickquestionnaire.core.repository;

import com.akulinski.quickquestionnaire.PostgresqlContainerExtension;
import com.akulinski.quickquestionnaire.core.domain.Option;
import com.akulinski.quickquestionnaire.core.domain.Question;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.time.Instant;

@SpringBootTest
@ExtendWith(PostgresqlContainerExtension.class)
@TestPropertySource(
        locations = "classpath:application.yaml")
class OptionRepositoryIT {

  @Autowired private OptionRepository optionRepository;

  @Autowired private QuestionRepository questionRepository;

  @BeforeEach
  void setUp() {}

  @Test
  void save() {
    Option option = new Option();
    option.setCreated(Instant.now());
    option.setModified(Instant.now());
    option.setOptionValue("test");

    final var block = optionRepository.save(option).block();

    final var fromDb = optionRepository.findById(block).block().getId();

    Assert.assertEquals(block, fromDb);
  }

  @Test
  void findByQuestionId() {

    Question question = new Question();
    question.setQuestionContent("test");
    final var blockQuestion = questionRepository.save(question).block();

    Option option = new Option();
    option.setCreated(Instant.now());
    option.setModified(Instant.now());
    option.setOptionValue("test");
    option.setQuestionId(blockQuestion);
    final var block = optionRepository.save(option).block();

    final var fromDb = optionRepository.findByQuestionId(blockQuestion).blockFirst();
    Assert.assertEquals(block, fromDb.getId());
  }
}
