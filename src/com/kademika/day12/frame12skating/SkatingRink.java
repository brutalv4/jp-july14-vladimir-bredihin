package com.kademika.day12.frame12skating;

/**
 * Created by Ricky on 17.09.14.
 */
public interface SkatingRink {

    Skates getSkates(Skater skater);

    void returnSkates(Skates skates, Skater skater);
}
