package com.akulinski.quickquestionnaire.core.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.Instant;

@Table("response")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Response {

  @Id @Column private Long id;

  @Column("question_id")
  private String questionId;

  @Column private String poster;

  @Column private Instant created;

  @Column private Instant modified;
}
