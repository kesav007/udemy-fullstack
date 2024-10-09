package com.codedecode.foodcatalog.controller;

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

import com.codedecode.foodcatalog.dto.FoodCatalogPage;
import com.codedecode.foodcatalog.dto.FoodItemDTO;
import com.codedecode.foodcatalog.service.FoodCatalogService;

@RestController
@RequestMapping("foodCatalogue")
@CrossOrigin(origins = "http://localhost:4200/")
public class FoodCatalogController {

	@Autowired
	FoodCatalogService foodCatalogService;
	
	@PostMapping("/addFoodItem")
	public ResponseEntity<FoodItemDTO> addFoodItem(@RequestBody FoodItemDTO foodItemDTO) {
		FoodItemDTO  foodItemSaved = foodCatalogService.addFoodItem(foodItemDTO);
		return new ResponseEntity<>(foodItemSaved, HttpStatus.CREATED);
	}
	
	@GetMapping("/fetchFoodCatalogWithFoodMenu/{restuarantId}")
	public ResponseEntity<FoodCatalogPage> fetchFoodCatalogWithFoodMenu(@PathVariable Integer restuarantId) {
		FoodCatalogPage foodCatalogPage = foodCatalogService.fetchFoodCatalogWithFoodMenu(restuarantId);
		return new ResponseEntity<>(foodCatalogPage, HttpStatus.OK);
	}
}
