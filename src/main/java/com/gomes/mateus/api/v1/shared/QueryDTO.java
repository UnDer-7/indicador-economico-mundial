package com.gomes.mateus.api.v1.shared;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.QueryParam;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class QueryDTO implements Serializable {
  private static final long serialVersionUID = -1930489333738193343L;

  @DefaultValue("1")
  @QueryParam("page")
  private Long page;

  @DefaultValue("15")
  @QueryParam("pageSize")
  private Long pageSize;
}
