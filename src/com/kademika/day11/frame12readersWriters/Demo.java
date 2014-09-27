package com.kademika.day11.frame12readersWriters;

import com.kademika.day11.frame06fileIOstream.FileReader;
import com.kademika.day11.frame06fileIOstream.FileWriter;
import com.kademika.day11.frame09bufferedStream.BufferedReader;

/**
 * Created by Ricky on 27.07.14.
 */
public class Demo {

    public static void main(String[] args) {

        String fileName = "data.txt";

        FileWriter writer = new JDKWriter();
        writer.write("Hi to JDK Writer!", fileName);

        FileReader reader = new JDKReader();
        System.out.println(reader.read(fileName));
    }
}
