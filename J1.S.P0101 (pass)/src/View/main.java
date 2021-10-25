/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controllers.Controllers;
import Controllers.RenderView;
import Controllers.checkInput;
import Models.Employee;
import java.util.Scanner;

/**
 *
 * @author VINH
 */
public class main {

    public static void main(String[] args) {
        Controllers ops = new Controllers();
        checkInput check = new checkInput();
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("EMPLOYEE MANAGEMENT SYSTEM");
            System.out.println("    1.	Add employees ");
            System.out.println("    2.	Update employees");
            System.out.println("    3.	Remove employees");
            System.out.println("    4.	Search employees");
            System.out.println("    5.	Sort employees by salary");
            System.out.println("    6.	Exit");
            choice = check.choiceInput();
            switch (choice) {
                case 1:
                    ops.addEmployees();
                    break;
                case 2:
                    ops.updateEmployees();
                    break;
                case 3:
                    ops.removeEmployees();
                    break;
                case 4:
                    ops.searchEmployees();
                    break;
                case 5:
                    ops.sortEmployees();
                    break;
                case 6:
                    ops.test();
                    break;
                case 7:
                    ops.add();
                    break;
            }
        } while (true);
    }
}
