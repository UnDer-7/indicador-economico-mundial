package com.gomes.mateus.core.domain.shared;

import java.util.List;

public abstract class Page<T> {
  private Long page;
  private Long pages;
  private Long pageSize;
  private Long total;
  private List<T> list;
}
