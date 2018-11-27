package br.com.ifood.vemproifood.dishlist.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.google.common.collect.ImmutableMap;
import br.com.ifood.vemproifood.dishlist.model.OpenWeatherMapResponse;

@RestController
@RequestMapping(path = "weather")
public class OpenWeatherController {
	
		public static String WEATHER_URL = "http://api.openweathermap.org/data/2.5/weather";
		
		private String apiKey = "eacfcb4eced0e01afbaa1d43d5e8567d";
		
		@GetMapping(path = "/{latitude}/{longitude}")
		@ResponseBody
		public double retrieveCurrentTemperatureByCoordinates(@PathVariable Double latitude, @PathVariable Double longitude) {
			
			RestTemplate restTemplate = new RestTemplate();
			String whetherUrlCoordinates = WEATHER_URL + "?units=metric&lat={latitude}&lon={longitude}&APPID={apiKey}";
			ResponseEntity<OpenWeatherMapResponse> response = restTemplate.getForEntity(whetherUrlCoordinates,
					OpenWeatherMapResponse.class,
			        ImmutableMap.of(
			                "latitude", latitude,
			                "longitude", longitude,
			                "apiKey", apiKey));

			return response.getBody().getMain().getTemp();			 
		}
		
		@GetMapping(path = "/{city}")
		@ResponseBody
		public double retrieveCurrentTemperatureByCity(@PathVariable String city) {
			
			RestTemplate restTemplate = new RestTemplate();
			String whetherUrlCity = WEATHER_URL + "?q={city}&APPID={apiKey}";
			ResponseEntity<OpenWeatherMapResponse> response = restTemplate.getForEntity(whetherUrlCity, OpenWeatherMapResponse.class,
			        ImmutableMap.of(
			                "city", city,
			                "apiKey", apiKey));
			Double kelvinToCelcios = response.getBody().getMain().getTemp() - 273.15;
	

			return kelvinToCelcios;
			 
		}
		
	}


