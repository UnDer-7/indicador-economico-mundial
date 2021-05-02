package com.gomes.mateus.backend.adapter.resource;

import com.gomes.mateus.api.v1.country.CountryResource;
import com.gomes.mateus.api.v1.shared.QueryDTO;
import com.gomes.mateus.backend.adapter.mapper.CountryMapper;
import com.gomes.mateus.backend.adapter.mapper.QueryMapper;
import com.gomes.mateus.core.port.driver.CountryService;
import lombok.RequiredArgsConstructor;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.core.Response;

@RequestScoped
@RequiredArgsConstructor
public class CountryResourceImpl implements CountryResource {
  final QueryMapper queryMapper;
  final CountryMapper countryMapper;
  final CountryService countryService;

  @Override
  public Response listCountries(final QueryDTO queryDTO) {
    final var query = queryMapper.fromDTO(queryDTO);
    final var countries = countryMapper.toCountryPageDTO(
      countryService.listCountries(query)
    );

    return Response.ok(countries).build();
  }

  @Override
  public Response searchIndicatorByCountry(final String countryCode, final QueryDTO queryDTO) {
    final var query = queryMapper.fromDTO(queryDTO);
    final var indicators = countryMapper.toIndicatorPageDTO(
      countryService.searchIndicatorByCountry(countryCode, query)
    );

    return Response.ok(indicators).build();
  }
}
