package org.example.sorting;

public class BaseSorter implements ISorter {

    public void sort(int[] arr) {
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
