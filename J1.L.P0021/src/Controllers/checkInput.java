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
                System.out.println("You need to input 1 - 5!");
            }

        } while (choice <= 0);
        return choice;
    }
    public boolean  hasNumber(String s){
        for (char c : s.toCharArray()) {
            if(Character.isDigit(c)){
                return true;
            }
        }
        return false;
    }
    public boolean checkCourse(String course, String[] courses) {
        int i;
        for (i = 0; i < courses.length; i++) {
            if (course.equalsIgnoreCase(courses[i])) {
                return true;
            }
        }
        return false;
    }
}
