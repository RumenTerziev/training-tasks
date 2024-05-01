package org.example;

public class MatrixTaskRemake {

    private static final int ROWS = 10;
    private static final int COLS = 10;
    private static final int[][] MATRIX = new int[ROWS][COLS];
    private static int currentRow = 0;
    private static int currentCol = 0;
    private static int NEXT_NUM = 1;
    private static final int MAX_NUM = MATRIX.length * MATRIX[0].length;

    public static void main(String[] args) {
        fillMatrix();
        printMatrix();
    }

    private static void fillMatrix() {
        while (NEXT_NUM <= MAX_NUM) {
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
        if (isColMode) {
            int currentNum = MATRIX[currentRow][index];
            if (isNotEligibleForChange(currentNum) || isOutOfBounds(currentRow, index)) {
                return true;
            }
            MATRIX[currentRow][index] = NEXT_NUM;
            NEXT_NUM++;
            currentCol = index;
        } else {
            int currentNum = MATRIX[index][currentCol];
            if (isNotEligibleForChange(currentNum) || isOutOfBounds(currentRow, index)) {
                return true;
            }
            MATRIX[index][currentCol] = NEXT_NUM;
            NEXT_NUM++;
            currentRow = index;
        }
        return false;
    }

    private static boolean isNotEligibleForChange(int number) {
        return number != 0 || NEXT_NUM > MAX_NUM;
    }

    private static boolean isOutOfBounds(int row, int col) {
        return row < 0 || row >= ROWS || col < 0 || col >= COLS;
    }

    private static void printMatrix() {
        for (int[] rows : MATRIX) {
            System.out.println(" ------------------------------------------------------------");
            for (int col = 0; col < rows.length; col++) {
                if (col == 0) {
                    System.out.print("|  ");
                }
                if (rows[col] <= 9) {
                    System.out.print(rows[col] + "   | ");
                } else if (rows[col] <= 99) {
                    System.out.print(rows[col] + "  | ");
                } else {
                    System.out.print(rows[col] + " | ");
                }
            }
            System.out.println();
        }
        System.out.println(" ------------------------------------------------------------");
    }
}
