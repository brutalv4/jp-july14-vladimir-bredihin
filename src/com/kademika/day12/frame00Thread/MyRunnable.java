package com.kademika.day12.frame00Thread;

/**
 * Created by Ricky on 25.08.14.
 */
public class MyRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println("Running " + Thread.currentThread().getName() + " " + this.getClass().getSimpleName());
    }
}
