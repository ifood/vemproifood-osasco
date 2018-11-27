package br.com.ifood.vemproifood.dishlist.service;

import br.com.ifood.vemproifood.dishlist.model.Dish;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DishListService {

	private final OpenWeatherService weatherRetriever;

	@Autowired
	public DishListService(
			OpenWeatherService openWeatherService) {
		this.weatherRetriever = openWeatherService;
	}

	public Object getDishListByCoordinates(Double lat, Double lon){
		Double temperature = this.weatherRetriever.retrieveCurrentTemperatureByCoordinates(lat, lon);

		/*
		 * ... to be continued
		 */

		return temperature;
	}

}