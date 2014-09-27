package com.kademika.day12.frame16idGenerator;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by Ricky on 24.09.14.
 */
public class IdGenerator {

    private AtomicLong aLong = new AtomicLong();

    public IdGenerator() {
        aLong.set(Long.MAX_VALUE);
    }

    public static void main(String[] args) {
        final IdGenerator generator = new IdGenerator();
        for (int i = 0; i < 100; i++) {

            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(generator.getNextId());
                }
            }).run();
        }
    }

    public long getNextId() {
        return aLong.getAndDecrement();
    }
}
