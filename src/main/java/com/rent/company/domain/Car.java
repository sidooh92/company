package com.rent.company.domain;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Car {
    private String brand;
    private String model;
    private CarTypesEnum carTypesEnum;
    private int productionYear;
    private String color;
    private int mileage;
    private CarStatusEnum carStatusEnum;
    private double costPerDay;

}
