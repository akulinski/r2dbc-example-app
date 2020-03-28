package com.akulinski.quickquestionnaire.core.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;
import java.util.Set;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Questionnaire {

  @Id private String id;

  private String description;

  @Indexed private String poster;

  @DBRef private Set<Question> questions;

  @CreatedDate private Instant created;

  @LastModifiedDate private Instant modified;
}
