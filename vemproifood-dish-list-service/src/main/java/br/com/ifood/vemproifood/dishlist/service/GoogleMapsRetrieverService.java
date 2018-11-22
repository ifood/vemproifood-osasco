package br.com.ifood.vemproifood.dishlist.service;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.google.common.collect.ImmutableMap;

import br.com.ifood.vemproifood.dishlist.model.GoogleMapsResponse;

@Service
public class GoogleMapsRetrieverService {

	static final String MAPS_URL = "https://maps.googleapis.com/maps/api/geocode/json";

	@Resource
	private RestTemplate restTemplate;
	@Value("${googlemaps.api.key}")
	private String apiKey;

	public String retrieveCityByCoordinates(final double latitude,
		      final double longitude) {
	    final ResponseEntity<GoogleMapsResponse> googleMapsDataResponse = restTemplate.getForEntity(
	    		MAPS_URL + "?latlng={latitude},{longitude}&key={apiKey}&location=ROOFTOP",
	    		GoogleMapsResponse.class,
	            ImmutableMap.of(
	                "latitude", latitude,
	                "longitude", longitude,
	                "apiKey", apiKey));

		GoogleMapsResponse body = googleMapsDataResponse.getBody();
		return body.getResults().get(0).getAddress_components().stream().filter(ad -> ad.getTypes().contains("administrative_area_level_2")).findFirst().get().getShort_name();

	}
}
