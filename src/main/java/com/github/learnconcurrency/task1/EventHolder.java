package com.github.learnconcurrency.task1;

/**
 * Created by User on 30.03.2017.
 */
public class EventHolder {

    private long events = 0;

    public synchronized void addEvent() {
        events=events+1;
    }

    public  long getEvents() {
        return events;
    }

    public static void main(String[] args) throws InterruptedException {
        final EventHolder eventHolder = new EventHolder();
        for (int i = 0; i < 100_000; i++) {

            Thread thread = new Thread(new Runnable() {
                public void run() {
                    eventHolder.addEvent();
                }
            });
            thread.start();
        }
        Thread.sleep(1000);
        System.out.print(eventHolder.getEvents());
    }


}
