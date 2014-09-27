package com.kademika.day11.frame06fileIOstream;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;

/**
 * Created by Ricky on 27.07.14.
 */
public class PrintStream {

    public static void main(String[] args) {

        File file = new File("data.txt");
        try {
           printStreamData(Files.newInputStream(file.toPath(), StandardOpenOption.READ));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void printStreamData(InputStream stream) {

        int i;
        try (InputStream iStream = stream) {
            while ((i = iStream.read()) != -1) {
                System.out.print((char) i);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
