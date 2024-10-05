package com.codedecode.foodcatalog.dto;

import java.util.List;

import com.codedecode.foodcatalog.entity.FoodItem;

public class FoodCatalogPage {
	
	private List<FoodItem> foodItems;
	
	private Restaurant restaurant;

	public List<FoodItem> getFoodItems() {
		return foodItems;
	}

	public void setFoodItems(List<FoodItem> foodItems) {
		this.foodItems = foodItems;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}
	
	

}
