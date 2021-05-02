package com.gomes.mateus.backend.adapter.resource;

import com.gomes.mateus.api.v1.country.CountryResource;
import com.gomes.mateus.backend.adapter.client.worldbank.CountryRestClient;
import com.gomes.mateus.test.Helpers;
import io.quarkus.test.common.http.TestHTTPEndpoint;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.mockito.InjectMock;
import io.restassured.RestAssured;
import io.restassured.filter.log.LogDetail;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.mockito.Mockito;

import javax.ws.rs.core.Response;

@QuarkusTest
@TestHTTPEndpoint(CountryResource.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CountryResourceITTest {
  @InjectMock
  @RestClient
  CountryRestClient countryClient;

  @BeforeEach
  void beforeEach() {
    Mockito.when(countryClient.listCountries(
      Mockito.anyLong(),
      Mockito.anyLong(),
      Mockito.anyString()
    )).thenReturn(Response.ok(Helpers.JSON_COUNTRY).build());

    Mockito.when(countryClient.searchIndicatorByCountry(
      Mockito.anyString(),
      Mockito.anyLong(),
      Mockito.anyLong(),
      Mockito.anyString()
    )).thenReturn(Response.ok(Helpers.JSON_INDICATORS).build());
  }

  @Test
  @Order(1)
  void deveListarPaisesComSucesso() {
   RestAssured
      .given()
      .queryParam("page", 3)
      .get()
      .then()
      .assertThat()
      .statusCode(200)
      .body("page", Matchers.equalTo(3))
      .body("pageTotal", Matchers.equalTo(30))
      .body("list", Matchers.hasSize(Matchers.greaterThan(0)))
      .body("list[0].id", Matchers.equalTo("ABW"))
      .log()
      .ifValidationFails(LogDetail.ALL);
  }


  @Test
  @Order(2)
  void deveListarIndicatorComSucesso() {
    RestAssured
      .given()
      .queryParam("page", 3)
      .get("indicators/BRA")
      .then()
      .assertThat()
      .statusCode(200)
      .body("page", Matchers.equalTo(3))
      .body("pageTotal", Matchers.equalTo(30))
      .body("list", Matchers.hasSize(Matchers.greaterThan(0)))
      .body("list[0].country.id", Matchers.equalTo("BR"))
      .log()
      .ifValidationFails(LogDetail.ALL);
  }

  @Test
  @Order(3)
  void testDeCacheNaoDeveChamarRestClientParaIndicadores() {
    RestAssured
      .given()
      .queryParam("page", 3)
      .get("indicators/BRA")
      .then()
      .assertThat()
      .statusCode(200)
      .body("page", Matchers.equalTo(3))
      .body("pageTotal", Matchers.equalTo(30))
      .body("list", Matchers.hasSize(Matchers.greaterThan(0)))
      .body("list[0].country.id", Matchers.equalTo("BR"))
      .log()
      .ifValidationFails(LogDetail.ALL);
    Mockito.verify(countryClient, Mockito.never())
      .searchIndicatorByCountry(
        Mockito.any(),
        Mockito.any(),
        Mockito.any(),
        Mockito.any()
      );
  }

  @Test
  @Order(4)
  void testDeCacheNaoDeveChamarRestClientParaCountries() {
    RestAssured
      .given()
      .queryParam("page", 3)
      .get()
      .then()
      .assertThat()
      .statusCode(200)
      .body("page", Matchers.equalTo(3))
      .body("pageTotal", Matchers.equalTo(30))
      .body("list", Matchers.hasSize(Matchers.greaterThan(0)))
      .body("list[0].id", Matchers.equalTo("ABW"))
      .log()
      .ifValidationFails(LogDetail.ALL);
    Mockito.verify(countryClient, Mockito.never())
      .listCountries(
        Mockito.any(),
        Mockito.any(),
        Mockito.any()
      );
  }
}
