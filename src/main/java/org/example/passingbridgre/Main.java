package org.example.passingbridgre;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        double result = getMinPassingTime(List.of(10.0, 2.0, 5.0, 1.0));
        System.out.println(result);
    }


    public static double getMinPassingTime(List<Double> times) {
        double totalTime = 0;

        List<Double> friendsOnLeftSide = new ArrayList<>(times);
        List<Double> friendsOnRightSide = new ArrayList<>();

        double first = friendsOnLeftSide.stream()
                .min(Double::compare)
                .orElse(0.0);

        friendsOnLeftSide.remove(first);

        double second = friendsOnLeftSide.stream()
                .min(Double::compare)
                .orElse(0.0);

        friendsOnLeftSide.remove(second);

        double third = friendsOnLeftSide.stream()
                .min(Double::compare)
                .orElse(0.0);

        double fourth = friendsOnLeftSide.stream()
                .max(Double::compare)
                .orElse(0.0);

        friendsOnRightSide.add(first);
        friendsOnRightSide.add(second);

        totalTime += second;

        friendsOnRightSide.remove(first);

        friendsOnLeftSide.add(first);
        totalTime += first;

        friendsOnLeftSide.remove(third);
        friendsOnLeftSide.remove(fourth);
        friendsOnRightSide.add(third);
        friendsOnRightSide.add(fourth);
        totalTime += fourth;

        friendsOnRightSide.remove(second);
        totalTime += second;

        friendsOnLeftSide.remove(first);
        friendsOnLeftSide.remove(second);

        friendsOnRightSide.add(first);
        friendsOnRightSide.add(second);
        totalTime += second;

        System.out.println(friendsOnLeftSide.size());
        System.out.println(friendsOnRightSide.size());

        return totalTime;
    }
}
