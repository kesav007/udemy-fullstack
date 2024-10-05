//import { FoodItem } from "src/app/Shared/models/FoodItem";
//import { Restaurant } from "src/app/Shared/models/Restaurant";

import { Restaurant } from "../../restaurant-listing/model/restaurant";
import { FoodItem } from "../../Shared/models/FoodItem";

export interface OrderDTO{

    foodItemsList?: FoodItem[];
    userId?: number;
    restaurant?: Restaurant;
}