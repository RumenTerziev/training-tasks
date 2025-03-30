package org.example.passingbridegre;

import java.util.ArrayList;
import java.util.List;

public class PassingBridge {

    public static void main(String[] args) {
        double result = new PassingBridge().getMinPassingTime(List.of(10.0, 2.0, 5.0, 1.0));
        System.out.println(result);
    }


    public double getMinPassingTime(List<Double> times) {
        double totalTime = 0;

        List<Double> friendsOnLeftSide = new ArrayList<>(times);
        List<Double> friendsOnRightSide = new ArrayList<>();

        // Get the passing time of the fastest and the second fastest that will pass the bridge for the first time
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

        // The two fastest pass the bridge
        friendsOnRightSide.add(first);
        friendsOnRightSide.add(second);

        totalTime += second;

        // The fastest one goes back with the lantern
        friendsOnRightSide.remove(first);
        friendsOnLeftSide.add(first);
        totalTime += first;

        // The slowest to pass the bridge
        friendsOnLeftSide.remove(third);
        friendsOnLeftSide.remove(fourth);
        friendsOnRightSide.add(third);
        friendsOnRightSide.add(fourth);
        totalTime += fourth;

        // Second-fastest goes bask
        friendsOnRightSide.remove(second);
        totalTime += second;

        friendsOnLeftSide.remove(first);
        friendsOnLeftSide.remove(second);

        // The two fastest pass the bridge again
        friendsOnRightSide.add(first);
        friendsOnRightSide.add(second);
        totalTime += second;

        System.out.println(friendsOnLeftSide.size());
        System.out.println(friendsOnRightSide.size());

        return totalTime;
    }
}
