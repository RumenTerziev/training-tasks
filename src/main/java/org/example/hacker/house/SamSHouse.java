package org.example.hacker.house;

import java.util.List;

import static org.example.hacker.house.HouseInputUtils.getHouseInput;

public class SamSHouse {
    public static void main(String[] args) {
        List<Integer> countFruitsFallingOnTheHouse = countApplesAndOrangesFallingOnTheHouse(getHouseInput());
        System.out.println(countFruitsFallingOnTheHouse.getFirst());
        System.out.println(countFruitsFallingOnTheHouse.getLast());
    }

    public static List<Integer> countApplesAndOrangesFallingOnTheHouse(HouseInput houseInput) {
        Integer longestAppleFallingDistance = getMaxDistance(houseInput.appleFallingDistances());
        Integer longestOrangeFallingDistance = getMaxDistance(houseInput.orangeFallingDistances());

        int rows = 1;
        int maxDistance = Math.max(longestAppleFallingDistance, longestOrangeFallingDistance);
        int cols = houseInput.orangeTreePosition() + maxDistance + 1;
        char[][] matrix = new char[rows][cols];

        fillMatrix(
                houseInput.appleTreePosition(),
                houseInput.orangeTreePosition(),
                houseInput.houseStartingPoint(),
                houseInput.houseEndingPoint(),
                rows,
                cols,
                matrix
        );

        int countApplesOnTheHouse = getCountFruitsOnTheHouse(houseInput.appleTreePosition(), houseInput.appleFallingDistances(), matrix);
        int countOrangesOnTheHouse = getCountFruitsOnTheHouse(houseInput.orangeTreePosition(), houseInput.orangeFallingDistances(), matrix);

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
