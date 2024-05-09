package org.example.hacker;

import java.util.ArrayList;
import java.util.List;

public class BirthdayCakeCandles {
    public static void main(String[] args) {

        List<Integer> arr = new ArrayList<>();
        arr.add(4);
        arr.add(2);
        arr.add(1);
        arr.add(3);
        arr.add(4);

        int max = arr.stream()
                .max(Integer::compareTo).orElse(0);

        long count = arr.stream()
                .filter(n -> n == max)
                .count();
        System.out.println(count);
    }
}
