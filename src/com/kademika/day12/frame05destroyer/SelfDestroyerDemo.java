package com.kademika.day12.frame05destroyer;

/**
 * Created by Ricky on 10.09.14.
 */
public class SelfDestroyerDemo {

    public static void main(String[] args) {

        SelfDestroyer destroyer = new SelfDestroyer();
        destroyer.start();

        try {
            Thread.currentThread().sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        destroyer.killMyself();
    }
}
