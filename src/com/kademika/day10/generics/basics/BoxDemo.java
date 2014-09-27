package com.kademika.day10.generics.basics;

/**
 * Created by Ricky on 28.06.14.
 */
public class BoxDemo {

    public static void main(String[] args) {
        Box<Integer> box = new Box<>();

        box.setItem(10);
        System.out.println(box.getItem());
    }
}
