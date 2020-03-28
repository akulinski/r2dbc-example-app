package com.akulinski.quickquestionnaire.core.service;

import com.akulinski.quickquestionnaire.core.repository.QuestionnaireRepository;
import com.akulinski.quickquestionnaire.core.service.dto.QuestionDTO;
import com.akulinski.quickquestionnaire.core.service.dto.QuestionnaireDTO;
import com.akulinski.quickquestionnaire.core.service.mappers.QuestionMapper;
import com.akulinski.quickquestionnaire.core.service.mappers.QuestionnaireMapper;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
@Slf4j
public class QuestionnaireService {

  private final QuestionnaireRepository questionnaireRepository;

  private final QuestionnaireMapper questionnaireMapper;

  private final QuestionMapper questionMapper;

  public Mono<QuestionnaireDTO> createQuestionnaire(@NonNull QuestionnaireDTO questionnaireDTO) {
    return questionnaireRepository
        .save(questionnaireMapper.asDO(questionnaireDTO))
        .map(questionnaireMapper::asDTO);
  }

  public Mono<QuestionnaireDTO> addQuestionToQuestionnaire(@NonNull QuestionDTO questionDTO) {
    return questionnaireRepository
        .findById(questionDTO.getQuestionnaireId())
        .flatMap(
            questionnaire -> {
              questionnaire.getQuestions().add(questionMapper.asDO(questionDTO));
              return questionnaireRepository.save(questionnaire);
            })
        .map(questionnaireMapper::asDTO);
  }
}
