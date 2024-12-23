package com.example.fooddelivery.service;

import com.example.fooddelivery.model.Application;

import java.util.List;

public interface ApplicationService {

    void updateApplications(List<Application> applications, Long selectedApplicationId);
    void addApplication(Long orderId, Long userId);
}
