package com.akulinski.quickquestionnaire.core.service;

import com.akulinski.quickquestionnaire.core.domain.Question;
import com.akulinski.quickquestionnaire.core.repository.IQuestionRepository;
import com.akulinski.quickquestionnaire.core.repository.IQuestionnaireRepository;
import com.akulinski.quickquestionnaire.core.service.dto.QuestionDTO;
import com.akulinski.quickquestionnaire.core.service.dto.QuestionnaireDTO;
import com.akulinski.quickquestionnaire.core.service.mappers.QuestionMapper;
import com.akulinski.quickquestionnaire.core.service.mappers.QuestionnaireMapper;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
@Slf4j
public class QuestionnaireService {

  private final IQuestionnaireRepository questionnaireRepository;

  private final IQuestionRepository questionRepository;

  private final QuestionnaireMapper questionnaireMapper;

  private final QuestionMapper questionMapper;

  public Mono<Long> createQuestionnaire(@NonNull QuestionnaireDTO questionnaireDTO) {
    return questionnaireRepository.save(questionnaireMapper.asDO(questionnaireDTO));
  }

  public Mono<Long> addQuestionToQuestionnaire(@NonNull QuestionDTO questionDTO) {
    final Question question = questionMapper.asDO(questionDTO);
    return questionRepository.save(question);
  }

  public Flux<QuestionnaireDTO> getAllQuestionnairesByPoster(@NonNull String poster) {
    return questionnaireRepository.findByPoster(poster).map(questionnaireMapper::asDTO);
  }

  public Mono<QuestionnaireDTO> findById(@NonNull Long id) {
    return questionnaireRepository.findById(id).map(questionnaireMapper::asDTO);
  }
}
