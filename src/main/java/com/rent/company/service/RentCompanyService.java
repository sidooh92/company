package com.rent.company.service;

import com.rent.company.domain.RentCompany;

public interface RentCompanyService {
    RentCompany createNewCompany();
    RentCompany addDepartmentToCompany();
    RentCompany removeDepartmentFromCompany();
}
