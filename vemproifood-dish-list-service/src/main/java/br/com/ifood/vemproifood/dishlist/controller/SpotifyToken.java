package br.com.ifood.vemproifood.dishlist.controller;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import br.com.ifood.vemproifood.dishlist.controller.OpenWeatherController;
import java.util.Map;


@RestController
@RequestMapping(path = "spotify")
public class SpotifyToken {

	public static String SPOTIFY_URL = "https://api.spotify.com/v1/recommendations?seed_genres=";
	public static String accessToken = "BQDs0Kb7363YoyVMJ9GVsfxM4E8jQbgePHrkkO2H_Zy8TojQuAE1opIZgPnkXpVBY49JdPNCV2ElsE5YhF4";
	
	
	public String getGenres(Double temperatura) {
		
		if (temperatura > 30) {
			return "party";
		}else if(temperatura >= 15 && temperatura <= 30 ) {
			return "pop";
		}else if(temperatura >=10 && temperatura <=14 ) {
			return "rock";
		}
		return "classical";
	}	
	
	public static HttpHeaders createHeaders(){
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set("Authorization", "Bearer "+accessToken);
		
		return headers;
	}
	
	@GetMapping(path = "/coordinates/{latitude}/{longitude}")
	public Map suggestTrackByCoordinates(@PathVariable Double latitude, @PathVariable Double longitude) {
		double tempByCoordinates = new OpenWeatherController().retrieveCurrentTemperatureByCoordinates(latitude, longitude);
		String url = SPOTIFY_URL + getGenres(tempByCoordinates);
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<String> entity = new HttpEntity<String>(createHeaders());
		ResponseEntity<Map> response = restTemplate.exchange(url, HttpMethod.GET, entity, Map.class);
		return response.getBody();
	}
	
	@GetMapping(path = "/city/{city}")
	public Map suggestTrackByCity(@PathVariable String city) {
		double tempByCity = new OpenWeatherController().retrieveCurrentTemperatureByCity(city);
		String url = SPOTIFY_URL + getGenres(tempByCity);
		
		RestTemplate restTemplateByCity = new RestTemplate();
		HttpEntity<String> entity = new HttpEntity<String>(createHeaders());
		ResponseEntity<Map> response = restTemplateByCity.exchange(url, HttpMethod.GET, entity, Map.class);
		return response.getBody();
	}

}
