package com.codedecode.order.dto;

import java.util.List;

public class OrderDTOFromFE {
	private Restaurant restaurant;
	private List<FoodItemDTO> foodItemsList;
	private Integer userId;
	
	public OrderDTOFromFE() {
	}
	

	public OrderDTOFromFE(Restaurant restaurant, List<FoodItemDTO> foodItemsList, Integer userId) {
		super();
		this.restaurant = restaurant;
		this.foodItemsList = foodItemsList;
		this.userId = userId;
	}


	public Integer getUserId() {
		return userId;
	}


	public void setUserId(Integer userId) {
		this.userId = userId;
	}


	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	public List<FoodItemDTO> getFoodItemsList() {
		return foodItemsList;
	}

	public void setFoodItemsList(List<FoodItemDTO> foodItemsList) {
		this.foodItemsList = foodItemsList;
	}

}
