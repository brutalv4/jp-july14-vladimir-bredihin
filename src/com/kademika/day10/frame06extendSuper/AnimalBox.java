package com.kademika.day10.frame06extendSuper;

import com.kademika.day10.domain.Animal;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ricky on 30.06.14.
 */
public class AnimalBox<T extends Animal> {

    private List<T> animals;

    public AnimalBox() {
        animals = new ArrayList<>();
    }

    public void addAnimal(T animal) {
        animals.add(animal);
    }

    public List<T> getAnimals() {
        return new ArrayList<>(animals);
    }

}
