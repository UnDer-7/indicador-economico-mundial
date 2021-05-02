package com.gomes.mateus.api.v1.country;

import com.gomes.mateus.api.v1.shared.PageDTO;
import com.gomes.mateus.api.v1.shared.QueryDTO;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/countries")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface CountryResource {

  @GET
  @Operation(summary = "List a page of countries")
  @APIResponse(
    responseCode = "200",
    content = @Content(
      mediaType = MediaType.APPLICATION_JSON,
      schema = @Schema(implementation = PageDTO.class)
    )
  )
  Response listCountries(@BeanParam QueryDTO queryDTO);

  @GET
  @Path("indicators/{countryCode}")
  @APIResponse(
    responseCode = "200",
    content = @Content(
      mediaType = MediaType.APPLICATION_JSON,
      schema = @Schema(implementation = PageDTO.class)
    )
  )
  Response searchIndicatorByCountry(@PathParam("countryCode") String countryCode, @BeanParam QueryDTO queryDTO);
}
