package com.akulinski.quickquestionnaire.core.service.mappers;

import com.akulinski.quickquestionnaire.core.domain.Response;
import com.akulinski.quickquestionnaire.core.service.dto.ResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.WARN)
public interface ResponseMapper {
  ResponseDTO asDTO(Response response);

  Response asDO(ResponseDTO responseDTO);
}
