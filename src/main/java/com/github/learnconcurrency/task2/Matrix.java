package com.github.learnconcurrency.task2;

/**
 * @author RastegaevYO
 */
public class Matrix {
    private int[][] data;
    private int[][] reversedData;

    public Matrix(int[][] data) {
        this.data = data;
    }

    public int[] getRow(int i) {
        return data[i];
    }

    public int[] getColumn(int i) {
        if (reversedData == null) {
            reversedData = fillReversedMatrixData(data);
        }
        return reversedData[i];
    }

    public void setGrid(int i, int j, int value) {
        data[i][j] = value;
    }

    public int getGrid(int i, int j) {
        return data[i][j];
    }

    private int[][] fillReversedMatrixData(int[][] data) {
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
