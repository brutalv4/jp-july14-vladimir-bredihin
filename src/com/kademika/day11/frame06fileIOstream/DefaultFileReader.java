package com.kademika.day11.frame06fileIOstream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by Ricky on 27.07.14.
 */
public class DefaultFileReader implements FileReader {

    @Override
    public String read(String fileName) {
        StringBuilder builder = new StringBuilder();

        try (FileInputStream fis = new FileInputStream(fileName)) {
            int i;
            while ((i = fis.read()) != -1) {
                builder.append((char) i);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return builder.toString();
    }
}
