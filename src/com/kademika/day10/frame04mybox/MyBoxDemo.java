package com.kademika.day10.frame04mybox;

import com.kademika.day10.domain.Cat;
import com.kademika.day10.domain.Dog;

import java.util.List;

/**
 * Created by Ricky on 30.06.14.
 */
public class MyBoxDemo {

    public static void main(String[] args) {
        MyGenericBox box = new MyGenericBox<>();
        Dog d1 = new Dog();
        d1.setName("Gamma");
        box.addLastObject(d1);

        Cat c1 = new Cat();
        c1.setName("Alpha");
        box.addLastObject(c1);

        Cat c2 = new Cat();
        c2.setName("Zetta");
        box.addLastObject(c2);

        Dog d2 = new Dog();
        d2.setName("Omega");
        box.addLastObject(d2);

        for (Object o : box.getAnimals()) {
            System.out.println(o);
        }

        box.sortByName();

        System.out.println();
        System.out.println("Sorted box:");

        for (Object o : box.getAnimals()) {
            System.out.println(o);
        }

    }
}
