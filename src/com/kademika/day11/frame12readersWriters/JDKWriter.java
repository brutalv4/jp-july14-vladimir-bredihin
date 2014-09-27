package com.kademika.day11.frame12readersWriters;

import com.kademika.day11.frame06fileIOstream.FileWriter;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

/**
 * Created by Ricky on 28.07.14.
 */
public class JDKWriter implements FileWriter {

    @Override
    public void write(String data, String fileName) {

        try (
                FileOutputStream fos = new FileOutputStream(fileName);
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fos);
//              custom charset
//              OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fos, StandardCharsets.ISO_8859_1);
        ) {
            outputStreamWriter.write(data);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
