package com.akulinski.quickquestionnaire.core.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.Instant;

@Table("option")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Option {

  @Id @Column private Long id;

  @Column private Long questionId;

  @Column private String optionValue;

  @Column private Instant created;

  @Column private Instant modified;
}
