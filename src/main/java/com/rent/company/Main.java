package com.rent.company;

import com.rent.company.domain.Department;
import com.rent.company.domain.RentCompany;
import com.rent.company.service.RentCompanyService;
import com.rent.company.service.RentCompanyServiceImpl;

import java.sql.SQLOutput;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    //zad2. dodawanie i (usuwanie) oddzialow z wypozyczalni
    //zad3. tworzenie pracownikow
    //zad4. przypisywanie praconikow do oddzialu
    //zad5. tworzenie klienta
    //zad6. tworzenie samochodu
    //zad7. wypozyczenie samochodu...
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RentCompanyService rentCompanyService = new RentCompanyServiceImpl();

        System.out.println("How program works:");
        System.out.println("Option 1 to create new company - pass all needed info");
        System.out.println("Option 2 to create department for given company");
        System.out.println("Option 3 display company with departments");
        System.out.println("Option 4 exit program");
        RentCompany newCompany = null;
        String action = "";

        while (!action.equalsIgnoreCase("4")) {
            action = scanner.nextLine();
            if (action.equalsIgnoreCase("1")) {
                System.out.println("CHOSEN 1");
                newCompany = createCompany(scanner, rentCompanyService);
            } else if (action.equalsIgnoreCase("2")) {
                System.out.println("CHOSEN 2");
                if(newCompany != null) {
                    System.out.println("Do you want to create(1) or delete(2) departament ");
                    String userChoice =  scanner.nextLine();
                    if(userChoice.equalsIgnoreCase("1")) {
                        String address = scanner.nextLine();
                        if(!checkIfDepartamentExists(address, newCompany.getDepartmentList())) {
                            Department department = new Department(address);
                            newCompany.getDepartmentList().add(department);
                        }
                    }
                    else if (userChoice.equalsIgnoreCase("2"))
                    {
                        String address = scanner.nextLine();
                        if(checkIfDepartamentExists(address,newCompany.getDepartmentList()))                         {
                            List<Department> departmentList = newCompany.getDepartmentList();
                            for(Department d : departmentList) {
                                if(d.getAddress().equalsIgnoreCase(address)) {
                                    departmentList.remove(d);
                                    break;
                                }
                            }

                        }

                    }
                    else {
                        System.out.println("CHOSEN 3");
                        System.out.println("Wrong option, try again");
                    }




                }
                else {
                    System.out.println("First you need create company");
                }

            } else if (action.equalsIgnoreCase("3")) {
                System.out.println(newCompany);
            }


        }


    }

    private static boolean checkIfDepartamentExists(String address, List<Department> departmentList) {
        int size = departmentList
                .stream()
                .filter(d -> d.getAddress().equalsIgnoreCase(address))
                .collect(Collectors.toList()).size();

        return size > 0;
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
