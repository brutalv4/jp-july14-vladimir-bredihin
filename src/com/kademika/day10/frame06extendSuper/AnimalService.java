package com.kademika.day10.frame06extendSuper;

import com.kademika.day10.domain.Animal;

import java.util.List;

/**
 * Created by Ricky on 30.06.14.
 */
public class AnimalService {

    public static Animal findAnimal(List<? extends Animal> animals, Animal animal) {
        return null;
    }

    public static void copy(List<? extends Animal> src, List<? super Animal> dest) {
        for (Animal animal : src) {
            dest.add(animal);
        }
    }
}

