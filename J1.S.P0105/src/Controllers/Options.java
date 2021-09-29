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

    int index;
    Validation val = new Validation();
    ArrayList<String> nameStoreKeeper = new ArrayList<>();

    private ArrayList<Product> products = new ArrayList<Product>();

    int number = 1;

    public ArrayList addStoreKeeper(ArrayList<String> nameStoreKeeper, String name) {
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
        products.add(product());
    }

    public boolean updateProduct(int id) throws ParseException {
        findId(id);
        products.set(index, product());
        return true;
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
        int id;
        Double price;
        String name, location, category, storeKeeper;
        String expiryDate, manuOfDate, receiptDate;
        int checkDate;
        do {
            id = val.getId("Input id: ", "You need to input integer!");
            if (!val.idIsExist(products, id, index)) {
                System.out.println("This id is already exsit!");
            }
        } while (!val.idIsExist(products, id, index));
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
        return new Product(id, name, location, price, expiryDate, manuOfDate, category, storeKeeper, receiptDate);
    }

    public void showNameStoreKeeper(ArrayList<String> nameStoreKeeper) {
        for (String n : nameStoreKeeper) {
            System.out.println(n);
        }
    }
    void printf(ArrayList<Product> product, int i) {
        System.out.printf("%s |%-5s |%s |%s |%s |%s |%-10s |%-10s |%-15s\n", "ID", "Name", "Location", "Price", "Expiry date", "Date of manufacture", "Category", "Storekeeper", "ReceiptDate");
        System.out.printf("%-2s |%-5s |%-8s |%-5s |%-11s |%-19s |%-10s |%-11s |%-1s\n",
                product.get(i).getId(), product.get(i).getName(), product.get(i).getLocation(), product.get(i).getPrice(), product.get(i).getExpiryDate(), product.get(i).getManuOfDate(), product.get(i).getCategory(), product.get(i).getStoreKeeper(), product.get(i).getReceiptDate());
    }

    public int findId(int id){
        for (int i = 0; i < products.size(); i++) {
            if(products.get(i).getId() == id){
                index = i;
                return id;
            }
        }
        return -1;
    }

}
