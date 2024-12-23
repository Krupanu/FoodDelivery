package com.example.fooddelivery.model;


import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;

@Getter
public enum OrderStatus {
    APPROVED("APPROVED"),
    DECLINED("DECLINED"),
    PENDING("PENDING"),
    IN_PROGRESS("IN_PROGRESS");

    private final String value;

    OrderStatus(final String value) {
        this.value = value;
    }

    @JsonCreator
    public static OrderStatus fromValue(String value) {
        for (OrderStatus orderStatus : OrderStatus.values()) {
            if (orderStatus.value.equalsIgnoreCase(value.trim())) {
                return orderStatus;
            }
        }
        throw new IllegalArgumentException("Unknown value: " + value);
    }

    @Override
    public String toString() {
        return value;
    }
}
