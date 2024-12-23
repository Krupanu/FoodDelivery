package com.example.fooddelivery.service.impl;

import com.example.fooddelivery.model.Food;
import com.example.fooddelivery.repository.FoodRepository;
import com.example.fooddelivery.service.FoodService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodServiceImpl implements FoodService {

    private final FoodRepository foodRepository;

    public FoodServiceImpl(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }

    @Override
    public Food getFoodInfo(Long foodId) {
        return foodRepository.getFoodById(foodId);
    }

    @Override
    public List<Food> foods() {
        return foodRepository.findAll();
    }

    @Override
    public Food addFood(Food food) {
        foodRepository.save(food);
        return food;
    }
}
