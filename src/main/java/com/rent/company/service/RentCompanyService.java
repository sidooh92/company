package com.rent.company.service;

import com.rent.company.domain.RentCompany;

public interface RentCompanyService {
    RentCompany createNewCompany(String name, String website,
                                 String address, String owner,
                                 String logo);
    RentCompany handleDepartmentsFromCompany(RentCompany newCompany, String userChoice, String address);
}
