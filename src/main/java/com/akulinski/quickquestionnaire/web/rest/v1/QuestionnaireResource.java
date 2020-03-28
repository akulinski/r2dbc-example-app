package com.akulinski.quickquestionnaire.web.rest.v1;

import com.akulinski.quickquestionnaire.core.service.QuestionnaireService;
import com.akulinski.quickquestionnaire.core.service.dto.QuestionDTO;
import com.akulinski.quickquestionnaire.core.service.dto.QuestionnaireDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/v1/questionnaire")
@RestController
public class QuestionnaireResource {

  private final QuestionnaireService questionnaireService;

  @PostMapping
  @ResponseStatus(HttpStatus.OK)
  public Mono<Long> save(@RequestBody @Valid QuestionnaireDTO questionnaireDTO) {
    return questionnaireService.createQuestionnaire(questionnaireDTO);
  }

  @GetMapping("/poster/{poster}")
  @ResponseStatus(HttpStatus.OK)
  public Flux<QuestionnaireDTO> getAllQuestionnairesByPoster(@PathVariable String poster) {
    return questionnaireService.getAllQuestionnairesByPoster(poster);
  }

  @GetMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public Mono<QuestionnaireDTO> findById(@PathVariable Long id) {
    return questionnaireService.findById(id);
  }

  @PostMapping("/add-question")
  @ResponseStatus(HttpStatus.OK)
  public Mono<Long> addQuestion(@RequestBody @Valid QuestionDTO questionDTO) {
    return questionnaireService.addQuestionToQuestionnaire(questionDTO);
  }
}
