package com.kademika.day10.frame06extendSuper;

import com.kademika.day10.domain.Animal;
import com.kademika.day10.domain.Cat;
import com.kademika.day10.domain.Dog;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ricky on 30.06.14.
 */
public class AnimalServiceDemo {

    public static void main(String[] args) {

        Dog dog = new Dog();
        Cat cat = new Cat();

        List<Animal> animals = new ArrayList<>();
        animals.add(cat);
        animals.add(dog);

        AnimalService.findAnimal(animals, cat);
    }
}
