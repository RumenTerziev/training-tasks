package org.example.sorting;

import java.util.Arrays;

public class Main {

    private static final ISorter QUICK_SORTER = new QuickSorter();

    private static final ISorter SELECTION_SORTER = new SelectionSorter();

    public static void main(String[] args) {
        int[] arr = {1, 8, 5, 4, 3, 6, 7, 2, 9, 10};
        System.out.println("Printing array before sorting:");
        printArray(arr);
        QUICK_SORTER.sort(arr);
        System.out.println("Printing array after sorting:");
        printArray(arr);
        System.out.println();

        int[] copyArr = {1, 8, 5, 4, 3, 6, 7, 2, 9, 10};
        System.out.println("Printing array before sorting:");
        printArray(copyArr);
        SELECTION_SORTER.sort(copyArr);
        System.out.println("Printing array after sorting:");
        printArray(copyArr);
    }

    private static void printArray(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }
}
