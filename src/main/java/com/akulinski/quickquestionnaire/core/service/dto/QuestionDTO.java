package com.akulinski.quickquestionnaire.core.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Size;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuestionDTO {

  @Size(max = 1000, min = 1)
  private String questionContent;

  @Size(max = 1000, min = 1)
  private String questionnaireId;

  private Set<OptionDTO> options;
}
