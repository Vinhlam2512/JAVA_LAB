/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import java.util.ArrayList;
import Models.Product;

/**
 *
 * @author VINH
 */
public class Ultils {

    int index;

    public int findById(ArrayList<Product> products, int id) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == id) {
                index = i;
                return id;
            }
        }
        return -1;
    }

    public boolean idIsExist(ArrayList<Product> products, int id) {
        if (findById(products, id) != -1) {
            return false;
        }
        return true;
    }

    public ArrayList searchByName(ArrayList<Product> products, String s) {
        ArrayList<Product> listSearch = new ArrayList<>();
        for (Product product : products) {
            if (product.getName().toLowerCase().contains(s.toLowerCase())) {
                listSearch.add(product);
            }
        }
        return listSearch;
    }

    public ArrayList searchByCategory(ArrayList<Product> products, String s) {
        ArrayList<Product> listSearch = new ArrayList<>();
        for (Product product : products) {
            if (product.getCategory().toLowerCase().contains(s.toLowerCase())) {
                listSearch.add(product);
            }
        }
        return listSearch;
    }

    public ArrayList searchByStoreKeeper(ArrayList<Product> products, String s) {
        ArrayList<Product> listSearch = new ArrayList<>();
        for (Product product : products) {
            if (product.getStoreKeeper().toLowerCase().contains(s.toLowerCase())) {
                listSearch.add(product);
            }
        }
        return listSearch;
    }

    public ArrayList searchByDate(ArrayList<Product> products, String s) {
        ArrayList<Product> listSearch = new ArrayList<>();
        for (Product product : products) {
            if (product.getReceiptDate().equalsIgnoreCase(s)) {
                listSearch.add(product);
            }
        }
        return listSearch;
    }
}
