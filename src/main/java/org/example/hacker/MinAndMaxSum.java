package org.example.hacker;

import java.util.ArrayList;
import java.util.List;

public class MinAndMaxSum {
    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(3);
        arr.add(5);
        arr.add(7);
        arr.add(9);
        arr.add(9);
        arr.add(9);

        arr.sort(Integer::compareTo);
        long min = 0;
        long max = 0;
        for (int i = 0; i < 4; i++) {
            min += arr.get(i);
            max += arr.get(arr.size() - i - 1);
        }
        System.out.println(min + " " + max);
    }
}
