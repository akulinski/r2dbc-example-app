package com.akulinski.quickquestionnaire.core.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseDTO {

  private String questionId;

  private String poster;

  private Long optionId;
}
