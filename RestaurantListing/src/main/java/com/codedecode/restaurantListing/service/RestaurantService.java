package com.codedecode.restaurantListing.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.codedecode.restaurantListing.dto.RestaurantDTO;
import com.codedecode.restaurantListing.entity.Restaurant;
import com.codedecode.restaurantListing.mapper.RestaurantMapper;
import com.codedecode.restaurantListing.repo.RestaurantRepo;

@Service
public class RestaurantService {

	@Autowired
	RestaurantRepo restaurantRepo;

	public List<RestaurantDTO> fetchAllRestaurants() {
		List<Restaurant> restaurants = restaurantRepo.findAll();
		List<RestaurantDTO> restaurantdtos = restaurants.stream()
				.map(restaurant -> RestaurantMapper.INSTANCE.mapRestaurantToRestaurantDTO(restaurant))
				.collect(Collectors.toList());
		return restaurantdtos;
	}

	public RestaurantDTO addRestaurantInDb(RestaurantDTO restaurantDTO) {
		Restaurant restaurant = RestaurantMapper.INSTANCE.mapRestaurantDTOToRestaurant(restaurantDTO);
		restaurant = restaurantRepo.save(restaurant);
		return RestaurantMapper.INSTANCE.mapRestaurantToRestaurantDTO(restaurant);
	}

	public ResponseEntity<RestaurantDTO> fetchRestaurantById(Integer id) {
		Optional<Restaurant> restaurant = restaurantRepo.findById(id);
		if (restaurant.isPresent()) {
			return new ResponseEntity<>(RestaurantMapper.INSTANCE.mapRestaurantToRestaurantDTO(restaurant.get()),
					HttpStatus.OK);
		}
		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}

}
