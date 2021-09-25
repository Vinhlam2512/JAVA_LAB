/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import java.time.LocalDate;
import java.util.Scanner;

/**
 *
 * @author VINH
 */
public class Validation {

    Scanner sc = new Scanner(System.in);

    int getId(String inputMsg, String errMsg) {
        int id;
        do {
            System.out.print(inputMsg);
            while (!sc.hasNextInt()) {
                System.out.println(errMsg);
                System.out.print(inputMsg);
                sc.nextLine();
            }
            id = Integer.parseInt(sc.nextLine().trim());
        } while (id < 1);
        return id;
    }

    String getName(String inputMsg, String errMsg) {
        String name;
        do {
            System.out.print(inputMsg);
            name = sc.nextLine().trim();
            if (!name.matches("[a-zA-Z]+")) {
                System.out.println(errMsg);
            }
        } while (!name.matches("[a-zA-Z]+"));
        return name;
    }

    String getString(String inputMsg) {
        String string;
        System.out.print(inputMsg);
        string = sc.nextLine().trim();
        return string;
    }

    Double getPrice(String inputMsg, String errMsg) {
        double price;
        do {
            System.out.print(inputMsg);
            while (!sc.hasNextDouble()) {
                System.out.println(errMsg);
                System.out.print(inputMsg);
                sc.nextLine();
            }
            price = Double.parseDouble(sc.nextLine().trim());
        } while (price < 1);
        return price;
    }

    LocalDate getDate(String inputMsg, String errMsg) {
        String date;
        String splited[];
        while (true) {
            try {
                System.out.print(inputMsg);
                date = sc.nextLine().trim();
                splited = date.split("/");
                int month = Integer.parseInt(splited[1]);
                int day = Integer.parseInt(splited[0]);
                int year = Integer.parseInt(splited[2]);
                if (year > 1900 && year < 2100) {
                    LocalDate date1 = LocalDate.of(year, month, day); // check day and month adn year
                    return date1;
                }
            } catch (Exception e) {
                System.out.println(errMsg);
            }
        }
    }
}
