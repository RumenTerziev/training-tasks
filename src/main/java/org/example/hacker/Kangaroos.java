package org.example.hacker;

import java.util.Arrays;
import java.util.Scanner;

public class Kangaroos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        System.out.println(kangaroo(array[0], array[1], array[2], array[3]));
    }

    public static String kangaroo(int firstKangarooStartingPoint, int firstKangarooJumpDistance,
                                  int secondKangarooStartingPoint, int secondKangarooJumpDistance) {
        int earlierStarting = Math.min(firstKangarooStartingPoint, secondKangarooStartingPoint);
        int lowerJumpDistance = Math.min(firstKangarooJumpDistance, secondKangarooJumpDistance);
        int initialDistance = Math.abs(firstKangarooStartingPoint - secondKangarooStartingPoint);
        int distanceToReduce = Math.abs(firstKangarooJumpDistance - secondKangarooJumpDistance);

        boolean isNotZero = distanceToReduce != 0;
        boolean willCatchUp = (earlierStarting == firstKangarooStartingPoint && lowerJumpDistance == secondKangarooJumpDistance)
                || (earlierStarting == secondKangarooStartingPoint && lowerJumpDistance == firstKangarooJumpDistance);
        boolean isDivisible = isNotZero && initialDistance % distanceToReduce == 0;
        return isDivisible && willCatchUp ? "YES" : "NO";
    }
}
