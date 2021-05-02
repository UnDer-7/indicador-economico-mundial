package com.gomes.mateus.backend.adapter.mapper;

import com.gomes.mateus.api.v1.country.dto.CountryDTO;
import com.gomes.mateus.api.v1.country.dto.IndicatorDTO;
import com.gomes.mateus.api.v1.shared.PageDTO;
import com.gomes.mateus.core.domain.country.Country;
import com.gomes.mateus.core.domain.country.Indicator;
import com.gomes.mateus.core.domain.shared.Page;
import java.util.Collection;
import org.mapstruct.Builder;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(
  componentModel = "CDI",
  injectionStrategy = InjectionStrategy.CONSTRUCTOR,
  builder = @Builder(disableBuilder = true)
)
public interface CountryMapper {
  Country fromCountryDTO(CountryDTO dto);
  Page<Country> fromCountryPageDTO(PageDTO<CountryDTO> entity);
  Collection<Country> fromCountryDTO(Collection<CountryDTO> dtos);

  CountryDTO toCountryDTO(Country entity);
  PageDTO<CountryDTO> toCountryPageDTO(Page<Country> entity);
  Collection<CountryDTO> toCountryDTO(Collection<Country> entities);

  Indicator fromIndicatorDTO(IndicatorDTO dto);
  Page<Indicator> fromIndicatorPageDTO(PageDTO<IndicatorDTO> dtos);
  Collection<Indicator> fromIndicatorDTO(Collection<IndicatorDTO> dtos);

  IndicatorDTO toIndicatorDTO(Indicator entity);
  PageDTO<IndicatorDTO> toIndicatorPageDTO(Page<Indicator> entity);
  Collection<IndicatorDTO> toIndicatorDTO(Collection<Indicator> entities);
}
