package org.example.matrix;

import java.util.HashMap;
import java.util.Map;

public class MatrixTaskRemake {

    private static final int ROWS = 5;
    private static final int COLS = 5;
    private static final int[][] MATRIX = new int[ROWS][COLS];
    private static int currentRow = 0;
    private static int currentCol = 0;
    private static int nextNum = 1;
    private static final int MAX_NUM = MATRIX.length * MATRIX[0].length;
    private static Map<Integer, Coordinate> coordinates = new HashMap<>();

    public static void main(String[] args) throws InterruptedException {
        fillMatrix();
        printMatrix();
        rotateMultipleTimes(5);
    }

    private static void fillMatrix() {
        while (nextNum <= MAX_NUM) {
            fillRow();
            fillColumn();
            fillRowBackWards();
            fillColBackwards();
        }
    }

    private static void fillRow() {
        fillForwards(currentCol, COLS, true);
        currentRow++;
    }

    private static void fillColumn() {
        fillForwards(currentRow, ROWS, false);
        currentCol--;
    }

    private static void fillRowBackWards() {
        fillBackwards(currentCol, true);
        currentRow--;
    }

    private static void fillColBackwards() {
        fillBackwards(currentRow, false);
        currentCol++;
    }

    private static void fillForwards(int startIndex, int endIndex, boolean isColMode) {
        for (int index = startIndex; index < endIndex; index++) {
            if (doFillValues(isColMode, index)) {
                break;
            }
        }
    }

    private static void fillBackwards(int startIndex, boolean isColMode) {
        for (int index = startIndex; index >= 0; index--) {
            if (doFillValues(isColMode, index)) break;
        }
    }

    private static boolean doFillValues(boolean isColMode, int index) {
        int localRow;
        int localCol;
        if (isColMode) {
            int currentNum = MATRIX[currentRow][index];
            if (isNotEligibleForChange(currentNum) || isOutOfBounds(currentRow, index)) {
                return true;
            }
            localRow = currentRow;
            localCol = index;
            currentCol = index;
        } else {
            int currentNum = MATRIX[index][currentCol];
            if (isNotEligibleForChange(currentNum) || isOutOfBounds(currentRow, index)) {
                return true;
            }
            localRow = index;
            localCol = currentCol;
            currentRow = index;
        }
        MATRIX[localRow][localCol] = nextNum;
        coordinates.putIfAbsent(nextNum, new Coordinate(localRow, localCol));
        nextNum++;
        return false;
    }

    private static boolean isNotEligibleForChange(int number) {
        return number != 0 || nextNum > MAX_NUM;
    }

    private static boolean isOutOfBounds(int row, int col) {
        return row < 0 || row >= ROWS || col < 0 || col >= COLS;
    }

    private static void printMatrix() {
        printDashes(MATRIX[0].length);
        System.out.println();
        for (int[] row : MATRIX) {
            for (int col = 0; col < row.length; col++) {
                if (col == 0) {
                    System.out.print("|");
                }
                printCell(row, col, row[col]);
            }
            System.out.println();
            printDashes(row.length);
            System.out.println();
        }
    }

    private static void printDashes(int rowLength) {
        for (int index = 0; index < 7 * rowLength - 1; index++) {
            if (index == 0) {
                System.out.print(" ");
            }
            System.out.print("-");
        }
    }

    private static void printCell(int[] row, int col, int num) {
        int cellLength = 6;
        String stringNum = row[col] + "";
        int countSpaces = cellLength - 2 - stringNum.length();
        String space = " ";
        System.out.print(space.repeat(2) + num + space.repeat(countSpaces) + "|");
    }

    private static void rotateMultipleTimes(int timesToRotate) throws InterruptedException {
        for (int i = 0; i < timesToRotate; i++) {
            rotateMatrix();
            Thread.sleep(1000);
            printMatrix();
        }
    }

    private static void rotateMatrix() {
        Map<Integer, Coordinate> updatedCoords = new HashMap<>();
        for (Map.Entry<Integer, Coordinate> entry : coordinates.entrySet()) {
            int nextKey = entry.getKey() + 1;
            if (coordinates.containsKey(nextKey)) {
                Coordinate nextCoords = coordinates.get(nextKey);
                updatedCoords.put(entry.getKey(), nextCoords);
            }
        }
        Coordinate firstNumCoords = coordinates.get(1);
        MATRIX[firstNumCoords.row()][firstNumCoords.col()] = MAX_NUM;
        coordinates = updatedCoords;
        coordinates.put(MAX_NUM, firstNumCoords);
        for (Map.Entry<Integer, Coordinate> coordinateEntry : updatedCoords.entrySet()) {
            if (coordinateEntry.getKey() > MAX_NUM) {
                break;
            }
            MATRIX[coordinateEntry.getValue().row()][coordinateEntry.getValue().col()] = coordinateEntry.getKey();
        }
    }
}
