package com.github.learnconcurrency.task2;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by User on 05.04.2017.
 */
public class MatrixProcessor {
    public static void main(String[] args) throws InterruptedException {

        int bigN = 100;
        int[][] data1 = new int[bigN][bigN];
        int[][] data2 = new int[bigN][bigN];
        fillData(bigN, data1, data2);

        Matrix m1 = new Matrix(data1);
        Matrix m2 = new Matrix(data2);

        MatrixProcessor mp = new MatrixProcessor();
        Matrix resM = mp.multiplyMatrixes(m1, m2);


        resM.printMatrix();
    }

    private Matrix multiplyMatrixes(Matrix m1, Matrix m2) {
        int n = m1.getN();
        int m = m1.getM();
        Matrix resM = new Matrix(n, m);
        int cores = Runtime.getRuntime().availableProcessors();
        ExecutorService service = Executors.newFixedThreadPool(cores);
        Future<Integer>[][] futures = new Future[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                futures[i][j] = service.submit(new RowProcessor(m1.getRow(i), m2.getColumn(j)));
            }
        }


        int outCount = 0;
        while (outCount < n * m) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    Future<Integer> future = futures[i][j];
                    if (future.isDone() && resM.getGrid(i, j) == 0) {
                        try {
                            Integer value = future.get();
                            resM.setGrid(i, j, value);
                            outCount++;
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        } catch (ExecutionException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }

        service.shutdown();

        return resM;
    }

    private static void fillData(int bigN, int[][] data1, int[][] data2) {
        for (int i = 0; i < bigN; i++) {
            for (int j = 0; j < bigN; j++) {
                data1[i][j] = 1;
                if (i == j) {
                    data2[i][j] = 1 * (i + 1);
                }
            }
        }
    }

}
