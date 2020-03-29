package com.akulinski.quickquestionnaire.web.rest.v1;

import com.akulinski.quickquestionnaire.core.service.QuestionService;
import com.akulinski.quickquestionnaire.core.service.dto.OptionDTO;
import com.akulinski.quickquestionnaire.core.service.dto.QuestionDTO;
import com.akulinski.quickquestionnaire.core.service.dto.ResponseDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/v1/question")
@RestController
public class QuestionResource {

  private final QuestionService questionService;

  @GetMapping("/by-question-id/{id}")
  @ResponseStatus(HttpStatus.OK)
  public Mono<QuestionDTO> getById(@PathVariable Long id) {
    return questionService.findById(id);
  }

  @GetMapping("/by-questionnaire-id/{id}")
  @ResponseStatus(HttpStatus.OK)
  public Flux<QuestionDTO> getByQuestionnaireId(@PathVariable Long id) {
    return questionService.findByQuestionnaireId(id);
  }

  @PostMapping("/add-option")
  @ResponseStatus(HttpStatus.OK)
  public Mono<Long> addOption(@RequestBody OptionDTO optionDTO) {
    return questionService.addOption(optionDTO);
  }

  @PostMapping("/add-response")
  @ResponseStatus(HttpStatus.OK)
  public Mono<Long> addResponse(@RequestBody @Valid ResponseDTO responseDTO) {
    return questionService.addResponse(responseDTO);
  }
}
