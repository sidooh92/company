package com.rent.company.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class Employee {
    private String firstName;
    private String lastName;
    private boolean isManager;
    private Department department;


    public Employee(String firstName, String lastName, boolean isManager, Department department) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.isManager = isManager;
        this.department = department;

    }
}
