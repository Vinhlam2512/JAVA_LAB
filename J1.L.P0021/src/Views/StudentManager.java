/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;
import Controller.Options;

/**
 *
 * @author VINH84
 */
public class StudentManager {

    public static void main(String[] args) {
        Menu menu = new Menu("STUDENT MANAGEMENT");
        menu.addOptions("   1.	Create");
        menu.addOptions("   2.	Find and Sort");
        menu.addOptions("   3.	Update/Delete");
        menu.addOptions("   4.	Report");
        menu.addOptions("   5.	Exit");
        int choice;
        do {
            menu.showMenu();
            choice = menu.getChoice();
            switch (choice) {
                case 1:
                    Options.create();
                    break;
                case 2:
                    
                    break;
                case 3:
                    
                    break;
                case 4:
                    Options.report();
                    break;
                case 5:
              
                    break;
                
            }
        }while(choice != 5);
    
    }
}
