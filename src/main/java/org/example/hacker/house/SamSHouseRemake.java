package org.example.hacker.house;

import java.util.List;

import static org.example.hacker.house.HouseInputUtils.getHouseInput;

public class SamSHouseRemake {
    public static void main(String[] args) {
        List<Long> countFruitsFallingOnTheHouse = countApplesAndOrangesFallingOnTheHouse(getHouseInput());
        System.out.println(countFruitsFallingOnTheHouse.getFirst());
        System.out.println(countFruitsFallingOnTheHouse.getLast());
    }

    public static List<Long> countApplesAndOrangesFallingOnTheHouse(HouseInput houseInput) {

        long countApplesOnTheHouse = getCountFruitsOnTheHouse(
                houseInput.houseStartingPoint(),
                houseInput.houseEndingPoint(),
                houseInput.appleTreePosition(),
                houseInput.appleFallingDistances()
        );

        long countOrangesOnTheHouse = getCountFruitsOnTheHouse(
                houseInput.houseStartingPoint(),
                houseInput.houseEndingPoint(),
                houseInput.orangeTreePosition(),
                houseInput.orangeFallingDistances()
        );

        return List.of(countApplesOnTheHouse, countOrangesOnTheHouse);
    }

    private static long getCountFruitsOnTheHouse(int houseStartingPoint, int houseEndingPoint,
                                                 int appleTreePoint, List<Integer> appleFallingDistances) {
        return appleFallingDistances.stream()
                .filter(distance -> appleTreePoint + distance >= houseStartingPoint)
                .filter(distance -> appleTreePoint + distance <= houseEndingPoint)
                .count();
    }
}
