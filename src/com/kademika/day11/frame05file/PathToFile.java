package com.kademika.day11.frame05file;

import java.io.File;
import java.io.IOException;

/**
 * Created by Ricky on 26.07.14.
 */
public class PathToFile {

    public static void main(String[] args) {

        File file = new File("test.txt");

//        System.out.println(System.getProperty("user.dir"));
//        System.out.println(File.separator);
//        System.out.println(File.pathSeparator);
//        for (File f : File.listRoots()) {
//            System.out.println(f.getAbsolutePath());
//        }

        System.out.println(file.getAbsolutePath());

    }

}
