package br.com.ifood.vemproifood.dishlist.service;

import br.com.ifood.vemproifood.dishlist.model.Dish;
import java.util.LinkedList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DishListService {

	private final OpenWeatherService weatherRetriever;

	private final GoogleMapService mapService;

	private final RecomendationService recomendationService;

	@Autowired
	public DishListService(OpenWeatherService openWeatherService,
                           GoogleMapService mapService,
                           RecomendationService recommendService) {
	    this.mapService = mapService;
		this.weatherRetriever = openWeatherService;
		this.recomendationService = recommendService;
	}

	public List<Dish> getDishListByCoordinates(Double lat, Double lon) {
		Double temperature = this.weatherRetriever.retrieveCurrentTemperatureByCoordinates(lat, lon);
        String cityName = mapService.getCityName(-1.45583, -48.50444);
        String type = recomendationService.getDishType(cityName);
		/*
		 * ... to be continued
		 */

		return new LinkedList<>();
	}

}