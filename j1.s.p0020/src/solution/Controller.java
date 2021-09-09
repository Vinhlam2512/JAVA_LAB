/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solution;

import java.util.Scanner;

/**
 *
 * @author VINH
 */
public class Controller {

    public static void selectionSort(int arr[], int size) {
        int minIndex,i;
        for (i = 0; i < size; i++) {
            minIndex = i;
            for (int j = i + 1; j < size; j++) {
                if (arr[j] < arr[minIndex]) {
                    int temp = arr[j];
                    arr[j] = arr[minIndex];
                    arr[minIndex] = temp;
                }
            }
        }
    }

}
