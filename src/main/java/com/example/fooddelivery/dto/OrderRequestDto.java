package com.example.fooddelivery.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class OrderRequestDto {
    private String title;
    private String description;
    private Double budget;
    private LocalDate deadline;
    private Long currentUserId;
}