/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.s.p0020;

import java.util.Scanner;

public class J1SP0020 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of array: ");
        int size = Integer.parseInt(sc.nextLine());
        int a[] = new int[size];
        for (int i = 0; i < size; i++) {
            System.out.print("Input element a[" + i + "]: ");
            a[i] = Integer.parseInt(sc.nextLine());
        }
        System.out.println("Unsorted array: ");
        Controller.printArr(a, size);

        Controller.selectionSort(a, size);

        System.out.println("Sorted array: ");
        Controller.printArr(a, size);

    }
}
