/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import java.util.Scanner;

/**
 *
 * @author VINH
 */
public class View {

    Scanner sc = new Scanner(System.in);

    public void menu() {
        System.out.println("1.	Add Storekeeper");
        System.out.println("2.	Add product");
        System.out.println("3.	Update product");
        System.out.println("4.	Search product by Name, Category, Storekeeper, ReceiptDate");
        System.out.println("5.	Sort product by Expiry date, Date of manufacture");
        System.out.println("6.      Add many");
        System.out.println("7.      Show");
        System.out.println("8.      Exit");
    }

    public int inputChoice() {
        int choice;
        do {
            System.out.print("Input your choice: ");
            while (!sc.hasNextInt()) {
                System.out.println("You need to input integer!");
                System.out.print("Input your choice: ");
                sc.next();
            }
            choice = Integer.parseInt(sc.nextLine());
            if (choice < 1 || choice > 7) {
                System.out.println("You need to input choice 1 - 7!");
            }
        } while (choice < 1 || choice > 8);
        return choice;
    }
}
