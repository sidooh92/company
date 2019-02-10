package com.rent.company.service;

import com.rent.company.domain.CarStatusEnum;
import com.rent.company.domain.CarTypesEnum;
import com.rent.company.domain.RentCompany;

public interface RentCompanyService {
    RentCompany createNewCompany(String name, String website,
                                 String address, String owner,
                                 String logo);
    RentCompany handleDepartmentsFromCompany(RentCompany newCompany, String userChoice, String address);
    void addEmployeWithParams(RentCompany newCompany, String firstName, String lastName, boolean isManager, String deptartamentAddress);
    void createCarForDepartment(RentCompanyServiceImpl rentCompanyService, RentCompany newCompany, String brand, String model, CarTypesEnum carTypesEnum, int productionYear, String color, int mileage, CarStatusEnum carStatusEnum, double costPerDay, String deptAddress);
    }
