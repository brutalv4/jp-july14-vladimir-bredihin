package com.kademika.day11.homeWork;

import java.util.Iterator;

/**
 * Created by Ricky on 05.08.14.
 */
public class SimpleListFileDemo {

    public static void main(String[] args) {

        SimpleList<String> list = new FileList<>();

        list.add("User");
        list.add("PC");
        list.add("XBOX");

//        list.remove("User");

        Iterator it = list.iterator();
        it.next();
        it.remove();

        it.next();
        it.remove();


    }
}
