package com.codedecode.restaurantListing.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codedecode.restaurantListing.dto.RestaurantDTO;
import com.codedecode.restaurantListing.service.RestaurantService;

@RestController
@RequestMapping("/restaurant")
@CrossOrigin(origins = "http://localhost:4200/")
public class RestaurantController {

	@Autowired
	RestaurantService restaurantService;

	@GetMapping("/fetchAllRestaurants")
	public ResponseEntity<List<RestaurantDTO>> fetchAllRestaurants() {
		List<RestaurantDTO> allRestaurants = restaurantService.fetchAllRestaurants();
		return new ResponseEntity<List<RestaurantDTO>>(allRestaurants, HttpStatus.OK);
	}

	@PostMapping("/addRestaurant")
	public ResponseEntity<RestaurantDTO> saveRestaurant(@RequestBody RestaurantDTO restaurantDTO) {
		RestaurantDTO restuarant = restaurantService.addRestaurantInDb(restaurantDTO);
		return new ResponseEntity<RestaurantDTO>(restuarant, HttpStatus.CREATED);
	}

	@GetMapping("/fetchRestaurantById/{id}")
	public ResponseEntity<RestaurantDTO> fetchRestaurantById(@PathVariable Integer id) {
		return restaurantService.fetchRestaurantById(id);		
	}

}
