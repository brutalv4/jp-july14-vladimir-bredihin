package com.kademika.day10.frame06extendSuper;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Ricky on 30.06.14.
 */
public class WildcardDemo {

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(new Integer[]{1, 2, 3});
        print(numbers);

        List<Long> longs = Arrays.asList(new Long[]{1L, 2L, 3L});
        print(longs);
    }

    public static void print(List<? extends Number> numbers) {

        for (Number n : numbers) {
            System.out.println(n);
        }
    }
}
