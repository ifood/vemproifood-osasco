package br.com.ifood.vemproifood.dishlist.service;

import java.util.Base64;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import br.com.ifood.vemproifood.dishlist.model.SpotifyTokenResponse;


public class SpotifyGetTokenService {

	String spotifyClientId = "afdd0e8ff66e4a808fd438a84df273bb";
	String spotifySecretKey = "f6774c4148fa47b5942c3b02c21fbb10";
	
	String loginToEncode = spotifyClientId + spotifySecretKey;
	
	String SPOTIFY_TOKEN_URL = "https://accounts.spotify.com/api/token";
	String encodedAuth= Base64.getEncoder().encodeToString((spotifyClientId+":"+spotifySecretKey).getBytes());
			
	public static HttpHeaders createHeaders(String encodedAuth){
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		headers.set("Authorization", "Basic "+ encodedAuth);
		
		return headers;
	}

	public String getSpotifyToken() {
				
		MultiValueMap<String, String> body = new LinkedMultiValueMap<String, String>();     
		
		body.add("grant_type", "client_credentials");
		
		RestTemplate restTemplateByCity = new RestTemplate();
		HttpEntity<?> entity = new HttpEntity<Object>(body ,createHeaders(encodedAuth));
		ResponseEntity<SpotifyTokenResponse> response = restTemplateByCity.exchange(SPOTIFY_TOKEN_URL, HttpMethod.POST, entity, SpotifyTokenResponse.class);
		
		return response.getBody().getAccess_token();
	}
}


