/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Controllers.Controller;
import Controllers.RenderViews;
import Controllers.checkInput;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author VINH
 */
public class Main {

    public static void main(String[] args) {
        checkInput check = new checkInput();
        Controller ops = new Controller();
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
                    ops.create();
                    break;
                case 2:
                    ops.findAndSort();
                    break;
                case 3:
                    ops.updateOrDelete();
                    break;
                case 4:
                    ops.report();
                    break;
                case 5:
                    ops.test();
                    break;
                case 6:
                    ops.demo();
                    break;
            }
        } while (true);
    }
}
