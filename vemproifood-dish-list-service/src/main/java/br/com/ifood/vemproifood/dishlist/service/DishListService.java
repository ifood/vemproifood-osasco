package br.com.ifood.vemproifood.dishlist.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ifood.vemproifood.dishlist.model.CategoryDTO;
import br.com.ifood.vemproifood.dishlist.model.Dish;

@Service
public class DishListService {

	private final OpenWeatherService weatherRetriever;
	private final RecomendationService recomendationService;
	private final GoogleMapsRetrieverService mapsService;

	@Autowired
	public DishListService(
			OpenWeatherService openWeatherService,
			final RecomendationService recomendationService,
			GoogleMapsRetrieverService mapsService) {
		this.weatherRetriever = openWeatherService;
		this.mapsService = mapsService;
		this.recomendationService = recomendationService;
	}

	public List<Dish> getDishListByCoordinates(Double lat, Double lon){
		Double temperature = this.weatherRetriever.retrieveCurrentTemperatureByCoordinates(lat, lon);
		System.out.println("Temperatura " + temperature);

		String city = this.mapsService.retrieveCityByCoordinates(lat, lon);
		System.out.println("Cidade " + city);

		CategoryDTO recommendType = recomendationService.getRecommendType("MAPS");
		System.out.println("Recomendacao " + recommendType.getCategory());
		

		return new LinkedList<>();
	}

}