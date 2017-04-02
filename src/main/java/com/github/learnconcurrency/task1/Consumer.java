package com.github.learnconcurrency.task1;

/**
 * Created by User on 30.03.2017.
 */
public class Consumer implements Runnable {
    private static final int DATA_TO_GET_SIZE = 5;
    private final DataHolder dataHolder;
    private final int i;

    public Consumer(DataHolder dataHolder, int i) {
        this.dataHolder = dataHolder;
        this.i = i;
    }

    @Override
    public void run() {
        for (int j = 0; j < DATA_TO_GET_SIZE; j++) {
            String data = dataHolder.getData(i);
        }
    }
}


