/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Controllers.Options;
import java.util.Scanner;
import Controllers.checkInput;
import Models.Student;
import java.util.ArrayList;

/**
 *
 * @author VINH
 */
public class Main {

    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList();
        
        students.add(new Student(1, "Nguyen Van A", 1, "C"));
        students.add(new Student(2, "Nguyen Van Z", 2, "Java"));
        students.add(new Student(3, "Nguyen Van K", 3, ".NET"));
        students.add(new Student(5, "Nguyen Van D", 4, "C"));
        students.add(new Student(6, "Nguyen Van V", 5, ".NET"));
        students.add(new Student(7, "Nguyen Van A", 6, "C"));
        students.add(new Student(8, "Nguyen Van Q", 7, "JAVA"));
        students.add(new Student(9, "Nguyen Van F", 8, "C"));
        
        checkInput check = new checkInput();
        Options ops = new Options();
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("-----------------------------");
            System.out.println("WELCOME TO STUDENT MANAGEMENT");
            System.out.println("    1.	Create");
            System.out.println("    2.	Find and Sort by name");
            System.out.println("    3.	Update/Delete by id");
            System.out.println("    4.	Report");
            System.out.println("    5.	Exit");
            int choice = check.choiceInput();
            switch (choice) {
                case 1:
                    ops.create(students);
                    break;
                case 2:
                    ops.findAndSort(students);
                    break;
                case 3:
                    ops.updateOrDelete(students);
                    break;
                case 4:
                    ops.report(students);
                    break;
                case 5:
                    return;
                case 6:
                    for (int i = 0; i < students.size(); i++) {
                        System.out.println(students.get(i).toString());
                    }
                    break;
            }
        } while (true);

    }
}
