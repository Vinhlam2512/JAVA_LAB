/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Scanner;

/**
 *
 * @author VINH
 */
public class Validation {

    Scanner sc = new Scanner(System.in);
    
    public int getId(String inputMsg, String errMsg) {
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

    public String getName(String inputMsg, String errMsg) {
        String name;
        do {
            System.out.print(inputMsg);
            name = sc.nextLine().trim().toUpperCase();
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
    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

    String getDate(String inputMsg, String errMsg) {
        String date;
        String[] splited;
        do {
            System.out.print(inputMsg);
            date = sc.nextLine().trim();
        } while (isDateValid(date) == false);
        return date;
    }

    public boolean isDateValid(String date) {
        try {
            DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            df.setLenient(false);
            df.parse(date);
            return true;
        } catch (ParseException e) {
            System.out.println("You need to input like the format dd/mm/yyyy!");
            return false;
        }
    }
}
