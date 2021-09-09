/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author VINH
 */
public class Validation {

    static Scanner sc = new Scanner(System.in);
    public boolean isNumeric(String str) {

        // null or empty
        if (str == null || str.length() == 0) {
            return false;
        }

        for (char c : str.toCharArray()) {
            if (Character.isDigit(c)) {
                return false;
            }
        }

        return true;

    }
    public Boolean checkCourse(String coursesName[], String courseName) {
        for (String course : coursesName) {
            if (courseName.equalsIgnoreCase(course)) {
                return true;
            }
        }
        return false;
    }

    public void main(String[] args) {
        int id;
        do {
            System.out.println("Please enter a positive number!");
            while (!sc.hasNextInt()) {
                System.out.println("That's not a number! ");
                sc.next();
            }
            id = sc.nextInt();
        } while (id <= 0);
        System.out.println(id);
//        sc.next();
//        id = sc.nextInt();
//        System.out.println("     " + id);
    }
}
