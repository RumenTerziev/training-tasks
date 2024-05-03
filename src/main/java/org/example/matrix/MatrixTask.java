package org.example.matrix;

public class MatrixTask {
    public static void main(String[] args) {
        int rows = 5;
        int cols = 5;
        int[][] matrix = new int[rows][cols];

        fillMatrix(matrix, rows, cols);

        printMatrix(matrix);
    }

    private static void fillMatrix(int[][] matrix, int rows, int cols) {
        int maxNum = rows * cols;
        int nextNum = 1;
        int currentRow = 1;
        int currentCol = 0;
        int colCounter = 0;
        int rowCounter = 0;
        while (nextNum <= maxNum) {
            for (int col = currentCol; col < cols - colCounter; col++) {
                matrix[rowCounter][col] = nextNum;
                currentCol = col;
                nextNum++;
                if (nextNum > maxNum) {
                    return;
                }
            }
            for (int row = currentRow; row < rows - rowCounter; row++) {
                matrix[row][currentCol] = nextNum;
                currentRow = row;
                nextNum++;
                if (nextNum > maxNum) {
                    return;
                }
            }
            currentCol--;

            for (int col = currentCol; col >= colCounter; col--) {
                matrix[currentRow][col] = nextNum;
                currentCol = col;
                nextNum++;
                if (nextNum > maxNum) {
                    return;
                }
            }
            colCounter++;
            rowCounter++;
            currentRow++;
            for (int row = currentRow - rowCounter; row > 0; row--) {

                if (matrix[row][currentCol] == 0) {

                    matrix[row][currentCol] = nextNum;
                    currentRow = row;
                    nextNum++;
                }

                if (nextNum > maxNum) {
                    return;
                }
            }
            currentRow++;
            currentCol++;

        }
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            System.out.println(" -------------------------");
            for (int col = 0; col < row.length; col++) {
                if (col == 0) {
                    System.out.print("|  ");
                }
                if (row[col] <= 9) {
                    System.out.print(row[col] + "  | ");
                } else {
                    System.out.print(row[col] + " | ");
                }
            }
            System.out.println();
        }
        System.out.println(" -------------------------");
    }
}
