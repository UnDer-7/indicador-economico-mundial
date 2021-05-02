package com.gomes.mateus.core.domain.country;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Country {
  private String id;
  private String name;

  public Country(
    final String id,
    final String name) {
    // todo: colocar asserts
    this.id = id;
    this.name = name;
  }
}
