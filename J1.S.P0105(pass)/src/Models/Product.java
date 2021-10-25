/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.util.ArrayList;

/**
 *
 * @author VINH
 */
public class Product {

    private int id;
    private String name;
    private String location;
    private String price;
    private String expiryDate;
    private String manuOfDate;
    private String category;
    private String storeKeeper;
    private String receiptDate;

    public Product() {
    }

    public Product(int id, String name, String location, String price, String expiryDate, String manuOfDate, String category, String storeKeeper, String receiptDate) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.price = price;
        this.expiryDate = expiryDate;
        this.manuOfDate = manuOfDate;
        this.category = category;
        this.storeKeeper = storeKeeper;
        this.receiptDate = receiptDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getManuOfDate() {
        return manuOfDate;
    }

    public void setManuOfDate(String manuOfDate) {
        this.manuOfDate = manuOfDate;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getStoreKeeper() {
        return storeKeeper;
    }

    public void setStoreKeeper(String storeKeeper) {
        this.storeKeeper = storeKeeper;
    }

    public String getReceiptDate() {
        return receiptDate;
    }

    public void setReceiptDate(String receiptDate) {
        this.receiptDate = receiptDate;
    }

    @Override
    public String toString() {
        return id + " " + name + " " + location + " " + price + " " + expiryDate + " " + manuOfDate + " " + category+ " " + storeKeeper + " " + receiptDate;
    }
    
}
