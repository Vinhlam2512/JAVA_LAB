/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.Product;
import java.util.ArrayList;
import java.time.LocalDate;
/**
 *
 * @author VINH
 */
public class Options {
    private ArrayList<Product> products = new ArrayList<Product>();
    private ArrayList<String> storeKeeper = new ArrayList<>();
    Validation val = new Validation();

    public void addStoreKeeper() {

    }

    public void add() {
        int id;
        Double price;
        String name, location, category, storeKeeper;
        LocalDate expiryDate, manuOfDate, receiptDate;
        id = val.getId("Input id: ", "You need to input integer!");
        name = val.getName("Input name: ", "You need to input correct name of product!");
        location = val.getString("Input location: ");
        price = val.getPrice("Input price: ", "Price not contains character");
        expiryDate = val.getDate("Input Expiry Date: ", "You need to input like the format dd/mm/yyyy!");
        do {
            manuOfDate = val.getDate("Input Manufacture Date: ", "You need to input like the format dd/mm/yyyy!");
            if (expiryDate.isAfter(manuOfDate) || expiryDate.isEqual(manuOfDate)) {
                System.out.println("Manufacture Date need after Expiry Date!");
            }
        } while (expiryDate.isAfter(manuOfDate) || expiryDate.isEqual(manuOfDate));
        category = val.getString("Input category: ");
        storeKeeper = val.getName("Input name of stor keeper: ", "You need to input correct name of stor keeper!");
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
}
