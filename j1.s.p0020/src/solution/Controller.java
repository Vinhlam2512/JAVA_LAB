/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solution;

/**
 *
 * @author VINH
 */
public class Controller {
    public static void selectionSort(int arr[], int size){
        int minIndex;
        for(int i = 0; i < size ;i ++){
            minIndex = i;
            for(int j = i+1; j < size;j++ ){
                if(arr[j] < arr[minIndex]){
                    int temp = arr[j];
                    arr[j] = arr[minIndex];
                    arr[minIndex] = temp;
                }
            }
        }
    }
    public static void printArr(int arr[], int size) {
        System.out.print("[");
        for (int i = 0; i < size; i++) {
            if (i == size - 1) {
                System.out.print(arr[i]);
            } else {
                System.out.print( arr[i] +", ");
            }
        } 
        System.out.println("]");
    }
}
