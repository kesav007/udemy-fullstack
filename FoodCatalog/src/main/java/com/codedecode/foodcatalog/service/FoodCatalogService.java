package com.codedecode.foodcatalog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.codedecode.foodcatalog.dto.FoodCatalogPage;
import com.codedecode.foodcatalog.dto.FoodItemDTO;
import com.codedecode.foodcatalog.dto.Restaurant;
import com.codedecode.foodcatalog.entity.FoodItem;
import com.codedecode.foodcatalog.mapper.FoodItemMapper;
import com.codedecode.foodcatalog.repo.FoodItemRepo;

@Service
public class FoodCatalogService {

	@Autowired
	FoodItemRepo foodItemRepo;
	
	@Autowired
	RestTemplate restTemplate;

	public FoodItemDTO addFoodItem(FoodItemDTO foodItemDTO) {
		FoodItem foodItemSaved = foodItemRepo.save(FoodItemMapper.INSTANCE.mapFoodItemDTOToFoodItem(foodItemDTO));
		return FoodItemMapper.INSTANCE.mapFoodItemToFoodItemDTO(foodItemSaved);
	}

	public FoodCatalogPage fetchFoodCatalogWithFoodMenu(Integer restuarantId) {
		List<FoodItem> foodItems = fetchFoodItemList(restuarantId);
		Restaurant restaurant =  fetchRestuarntByIdFromRestaurantMS(restuarantId);
		return createFoodCatalogPage(foodItems, restaurant);
	}

	private FoodCatalogPage createFoodCatalogPage(List<FoodItem> foodItems, Restaurant restaurant) {
		FoodCatalogPage foodCatalogPage = new FoodCatalogPage();
		foodCatalogPage.setFoodItems(foodItems);
		foodCatalogPage.setRestaurant(restaurant);
		return foodCatalogPage;
	}

	private Restaurant fetchRestuarntByIdFromRestaurantMS(Integer restuarantId) {
		return restTemplate.getForObject("http://RESTUARANT-SERVICE/restaurant/fetchRestaurantById/" + restuarantId, Restaurant.class);
	}

	private List<FoodItem> fetchFoodItemList(Integer restuarantId) {
		return foodItemRepo.findByRestaurantId(restuarantId);
	}

}
