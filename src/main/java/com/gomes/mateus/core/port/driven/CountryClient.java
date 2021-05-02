package com.gomes.mateus.core.port.driven;

import com.gomes.mateus.core.domain.country.Country;
import com.gomes.mateus.core.domain.country.Indicator;
import com.gomes.mateus.core.domain.shared.Page;
import com.gomes.mateus.core.domain.shared.Query;

public interface CountryClient {
  Page<Country> listCountries(Query query);

  Page<Indicator> searchIndicatorByCountry(String countryCode, Query query);
}
