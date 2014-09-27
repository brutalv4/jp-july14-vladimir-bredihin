package com.kademika.day10.frame05;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Ricky on 30.06.14.
 */
public class GenericMethodDemo {

    public static void main(String[] args) {
        List<String> strings = Arrays.asList(new String[]{"One", "Two", "Three"});
        print(strings);

        List<Integer> numbers = Arrays.asList(new Integer[]{1, 2, 3});
        print(numbers);
    }

    public static <E> void print(List<E> elements) {
        for (E e : elements) {
            System.out.println(e.toString());
        }
    }

}
