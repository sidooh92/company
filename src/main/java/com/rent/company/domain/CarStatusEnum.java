package com.rent.company.domain;

public enum CarStatusEnum {
    RENTED("RENTED"),
    AVAILABLE("AVAILABLE"),
    UNAVAILABLE("UNAVAILABLE");

    private final String value;

    private CarStatusEnum(String value) {
        this.value = value;

    }

    public String getValue() {
        return value;
    }
}
