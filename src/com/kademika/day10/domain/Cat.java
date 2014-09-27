package com.kademika.day10.domain;

/**
 * Created by Ricky on 28.06.14.
 */
public class Cat extends Animal {

    private String color;
    private double weight;
    private boolean isHungry = true;

    public Cat() {
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isHungry() {
        return isHungry;
    }

    public void setHungry(boolean isHungry) {
        this.isHungry = isHungry;
    }

    @Override
    public String toString() {
        return "Cat#" + getName();
    }
}
