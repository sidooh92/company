package com.rent.company.service;

import com.rent.company.domain.Department;
import com.rent.company.domain.Employee;
import com.rent.company.domain.RentCompany;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class RentCompanyServiceImpl implements RentCompanyService {

    @Override
    public RentCompany createNewCompany(String name, String website,
                                        String address, String owner,
                                        String logo) {
        RentCompany rentCompany =
                new RentCompany(name, website, address, owner, logo);
        return rentCompany;
    }

    @Override
    public RentCompany handleDepartmentsFromCompany(RentCompany newCompany, String userChoice, String address) {
        if (userChoice.equalsIgnoreCase("1")) {
            addDepartment(newCompany, address);
        } else if (userChoice.equalsIgnoreCase("2")) {
            removeDepartament(newCompany, address);
        } else {
            System.out.println("Wrong option, try again");
        }
        return newCompany;
    }

    private static boolean checkIfDepartamentExists(String address, List<Department> departmentList) {
        int size = departmentList
                .stream()
                .filter(d -> d.getAddress().equalsIgnoreCase(address))
                .collect(Collectors.toList()).size();

        return size > 0;
    }


    private void addDepartment(RentCompany newCompany, String address) {
        if (!checkIfDepartamentExists(address, newCompany.getDepartmentList())) {
            Department department = new Department(address);
            newCompany.getDepartmentList().add(department);
        }
    }

    private void removeDepartament(RentCompany newCompany, String address) {
        if (checkIfDepartamentExists(address, newCompany.getDepartmentList())) {
            List<Department> departmentList = newCompany.getDepartmentList();
            for (Department d : departmentList) {
                if (d.getAddress().equalsIgnoreCase(address)) {
                    departmentList.remove(d);
                    break;
                }
            }
        }
    }



    public void addEmployeWithParams(RentCompany newCompany, String firstName, String lastName, boolean isManager, String deptartamentAddress) {
        Optional<Department> department = findDepartmentByAddress(newCompany, deptartamentAddress);

        if(department.isPresent()) {
            Employee emp = new Employee(firstName, lastName, isManager, department.get());
            department.get().getEmployeeList().add(emp);
            System.out.println("Employee added");
        }
        else {
            System.out.println("Cannot add employee to departament that does not exist");
        }
    }

    private Optional<Department> findDepartmentByAddress(RentCompany newCompany, String deptartamentAddress) {
        List<Department> departmentList = newCompany.getDepartmentList();
        return departmentList
                .stream()
                .filter(dep -> dep.getAddress().equalsIgnoreCase(deptartamentAddress))
                .findFirst();
    }

}
