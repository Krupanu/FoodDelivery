package com.example.fooddelivery.service;

import com.example.fooddelivery.dao.UserDao;
import com.example.fooddelivery.model.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserDao userDao;

    public CustomUserDetailsService(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDao.findByEmailid(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with email: " + username);
        }
        return org.springframework.security.core.userdetails.User
                .withUsername(user.getEmailid())
                .password(user.getPassword())
                .build();
    }
}
