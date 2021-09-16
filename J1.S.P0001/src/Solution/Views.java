/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Solution;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author VINH
 */
public class Views {

    Controllers ctl = new Controllers();
    Scanner sc = new Scanner(System.in);

    public int input() {
        int size;
        do {
            System.out.print("Enter number of array: ");
            while (!sc.hasNextInt()) {
                System.out.println("That's not a number!");
                System.out.print("Enter size of array: ");
                sc.next();
            }
            size = sc.nextInt();
        } while (size <= 0);
        return size;
    }

    public void randomArray(int arr[], int size) {
        Random rad = new Random();
        for (int i = 0; i < size; i++) {
            arr[i] = rad.nextInt(size - 1) + 1;
        }
    }

    public void printArr(int arr[], int size) {
        int i;
        System.out.print("[");
        for (i = 0; i < size; i++) {
            if (i == size - 1) {
                System.out.print(arr[i]);
            } else {
                System.out.print(arr[i] + ", ");
            }
        }
        System.out.println("]");
    }

}
