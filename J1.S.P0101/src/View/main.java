/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.util.Scanner;
import Controllers.checkInput;
import Controllers.Options;


/**
 *
 * @author VINH
 */
public class main {

    public static void main(String[] args) {

        Options ops = new Options();
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

                    break;
                case 4:

                    break;
                case 5:

                    break;
                case 6:
                    return;
            }
        } while (true);
    }
}
