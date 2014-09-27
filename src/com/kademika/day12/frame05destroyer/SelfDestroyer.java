package com.kademika.day12.frame05destroyer;

/**
 * Created by Ricky on 10.09.14.
 */
public class SelfDestroyer extends Thread {

    private volatile boolean killMe;

    public void killMyself() {
        killMe = true;
    }

    @Override
    public void run() {
        while (!killMe) {
            try {
                System.out.println("Enjoying life..");
                sleep(100);
            } catch (InterruptedException e) {
                // ignore
            }
        }
        System.out.println("Life is so cool aaaaa (Dying...)");
    }
}
