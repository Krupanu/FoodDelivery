package com.example.fooddelivery.repository;

import com.example.fooddelivery.model.Food;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepository extends JpaRepository<Food, Long> {
    Food getFoodById(Long id);

}
