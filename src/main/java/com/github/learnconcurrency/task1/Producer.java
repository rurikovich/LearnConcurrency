package com.github.learnconcurrency.task1;

/**
 * Created by User on 30.03.2017.
 */
public class Producer implements Runnable {
    public static final int DATA_TO_PUT_SIZE = 10;

    private final DataHolder dataHolder;
    private final int i;

    public Producer(DataHolder dataHolder, int i) {
        this.dataHolder = dataHolder;
        this.i = i;
    }

    public void run() {
        for (int j = 0; j < DATA_TO_PUT_SIZE; j++) {
            dataHolder.addData("data_" + j, i);
        }
    }
}
