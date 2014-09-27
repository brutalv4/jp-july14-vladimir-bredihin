package com.kademika.day11.frame05file;

import java.io.File;
import java.io.IOException;

/**
 * Created by Ricky on 26.07.14.
 */
public class CreateDirWithFile {

    public static void main(String[] args) {

        File dir = new File("newDir");
        File file = new File(dir.getName() + File.separator + "read.me");
        if (dir.mkdir()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println(file.getAbsolutePath());
    }
}
