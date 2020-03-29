package com.akulinski.quickquestionnaire.core.repository;

import com.akulinski.quickquestionnaire.core.domain.Response;
import reactor.core.publisher.Mono;

public interface IResponseRepository {
    Mono<Long> save(Response response);
}
