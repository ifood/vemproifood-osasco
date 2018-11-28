package br.com.ifood.vemproifood.dishlist.service;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping(path = "spotify")
public class SpotifyService {

	public static String SPOTIFY_URL = "https://api.spotify.com/v1/recommendations?seed_genres=";
	public static String accessToken = new SpotifyGetTokenService().getSpotifyToken();
	
	
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
	public Object suggestTrackByCoordinates(@PathVariable Double latitude, @PathVariable Double longitude) {
		double tempByCoordinates = new OpenWeatherService().retrieveCurrentTemperatureByCoordinates(latitude, longitude);
		String url = SPOTIFY_URL + getGenres(tempByCoordinates);
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<String> entity = new HttpEntity<String>(createHeaders());
		ResponseEntity<Object> response = restTemplate.exchange(url, HttpMethod.GET, entity, Object.class);
		return response.getBody();
	}
	
	@GetMapping(path = "/city/{city}")
	public Object suggestTrackByCity(@PathVariable String city) {
		double tempByCity = new OpenWeatherService().retrieveCurrentTemperatureByCity(city);
		String url = SPOTIFY_URL + getGenres(tempByCity);
		
		RestTemplate restTemplateByCity = new RestTemplate();
		HttpEntity<String> entity = new HttpEntity<String>(createHeaders());
		ResponseEntity<Object> response = restTemplateByCity.exchange(url, HttpMethod.GET, entity, Object.class);
		return response.getBody();
	}

}
