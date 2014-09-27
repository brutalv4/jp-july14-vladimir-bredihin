package com.kademika.day12.frame12skating;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by Ricky on 21.09.14.
 */
public class VipSkatingRinkQueued implements SkatingRink {

    private final Queue<Skates> skateShelf = new LinkedBlockingQueue<>();

    public VipSkatingRinkQueued() {

        for (int i = 0; i < 3; i++) {
            skateShelf.add(new Skates());
        }
    }

    @Override
    public Skates getSkates(Skater skater) {

        Skates skates = skateShelf.poll();

        if (skates != null) {
            System.out.println(skater.getName() + " got skates");
        }

        return skates;
    }

    @Override
    public void returnSkates(Skates skates, Skater skater) {

        skateShelf.add(skates);

        System.out.println(skater.getName() + " returned skates");

    }
}
