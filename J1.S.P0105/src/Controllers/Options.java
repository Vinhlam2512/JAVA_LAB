/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.Product;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Date;
import java.util.Random;

/**
 *
 * @author VINH
 */
public class Options {

    Validation val = new Validation();
    Ultils ult = new Ultils();
    ArrayList<String> nameStoreKeeper = new ArrayList<>();

    private ArrayList<Product> products = new ArrayList<Product>();

    int number = 1;

    public ArrayList addStoreKeeper(String name) {
        for (String n : nameStoreKeeper) {
            if (name.equalsIgnoreCase(n)) {
                name = name + number;
                number += 1;
//                return null;
            }
        }
        nameStoreKeeper.add(name);
        return nameStoreKeeper;
    }

    public void add() throws ParseException {
        int id;
        Double price;
        String name, location, category, storeKeeper;
        String expiryDate, manuOfDate, receiptDate;
        int checkDate;
        do {
            id = val.getId("Input id: ", "You need to input integer!");
            if (!ult.idIsExist(products, id)) {
                System.out.println("This id is already exsit!");
            }
        } while (!ult.idIsExist(products, id));
        name = val.getName("Input name: ", "You need to input correct name of product!");
        price = val.getPrice("Input price: ", "Price not contains character");
        location = val.getString("Input location: ");
        expiryDate = val.getDate("Input Expiry Date: ", "You need to input like the format dd/mm/yyyy!");
        do {
            manuOfDate = val.getDate("Input Manufacture Date: ", "You need to input like the format dd/mm/yyyy!");
            checkDate = val.compareDate(expiryDate, manuOfDate);
        } while (checkDate >= 0);
        category = val.getString("Input category: ");
        storeKeeper = val.checkName(nameStoreKeeper);
        receiptDate = val.getDate("Input Receipt Date: ", "You need to input like the format dd/mm/yyyy!");
        products.add(new Product(id, name, location, price, expiryDate, manuOfDate, category, storeKeeper, receiptDate));
    }

    public boolean updateProduct(int idUpdate) throws ParseException {
        int id;
        Double price;
        String name, location, category, storeKeeper;
        String expiryDate, manuOfDate, receiptDate;
        int checkDate;
        if (ult.findById(products, idUpdate) != -1) {
            id = ult.findById(products, idUpdate);
            name = val.getName("Input name: ", "You need to input correct name of product!");
            price = val.getPrice("Input price: ", "Price not contains character");
            location = val.getString("Input location: ");
            expiryDate = val.getDate("Input Expiry Date: ", "You need to input like the format dd/mm/yyyy!");
            do {
                manuOfDate = val.getDate("Input Manufacture Date: ", "You need to input like the format dd/mm/yyyy!");
                checkDate = val.compareDate(expiryDate, manuOfDate);
            } while (checkDate >= 0);
            category = val.getString("Input category: ");
            storeKeeper = val.checkName(nameStoreKeeper);
            receiptDate = val.getDate("Input Receipt Date: ", "You need to input like the format dd/mm/yyyy!");
            products.set(ult.index, new Product(id, name, location, price, expiryDate, manuOfDate, category, storeKeeper, receiptDate));
            return true;
        }
        return false;
    }

    public ArrayList search(int choice, String s) {
        ArrayList<Product> list;
        if (choice == 1) {
            list = ult.searchByName(products, s);
        } else if (choice == 2) {
            list = ult.searchByCategory(products, s);
        } else if (choice == 3) {
            list = ult.searchByStoreKeeper(products, s);
        } else {
            list = ult.searchByDate(products, s);
        }
        return list;
    }

    public ArrayList sort(int choice) {
        if (choice == 1) {
            Collections.sort(products, (Product p1, Product p2) -> {
                return p1.getExpiryDate().compareTo(p2.getExpiryDate());
            });
        } else {
            Collections.sort(products, (Product p1, Product p2) -> {
                return p1.getManuOfDate().compareTo(p2.getManuOfDate());
            });
        }
        return products;
    }

    public Options() {
        products.add(new Product(1, "Quan", "MC", 4.6, "2001/1/6", "2001/3/30", "Quan ao", "Lam", "2001/3/7"));
        products.add(new Product(1, "Quan", "MC", 4.6, "2001/1/3", "2001/3/3", "Quan ao", "Lam", "2001/3/7"));
        products.add(new Product(2, "Ao", "HN", 4.6, "2001/9/3", "2000/4/4", "Quan ao", "Quang", "2001/3/5"));
        products.add(new Product(3, "Banh", "BG", 4.6, "2001/3/3", "2001/3/2", "thuc an", "Vinh", "2001/3/10"));
    }

    public void show() {
        System.out.printf("%s |%-5s |%s |%s |%s |%s |%-10s |%-10s |%-15s\n", "ID", "Name", "Location", "Price", "Expiry date", "Date of manufacture", "Category", "Storekeeper", "ReceiptDate");
        System.out.println("--------------------------------------------------------------------------------------------------");
        for (Product product : products) {
//            System.out.println("|ID |Name |Location |Price |Expiry date\t|Date of manufacture|Category|Storekeeper|ReceiptDate");
//            System.out.println(product.toString());
            System.out.printf("%-2s |%-5s |%-8s |%-5s |%-11s |%-19s |%-10s |%-11s |%-1s\n",
                    product.getId(), product.getName(), product.getLocation(), product.getPrice(), product.getExpiryDate(), product.getManuOfDate(), product.getCategory(), product.getStoreKeeper(), product.getReceiptDate());

        }
    }

    Product product() throws ParseException {

    }

    public void showNameStoreKeeper(ArrayList<String> nameStoreKeeper) {
        for (String n : nameStoreKeeper) {
            System.out.println(n);
        }
    }
}
