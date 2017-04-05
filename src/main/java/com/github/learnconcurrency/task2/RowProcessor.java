package com.github.learnconcurrency.task2;

/**
 * Created by User on 05.04.2017.
 */
public class RowProcessor implements Runnable {
    private int i;
    private int j;
    private int[] row;
    private int[] column;

    private MatrixProcessor matrixProcessor;

    public RowProcessor(int i, int j, int[] row, int[] column, MatrixProcessor matrixProcessor) {
        this.i = i;
        this.j = j;
        this.row = row;
        this.column = column;
        this.matrixProcessor = matrixProcessor;
    }

    @Override
    public void run() {
        int res = 0;
        int n = row.length;
        for (int i = 0; i < n; i++) {
            res += row[i] * column[i];
        }
        matrixProcessor.setResGrid(i, j, res);
    }
}
