package com.gomes.mateus.api.v1.shared;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.ws.rs.QueryParam;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QueryDTO {
  @QueryParam("page")
  private Long page;

  @QueryParam("pageSize")
  private Long pageSize;
}
