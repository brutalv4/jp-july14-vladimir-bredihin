package com.kademika.day10.frame06extendSuper;

import com.kademika.day10.domain.Animal;
import com.kademika.day10.domain.Cat;
import com.kademika.day10.domain.Dog;

/**
 * Created by Ricky on 30.06.14.
 */
public class AnimalBoxDemo {

    public static void main(String[] args) {

        AnimalBox<Animal> aBox = new AnimalBox<>();
        aBox.addAnimal(new Dog());
        aBox.addAnimal(new Cat());

        for (Animal animal : aBox.getAnimals()) {
            animal.getName();
        }
    }
}
