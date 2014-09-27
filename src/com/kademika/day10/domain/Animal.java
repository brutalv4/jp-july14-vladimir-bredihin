package com.kademika.day10.domain;

/**
 * Created by Ricky on 28.06.14.
 */
public abstract class Animal {

    private Long id;
    private String name;
    private Double price;

    public long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

}
