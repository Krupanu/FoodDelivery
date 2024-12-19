package com.example.fooddelivery.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    // Настройка PasswordEncoder
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // Настройка доступа к URL
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable() // Для упрощения (опционально)
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/login", "/", "/index").permitAll() // Доступ для всех
                        .anyRequest().authenticated() // Остальные страницы требуют аутентификации
                )
                .formLogin(form -> form
                        .loginPage("/login") // Указывает кастомную страницу входа
                        .defaultSuccessUrl("/index", true) // Перенаправление после успешного входа
                        .permitAll()
                )
                .logout(logout -> logout
                        .logoutUrl("/logout") // URL для выхода
                        .logoutSuccessUrl("/login?logout") // Перенаправление после выхода
                        .permitAll()
                );

        return http.build();
    }

    // Настройка аутентификации (пример с базой данных)
    @Bean
    public UserDetailsService userDetailsService(UserDetailsService userDetailsService) {
        return userDetailsService::loadUserByUsername;
    }
}
