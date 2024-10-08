package com.codedecode.restaurantListing.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.codedecode.restaurantListing.dto.RestaurantDTO;
import com.codedecode.restaurantListing.entity.Restaurant;

@Mapper
public interface RestaurantMapper {

	RestaurantMapper INSTANCE = Mappers.getMapper(RestaurantMapper.class);

	Restaurant mapRestaurantDTOToRestaurant(RestaurantDTO restaurantDTO);

	RestaurantDTO mapRestaurantToRestaurantDTO(Restaurant restaurant);
}
