package com.kademika.day10.domain;

/**
 * Created by Ricky on 28.06.14.
 */
public class Dog extends Animal {

    private Integer age;

    public Dog() {
    }

    public Dog(String name, Integer age) {
        this.setName(name);
        this.age = age;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Dog#" + getName();
    }
}
