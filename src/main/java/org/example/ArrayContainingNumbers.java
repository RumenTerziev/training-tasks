package org.example;

public class ArrayContainingNumbers {

    public static void main(String[] args) {
        int K = 20;
        int[] array = new int[K];
        for (int i = 1; i <= K; i++) {
            array[i - 1] = i;
        }
        System.out.println(method(array, K));
    }

    static boolean method(int[] A, int K) {
        int n = A.length;
        for (int i = 0; i < n - 1; i++) {
            if (A[i] + 1 < A[i + 1])
                return false;
        }

        if (A[0] != 1 && A[n - 1] != K)
            return false;
        else
            return true;
    }
}
