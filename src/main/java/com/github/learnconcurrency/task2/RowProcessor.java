package com.github.learnconcurrency.task2;

import java.util.concurrent.Callable;

/**
 * Created by User on 05.04.2017.
 */
public class RowProcessor implements Callable<Integer> {
    private int[] row;
    private int[] column;

    public RowProcessor(int[] row, int[] column) {
        this.row = row;
        this.column = column;
    }

    @Override
    public Integer call() throws Exception {
        int res = 0;
        int n = row.length;
        for (int i = 0; i < n; i++) {
            res += row[i] * column[i];
        }
        return res;
    }
}
