package com.kademika.day12.frame12skating;

/**
 * Created by Ricky on 17.09.14.
 */
public class SchoolSkatingRink implements SkatingRink {

    @Override
    public Skates getSkates(Skater skater) {
        System.out.println(skater.getName() + " got skates");
        return new Skates();
    }

    @Override
    public void returnSkates(Skates skates, Skater skater) {
        System.out.println(skater.getName() + " returned skates");
    }
}
