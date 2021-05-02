package com.gomes.mateus.core.service;

import com.gomes.mateus.core.domain.country.Country;
import com.gomes.mateus.core.domain.country.Indicator;
import com.gomes.mateus.core.domain.shared.Page;
import com.gomes.mateus.core.domain.shared.Query;
import com.gomes.mateus.core.port.driven.CountryClient;
import com.gomes.mateus.core.port.driver.CountryService;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class CountryServiceTest {
  @Mock
  CountryClient countryClient;

  CountryService countryService;

  @BeforeEach
  void setUp() {
    countryService = new CountryServiceImpl(
      countryClient
    );
  }

  @Test
  void deveOrdenarListaDeIndicadoresCorretamente() {
    // GIVEN
    final var countryCode = "BRA";
    final var query = new Query(1L, 10L);
    final var paginaIndicadorForaDeOrdem = new Page<Indicator>(
      9L, 22L, 23L, 44L, buildListIndicador()
    );

    Mockito.when(countryClient.searchIndicatorByCountry(
      countryCode,
      query
    )).thenReturn(paginaIndicadorForaDeOrdem);

    // WHEN
    Page<Indicator> indicatorPage = countryService.searchIndicatorByCountry(countryCode, query);

    // THEN
    Assertions.assertEquals("2020", indicatorPage.getList().get(0).getDate());
    Assertions.assertEquals("2011", indicatorPage.getList().get(1).getDate());
    Assertions.assertEquals("1990", indicatorPage.getList().get(2).getDate());
  }

  private List<Indicator> buildListIndicador() {
    final var country1 = new Country("BRA", "Brazil");
    final var country2 = new Country("USA", "'Merica");
    final var country3 = new Country("JPA", "Japan");

    final var indicador1 = new Indicator(country1, "2020", Float.MAX_VALUE);
    final var indicador3 = new Indicator(country3, "1990", Float.MAX_VALUE);
    final var indicador2 = new Indicator(country2, "2011", Float.MAX_VALUE);

    return Arrays.asList(indicador1, indicador2, indicador3);
  }
}
