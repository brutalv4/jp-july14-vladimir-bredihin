package com.kademika.day11.frame09bufferedStream;

import com.kademika.day11.frame06fileIOstream.FileReader;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by Ricky on 27.07.14.
 */
public class BufferedReader implements FileReader {

    @Override
    public String read(String fileName) {
        StringBuilder builder = new StringBuilder();

        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(fileName));) {
            int i;
            while ((i = bis.read()) != -1) {
                builder.append((char) i);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return builder.toString();
    }
}
