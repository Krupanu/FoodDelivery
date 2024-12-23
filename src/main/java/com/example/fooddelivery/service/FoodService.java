package com.example.fooddelivery.service;

import com.example.fooddelivery.model.Food;
import com.example.fooddelivery.model.Order;

import java.util.List;

public interface FoodService {
    Food getFoodInfo(Long foodId);
    List<Food> foods();
    Food addFood(Food food);

}
