package com.akulinski.quickquestionnaire.core.service.mappers;

import com.akulinski.quickquestionnaire.core.domain.Option;
import com.akulinski.quickquestionnaire.core.service.dto.OptionDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.WARN)
public interface OptionMapper {
    OptionDTO asDTO(Option option);

    Option asDO(OptionDTO optionDTO);
}
