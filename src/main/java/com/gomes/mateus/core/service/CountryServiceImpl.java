package com.gomes.mateus.core.service;

import com.gomes.mateus.core.domain.country.Country;
import com.gomes.mateus.core.domain.country.Indicator;
import com.gomes.mateus.core.domain.shared.Page;
import com.gomes.mateus.core.domain.shared.Query;
import com.gomes.mateus.core.port.driven.CountryClient;
import com.gomes.mateus.core.port.driver.CountryService;
import lombok.RequiredArgsConstructor;

import javax.enterprise.context.RequestScoped;

@RequestScoped
@RequiredArgsConstructor
public class CountryServiceImpl implements CountryService {
  final CountryClient countryClient;

  @Override
  public Page<Country> listCountries(final Query query) {
    return countryClient.listCountries(query);
  }

  @Override
  public Page<Indicator> searchIndicatorByCountry(final String countryCode, final Query query) {
    return countryClient.searchIndicatorByCountry(countryCode, query);
  }
}
