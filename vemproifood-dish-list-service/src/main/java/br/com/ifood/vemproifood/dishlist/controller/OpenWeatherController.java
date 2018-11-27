package br.com.ifood.vemproifood.dishlist.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import br.com.ifood.vemproifood.dishlist.model.OpenWeatherMapResponse;
import br.com.ifood.vemproifood.dishlist.model.OpenWeatherMapResponse.MainInformations;

@RestController
@RequestMapping(path = "weather")
public class OpenWeatherController {
		public static String WEATHER_URL = "http://api.openweathermap.org/data/2.5/weather";
		private String apiKey = "eacfcb4eced0e01afbaa1d43d5e8567d";
		public MainInformations main;
		
		@GetMapping(path = "/{latitude}/{longitude}")
		@ResponseBody
		public double create(@PathVariable Double latitude, @PathVariable Double longitude) {
			
			RestTemplate restTemplate = new RestTemplate();
			String fooResourceUrl = WEATHER_URL + "?units=metric&lat=-23.944887&lon=-46.378700&APPID=eacfcb4eced0e01afbaa1d43d5e8567d";
			ResponseEntity<OpenWeatherMapResponse> response = restTemplate.getForEntity(fooResourceUrl, OpenWeatherMapResponse.class);

			return response.getBody().getMain().getTemp();
			 
		}
		
	}
