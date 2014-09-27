package com.kademika.day11.frame15zipUtil;

/**
 * Created by Ricky on 02.08.14.
 */
public class ZipUtilDemo {

    public static void main(String[] args) {

//        let's zip image file
        ZipUtil.main(new String[] {"zip", "-f", "bg.jpg", "-a", "bg_archive.zip"});

//        let's zip folder with images
//        ZipUtil.main(new String[] {"zip", "-f", "folder2zip", "-a", "zippedFolder.zip"});

//        let's unzip file
        ZipUtil.main(new String[] {"unzip", "-a", "zippedFolder.zip"});
    }
}
