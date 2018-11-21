package br.com.ifood.vemproifood.dishlist.service;

import br.com.ifood.vemproifood.dishlist.model.OpenWeatherMapResponse;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.ImmutableMap;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service("open.weather.map.weather.retriever")
final class OpenWeatherService {

  @VisibleForTesting
  static final String WEATHER_URL = "http://api.openweathermap.org/data/2.5/weather";

  @Resource
  private RestTemplate restTemplate;

  @Value("${openweathermap.api.key}")
  private String apiKey;


  public double retrieveCurrentTemperatureByCoordinates(final double latitude, final double longitude) {
    final ResponseEntity<OpenWeatherMapResponse> weatherDataResponse = restTemplate.getForEntity(
        WEATHER_URL + "?units=metric&lat={latitude}&lon={longitude}&APPID={apiKey}",
        OpenWeatherMapResponse.class,
        ImmutableMap.of(
            "latitude", latitude,
            "longitude", longitude,
            "apiKey", apiKey));
    return weatherDataResponse.getBody().getMain().getTemp();
  }

}