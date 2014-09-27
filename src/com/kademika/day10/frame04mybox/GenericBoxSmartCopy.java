package com.kademika.day10.frame04mybox;

import com.kademika.day10.domain.Animal;
import com.kademika.day10.domain.Cat;
import com.kademika.day10.domain.Dog;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ricky on 21.07.14.
 */
public class GenericBoxSmartCopy {

    public static void main(String[] args) {
        List<Dog> dogs = new ArrayList<>();
        List<Cat> cats = new ArrayList<>();

        // Size == 0
        List<Animal> animals = new ArrayList<>();

        for (int i = 1; i <= 10; i++) {
            dogs.add(new Dog());
            cats.add(new Cat());
        }

        MyGenericBox.copy(dogs, animals);
        MyGenericBox.copy(cats, animals);

//        will not compile
//        MyGenericBox.copy(dogs, cats);
    }
}
