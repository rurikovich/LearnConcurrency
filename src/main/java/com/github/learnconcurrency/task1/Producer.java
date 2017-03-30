package com.github.learnconcurrency.task1;

/**
 * Created by User on 30.03.2017.
 */
public class Producer implements Runnable {
    private EventHolder eventHolder;

    public Producer(EventHolder eventHolder) {
        this.eventHolder = eventHolder;
    }

    public void run() {
        eventHolder.addEvent();
    }
}
