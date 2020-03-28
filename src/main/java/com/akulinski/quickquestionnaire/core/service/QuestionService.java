package com.akulinski.quickquestionnaire.core.service;

import com.akulinski.quickquestionnaire.core.domain.Response;
import com.akulinski.quickquestionnaire.core.repository.IQuestionRepository;
import com.akulinski.quickquestionnaire.core.repository.IResponseRepository;
import com.akulinski.quickquestionnaire.core.service.dto.QuestionDTO;
import com.akulinski.quickquestionnaire.core.service.dto.ResponseDTO;
import com.akulinski.quickquestionnaire.core.service.mappers.QuestionMapper;
import com.akulinski.quickquestionnaire.core.service.mappers.ResponseMapper;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Slf4j
@RequiredArgsConstructor
public class QuestionService {

  private final IQuestionRepository questionRepository;

  private final IResponseRepository responseRepository;

  private final QuestionMapper questionMapper;

  private final ResponseMapper responseMapper;

  public Mono<QuestionDTO> findById(@NonNull Long id) {
    return questionRepository.findById(id).map(questionMapper::asDTO);
  }

  public Flux<QuestionDTO> findByQuestionnaireId(@NonNull Long questionnaireId) {
    return questionRepository.findByQuestionnaireId(questionnaireId).map(questionMapper::asDTO);
  }

  public void addResponse(ResponseDTO responseDTO) {

    final Response response = responseMapper.asDO(responseDTO);

    responseRepository.save(response);
  }
}
