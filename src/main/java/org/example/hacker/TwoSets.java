package org.example.hacker;

import java.util.List;

public class TwoSets {

    public static void main(String[] args) {
        List<Integer> firstArr = List.of(2);
        List<Integer> secondArr = List.of(20, 30, 12);
        int totalX = getTotalX(firstArr, secondArr);
        System.out.println(totalX);
    }

    private static int getTotalX(List<Integer> a, List<Integer> b) {
        int startPoint = a.getLast();
        int endPoint = b.getFirst();
        int count = 0;
        for (int num = startPoint; num <= endPoint; num++) {
            if (isEligible(num, a, b)) {
                count++;
            }
        }
        return count;
    }

    private static boolean isEligible(int currentNum, List<Integer> a, List<Integer> b) {
        boolean isValid = true;
        for (Integer integer : a) {
            if (currentNum % integer != 0) {
                isValid = false;
                break;
            }
        }
        for (Integer integer : b) {
            if (integer % currentNum != 0) {
                isValid = false;
                break;
            }
        }
        return isValid;
    }
}
