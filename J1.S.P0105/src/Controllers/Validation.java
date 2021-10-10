/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.Product;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author VINH
 */
public class Validation {

    Scanner sc = new Scanner(System.in);

    public int inputChoice(int min, int max) {
        int choice;
        do {
            System.out.print("Input your choice: ");
            while (!sc.hasNextInt()) {
                System.out.println("You need to input integer!");
                System.out.print("Input your choice: ");
                sc.next();
            }
            choice = Integer.parseInt(sc.nextLine());
            if (choice < min || choice > max) {
                System.out.println("You need to input choice 1 - " + max);
            }
        } while (choice < min || choice > max);
        return choice;
    }

    public int getId(String inputMsg, String errMsg) {
        int id;
        do {
            System.out.print(inputMsg);
            while (!sc.hasNextInt()) {
                System.out.println(errMsg);
                System.out.print(inputMsg);
                sc.nextLine();
            }
            id = Integer.parseInt(sc.nextLine());
        } while (id < 1);
        return id;
    }

    public String getName(String inputMsg, String errMsg) {
        String name;

        while (true) {
            System.out.print(inputMsg);
            name = sc.nextLine().trim().toUpperCase();
            if (name.matches("^[A-Za-z]+([\\ A-Za-z]+)*")) {
                return name;
            }
            System.out.println(errMsg);
        }
    }

    public String getString(String inputMsg) {
        String string;
        System.out.print(inputMsg);
        string = sc.nextLine().trim();
        return string;
    }

    public Double getPrice(String inputMsg, String errMsg) {
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

    public String getDate(String inputMsg, String errMsg) {
        String date;
        String[] splited;
        do {
            System.out.print(inputMsg);
            date = sc.nextLine().trim();
        } while (isDateValid(date) == false);
        return date;
    }

    SimpleDateFormat sdformat = new SimpleDateFormat("yyyy/MM/dd");

    public int compareDate(String expiryDate, String manuOfDate) throws ParseException { // compare 2 date
        Date date1, date2;
        date1 = sdformat.parse(expiryDate);
        date2 = sdformat.parse(manuOfDate);
        if (date1.after(date2)) {
            System.out.println("Manufacture Date need after Expiry Date!");
            return 1;
        } else {
            return -1;
        }
    }

    public boolean isDateValid(String date) { // check format date
        try {
            DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
            df.setLenient(false);
            df.parse(date);
            return true;
        } catch (ParseException e) {
            System.out.println("You need to input like the format yyyy/MM/dd!");
            return false;
        }
    }

    public String checkName(ArrayList<String> nameStoreKeeper) {
        if (nameStoreKeeper.size() != 0) {
            System.out.println("List name of storeKeeper you need to choose:");
            for (int i = 0; i < nameStoreKeeper.size(); i++) {
                int n = i + 1;
                System.out.println(n + ". " + nameStoreKeeper.get(i));
            }
            do {
                String storeKeeper = getName("Input name of storeKeeper: ", "You need to input correct name of store keeper!");
                for (String str : nameStoreKeeper) {
                    if (str.equalsIgnoreCase(storeKeeper)) {
                        return storeKeeper;
                    }
                }
            } while (true);
        }
        String storeKeeper = getName("Input name of storeKeeper: ", "You need to input correct name of store keeper!");
        return storeKeeper;
    }
}
