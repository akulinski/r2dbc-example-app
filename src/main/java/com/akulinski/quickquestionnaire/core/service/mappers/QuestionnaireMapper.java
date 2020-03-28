package com.akulinski.quickquestionnaire.core.service.mappers;

import com.akulinski.quickquestionnaire.core.domain.Questionnaire;
import com.akulinski.quickquestionnaire.core.service.dto.QuestionDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.WARN)
public interface QuestionnaireMapper {

  QuestionDTO asDTO(Questionnaire questionnaire);

  Questionnaire asDO(QuestionDTO questionDTO);
}
