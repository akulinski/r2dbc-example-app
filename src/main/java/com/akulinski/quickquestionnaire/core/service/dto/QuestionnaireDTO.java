package com.akulinski.quickquestionnaire.core.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuestionnaireDTO {

  private String description;

  private String poster;

  private Set<QuestionDTO> questions;
}
