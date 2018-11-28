package br.com.ifood.vemproifood.dishlist.service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.google.common.collect.ImmutableMap;
import br.com.ifood.vemproifood.dishlist.model.OpenWeatherMapResponse;
import br.com.ifood.vemproifood.dishlist.model.exception.InvalidCoordinatesException;


public class OpenWeatherService {
	
		public static String WEATHER_URL = "http://api.openweathermap.org/data/2.5/weather";
		
		private String apiKey = "eacfcb4eced0e01afbaa1d43d5e8567d";
		
		public double retrieveCurrentTemperatureByCoordinates( Double latitude, Double longitude) {
			
			if( latitude > 90 || latitude < -90 ) throw new InvalidCoordinatesException(latitude);
			if( longitude > 180 || longitude < -180 ) throw new InvalidCoordinatesException(longitude);
			
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
		
		public double retrieveCurrentTemperatureByCity( String city) {
			
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


