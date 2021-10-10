
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author VINH
 */
public class Validate {

    Scanner sc = new Scanner(System.in);

     public int inputChoice() {
        int choice;
        do {
            System.out.print("Your choice: ");
            while (!sc.hasNextInt()) {
                System.out.println("You need to input integer! ");
                System.out.print("Your choice: ");
                sc.next();
            }
            choice = sc.nextInt();
            if (choice < 0 || choice > 3) {
                System.out.println("You need to input 1 - 3!");
            }

        } while (choice <= 0);
        return choice;
    }
}
