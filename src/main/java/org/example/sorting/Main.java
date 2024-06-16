package org.example.sorting;

import java.util.Arrays;

public class Main {

    private static final ISorter QUICK_SORTER = new QuickSorter();

    private static final ISorter BASE_SORTER = new BaseSorter();

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
        BASE_SORTER.sort(copyArr);
        System.out.println("Printing array after sorting:");
        printArray(copyArr);
    }

    private static void printArray(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }
}
