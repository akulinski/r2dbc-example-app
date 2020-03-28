package com.akulinski.quickquestionnaire.core.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("question")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Question {

  @Id @Column private Long id;

  @Column private Long questionnaireId;

  @Column private String questionContent;
}
