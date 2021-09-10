/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Controllers.Options;
import java.util.Scanner;
import Controllers.checkInput;

/**
 *
 * @author VINH
 */
public class Main {

    public static void main(String[] args) {
        checkInput check = new checkInput();
        Options ops = new Options();
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("WELCOME TO STUDENT MANAGEMENT");
            System.out.println("    1.	Create");
            System.out.println("    2.	Find and Sort");
            System.out.println("    3.	Update/Delete");
            System.out.println("    4.	Report");
            System.out.println("    5.	Exit");
            int choice = check.choiceInput();
            switch (choice) {
                case 1:
                    ops.create();
                    break;
                case 2:
                    ops.findAndSort();
                    break;
                case 3:
                    break;

                case 4:
                    break;

                case 5:
                    return;
            }
        } while (true);

    }
}
