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

    public boolean add() throws ParseException {
        int id;
        String price;
        String name, location, category, storeKeeper;
        String expiryDate, manuOfDate, receiptDate;
        int checkDate;
        if (nameStoreKeeper.isEmpty()) {
            return false;
        } else {
            do {
                id = val.getId("Input id: ", "You need to input integer!");
                if (!ult.idIsExist(products, id)) {
                    System.out.println("This id is already exsit!");
                }
            } while (!ult.idIsExist(products, id));
            do {
                name = val.getName("Input name: ", "You need to input correct name of product!");
            } while (name.isEmpty());

            do {
                price = val.getPrice("Input price: ", "Price not contains character");
            } while (price.equals(""));
            do {
                location = val.getString("Input location: ");
            } while (location.isEmpty());

            do {
                expiryDate = val.getDate("Input Expiry Date: ", "You need to input like the format dd/mm/yyyy!");
            } while (expiryDate.isEmpty() || !val.isDateValid(expiryDate));
            do {
                do {
                    manuOfDate = val.getDate("Input Manufacture Date: ", "You need to input like the format dd/mm/yyyy!");
                } while (manuOfDate.isEmpty() || !val.isDateValid(manuOfDate));
                checkDate = val.compareDate(manuOfDate, expiryDate, "Manufacture Date need before Expiry Date!");
            } while (checkDate == 1);
            do {
                category = val.getString("Input category: ");
            } while (category.isEmpty());
            do {
                storeKeeper = val.checkName(nameStoreKeeper);
            } while (storeKeeper.isEmpty());
            do {
                do {
                    receiptDate = val.getDate("Input Receipt Date: ", "You need to input like the format dd/mm/yyyy!");
                } while (receiptDate.isEmpty() || !val.isDateValid(receiptDate));
                checkDate = val.compareDate(manuOfDate, receiptDate, "ReceiptDate Date need after Manufacture Date!");
            } while (checkDate == 1);
            products.add(new Product(id, name, location, price, expiryDate, manuOfDate, category, storeKeeper, receiptDate));
            return true;
        }
    }

    public ArrayList<Product> getListUpdate(int id) {
        ArrayList<Product> l = ult.findById(products, id);
        return l;
    }

    public boolean updateProduct(int idUpdate) throws ParseException {
        int id;
        String price;
        String name, location, category, storeKeeper;
        String expiryDate, manuOfDate, receiptDate;
        int checkDate;
        if (!ult.findById(products, idUpdate).isEmpty()) {
            id = ult.idCheck;
            name = val.getName("Input name: ", "You need to input correct name of product!");
            if (name.equals("")) {
                name = products.get(ult.index).getName();
            }
            price = val.getPrice("Input price: ", "Price not contains character");
            if (price.equals("")) {
                price = products.get(ult.index).getPrice();
            }
            location = val.getString("Input location: ");
            if (location.equals("")) {
                location = products.get(ult.index).getLocation();
            }
            do {
                expiryDate = val.getDate("Input Expiry Date: ", "You need to input like the format dd/mm/yyyy!"); // sua
                if (expiryDate.isEmpty()) {
                    expiryDate = products.get(ult.index).getExpiryDate();
                    break;
                }
            } while (!val.isDateValid(expiryDate));

            manuOfDate = val.getDate("Input Manufacture Date: ", "You need to input like the format dd/mm/yyyy!");
            if (val.compareDate(products.get(ult.index).getManuOfDate(), expiryDate, "") == 1 && manuOfDate.isEmpty()) {
                do {
                    do {
                        manuOfDate = val.getDate("Input Manufacture Date: ", "You need to input like the format dd/mm/yyyy!");
                    } while (!val.isDateValid(manuOfDate));
                    checkDate = val.compareDate(manuOfDate, expiryDate, "Manufacture Date need before Expiry Date!");
                    if (manuOfDate.equals("")) {
                        break;
                    }
                } while (checkDate == 1);
            } else if (manuOfDate.isEmpty()) {
                manuOfDate = products.get(ult.index).getManuOfDate();

            } else {
                do {
                    do {
                        manuOfDate = val.getDate("Input Manufacture Date: ", "You need to input like the format dd/mm/yyyy!");
                    } while (!val.isDateValid(manuOfDate));
                    checkDate = val.compareDate(manuOfDate, expiryDate, "Manufacture Date need before Expiry Date!");
                    if (manuOfDate.equals("")) {
                        break;
                    }
                } while (checkDate == 1);
            }

            category = val.getString("Input category: ");
            if (category.equals("")) {
                category = products.get(ult.index).getCategory();
            }
//            System.out.println("List name of storeKeeper you need to choose:");
//            for (int i = 0; i < nameStoreKeeper.size(); i++) {
//                int n = i + 1;
//                System.out.println(n + ". " + nameStoreKeeper.get(i));
//            }
            storeKeeper = val.checkName(nameStoreKeeper);

//            storeKeeper = val.getName("Input name of storeKeeper: ", "You need to input correct name of store keeper!");
            if (storeKeeper.equals("")) {
                storeKeeper = products.get(ult.index).getStoreKeeper();
            }
//            } else {
//                storeKeeper = val.checkName(nameStoreKeeper);
//            }
            //sua
            receiptDate = val.getDate("Input Receipt Date: ", "You need to input like the format dd/mm/yyyy!");
            if (val.compareDate(manuOfDate, products.get(ult.index).getReceiptDate(), "") == 1 && receiptDate.isEmpty()) {
                do {
                    do {
                        receiptDate = val.getDate("Input Receipt Date: ", "You need to input like the format dd/mm/yyyy!");
                    } while (!val.isDateValid(receiptDate));
                    checkDate = val.compareDate(manuOfDate, receiptDate, "Manufacture Date need before Expiry Date!");
                } while (checkDate == 1);
            } else if (receiptDate.isEmpty()) {
                receiptDate = products.get(ult.index).getReceiptDate();

            } else {
                do {
                    do {
                        receiptDate = val.getDate("Input Receipt Date: ", "You need to input like the format dd/mm/yyyy!");
                    } while (!val.isDateValid(receiptDate));
                    checkDate = val.compareDate(manuOfDate, receiptDate, "Manufacture Date need before Expiry Date!");
                } while (checkDate == 1);
            }
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
        products.add(new Product(1, "Quan", "MC", "4.6", "2001/7/6", "2001/3/30", "Quan ao", "Lam", "2001/4/7"));
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

    public void showNameStoreKeeper(ArrayList<String> nameStoreKeeper) {
        for (String n : nameStoreKeeper) {
            System.out.println(n);
        }
    }

}
