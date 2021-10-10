/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Controllers.Options;
import Controllers.Validation;
import Models.Product;
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
        System.out.println("6.      Show");
        System.out.println("7.      Exit");
    }

    public void menuSearch() {
        System.out.println("Input field you want to search: ");
        System.out.println("1. Name");
        System.out.println("2. Category");
        System.out.println("3. StoreKeeper");
        System.out.println("4. ReceiptDate");
    }

    public void menuSort() {
        System.out.println("Input field you want to sort: ");
        System.out.println("1. Expiry date");
        System.out.println("2. Date of manufacture");
    }

    void printf(ArrayList<Product> product, int i) {
        System.out.printf("%-2s |%-5s |%-8s |%-5s |%-11s |%-19s |%-10s |%-11s |%-1s\n",
                product.get(i).getId(), product.get(i).getName(), product.get(i).getLocation(), product.get(i).getPrice(), product.get(i).getExpiryDate(), product.get(i).getManuOfDate(), product.get(i).getCategory(), product.get(i).getStoreKeeper(), product.get(i).getReceiptDate());
    }

    public void view() throws ParseException {
        Scanner sc = new Scanner(System.in);
        Options ops = new Options();
        Validation val = new Validation();
        int choice, size, n;
        String field;
        do {
            menu();
            choice = val.inputChoice(1, 8);
            switch (choice) {
                case 1:
                    String name;
                    size = val.getId("Input number of storeKeeper you want to add: ", "You need to input integer!");
                    for (int i = 0; i < size; i++) {
                        n = i + 1;
                        name = val.getName("Input name of stor keeper " + n + " : ", "You need to input name of store keeper!");
                        ops.addStoreKeeper(name);
                    }
                    break;
                case 2:
                    ops.add();
                    break;
                case 3:
                    int id = val.getId("Input id you want to update:", "You need to input integer!");
                    if (ops.updateProduct(id)) {
                        System.out.println("--------------------------------Update Success--------------------------------");
                    } else {
                        System.out.println("--------------------------------Id doesnot exist--------------------------------");
                    }
                    break;
                case 4:
                    ArrayList<Product> listSearch;
                    String sSearch;
                    menuSearch();
                    choice = val.inputChoice(1, 4);
                    switch (choice) {
                        case 1:
                            sSearch = val.getName("Input name: ", "You need to input name of product!");
                            listSearch = ops.search(choice, sSearch);
                            if (listSearch.isEmpty()) {
                                System.out.println("--------------------------------Name does not exist!--------------------------------");
                                break;
                            }
                            System.out.printf("%s |%-5s |%s |%s |%s |%s |%-10s |%-10s |%-15s\n", "ID", "Name", "Location", "Price", "Expiry date", "Date of manufacture", "Category", "Storekeeper", "ReceiptDate");
                            for (int i = 0; i < listSearch.size(); i++) {
                                printf(listSearch, i);
                            }
                            break;
                        case 2:
                            sSearch = val.getString("Input category: ");
                            listSearch = ops.search(choice, sSearch);
                            if (listSearch.isEmpty()) {
                                System.out.println("--------------------------------Category does not exist!--------------------------------");
                                break;
                            }
                            System.out.printf("%s |%-5s |%s |%s |%s |%s |%-10s |%-10s |%-15s\n", "ID", "Name", "Location", "Price", "Expiry date", "Date of manufacture", "Category", "Storekeeper", "ReceiptDate");
                            for (int i = 0; i < listSearch.size(); i++) {
                                printf(listSearch, i);
                            }
                            break;
                        case 3:
                            sSearch = val.getName("Input name of storeKeeper: ", "You need to input correct name of store keeper!");
                            listSearch = ops.search(choice, sSearch);
                            if (listSearch.isEmpty()) {
                                System.out.println("--------------------------------Name of storeKeeper does not exist!--------------------------------");
                                break;
                            }
                            System.out.printf("%s |%-5s |%s |%s |%s |%s |%-10s |%-10s |%-15s\n", "ID", "Name", "Location", "Price", "Expiry date", "Date of manufacture", "Category", "Storekeeper", "ReceiptDate");
                            for (int i = 0; i < listSearch.size(); i++) {
                                printf(listSearch, i);
                            }
                            break;
                        case 4:
                            sSearch = val.getDate("Input Receipt Date: ", "You need to input like the format dd/mm/yyyy!");
                            listSearch = ops.search(choice, sSearch);
                            if (listSearch.isEmpty()) {
                                System.out.println("--------------------------------Receipt Date does not exist!--------------------------------");
                                break;
                            }
                            System.out.printf("%s |%-5s |%s |%s |%s |%s |%-10s |%-10s |%-15s\n", "ID", "Name", "Location", "Price", "Expiry date", "Date of manufacture", "Category", "Storekeeper", "ReceiptDate");
                            for (int i = 0; i < listSearch.size(); i++) {
                                printf(listSearch, i);
                            }
                            break;
                    }
                    break;
                case 5:
                    ArrayList<Product> listSort;
                    String date;
                    menuSort();
                    choice = val.inputChoice(1, 2);
                    switch (choice) {
                        case 1:
                            listSort = ops.sort(choice);
                            if (listSort.isEmpty()) {
                                System.out.println("--------------------------------Dont have data to sort--------------------------------");
                                break;
                            }
                            System.out.printf("%s |%-5s |%s |%s |%s |%s |%-10s |%-10s |%-15s\n", "ID", "Name", "Location", "Price", "Expiry date", "Date of manufacture", "Category", "Storekeeper", "ReceiptDate");
                            for (int i = 0; i < listSort.size(); i++) {
                                printf(listSort, i);
                            }
                            break;
                        case 2:
                            listSort = ops.sort(choice);
                            if (listSort.isEmpty()) {
                                System.out.println("--------------------------------Dont have data to sort--------------------------------");
                                break;
                            }
                            System.out.printf("%s |%-5s |%s |%s |%s |%s |%-10s |%-10s |%-15s\n", "ID", "Name", "Location", "Price", "Expiry date", "Date of manufacture", "Category", "Storekeeper", "ReceiptDate");
                            for (int i = 0; i < listSort.size(); i++) {
                                printf(listSort, i);
                            }
                            break;
                    }
                    break;
                case 6:
                    ops.show();
                    break;
                case 7:
                    break;
                case 8:
//                    ops.showNameStoreKeeper(nameStoreKeeper);
                    break;
            }
        } while (true);
    }

}
