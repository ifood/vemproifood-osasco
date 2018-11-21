package br.com.ifood.vemproifood.dishlist.service;

import com.google.common.collect.ImmutableMap;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@Service("recommendation.service")
public class RecomendationService {

    public String dishType;

    final String RECOMMENDATION = "https://6h3yzrpuwj.execute-api.sa-east-1.amazonaws.com/v1/recommend?city={city}";

    @Resource
    private RestTemplate restTemplate;

    public String getDishType(String cityName) {
        ResponseEntity<DishType> result = restTemplate.getForEntity(RECOMMENDATION,
            DishType.class,
            ImmutableMap.of("city", cityName));
        return result.getBody().dishType;
    }

    static class DishType {
        private String dishType;

        public void setDishType(String value) { this.dishType = value; }
        public String getDishType() { return dishType; }

    }
}
