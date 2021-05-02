package com.gomes.mateus.api.v1.shared;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
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
public final class PageDTO<T> implements Serializable {
  private static final long serialVersionUID = -2637944517946789136L;

  private Long page;

  @JsonAlias("pages")
  private Long pageTotal;

  @JsonAlias("per_page")
  private Long pageSize;

  private Long total;

  private List<T> list = new ArrayList<>();
}
