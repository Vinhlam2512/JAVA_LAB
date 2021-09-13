/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.Student;
import java.util.ArrayList;
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
            if (choice <= 0 || choice > 6) {
                System.out.println("You need to input 1 - 5!");
            }

        } while (choice <= 0);
        return choice;
    }

    public boolean hasNumber(String s) {
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
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

    public int checkId(ArrayList<Student> student, int id) {
        int i;
        if (student.isEmpty()) {
            return 0;
        }
        for ( i = 0; i < student.size(); i++) {
            if (student.get(i).getId() == id) {
                return id;
            }
        }
        return 0;
    }
    
    
    public int getFindId(String inputMsg) {
        int fId;
        System.out.print(inputMsg);
        try {
            fId = Integer.parseInt(sc.nextLine());
            return fId;
        } catch (Exception e) {
            return -1;
        }
    }
    
    public String isContinue() {
        System.out.println("Do you want to continue (Y/N)? Choose Y to continue, N to return main screen.");
        do {
            System.out.print("Your choice: ");
            String s = sc.nextLine();
            if (s.equalsIgnoreCase("y")) {
                return "Y";
            }
            if (s.equalsIgnoreCase("n")) {
                return "N";
            }
            if (!s.equalsIgnoreCase("y") || !s.equalsIgnoreCase("n")) {
                System.out.println("You must be choose Y or N");
            }
        } while (true);
    }
    public String isExist(){
        
    }
}
