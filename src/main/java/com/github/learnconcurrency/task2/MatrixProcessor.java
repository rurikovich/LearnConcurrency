package com.github.learnconcurrency.task2;

/**
 * Created by User on 05.04.2017.
 */
public class MatrixProcessor {
    public static void main(String[] args) {

        int[][] data1 = {new int[]{1, 1}, new int[]{2, 2}};
        Matrix m1 = new Matrix(data1);

        int[][] data2 = {new int[]{1, 1}, new int[]{2, 2}};
        Matrix m2 = new Matrix(data2);

        MatrixProcessor mp = new MatrixProcessor();
        Matrix resM = mp.multiplyMatrixes(m1, m2);
    }

    private Matrix multiplyMatrixes(Matrix m1, Matrix m2) {
        int cores = Runtime.getRuntime().availableProcessors();



        return null;
    }

    public void setResGrid(int i, int j, int res) {

    }
}
