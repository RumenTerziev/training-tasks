package org.example;

import java.util.Arrays;

public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 1, 6, 7, 8, 9, 5, 10};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(findIndex(arr, 9));
    }

    public static int findIndex(int[] arr, int key) {
        if (arr.length == 0 || key < arr[0] || key > arr[arr.length - 1]) {
            return -1;
        }
        if (key == arr[0]) {
            return 0;
        }
        if (key == arr[arr.length - 1]) {
            return arr.length - 1;
        }
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == key) {
                return mid;
            } else if (key < arr[mid]) {
                high = mid - 1;
            } else if (key > arr[mid]) {
                low = mid + 1;
            }
        }
        return -1;
    }
}
