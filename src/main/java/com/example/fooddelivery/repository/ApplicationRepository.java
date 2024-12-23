package com.example.fooddelivery.repository;

import com.example.fooddelivery.model.Application;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationRepository extends JpaRepository<Application, Long> {
}
