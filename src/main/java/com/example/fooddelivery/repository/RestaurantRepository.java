package com.example.fooddelivery.repository;

import com.example.fooddelivery.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantRepository extends JpaRepository<Admin, Long> {
}