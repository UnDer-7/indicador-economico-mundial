package com.gomes.mateus.core.domain.country;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Indicator {
  private Country country;
  private String date;

  public Indicator(
    final Country country,
    final String date) {
    // todo: colocar asserts
    this.country = country;
    this.date = date;
  }
}
