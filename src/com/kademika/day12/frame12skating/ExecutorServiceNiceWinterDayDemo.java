package com.kademika.day12.frame12skating;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Ricky on 17.09.14.
 */
public class ExecutorServiceNiceWinterDayDemo {

    public static void main(String[] args) {

        System.out.println("Good morning everyone we are opened!!!");

        final SkatingRink skatingRink = new SchoolSkatingRink();

        final Random random = new Random();

        final ExecutorService service = Executors.newFixedThreadPool(5);

        try {
            for (int i = 0; i < 10; i++) {

                final Skater skater = new Skater("Skater " + i);

                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Skates skates = null;
                        while (skates == null) {
                            skates = skatingRink.getSkates(skater);
                            sleep(random.nextInt(2000));
                        }

                        skates = skatingRink.getSkates(skater);
                        System.out.println(skater.getName() + " on ice");
                        sleep(random.nextInt(2000));
                        skatingRink.returnSkates(skates, skater);
                    }
                });

                service.submit(thread);

            }
        } finally {
            service.shutdown();
        }

    }

    private static void sleep(int timeout) {
        try {
            Thread.currentThread().sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
