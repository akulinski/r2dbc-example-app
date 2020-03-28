package com.akulinski.quickquestionnaire.core.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.Instant;

@Table("question")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Question {

  @Id @Column private Long id;

  @Column("questionnaire_id")
  private Long questionnaireId;

  @Column("question_content")
  private String questionContent;

  @Column private Instant created;

  @Column private Instant modified;
}
