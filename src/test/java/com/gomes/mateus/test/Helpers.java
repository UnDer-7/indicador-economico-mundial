package com.gomes.mateus.test;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class Helpers {
  public static final String JSON_COUNTRY = "[\n" +
    "  {\n" +
    "    \"page\": 3,\n" +
    "    \"pages\": 30,\n" +
    "    \"per_page\": \"10\",\n" +
    "    \"total\": 297\n" +
    "  },\n" +
    "  [\n" +
    "    {\n" +
    "      \"id\": \"ABW\",\n" +
    "      \"iso2Code\": \"AW\",\n" +
    "      \"name\": \"Aruba\",\n" +
    "      \"region\": {\n" +
    "        \"id\": \"LCN\",\n" +
    "        \"iso2code\": \"ZJ\",\n" +
    "        \"value\": \"Latin America & Caribbean \"\n" +
    "      },\n" +
    "      \"adminregion\": {\n" +
    "        \"id\": \"\",\n" +
    "        \"iso2code\": \"\",\n" +
    "        \"value\": \"\"\n" +
    "      },\n" +
    "      \"incomeLevel\": {\n" +
    "        \"id\": \"HIC\",\n" +
    "        \"iso2code\": \"XD\",\n" +
    "        \"value\": \"High income\"\n" +
    "      },\n" +
    "      \"lendingType\": {\n" +
    "        \"id\": \"LNX\",\n" +
    "        \"iso2code\": \"XX\",\n" +
    "        \"value\": \"Not classified\"\n" +
    "      },\n" +
    "      \"capitalCity\": \"Oranjestad\",\n" +
    "      \"longitude\": \"-70.0167\",\n" +
    "      \"latitude\": \"12.5167\"\n" +
    "    },\n" +
    "    {\n" +
    "      \"id\": \"AFG\",\n" +
    "      \"iso2Code\": \"AF\",\n" +
    "      \"name\": \"Afghanistan\",\n" +
    "      \"region\": {\n" +
    "        \"id\": \"SAS\",\n" +
    "        \"iso2code\": \"8S\",\n" +
    "        \"value\": \"South Asia\"\n" +
    "      },\n" +
    "      \"adminregion\": {\n" +
    "        \"id\": \"SAS\",\n" +
    "        \"iso2code\": \"8S\",\n" +
    "        \"value\": \"South Asia\"\n" +
    "      },\n" +
    "      \"incomeLevel\": {\n" +
    "        \"id\": \"LIC\",\n" +
    "        \"iso2code\": \"XM\",\n" +
    "        \"value\": \"Low income\"\n" +
    "      },\n" +
    "      \"lendingType\": {\n" +
    "        \"id\": \"IDX\",\n" +
    "        \"iso2code\": \"XI\",\n" +
    "        \"value\": \"IDA\"\n" +
    "      },\n" +
    "      \"capitalCity\": \"Kabul\",\n" +
    "      \"longitude\": \"69.1761\",\n" +
    "      \"latitude\": \"34.5228\"\n" +
    "    }\n" +
    "  ]\n" +
    "]";

  public static final String JSON_INDICATORS = "[\n" +
    "  {\n" +
    "    \"page\": 3,\n" +
    "    \"pages\": 30,\n" +
    "    \"per_page\": 50,\n" +
    "    \"total\": 61,\n" +
    "    \"sourceid\": \"2\",\n" +
    "    \"sourcename\": \"World Development Indicators\",\n" +
    "    \"lastupdated\": \"2021-04-26\"\n" +
    "  },\n" +
    "  [\n" +
    "    {\n" +
    "      \"indicator\": {\n" +
    "        \"id\": \"SI.POV.DDAY\",\n" +
    "        \"value\": \"Poverty headcount ratio at $1.90 a day (2011 PPP) (% of population)\"\n" +
    "      },\n" +
    "      \"country\": {\n" +
    "        \"id\": \"BR\",\n" +
    "        \"value\": \"Brazil\"\n" +
    "      },\n" +
    "      \"countryiso3code\": \"BRA\",\n" +
    "      \"date\": \"2020\",\n" +
    "      \"value\": null,\n" +
    "      \"unit\": \"\",\n" +
    "      \"obs_status\": \"\",\n" +
    "      \"decimal\": 1\n" +
    "    },\n" +
    "    {\n" +
    "      \"indicator\": {\n" +
    "        \"id\": \"SI.POV.DDAY\",\n" +
    "        \"value\": \"Poverty headcount ratio at $1.90 a day (2011 PPP) (% of population)\"\n" +
    "      },\n" +
    "      \"country\": {\n" +
    "        \"id\": \"BR\",\n" +
    "        \"value\": \"Brazil\"\n" +
    "      },\n" +
    "      \"countryiso3code\": \"BRA\",\n" +
    "      \"date\": \"2019\",\n" +
    "      \"value\": 4.6,\n" +
    "      \"unit\": \"\",\n" +
    "      \"obs_status\": \"\",\n" +
    "      \"decimal\": 1\n" +
    "    }\n" +
    "  ]\n" +
    "  ]";
}
