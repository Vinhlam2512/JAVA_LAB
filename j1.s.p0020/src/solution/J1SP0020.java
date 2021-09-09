/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solution;

import java.util.Scanner;

public class J1SP0020 {

    public static void main(String[] args) {
        int size;
        int i;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.print("Enter size of array: ");
            while (!sc.hasNextInt()) {
                System.out.println("That's not a number!");
                System.out.print("Enter size of array: ");
                sc.next();
            }
            size = sc.nextInt();
        } while (size <= 0);
        int a[] = new int[size];
        for (i = 0; i < size; i++) {
            System.out.print("Input element a[" + i + "]: ");
            a[i] = sc.nextInt();
        }
        System.out.println("Unsorted array: ");
        Views.printArr(a, size);

        Controller.selectionSort(a, size);

        System.out.println("Sorted array: ");
        Views.printArr(a, size);

    }
}
