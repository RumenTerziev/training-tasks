package org.example;

import java.util.Arrays;

public class BinarySearchRecursively {

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Arrays.sort(arr);
        System.out.println(findIndex(arr, 5));
    }

    private static int findIndex(int[] arr, int key) {
        if (key < arr[0] || key > arr[arr.length - 1]) {
            return -1;
        }

        int index = arr.length / 2;

        if (arr[index] == key) {
            return index;
        } else if (arr[index] > key) {
            return findIndex(Arrays.copyOfRange(arr, 0, index), key);
        } else if (arr[index] < key) {
            return findIndex(Arrays.copyOfRange(arr, index, arr.length), key);
        }
        return -1;
    }
}
