package com.akulinski.quickquestionnaire.core.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuestionDTO {

  private String questionContent;

  private String questionnaireId;

  private Set<OptionDTO> options;
}
