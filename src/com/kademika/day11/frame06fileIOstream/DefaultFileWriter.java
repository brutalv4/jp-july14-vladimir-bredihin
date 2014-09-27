package com.kademika.day11.frame06fileIOstream;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by Ricky on 27.07.14.
 */
public class DefaultFileWriter implements FileWriter {

    @Override
    public void write(String data, String fileName) {

        try (FileOutputStream fos = new FileOutputStream(fileName)) {
            fos.write(data.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
