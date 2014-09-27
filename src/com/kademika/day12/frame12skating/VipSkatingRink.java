package com.kademika.day12.frame12skating;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Ricky on 17.09.14.
 */
public class VipSkatingRink implements SkatingRink {

    private Lock skatesLock;

    private List<Skates> skatesList;

    public VipSkatingRink() {
        skatesList = new LinkedList<>();

        for (int i = 0; i < 3; i++) {
            skatesList.add(new Skates());
        }

        skatesLock = new ReentrantLock();
    }

    @Override
    public Skates getSkates(Skater skater) {
        if (skatesList.isEmpty()) {
            try {
                synchronized (skatesList) {
                    skatesList.wait();
                }
            } catch (InterruptedException e) {
//                ignore
            }
        }

        skatesLock.lock();

        Skates skates = skatesList.remove(0);

        skatesLock.unlock();

        System.out.println(skater.getName() + " got skates");

        return skates;
    }

    @Override
    public void returnSkates(Skates skates, Skater skater) {

        skatesList.add(skates);

        synchronized (skatesList) {
            skatesList.notifyAll();
        }

        System.out.println(skater.getName() + " returned skates");
    }

    public boolean gotFreeSkates() {
        return !skatesList.isEmpty();
    }
}
