package com.kademika.day10.frame05;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Ricky on 30.06.14.
 */
public class PrinterDemo {

    public static void main(String[] args) {

        List<String> strList = new ArrayList<>();
        strList.add("one");

        Printer printer = new PrinterDemo().new Printer();
        printer.print(strList);
    }

    class Printer<E> {

        public void print(List<Integer> data) {
            System.out.println("Printer#print(List<Integer>)");
            for (Integer i : data) {
                System.out.println(i);
            }
        }

        public <E> void print(Collection<E> data) {
            System.out.println("Printer#print(Collection<E>)");
            for (E e : data) {
                System.out.println(e);
            }
        }
    }
}
