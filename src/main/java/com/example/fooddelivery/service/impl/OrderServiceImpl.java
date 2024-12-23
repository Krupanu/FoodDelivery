package com.example.fooddelivery.service.impl;

import com.example.fooddelivery.model.Food;
import com.example.fooddelivery.model.Order;
import com.example.fooddelivery.model.User;
import com.example.fooddelivery.repository.FoodRepository;
import com.example.fooddelivery.repository.OrderRepository;
import com.example.fooddelivery.repository.UserRepository;
import com.example.fooddelivery.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository;
    private UserRepository userRepository;
    private FoodRepository foodRepository;

    public OrderServiceImpl(OrderRepository orderRepository, UserRepository userRepository, FoodRepository foodRepository) {
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
        this.foodRepository = foodRepository;
    }

    @Override
    public Order getOrderInfo(Long id) {
        return orderRepository.getOrderById(id);
    }

    @Override
    public List<Order> orders() {
        return orderRepository.findAll();
    }

    @Override
    public Order addOrder(Order order, Long currentUserId, List<Food> foods) {
        Optional<User> currentUser = userRepository.findById(currentUserId);
        currentUser.ifPresent(order::setCreatedBy);

        orderRepository.save(order);

        return order;
    }
}
