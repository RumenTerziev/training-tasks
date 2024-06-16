package org.example.sorting;

import java.util.Arrays;

public class SortingArray {

    public static void main(String[] args) {
        int[] arr = {1, 8, 5, 4, 3, 6, 7, 2, 9, 10};
        sortedArray(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void sortedArray(int[] arr) {
        for (int indexOne = 0; indexOne < arr.length - 1; indexOne++) {
            for (int indexTwo = indexOne + 1; indexTwo < arr.length; indexTwo++) {
                if (arr[indexOne] > arr[indexTwo]) {
                    int temp = arr[indexTwo];
                    arr[indexTwo] = arr[indexOne];
                    arr[indexOne] = temp;
                }
            }
        }
    }
}
