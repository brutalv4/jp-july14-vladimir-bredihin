package com.kademika.day11.frame09bufferedStream;

import java.io.*;

/**
 * Created by Ricky on 27.07.14.
 */
public class BufferedCopyFile {

    public static void main(String[] args) {

        String srcName = "test.txt";
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

        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(src), 256);
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(dest), 256);
        ) {

            int i;
            while ((i = bis.read()) != -1) {
                bos.write(i);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
