package br.com.ifood.vemproifood.dishlist.service;

import br.com.ifood.vemproifood.dishlist.model.GoogleMapResponse;
import com.google.common.collect.ImmutableMap;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@Service("googlemap.service")
public class GoogleMapService {
    private final String GOOGLE = "https://maps.googleapis.com/maps/api/geocode/json";

    @Resource
    private RestTemplate restTemplate;

    @Value("${googlemap.api.key}")
    private String apiKey;

    public String getCityName(double lat, double lng) {
        final String latlng = "" + lat + "," + lng;
        ResponseEntity<GoogleMapResponse> response = restTemplate.getForEntity(GOOGLE.concat("?lat={latlng}&key={apiKey}"),
            GoogleMapResponse.class,
            ImmutableMap.of("latlng", latlng, "apiKey", apiKey));
        return "Belem";
    }

}
