package com.example.fooddelivery.dao;

import com.example.fooddelivery.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<User, Integer> {

    User findByEmailidAndPassword(String emailId, String password);
    User findByEmailid(String emailId);
    User findByEmailidAndMobileno(String emailId, String mobileNo);
}
