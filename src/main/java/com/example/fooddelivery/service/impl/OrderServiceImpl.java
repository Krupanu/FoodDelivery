package com.example.fooddelivery.service.impl;

import com.example.fooddelivery.model.Order;
import com.example.fooddelivery.repository.OrderRepository;
import com.example.fooddelivery.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Order getOrderInfo(Long id) {
        return orderRepository.getOrderById(id);
    }

    @Override
    public List<Order> orders() {
        return orderRepository.findAll();
    }
}
