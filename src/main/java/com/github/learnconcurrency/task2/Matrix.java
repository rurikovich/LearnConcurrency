package com.github.learnconcurrency.task2;

/**
 * @author RastegaevYO
 */
public class Matrix {
    private int[][] data;
    private int[][] reversedData;

    public Matrix(int[][] data) {
        this.data = data;
        this.reversedData = fillReversedMatrixData();
    }

    public Matrix(int n, int m) {
        data = new int[n][m];
    }

    public int getN() {
        return data.length;
    }

    public int getM() {
        return data[0].length;
    }

    public int[] getRow(int i) {
        return data[i];
    }

    public int[] getColumn(int i) {
        return reversedData[i];
    }

    public synchronized void setGrid(int i, int j, int value) {
        data[i][j] = value;
    }

    public int getGrid(int i, int j) {
        return data[i][j];
    }

    public void printMatrix() {
        for (int i = 0; i < getN(); i++) {
            for (int j = 0; j < getM(); j++) {
                System.out.print(getGrid(i, j) + " ");
            }
            System.out.println();
            System.out.println();
        }
    }

    private int[][] fillReversedMatrixData() {
        int n = data[0].length;
        int[][] reversedData = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                reversedData[i][j] = data[j][i];
            }
        }
        return reversedData;
    }
}
