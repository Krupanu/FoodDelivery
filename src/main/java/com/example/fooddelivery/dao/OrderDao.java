package com.example.fooddelivery.dao;

import java.util.List;

import com.example.fooddelivery.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface OrderDao extends JpaRepository<Orders , Integer> {

    List<Orders> findByOrderId(String orderId);
    List<Orders> findByUserId(int userId);
    List<Orders> findByOrderDate(String orderDate);
    List<Orders> findByOrderDateAndUserId(String orderDate, int userId);

}
