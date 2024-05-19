package org.example.hacker.house;

import java.util.List;
import java.util.Scanner;

import static org.example.hacker.house.IOUtils.getListFromLine;

public class SamSHouseRemake {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> houseCoords = getListFromLine(scanner);
        List<Integer> treesCoords = getListFromLine(scanner);
        List<Integer> fruitCounts = getListFromLine(scanner);
        List<Integer> appleDistancesOfFalling = getListFromLine(scanner);
        List<Integer> orangeDistancesOfFalling = getListFromLine(scanner);

        int houseStartingPoint = houseCoords.get(0);
        int houseEndingPoint = houseCoords.get(1);
        int appleTreePosition = treesCoords.get(0);
        int orangeTreePosition = treesCoords.get(1);
        int applesCount = fruitCounts.get(0);
        int orangesCount = fruitCounts.get(1);

        List<Long> countFruitsFallingOnTheHouse = countApplesAndOrangesFallingOnTheHouse(houseStartingPoint,
                houseEndingPoint, appleTreePosition, orangeTreePosition,
                appleDistancesOfFalling, orangeDistancesOfFalling);
        System.out.println(countFruitsFallingOnTheHouse.getFirst());
        System.out.println(countFruitsFallingOnTheHouse.getLast());
    }

    public static List<Long> countApplesAndOrangesFallingOnTheHouse(int houseStartingPoint, int houseEndingPoint,
                                                                    int appleTreePoint, int orangeTreePoint,
                                                                    List<Integer> appleFallingDistances,
                                                                    List<Integer> orangeFallingDistances) {

        long countApplesOnTheHouse = getCountFruitsOnTheHouse(
                houseStartingPoint,
                houseEndingPoint,
                appleTreePoint,
                appleFallingDistances
        );

        long countOrangesOnTheHouse = getCountFruitsOnTheHouse(
                houseStartingPoint,
                houseEndingPoint,
                orangeTreePoint,
                orangeFallingDistances
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
