package com.kademika.day11.frame06fileIOstream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by Ricky on 27.07.14.
 */
public class CopyFile {

    public static void main(String[] args) {

        String srcName = "data";
        File src = new File(srcName);

        if (src.exists()) {
            copyFile(src);
        }
    }

    public static void copyFile(File src) {

        StringBuilder destName = new StringBuilder();
        String[] nameFields = src.getName().split("\\.");

        if (nameFields.length > 1) {
            for (int i = 0; i < nameFields.length - 1; i++) {
                destName.append((i == 0) ? "" : ".");
                destName.append(nameFields[i]);
            }
        } else {
            destName.append(nameFields[0]);
        }

        destName.append("_copy");
        destName.append((nameFields.length == 1) ? "" : "." + nameFields[nameFields.length - 1]);

        File dest = new File(destName.toString());

        try (FileInputStream iStream = new FileInputStream(src);
             FileOutputStream oStream = new FileOutputStream(dest)) {

            int i;
            while ((i = iStream.read()) != -1) {
                oStream.write(i);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
