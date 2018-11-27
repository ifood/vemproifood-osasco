package br.com.ifood.vemproifood.dishlist.controller;

import br.com.ifood.vemproifood.dishlist.model.Dish;
import br.com.ifood.vemproifood.dishlist.model.exception.InvalidCoordinatesException;
import br.com.ifood.vemproifood.dishlist.service.DishListService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path = "dishes_by_location")
public class DishListController {

	private final DishListService dishListService;

	@Autowired
	public DishListController(DishListService dishListService) {
		this.dishListService = dishListService;
	}


	@RequestMapping(path = "{latitude}/{longitude}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	ResponseEntity <Object> getDishListByCoordinates(
			@PathVariable(name = "latitude")
			final double latitude,
			@PathVariable(name = "longitude")
			final double longitude) {

		if( latitude > 90 || latitude < -90 ) throw new InvalidCoordinatesException(latitude);
		if( longitude > 180 || longitude < -180 ) throw new InvalidCoordinatesException(longitude);

		return ResponseEntity.ok(getDishListByCoordinates(latitude, longitude));
	}
}