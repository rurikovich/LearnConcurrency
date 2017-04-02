package com.github.learnconcurrency.task1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.logging.Logger;

import static java.lang.String.format;

/**
 * Created by User on 30.03.2017.
 */
public class DataHolder {
    private final Logger logger = Logger.getLogger(DataHolder.class.getName());
    private int listSize = 7;

    private Queue<String> data = new LinkedList<>();

    public synchronized void addData(String s, int producerNumber) {
        while (isFull()) {
            System.out.println(format("addData. waiting. size =%s", data.size()));
            waitWithException();
        }

        data.offer(s);
        System.out.println(format("Producer #%s put data=%s", producerNumber, s));
        notifyAll();
    }

    public synchronized String getData(int consumerNumber) {
        while (data.size() == 0) {
            System.out.println(format("getData. waiting. size = %s", data.size()));
            waitWithException();
        }

        String res = data.poll();
        System.out.println(format("Consumer #%s. get data = %s", consumerNumber, res));
        notifyAll();
        return res;
    }

    private synchronized boolean isFull() {
        return data.size() >= listSize;
    }

    public static void main(String[] args) throws InterruptedException {
        DataHolder dataHolder = new DataHolder();
        int n = 20;
        for (int i = 0; i < n; i++) {
            new Thread(new Producer(dataHolder, i)).start();
        }

        for (int i = 0; i < 2*n; i++) {
            new Thread(new Consumer(dataHolder, i)).start();
        }

        Thread.sleep(1000);
    }

    private void waitWithException() {
        try {
            wait();
        } catch (InterruptedException e) {
            logger.severe(e.getMessage());
        }
    }
}
