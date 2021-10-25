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
public class main {

    public static void main(String[] args) {
                
        Views views = new Views();
        Controllers control = new Controllers();
        Scanner sc = new Scanner(System.in);
        int size = views.input();
        int arr[] = new int[size];
        views.randomArray(arr, size);
        System.out.print("Unsorted array: ");
        views.printArr(arr, size);
        control.bubbleSort(arr);
        System.out.print("Sorted array: ");
        views.printArr(arr, size);
    }
}
