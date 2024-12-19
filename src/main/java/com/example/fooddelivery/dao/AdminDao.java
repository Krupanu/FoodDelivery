package com.example.fooddelivery.dao;

import com.example.fooddelivery.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AdminDao extends JpaRepository<Admin, Integer> {

    Admin findByEmailidAndPassword(String emailId , String password);
    Admin findByEmailid(String emailId);

}
