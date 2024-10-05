package com.codedecode.order.dto;

import java.util.List;

public class OrderDTO {

	private int orderId;
	private Restaurant restaurant;
	private List<FoodItemDTO> foodItemsList;
	private UserDTO userDTO;

	public OrderDTO() {
	}

	public OrderDTO(int orderId, Restaurant restaurant, List<FoodItemDTO> foodItemsList, UserDTO userDTO) {
		this.orderId = orderId;
		this.restaurant = restaurant;
		this.foodItemsList = foodItemsList;
		this.userDTO = userDTO;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
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

	public UserDTO getUserDTO() {
		return userDTO;
	}

	public void setUserDTO(UserDTO userDTO) {
		this.userDTO = userDTO;
	}

}
