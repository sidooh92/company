package com.rent.company;

import com.rent.company.domain.CarStatusEnum;
import com.rent.company.domain.CarTypesEnum;
import com.rent.company.domain.Client;
import com.rent.company.domain.RentCompany;
import com.rent.company.service.RentCompanyService;
import com.rent.company.service.RentCompanyServiceImpl;
import lombok.extern.java.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Log
public class Main {

    //zad8. wypozyczenie samochodu
    //wypozyczenie samochodu - utworzenie rezerwacji...
    //zwrot samochodu - aktualizacja kilometrow,
    //przypisanie samochodu do departamentu zwrotu oraz obliczenie kosztu calkowitego rezerwacji
    //zad9. zrzut stanu aplikacji do pliku txt (dla przecwiczenia zapisu do pliku)
    //zad10. zastapenie System.out.println przez loggera
    //zad11. dokananie refaktoryzacji kodu  interfejsy + klasy service
    //zad12. napisac testy jednostkowe o pokryciu 75%-80% +
    //zad13. dodanie bazy danych + jdbc/hibernate
    //zad14. zaimplementowanie rzeczy z pdf od zadania

    public static void main(String[] args) {
        log.info("TEST logger config");

        Scanner scanner = new Scanner(System.in);
        RentCompanyService rentCompanyService = new RentCompanyServiceImpl();
        RentCompany currentCompany = null;
        List<RentCompany> companies = new ArrayList<>();
        showInstructions();

        String action = "";
        while (!action.equalsIgnoreCase("10")) {
            action = scanner.nextLine();

            if (action.equalsIgnoreCase("0")) {
                companies.forEach(company -> System.out.println(company.getName()));
                String chosenCompanyName = scanner.nextLine();
                currentCompany = null;
                for (RentCompany company : companies) {
                    if (company.getName().equalsIgnoreCase(chosenCompanyName)) {
                        currentCompany = company;
                        break;
                    }
                }
                if(currentCompany == null) {
                    System.out.println("Try again, company with name " +
                            "you gave does not exist");
                }


            } else if (action.equalsIgnoreCase("1")) {
                System.out.println("Creating new company");
                currentCompany = createCompany(scanner, rentCompanyService, companies);
                System.out.println("New company created");

            } else if (action.equalsIgnoreCase("2")) {
                System.out.println("Creating new departament");
                if (currentCompany != null) {
                    currentCompany = handleCompanyDepartments(scanner, rentCompanyService, currentCompany);
                    System.out.println("New departament created");
                } else {
                    System.out.println("First you need create company");
                }

            } else if (action.equalsIgnoreCase("3")) {
                System.out.println("Display company status");
                System.out.println(currentCompany);
                System.out.println("Dispaly clients: ");
                currentCompany.getClientList().forEach(System.out::println);

            } else if (action.equalsIgnoreCase("4")) {
                System.out.println("Creating empolyee with department ,pass firstName, lastName, manager, dept address");
                addNewEmployeeWithDepartment(scanner, currentCompany, rentCompanyService);

            } else if (action.equalsIgnoreCase("5")) {
                System.out.println("Creating client");
                addClient(currentCompany.getClientList(), scanner);
                System.out.println("Client created");

            } else if (action.equalsIgnoreCase("6")) {
                System.out.println("Creating car");
                addCar(scanner, (RentCompanyServiceImpl) rentCompanyService, currentCompany);
                System.out.println("Car created");
            }


        }


    }

    private static void addCar(Scanner scanner, RentCompanyServiceImpl rentCompanyService, RentCompany newCompany) {
        String brand = scanner.nextLine();
        String model = scanner.nextLine();
        CarTypesEnum carTypesEnum = CarTypesEnum.valueOf(scanner.nextLine());
        int productionYear = Integer.parseInt(scanner.nextLine());
        String color = scanner.nextLine();
        int mileage = Integer.parseInt(scanner.nextLine());
        CarStatusEnum carStatusEnum = CarStatusEnum.valueOf(scanner.nextLine());
        double costPerDay = Double.parseDouble(scanner.nextLine());
        String deptAddress = scanner.nextLine();

        rentCompanyService.createCarForDepartment(rentCompanyService, newCompany, brand, model, carTypesEnum, productionYear, color, mileage, carStatusEnum, costPerDay, deptAddress);
    }


    private static void addClient(List<Client> clientList, Scanner scanner) {
        String firstName = scanner.nextLine();
        String lastName = scanner.nextLine();
        String addresses = scanner.nextLine();
        String mail = scanner.nextLine();
        Client client = new Client(firstName, lastName, addresses, mail);
        clientList.add(client);
    }

    public static void addNewEmployeeWithDepartment(Scanner scanner, RentCompany newCompany, RentCompanyService rentCompanyService) {
        String firstName = scanner.nextLine();
        String lastName = scanner.nextLine();
        String isManagerString = scanner.nextLine();
        boolean isManager = isManagerString.equalsIgnoreCase("y");
        String deptartamentAddress = scanner.nextLine();

        rentCompanyService.addEmployeWithParams(newCompany, firstName, lastName, isManager, deptartamentAddress);
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


    private static RentCompany createCompany(Scanner scanner, RentCompanyService rentCompanyService, List<RentCompany> companies) {
        System.out.println("Pass params");
        String name = scanner.nextLine();
        String website = scanner.nextLine();
        String address = scanner.nextLine();
        String owner = scanner.nextLine();
        String logo = scanner.nextLine();
        System.out.println("Passed all params");
        RentCompany newCompany = rentCompanyService.createNewCompany(name, website,
                address, owner, logo);
        companies.add(newCompany);
        return newCompany;
    }


}
