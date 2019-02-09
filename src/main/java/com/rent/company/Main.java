package com.rent.company;

import com.rent.company.domain.RentCompany;
import com.rent.company.service.RentCompanyService;
import com.rent.company.service.RentCompanyServiceImpl;

import java.util.Scanner;

public class Main {
    //zad1. dodawanie wypozyczalni
    //zad2. dodawanie i usuwanie oddzialow z wypozyczalni
    //zad3. tworzenie pracownikow
    //zad4. przypisywanie praconikow do oddzialu
    //zad5. tworzenie klienta
    //zad6. tworzenie samochodu
    //zad7. wypozyczenie samochodu...
    public static void main(String[] args) {

        RentCompanyService rentCompanyService = new RentCompanyServiceImpl();

        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        String website = scanner.nextLine();
        String address = scanner.nextLine();
        String owner = scanner.nextLine();
        String logo = scanner.nextLine();
        RentCompany newCompany = rentCompanyService.createNewCompany(name, website,
                address, owner, logo);

        System.out.println(newCompany);


    }


}
