package com.kademika.day10.frame14junit;

import com.kademika.day10.domain.Cat;

/**
 * Created by Ricky on 30.06.14.
 */
public class HouseWife {

    private String name;
    private int age;

    public HouseWife() {
    }

    public void feed(Cat[] cats) {

        for (Cat c : cats) {
            if (c.isHungry()) {
                c.setHungry(false);
            } else {
                throw new CatNotHungryException(c.getName() + " is not hungry!");
            }
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
