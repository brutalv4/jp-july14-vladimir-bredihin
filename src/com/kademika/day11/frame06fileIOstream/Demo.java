package com.kademika.day11.frame06fileIOstream;

/**
 * Created by Ricky on 27.07.14.
 */
public class Demo {

    public static void main(String[] args) {
        String fileName = "data.txt";

        FileWriter writer = new LegacyFileWriter();
        writer.write("I love programming!", fileName);

        FileReader reader = new LegacyFileReader();
        System.out.println(reader.read(fileName));;

        writer = new DefaultFileWriter();
        writer.write("Me too!", fileName);

        reader = new DefaultFileReader();
        System.out.println(reader.read(fileName));
    }
}
