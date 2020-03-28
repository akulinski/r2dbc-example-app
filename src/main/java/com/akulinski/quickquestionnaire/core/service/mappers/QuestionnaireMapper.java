package com.akulinski.quickquestionnaire.core.service.mappers;

import com.akulinski.quickquestionnaire.core.domain.Questionnaire;
import com.akulinski.quickquestionnaire.core.service.dto.QuestionnaireDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.WARN)
public interface QuestionnaireMapper {

  QuestionnaireDTO asDTO(Questionnaire questionnaire);

  Questionnaire asDO(QuestionnaireDTO questionnaireDTO);
}
