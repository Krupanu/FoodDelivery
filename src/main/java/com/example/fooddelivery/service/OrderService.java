package com.example.fooddelivery.service;

import com.example.fooddelivery.model.Order;

import java.util.List;

public interface OrderService {
    Order getOrderInfo(Long id);
    List<Order> orders();

}
