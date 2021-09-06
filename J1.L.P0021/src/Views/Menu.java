/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import java.util.ArrayList;
import Controller.Validation;

/**
 *
 * @author VINH
 */
public class Menu {
    String menuTitle;
    ArrayList<String> optionsList = new ArrayList<String>();

    public Menu() {
    }

    public Menu(String menuTitle) {
        this.menuTitle = menuTitle;
    }
    
    public void addOptions(String options){
        optionsList.add(options);
    }
    
    public void showMenu() {
        System.out.println("\n------------------------------------");
        System.out.println("WELCOME TO " + menuTitle);
        for (String x : optionsList)
            System.out.println(x); 
    }
    
    public int getChoice() {
        int maxOption = optionsList.size();
        //lựa chọn lớn nhất là số thứ tự ứng với số mục chọn
        String inputMsg = "Choose [1.." + maxOption + "]: ";
        String errorMsg = "You are required to choose the option 1.." + maxOption; 
        return Validation.getAnInteger(inputMsg, errorMsg, 1, maxOption);
        //in ra câu nhập: Choose[1..8]: , giả sử có 8 mục chọn trong
        //menu
    }
}
