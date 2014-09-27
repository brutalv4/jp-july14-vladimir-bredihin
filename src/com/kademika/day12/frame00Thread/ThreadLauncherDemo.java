package com.kademika.day12.frame00Thread;

/**
 * Created by Ricky on 25.08.14.
 */
public class ThreadLauncherDemo {

    public static void main(String[] args) {

        System.out.println("Running " + Thread.currentThread().getName());

        new MyThread().run();

        new MyThread().start();

        new Thread(new MyRunnable()).start();

    }
}
