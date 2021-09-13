/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solution;

import java.util.Scanner;

public class J1SP0020 {

    public static void main(String[] args) {
        Views view = new Views();
        int size;
        int i;
        Scanner sc = new Scanner(System.in);
        size = view.input();
        int a[] = new int[size];
        view.inputArr(a);
        System.out.println("Unsorted array: ");
        view.printArr(a, size);
        Controller.selectionSort(a);
        System.out.println("Sorted array: ");
        view.printArr(a, size);

    }
}
