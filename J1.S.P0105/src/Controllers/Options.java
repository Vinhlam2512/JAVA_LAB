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
//                return null;
            }
        }
        nameStoreKeeper.add(name);

        return nameStoreKeeper;
    }

    public void add() throws ParseException {

        Product p = product();
        products.add(p);
    }

    public boolean updateProduct(int id) throws ParseException {
        for (int i = 0; i < products.size(); i++) {
            if (id == products.get(i).getId()) {
                System.out.println("Your result");
                printf(products, i);
                System.out.println("Input information you want to update!");
                products.set(i, product());
                return true;
            }
        }
        return false;
    }

    public void search() {

    }

    public void sort() {

    }

    public void addMany() {
        products.add(new Product(1, "Quan", "MC", 4.6, "3/3/2001", "3/3/2001", "Quan ao", "Lam", "3/3/2001"));
        products.add(new Product(2, "Ao", "HN", 4.6, "3/3/2001", "3/3/2001", "Quan ao", "Quang", "3/3/2001"));
        products.add(new Product(3, "Banh", "BG", 4.6, "3/3/2001", "3/3/2001", "thuc an", "Vinh", "3/3/2001"));
    }

    public void show() {
        System.out.printf("%s |%-5s |%s |%s |%s |%-10s |%-10s |%-15s\n", "ID", "Name", "Location", "Expiry date", "Date of manufacture", "Category", "Storekeeper", "ReceiptDate");
        for (Product product : products) {
//            System.out.println("|ID |Name |Location |Price |Expiry date\t|Date of manufacture|Category|Storekeeper|ReceiptDate");
//            System.out.println(product.toString());
            System.out.printf("%-2s |%-5s |%-8s |%-11s |%-19s |%-10s |%-11s |%-15s\n",
                    product.getId(), product.getName(), product.getLocation(), product.getExpiryDate(), product.getManuOfDate(), product.getCategory(), product.getStoreKeeper(), product.getReceiptDate());

        }
    }

    Product product() throws ParseException {
        int id = 0;
        Double price = null;
        String name = null, location = null, category = null, storeKeeper = null;
        String expiryDate = null, manuOfDate = null, receiptDate = null;
        Date date1, date2;
        do {
            id = val.getId("Input id: ", "You need to input integer!");
        } while (!idIsExist(id));

        name = val.getName("Input name: ", "You need to input correct name of product!");
        location = val.getString("Input location: ");
        price = val.getPrice("Input price: ", "Price not contains character");
        expiryDate = val.getDate("Input Expiry Date: ", "You need to input like the format dd/mm/yyyy!");
        do {
            manuOfDate = val.getDate("Input Manufacture Date: ", "You need to input like the format dd/mm/yyyy!");
            date1 = sdformat.parse(expiryDate);
            date2 = sdformat.parse(manuOfDate);
            if (date1.compareTo(date2) >= 0) {
                System.out.println("Manufacture Date need after Expiry Date!");
            }
        } while (date1.compareTo(date2) >= 0);
        category = val.getString("Input category: ");
        storeKeeper = checkName();
        receiptDate = val.getDate("Input Receipt Date: ", "You need to input like the format dd/mm/yyyy!");
        return new Product(id, name, location, price, expiryDate, manuOfDate, category, storeKeeper, receiptDate);
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

    boolean idIsExist(int id) {
        for (Product product : products) {
            
            if (id == product.getId()) {
                System.out.println("Id is exist!");
                return false;
            }
        }
        return true;
    }
    
    Product productUp() throws ParseException {
        int id = 0;
        Double price = null;
        String name = null, location = null, category = null, storeKeeper = null;
        String expiryDate = null, manuOfDate = null, receiptDate = null;
        Date date1, date2;
        do {
            id = val.getId("Input id: ", "You need to input integer!");
//            if(id == )
        } while (!idIsExist(id));

        name = val.getName("Input name: ", "You need to input correct name of product!");
        location = val.getString("Input location: ");
        price = val.getPrice("Input price: ", "Price not contains character");
        expiryDate = val.getDate("Input Expiry Date: ", "You need to input like the format dd/mm/yyyy!");
        do {
            manuOfDate = val.getDate("Input Manufacture Date: ", "You need to input like the format dd/mm/yyyy!");
            date1 = sdformat.parse(expiryDate);
            date2 = sdformat.parse(manuOfDate);
            if (date1.compareTo(date2) >= 0) {
                System.out.println("Manufacture Date need after Expiry Date!");
            }
        } while (date1.compareTo(date2) >= 0);
        category = val.getString("Input category: ");
        storeKeeper = checkName();
        receiptDate = val.getDate("Input Receipt Date: ", "You need to input like the format dd/mm/yyyy!");
        return new Product(id, name, location, price, expiryDate, manuOfDate, category, storeKeeper, receiptDate);
    }

    void printf(ArrayList<Product> product, int i) {
        System.out.printf("%s |%-5s |%s |%s |%s |%-10s |%-10s |%-15s\n", "ID", "Name", "Location", "Expiry date", "Date of manufacture", "Category", "Storekeeper", "ReceiptDate");
        System.out.printf("%-2s |%-5s |%-8s |%-11s |%-19s |%-10s |%-11s |%-15s\n",
                product.get(i).getId(), product.get(i).getName(), product.get(i).getLocation(), product.get(i).getExpiryDate(), product.get(i).getManuOfDate(), product.get(i).getCategory(), product.get(i).getStoreKeeper(), product.get(i).getReceiptDate());
    }

}
