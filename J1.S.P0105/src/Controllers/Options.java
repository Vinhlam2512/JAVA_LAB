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
import java.util.Date;
import java.util.Random;

/**
 *
 * @author VINH
 */
public class Options {

    Validation val = new Validation();

    private ArrayList<Product> products = new ArrayList<Product>();
    private ArrayList<String> nameStoreKeeper = new ArrayList<>();
    SimpleDateFormat sdformat = new SimpleDateFormat("dd/MM/yyyy");
    int number = 1;

    public ArrayList addStoreKeeper(String name) {
        for (String n : nameStoreKeeper) {
            if (name.equalsIgnoreCase(n)) {
                name = name + number;
                number += 1;
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
        Date date1, date2;

//        id = val.getId("Input id: ", "You need to input integer!");
//        name = val.getName("Input name: ", "You need to input correct name of product!");
//        location = val.getString("Input location: ");
//        price = val.getPrice("Input price: ", "Price not contains character");
//        expiryDate = val.getDate("Input Expiry Date: ", "You need to input like the format dd/mm/yyyy!");
//        do {
//            manuOfDate = val.getDate("Input Manufacture Date: ", "You need to input like the format dd/mm/yyyy!");
//            date1 = sdformat.parse(expiryDate);
//            date2 = sdformat.parse(manuOfDate);
//            if (date1.compareTo(date2) >= 0) {
//                System.out.println("Manufacture Date need after Expiry Date!");
//            }
//        } while (date1.compareTo(date2) >= 0);
//        category = val.getString("Input category: ");
        storeKeeper = checkName();

        receiptDate = val.getDate("Input Receipt Date: ", "You need to input like the format dd/mm/yyyy!");
        products.add(new Product(id, name, location, price, name, name, category, storeKeeper, location));
    }

    public void updateProduct() {

    }

    public void search() {

    }

    public void sort() {

    }

    public void addMany() {
        products.add(new Product(1, "vinh", "MC", 4.6, "3/3/2001", "3/3/2001", "thuc an", "vinh", "3/3/2001"));
    }

    public void show() {
        for (Product product : products) {
            System.out.println(product.toString());
        }
    }

    public void showNameStoreKeeper() {
        for (String n : nameStoreKeeper) {
            System.out.println(n);
        }
    }

    String checkName() {
        if (nameStoreKeeper.size() != 0) {
            System.out.println("List name of storeKeeper you need to choose:");
            for (int i = 0; i < nameStoreKeeper.size(); i++) {
                int n = i + 1;
                System.out.println(n + ". " + nameStoreKeeper.get(i));
            }
            do {
                String storeKeeper = val.getName("Input name of storeKeeper: ", "You need to input correct name of store keeper!");
                for (String str : nameStoreKeeper) {
                    if (str.equalsIgnoreCase(storeKeeper)) {
                        return storeKeeper;
                    }
                }
            } while (true);
        }
        String storeKeeper = val.getName("Input name of storeKeeper: ", "You need to input correct name of store keeper!");
        return storeKeeper;
    }
}
