package com.example.fooddelivery.service.impl;

import com.example.fooddelivery.model.Application;
import com.example.fooddelivery.model.ApplicationStatus;
import com.example.fooddelivery.model.Order;
import com.example.fooddelivery.model.User;
import com.example.fooddelivery.repository.ApplicationRepository;
import com.example.fooddelivery.repository.OrderRepository;
import com.example.fooddelivery.repository.UserRepository;
import com.example.fooddelivery.service.ApplicationService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Service
public class ApplicationServiceImpl implements ApplicationService {

    private final ApplicationRepository applicationRepository;
private final OrderRepository orderRepository;
private final UserRepository userRepository;

    public ApplicationServiceImpl(ApplicationRepository applicationRepository, OrderRepository orderRepository, UserRepository userRepository) {
        this.applicationRepository = applicationRepository;
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void updateApplications(List<Application> applications, Long selectedApplicationId) {
        applications.forEach(application -> {
            if(!Objects.equals(application.getId(), selectedApplicationId)) {
                application.setStatus(ApplicationStatus.DECLINED);
            } else {
                application.setStatus(ApplicationStatus.APPROVED);
            }
        });

        applicationRepository.saveAll(applications);
    }

    @Override
    public void addApplication(Long orderId, Long userId) {
        Order order = orderRepository.getOrderById(orderId);
        User user = userRepository.getById(userId);

        Application newApplication = new Application();
        newApplication.setUser(user);
        newApplication.setOrder(order);
        newApplication.setCreatedAt(LocalDate.now());
        newApplication.setStatus(ApplicationStatus.IN_PROGRESS);

        applicationRepository.save(newApplication);
    }
}
