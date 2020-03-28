package com.akulinski.quickquestionnaire.core.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuestionnaireDTO {

  @Size(max = 1000, min = 1)
  private String description;

  @Size(max = 100, min = 1)
  private String poster;
}
