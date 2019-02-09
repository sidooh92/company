package com.rent.company.domain;

public enum  CarTypesEnum {
    COMBI("COMBI"),
    HATCHBACK("HATCHBACK"),
    SEDAN("SEDAN"),
    PICKUP("PICKUP");

    private final String value;

    private CarTypesEnum(String value) {
        this.value = value;

    }

    public String getValue() {
        return value;
    }
}
