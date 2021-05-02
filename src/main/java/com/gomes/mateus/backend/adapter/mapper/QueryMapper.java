package com.gomes.mateus.backend.adapter.mapper;

import com.gomes.mateus.api.v1.shared.QueryDTO;
import com.gomes.mateus.core.domain.shared.Query;
import org.mapstruct.Builder;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(
  componentModel = "CDI",
  injectionStrategy = InjectionStrategy.CONSTRUCTOR,
  builder = @Builder(disableBuilder = true)
)
public interface QueryMapper {
  Query fromDTO(QueryDTO dto);
}
