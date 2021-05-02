package com.gomes.mateus.backend.adapter.client.worldbank;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.gomes.mateus.api.v1.country.dto.CountryDTO;
import com.gomes.mateus.api.v1.country.dto.IndicatorDTO;
import com.gomes.mateus.api.v1.shared.PageDTO;
import com.gomes.mateus.backend.adapter.mapper.CountryMapper;
import com.gomes.mateus.core.domain.country.Country;
import com.gomes.mateus.core.domain.country.Indicator;
import com.gomes.mateus.core.domain.shared.Page;
import com.gomes.mateus.core.domain.shared.Query;
import com.gomes.mateus.core.port.driven.CountryClient;
import io.quarkus.cache.CacheResult;
import java.util.List;
import lombok.SneakyThrows;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.core.MediaType;

@RequestScoped
public class CountryClientImpl implements CountryClient {
  final CountryRestClient countryRestClient;
  final CountryMapper countryMapper;

  private final ObjectMapper objectMapper = new ObjectMapper();

  @Inject
  public CountryClientImpl(
    @RestClient final CountryRestClient countryRestClient,
    final CountryMapper countryMapper) {
    this.countryRestClient = countryRestClient;
    this.countryMapper = countryMapper;
  }

  @Override
  @SneakyThrows
  @CacheResult(cacheName = "list-countries")
  public Page<Country> listCountries(final Query query) {
    final var response = countryRestClient.listCountries(
      query.getPage(),
      query.getPageSize(),
      MediaType.APPLICATION_JSON_TYPE.getSubtype()
    );
    final var countriesJson = response.readEntity(String.class);
    final var arrayNode = objectMapper.readValue(countriesJson, ArrayNode.class);

    final var countryPage = objectMapper.readValue(
      arrayNode.get(0).toString(),
      new TypeReference<PageDTO<CountryDTO>>() {}
    );

    final var countries = objectMapper.readValue(
      arrayNode.get(1).toString(),
      new TypeReference<List<CountryDTO>>() {}
    );
    countryPage.setList(countries);

    return countryMapper.fromCountryPageDTO(countryPage);
  }

  @Override
  @SneakyThrows
  @CacheResult(cacheName = "search-indicator-by-country")
  public Page<Indicator> searchIndicatorByCountry(final String countryCode, final Query query) {
    final var response = countryRestClient.searchIndicatorByCountry(
      countryCode,
      query.getPage(),
      query.getPageSize(),
      MediaType.APPLICATION_JSON_TYPE.getSubtype()
    );
    final var indicatorsJson = response.readEntity(String.class);
    final var arrayNode = objectMapper.readValue(indicatorsJson, ArrayNode.class);

    final var indicatorPage = objectMapper.readValue(
      arrayNode.get(0).toString(),
      new TypeReference<PageDTO<IndicatorDTO>>() {}
    );

    final var indicators = objectMapper.readValue(
      arrayNode.get(1).toString(),
      new TypeReference<List<IndicatorDTO>>() {}
    );
    indicatorPage.setList(indicators);

    return countryMapper.fromIndicatorPageDTO(indicatorPage);
  }
}
