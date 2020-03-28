package com.akulinski.quickquestionnaire.core.service.mappers;

import com.akulinski.quickquestionnaire.core.domain.Question;
import com.akulinski.quickquestionnaire.core.service.dto.QuestionDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.WARN)
public interface QuestionMapper {

  QuestionDTO asDTO(Question question);

  Question asDO(QuestionDTO questionDTO);
}
