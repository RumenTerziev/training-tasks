package org.example.maxsum.finder.util;

import java.util.*;

public class TestCasesGenerator {

    public static Map<int[], List<Integer>> getTestCases() {
        Map<int[], List<Integer>> testCases = new LinkedHashMap<>();
        testCases.put(new int[]{1, -1, 2, 5, -4, 3, 8, -1, 2, -5000, 30000}, List.of(30000));
        testCases.put(new int[]{-1, 30000}, List.of(30000));
        testCases.put(new int[]{2, -1, 8, -5, -4, -1, 2}, Arrays.asList(2, -1, 8));
        testCases.put(new int[]{5, -6, 2, -1, 8, -1, 2, -1}, Arrays.asList(2, -1, 8, -1, 2));
        testCases.put(new int[]{1, 2, 3}, Arrays.asList(1, 2, 3));
        return testCases;
    }

    public static int[] getLargeTestArray() {
        int size = 2000;
        Random rand = new Random();
        int[] ar = new int[size];
        for (int i = 0; i < size; i++) {
            ar[i] = rand.nextInt(1000);
            int luck = rand.nextInt(3);
            if (luck == 2) {
                ar[i] = ar[i] * -1;
            }
        }
        return ar;
    }
}
