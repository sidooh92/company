package com.rent.company.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@ToString
@Getter
@Setter
public class RentCompany {
    private String name;
    private String website;
    private String address;
    private String owner;
    private String logo;
    private List<Department> departmentList;

    public RentCompany(String name, String website, String address, String owner, String logo) {
        this.name = name;
        this.website = website;
        this.address = address;
        this.owner = owner;
        this.logo = logo;
        this.departmentList = new ArrayList<>();
    }
}
