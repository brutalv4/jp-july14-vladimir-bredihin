package com.kademika.day11.homeWork;

import java.util.Iterator;

/**
 * Created by Ricky on 05.08.14.
 */
public interface SimpleList<T> {

    void add(T object);

    boolean contains(T object);

    void remove(T object);

    int size();

    Iterator<T> iterator();
}