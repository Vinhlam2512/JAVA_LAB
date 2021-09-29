/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Controllers.Options;
import Controllers.Validation;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author VINH
 */
public class View {

    Scanner sc = new Scanner(System.in);

    public void menu() {
        System.out.println("");
        System.out.println("-------------------------------------------------------------------------------------------");
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
            choice = sc.nextInt();
            if (choice < 1 || choice > 8) {
                System.out.println("You need to input choice 1 - 7!");
            }
        } while (choice < 1 || choice > 8);
        return choice;
    }

    public void view() throws ParseException {
        Scanner sc = new Scanner(System.in);
        View v = new View();
        Options ops = new Options();
        Validation val = new Validation();
        int choice, size, n;

        ArrayList<String> nameStoreKeeper = new ArrayList<>();

        do {
            v.menu();
            choice = v.inputChoice();
            switch (choice) {
                case 1:
                    String name;
                    size = val.getId("Input number of storeKeeper you want to add: ", "You need to input integer!");
                    for (int i = 0; i < size; i++) {
                        n = i + 1;
                        name = val.getName("Input name of stor keeper " + n + " : ", "You need to input name of stor keeper!");
                        ops.addStoreKeeper(nameStoreKeeper, name);
                    }
                    break;
                case 2:
//                    ops.add(id, name, location, price, expiryDate, manuOfDate, category, storeKeeper, receiptDate);
                    ops.add();
                    break;
                case 3:
                    int id = val.getId("Input id you want to update:", "You need to input integer!");
                    ops.updateProduct(id);
                    break;
                case 4:
                    ops.search();
                    break;
                case 5:
                    ops.sort();
                    break;
                case 6:
                    ops.addMany();
                    break;
                case 7:
                    ops.show();
                    break;
                case 8:
                    ops.showNameStoreKeeper(nameStoreKeeper);
                    break;
            }
        } while (true);
    }

}
