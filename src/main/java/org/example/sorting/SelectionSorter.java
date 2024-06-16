package org.example.sorting;

public class SelectionSorter implements ISorter {

    public void sort(int[] arr) {
        for (int indexOne = 0; indexOne < arr.length - 1; indexOne++) {
            int minIndex = indexOne;
            for (int indexTwo = indexOne + 1; indexTwo < arr.length; indexTwo++) {
                if (arr[indexTwo] < arr[minIndex]) {
                    minIndex = indexTwo;
                }
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[indexOne];
            arr[indexOne] = temp;
        }
    }
}
