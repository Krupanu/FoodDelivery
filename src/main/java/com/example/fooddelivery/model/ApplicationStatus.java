package com.example.fooddelivery.model;


import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;

@Getter
public enum ApplicationStatus {
    APPROVED("APPROVED"),
    DECLINED("DECLINED"),
    IN_PROGRESS("IN_PROGRESS");

    private final String value;

    ApplicationStatus(final String value) {
        this.value = value;
    }

    @JsonCreator
    public static ApplicationStatus fromValue(String value) {
        for (ApplicationStatus orderStatus : ApplicationStatus.values()) {
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
