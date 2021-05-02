package com.gomes.mateus.core.domain.shared;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@EqualsAndHashCode
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Query {
  private Long page;
  private Long pageSize;

  public Query(Long page, Long pageSize) {
    // todo: colocar assers
    this.page = page;
    this.pageSize = pageSize;
  }
}
