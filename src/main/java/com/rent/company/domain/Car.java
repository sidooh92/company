package com.rent.company.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@ToString
@Getter
@Setter
@AllArgsConstructor
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
