package br.com.ifood.vemproifood.dishlist.service;

import br.com.ifood.vemproifood.dishlist.model.CategoryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class RecomendationService {

    private final String URL;

    private final RestTemplate restTemplate;

    @Autowired
    public RecomendationService(@Value("${recomendation.url}") String url,
                                RestTemplate restTemplate) {
        URL = url;
        this.restTemplate = restTemplate;
    }

    CategoryDTO getRecommendType(final String city){
        return restTemplate
                .getForObject(URL + "?city=" + city, CategoryDTO.class);
    }
}
