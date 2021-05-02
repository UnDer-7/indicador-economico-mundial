package com.gomes.mateus.api.v1.country.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class IndicatorDTO implements Serializable {
  private static final long serialVersionUID = -772074270737135119L;

  private CountryDTO country;
  private String date;
}
