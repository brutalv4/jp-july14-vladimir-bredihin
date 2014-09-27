package com.kademika.day11.frame05file;

import java.io.File;

/**
 * Created by Ricky on 26.07.14.
 */
public class HomeTree {

    public static void main(String[] args) {

        File home = new File(System.getProperty("user.home"));
        if (home.exists()) {
            for (File f : home.listFiles()) {
                if (f.isDirectory()) {
                    System.out.println(f.getAbsolutePath());
                }
            }
        }
    }
}
