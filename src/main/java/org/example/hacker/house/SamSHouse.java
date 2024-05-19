package org.example.hacker.house;

import java.util.List;
import java.util.Scanner;

import static org.example.hacker.house.IOUtils.getListFromLine;

public class SamSHouse {
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

        List<Integer> countFruitsFallingOnTheHouse = countApplesAndOrangesFallingOnTheHouse(houseStartingPoint,
                houseEndingPoint, appleTreePosition, orangeTreePosition,
                appleDistancesOfFalling, orangeDistancesOfFalling);
        System.out.println(countFruitsFallingOnTheHouse.getFirst());
        System.out.println(countFruitsFallingOnTheHouse.getLast());
    }


    public static List<Integer> countApplesAndOrangesFallingOnTheHouse(int houseStartingPoint, int houseEndingPoint,
                                                                       int appleTreePoint, int orangeTreePoint,
                                                                       List<Integer> appleFallingDistances,
                                                                       List<Integer> orangeFallingDistances) {
        Integer longestAppleFallingDistance = getMaxDistance(appleFallingDistances);
        Integer longestOrangeFallingDistance = getMaxDistance(orangeFallingDistances);

        int rows = 1;
        int maxDistance = Math.max(longestAppleFallingDistance, longestOrangeFallingDistance);
        int cols = orangeTreePoint + maxDistance + 1;
        char[][] matrix = new char[rows][cols];

        fillMatrix(appleTreePoint, orangeTreePoint, houseStartingPoint, houseEndingPoint, rows, cols, matrix);

        int countApplesOnTheHouse = getCountFruitsOnTheHouse(appleTreePoint, appleFallingDistances, matrix);
        int countOrangesOnTheHouse = getCountFruitsOnTheHouse(orangeTreePoint, orangeFallingDistances, matrix);

        printMatrix(rows, cols, matrix);

        return List.of(countApplesOnTheHouse, countOrangesOnTheHouse);
    }

    private static int getCountFruitsOnTheHouse(int treePoint, List<Integer> fruitFallingDistances, char[][] matrix) {
        int countFruitsOnTheHouse = 0;
        for (Integer distance : fruitFallingDistances) {
            int fallingPosition = treePoint + distance;
            if (fallingPosition < 0) {
                continue;
            }
            if (matrix[0][fallingPosition] == 'H') {
                countFruitsOnTheHouse++;
            }
        }
        return countFruitsOnTheHouse;
    }

    private static void fillMatrix(int appleTreePoint, int orangeTreePoint, int houseStartingPoint,
                                   int houseEndingPoint, int rows, int cols, char[][] matrix) {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (col >= houseStartingPoint && col <= houseEndingPoint) {
                    matrix[row][col] = 'H';
                } else if (col == appleTreePoint) {
                    matrix[row][col] = 'A';
                } else if (col == orangeTreePoint) {
                    matrix[row][col] = 'O';
                } else {
                    matrix[row][col] = '_';
                }
            }
        }
    }

    private static void printMatrix(int rows, int cols, char[][] matrix) {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static Integer getMaxDistance(List<Integer> distances) {
        return distances.stream()
                .max(Integer::compareTo)
                .orElseThrow(() -> new RuntimeException("Distances not in apples list"));
    }
}
