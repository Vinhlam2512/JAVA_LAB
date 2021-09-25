/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import java.util.Scanner;

/**
 *
 * @author VINH
 */
public class checkInput {

    Scanner sc = new Scanner(System.in);

    public int choiceInput() {
        int choice;
        do {
            System.out.print("Your choice: ");
            while (!sc.hasNextInt()) {
                System.out.println("You need to input integer! ");
                System.out.print("Your choice: ");
                sc.next();
            }
            choice = sc.nextInt();
            if (choice <= 0) {
                System.out.println("You need to input 1 - 6!");
            }

        } while (choice <= 0 || choice > 7);
        return choice;
    }

    public boolean hasNumber(String s) {
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }

    public boolean isAllNumber(String s) {
        int length = s.length();
        int count = 0;
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                count++;
            }
        }
        if (count == 10 && length == 10) {
            return true;
        }
        return false;
    }

    public boolean isEmail(String email) {
        String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        return email.matches(regex);
    }

    public int validateYear(int year) {
        if (1960 > year || year > 2003) {
            System.out.println("Please input year in 1960 to 2003");
            return 0;
        }
        return 1;
    }

    public boolean validateSalary(String s) {
        int length = s.length();
        int count = 0;
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                count++;
            }
        }
        if (count == length) {
            return true;
        }
        return false;
    }
}
