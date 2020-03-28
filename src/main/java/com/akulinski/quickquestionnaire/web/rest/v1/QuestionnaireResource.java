package com.akulinski.quickquestionnaire.web.rest.v1;

import com.akulinski.quickquestionnaire.core.service.QuestionnaireService;
import com.akulinski.quickquestionnaire.core.service.dto.QuestionDTO;
import com.akulinski.quickquestionnaire.core.service.dto.QuestionnaireDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
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
  public Mono<QuestionnaireDTO> save(@RequestBody @Valid QuestionnaireDTO questionnaireDTO) {
    return questionnaireService.createQuestionnaire(questionnaireDTO);
  }

  @PostMapping("/add-question")
  @ResponseStatus(HttpStatus.OK)
  public Mono<QuestionnaireDTO> addQuestion(@RequestBody @Valid QuestionDTO questionDTO) {
    return questionnaireService.addQuestionToQuestionnaire(questionDTO);
  }
}
