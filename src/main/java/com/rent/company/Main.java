package com.rent.company;

import com.rent.company.domain.Department;
import com.rent.company.domain.Employee;
import com.rent.company.domain.RentCompany;
import com.rent.company.service.RentCompanyService;
import com.rent.company.service.RentCompanyServiceImpl;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Main {

    //zad5. tworzenie klienta
    //zad6. tworzenie samochodu
    //zad6b rozbudowanie aplikacji o zarzadzanie wieloma firmami
    //zad7. wypozyczenie samochodu...
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RentCompanyService rentCompanyService = new RentCompanyServiceImpl();
        RentCompany newCompany = null;
        showInstructions();

        String action = "";
        while (!action.equalsIgnoreCase("10")) {
            action = scanner.nextLine();
            if (action.equalsIgnoreCase("1")) {
                newCompany = createCompany(scanner, rentCompanyService);
            } else if (action.equalsIgnoreCase("2")) {
                if (newCompany != null) {
                    newCompany = handleCompanyDepartments(scanner, rentCompanyService, newCompany);
                } else {
                    System.out.println("First you need create company");
                }
            } else if (action.equalsIgnoreCase("3")) {
                System.out.println(newCompany);

            } else if (action.equalsIgnoreCase("4")) {
                String firstName = scanner.nextLine();
                String lastName = scanner.nextLine();
                boolean isManager = scanner.nextBoolean();
                String deptartamentAddress = scanner.nextLine();

                Optional<Department> department = findDepartmentByAddress(newCompany, deptartamentAddress);

                if(department.isPresent()) {
                    Employee emp = new Employee(firstName, lastName, isManager, department.get());
                    department.get().getEmployeeList().add(emp);
                }
                else {
                    System.out.println("Cannot add employee to departament that does not exist");
                }
                //sprawdzic czy istnieje departament
                //jezeli tak to dodac do niego pracownika
                //jezeli nie to wyswietlic komunikat

                //zad3. tworzenie pracownikow
                //zad4. przypisywanie praconikow do oddzialu
            }


        }


    }

    private static Optional<Department> findDepartmentByAddress(RentCompany newCompany, String deptartamentAddress) {
        List<Department> departmentList = newCompany.getDepartmentList();
        return departmentList
                .stream()
                .filter(dep -> dep.getAddress().equalsIgnoreCase(deptartamentAddress))
                .findFirst();
    }

    private static RentCompany handleCompanyDepartments(Scanner scanner, RentCompanyService rentCompanyService, RentCompany newCompany) {
        System.out.println("Do you want to create(1) or delete(2) departament ");
        String userChoice = scanner.nextLine();
        System.out.println("Enter departmens address");
        String address = scanner.nextLine();

        newCompany = rentCompanyService.handleDepartmentsFromCompany(newCompany, userChoice, address);
        return newCompany;
    }


    private static void showInstructions() {
        System.out.println("How program works:");
        System.out.println("Option 1 to create new company - pass all needed info");
        System.out.println("Option 2 to create department for given company");
        System.out.println("Option 3 display company with departments");
        System.out.println("Option 4 add new worker to given departament");
        System.out.println("Option 5 add new client");
        System.out.println("Option 6 add new car");
        System.out.println("Option 7 rent a car");
        System.out.println("Option 10 exit program");

    }


    private static RentCompany createCompany(Scanner scanner, RentCompanyService rentCompanyService) {
        System.out.println("Pass params");
        String name = scanner.nextLine();
        String website = scanner.nextLine();
        String address = scanner.nextLine();
        String owner = scanner.nextLine();
        String logo = scanner.nextLine();
        System.out.println("Passed all params");
        return rentCompanyService.createNewCompany(name, website,
                address, owner, logo);
    }


}
