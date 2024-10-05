package com.codedecode.order.entity;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import com.codedecode.order.dto.FoodItemDTO;
import com.codedecode.order.dto.Restaurant;
import com.codedecode.order.dto.UserDTO;

@Document("order")
public class Order {

	private Integer orderId;
	private List<FoodItemDTO> foodItemsDTO;
	private Restaurant restaurant;
	private UserDTO userDTO;

	public Order() {
	}

	public Order(Integer orderId, List<FoodItemDTO> foodItemsDTO, Restaurant restaurant, UserDTO userDTO) {
		this.orderId = orderId;
		this.foodItemsDTO = foodItemsDTO;
		this.restaurant = restaurant;
		this.userDTO = userDTO;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public List<FoodItemDTO> getFoodItemsDTO() {
		return foodItemsDTO;
	}

	public void setFoodItemsDTO(List<FoodItemDTO> foodItemsDTO) {
		this.foodItemsDTO = foodItemsDTO;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	public UserDTO getUserDTO() {
		return userDTO;
	}

	public void setUserDTO(UserDTO userDTO) {
		this.userDTO = userDTO;
	}

}
