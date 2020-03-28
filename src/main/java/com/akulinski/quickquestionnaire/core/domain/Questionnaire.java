package com.akulinski.quickquestionnaire.core.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.Instant;

@Table("questionnaire")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Questionnaire {

  @Id @Column private Long id;

  @Column private String description;

  @Column private String poster;

  @Column private Instant created;

  @Column private Instant modified;
}
