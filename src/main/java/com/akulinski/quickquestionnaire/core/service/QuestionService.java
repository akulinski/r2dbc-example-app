package com.akulinski.quickquestionnaire.core.service;

import com.akulinski.quickquestionnaire.core.domain.Option;
import com.akulinski.quickquestionnaire.core.domain.Response;
import com.akulinski.quickquestionnaire.core.repository.IOptionRepository;
import com.akulinski.quickquestionnaire.core.repository.IQuestionRepository;
import com.akulinski.quickquestionnaire.core.repository.IResponseRepository;
import com.akulinski.quickquestionnaire.core.service.dto.OptionDTO;
import com.akulinski.quickquestionnaire.core.service.dto.QuestionDTO;
import com.akulinski.quickquestionnaire.core.service.dto.ResponseDTO;
import com.akulinski.quickquestionnaire.core.service.mappers.OptionMapper;
import com.akulinski.quickquestionnaire.core.service.mappers.QuestionMapper;
import com.akulinski.quickquestionnaire.core.service.mappers.ResponseMapper;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.HashSet;

@Service
@Slf4j
@RequiredArgsConstructor
public class QuestionService {

  private final IQuestionRepository questionRepository;

  private final IResponseRepository responseRepository;

  private final IOptionRepository optionRepository;

  private final QuestionMapper questionMapper;

  private final ResponseMapper responseMapper;

  private final OptionMapper optionMapper;

  public Mono<QuestionDTO> findById(@NonNull Long id) {
    final var questionDTOMono = questionRepository.findById(id).map(questionMapper::asDTO);

    final var listMono =
        optionRepository.findByQuestionId(id).map(optionMapper::asDTO).collectList();

    return questionDTOMono
        .zipWith(listMono)
        .map(
            t -> {
              t.getT1().setOptions(new HashSet<>(t.getT2()));
              return t.getT1();
            });
  }

  public Flux<QuestionDTO> findByQuestionnaireId(@NonNull Long questionnaireId) {
    return questionRepository.findByQuestionnaireId(questionnaireId).map(questionMapper::asDTO);
  }

  public Mono<Long> addResponse(ResponseDTO responseDTO) {

    final Response response = responseMapper.asDO(responseDTO);

    return responseRepository.save(response);
  }

  public Mono<Long> addOption(OptionDTO optionDTO) {
    final Option option = optionMapper.asDO(optionDTO);
    return optionRepository.save(option);
  }
}
