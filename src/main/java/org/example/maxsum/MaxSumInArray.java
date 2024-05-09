package org.example.maxsum;

import java.util.*;

public class MaxSumInArray {
    public static void main(String[] args) {
        Map<int[], List<Integer>> testCases = new LinkedHashMap<>();
        testCases.put(new int[]{1, -1, 2, 5, -4, 3, 8, -1, 2, -5000, 30000}, List.of(30000));
        testCases.put(new int[]{-1, 30000}, List.of(30000));
        testCases.put(new int[]{2, -1, 8, -5, -4, -1, 2}, Arrays.asList(2, -1, 8));
        testCases.put(new int[]{5, -6, 2, -1, 8, -1, 2, -1}, Arrays.asList(2, -1, 8, -1, 2));
        testCases.put(new int[]{1, 2, 3}, Arrays.asList(1, 2, 3));

        for (int[] key : testCases.keySet()) {
            System.out.println(getMaxSumOfSequences(key));
        }
    }

    static List<Integer> getMaxSumOfSequences(int[] arr) {
        NavigableMap<Integer, List<Integer>> sequences = new TreeMap<>();
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            List<Integer> currentSequence = new ArrayList<>();
            for (int j = i; j < arr.length; j++) {
                currentSequence.add(arr[j]);
                sum += arr[j];
                sequences.put(sum, new ArrayList<>(currentSequence));
            }
        }
        return sequences.lastEntry().getValue();
    }
}
