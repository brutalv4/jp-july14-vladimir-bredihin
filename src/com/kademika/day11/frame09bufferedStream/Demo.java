package com.kademika.day11.frame09bufferedStream;

import com.kademika.day11.frame06fileIOstream.FileReader;

/**
 * Created by Ricky on 27.07.14.
 */
public class Demo {

    public static void main(String[] args) {

        String fileName = "test.txt";
        FileReader reader = new BufferedReader();
        System.out.println(reader.read(fileName));
    }
}
