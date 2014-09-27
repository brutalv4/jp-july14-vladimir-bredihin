package com.kademika.day11.frame12readersWriters;

import com.kademika.day11.frame06fileIOstream.FileReader;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

/**
 * Created by Ricky on 28.07.14.
 */
public class JDKReader implements FileReader {

    @Override
    public String read(String fileName) {
        StringBuilder builder = new StringBuilder();

        try (
                FileInputStream fis = new FileInputStream(fileName);
                InputStreamReader reader = new InputStreamReader(fis);
//                custom charset
//                InputStreamReader reader = new InputStreamReader(fis, StandardCharsets.UTF_8);
                BufferedReader bufferedReader = new BufferedReader(reader)
        ) {
            String str;
            while ((str = bufferedReader.readLine()) != null) {
                builder.append(str);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return builder.toString();
    }
}
