package com.gomes.mateus.core.domain.shared;

import java.util.List;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class Page<T> {
  private Long page;
  private Long pageTotal;
  private Long pageSize;
  private Long total;
  private List<T> list;

  public Page(
    final Long page,
    final Long pageTotal,
    final Long pageSize,
    final Long total,
    final List<T> list) {
    // todo: colocar asserts

    this.page = page;
    this.pageTotal = pageTotal;
    this.pageSize = pageSize;
    this.total = total;
    this.list = list;
  }
}
