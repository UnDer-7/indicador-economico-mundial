package com.gomes.mateus.backend.adapter.client.worldbank;

import org.eclipse.microprofile.faulttolerance.Retry;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@RequestScoped
@Path("/v2/country")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@RegisterRestClient(configKey = "countryRestClient")
public interface CountryRestClient {
  @GET
  @Retry(maxRetries = 4)
  Response listCountries(
    @QueryParam("page") @DefaultValue("1") Long page,
    @QueryParam("per_page") @DefaultValue("10") Long pageSize,
    @QueryParam("format") @DefaultValue("json") String format
  );

  @GET
  @Path("/{countryCode}/indicator/SI.POV.DDAY")
  @Retry(maxRetries = 4)
  Response searchIndicatorByCountry(
    @PathParam("countryCode") String countryCode,
    @QueryParam("page") @DefaultValue("1") Long page,
    @QueryParam("per_page") @DefaultValue("10") Long pageSize,
    @QueryParam("format") @DefaultValue("json") String format
  );
}
