package com.kademika.day10.frame04mybox;

import com.kademika.day10.domain.Animal;
import com.kademika.day10.domain.Dog;

import java.util.*;

/**
 * Created by Ricky on 30.06.14.
 */
public class MyGenericBox<T extends Animal> {

    private List<T> animals;

    public MyGenericBox() {
        animals = new ArrayList<T>();
    }

    public void addLastObject(T object) {
        animals.add(object);
    }

    public T getLastObject(int i) {
        return animals.get(i);
    }

    public void remove(int i) {
        animals.remove(i);
    }

    public void sortByName() {

        Collections.sort(animals, new Comparator<T>() {
            @Override
            public int compare(T o1, T o2) {
                String s1 = o1.getName();
                String s2 = o2.getName();
                int result = s1.compareToIgnoreCase(s2);

                if (result > 0) {
                    return 1;
                } else if (result < 1) {
                    return -1;
                }
                return 0;
            }
        });
    }

    public List<T> getAnimals() {
        return new ArrayList<>(animals);
    }

    public static void copy(List<? extends Animal> source, List<? super Animal> dest) {
        for (Animal animal : source) {
            dest.add(animal);
        }
    }
}
