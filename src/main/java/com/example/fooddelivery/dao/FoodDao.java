package com.example.fooddelivery.dao;

import java.util.List;

import com.example.fooddelivery.model.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodDao extends JpaRepository<Food, Integer> {

    List<Food> findByNameContainingIgnoreCase(String name);
    List<Food> findByCategoryId(int categpryId);
}
