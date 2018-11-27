package br.com.ifood.vemproifood.dishlist.controller;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import br.com.ifood.vemproifood.dishlist.controller.OpenWeatherController;
import java.util.Map;


@RestController
@RequestMapping(path = "nova")
public class SpotifyToken {
	//private Double latitude = -23.944887; 
	//private Double longitude = -46.378700;
	
	
	public String genre = "teste";
	

	public static String SPOTIFY_URL = "https://api.spotify.com/v1/recommendations?seed_genres=";
	public static String accessToken = "BQA7X3w09LVY5mO8lv3VA12gOJY7iQyaUihJByCPjjxWSCmVaApsAR_Gh-OA2hYlooahx1GzFKJRLQrNHiE";
	
	
	public String getGenres(Double latitude,Double longitude) {
		double temp = new OpenWeatherController().create(latitude, longitude);
		if (temp > 30) {
			return "party";
		}else if(temp >= 15 && temp <= 30 ) {
			return "pop";
		}else if(temp >=10 && temp <=14 ) {
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
	@GetMapping(path = "/token/{latitude}/{longitude}")
	@ResponseBody
	public Map sayPost(@PathVariable Double latitude, @PathVariable Double longitude) {

		String url = SPOTIFY_URL + getGenres(latitude,longitude);
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<String> entity = new HttpEntity<String>(createHeaders());
		ResponseEntity<Map> response = restTemplate.exchange(url, HttpMethod.GET, entity, Map.class);
		//ResponseEntity<String> result = restTemplate.getForEntity(SPOTIFY_URL,entity,  );
		System.out.println(url);
		return response.getBody();
	}

}
