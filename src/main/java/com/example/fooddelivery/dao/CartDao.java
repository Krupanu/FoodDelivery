package com.example.fooddelivery.dao;

import java.util.List;

import com.example.fooddelivery.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CartDao extends JpaRepository<Cart, Integer> {

    List<Cart> findByUserId(int userId);
    Long countByUserId(int userId);

}
