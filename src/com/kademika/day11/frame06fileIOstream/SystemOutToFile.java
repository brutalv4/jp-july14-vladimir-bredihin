package com.kademika.day11.frame06fileIOstream;

import java.io.*;
import java.io.PrintStream;

/**
 * Created by Ricky on 31.07.14.
 */
public class SystemOutToFile {

    public static void main(String[] args) {

        String fileName = "newSout";
        File file = new File(fileName);

        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try (
                PrintStream printStream = new PrintStream(file)
        ) {
            System.setOut(printStream);
            System.out.println("Hello World! =)");
            System.out.println("This is new sout!");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
