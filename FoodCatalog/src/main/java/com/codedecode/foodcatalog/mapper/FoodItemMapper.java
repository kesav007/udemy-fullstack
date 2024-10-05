package com.codedecode.foodcatalog.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.codedecode.foodcatalog.dto.FoodItemDTO;
import com.codedecode.foodcatalog.entity.FoodItem;

@Mapper
public interface FoodItemMapper {

	FoodItemMapper INSTANCE = Mappers.getMapper(FoodItemMapper.class);

	FoodItemDTO mapFoodItemToFoodItemDTO(FoodItem foodItem);

	FoodItem mapFoodItemDTOToFoodItem(FoodItemDTO foodItemDTO);
}
