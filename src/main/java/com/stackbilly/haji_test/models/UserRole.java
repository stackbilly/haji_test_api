package com.stackbilly.haji_test.models;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum UserRole {
    USER, ADMIN, DRIVER;

    @JsonCreator
    public static UserRole fromString(String value) {
        switch (value.toUpperCase()) {
            case "USER":
                return USER;
            case "ADMIN":
                return ADMIN;
            case "DRIVER":
                return DRIVER;
            default:
                throw new IllegalArgumentException("Unknow user role " + value);
        }
    }
}
