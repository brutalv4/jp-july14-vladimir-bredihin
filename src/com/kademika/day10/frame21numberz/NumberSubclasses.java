package com.kademika.day10.frame21numberz;

import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
import java.net.URLDecoder;
import java.util.jar.JarEntry;
import java.util.jar.JarInputStream;

/**
 * Created by Ricky on 02.07.14.
 */
public class NumberSubclasses {

    //            java.io.PrintStream out = System.out;
//            java.net.URL u = null;
//            out.println("");
//            out.println("Find the location of java/lang/String.class");
//            u = ClassLoader.getSystemResource("java/lang/String.class");
//            out.println("URL: "+u);
//*************************************************************************************
    public static void main(String[] args) throws Exception {
        Class aClass = Number.class;

        String className = aClass.getName();
        className = className.replace(".", "/") + ".class";

        String packageName = aClass.getPackage().getName();
        packageName = packageName.replace(".", "/");

        URL url = ClassLoader.getSystemResource(className);

        String fileName = URLDecoder.decode(url.getFile(), "UTF-8");
        fileName = fileName.substring(fileName.indexOf("/") + 1, fileName.indexOf("!"));

        File file = new File(fileName);

        if (file.exists()) {
            JarInputStream jarFile = new JarInputStream(new FileInputStream(file));
            JarEntry jarEntry;

            while (true) {
                jarEntry = jarFile.getNextJarEntry();
                if (jarEntry == null) {
                    break;
                }
                if (jarEntry.getName().startsWith(packageName)) {
                    String s = jarEntry.getName();
                    s = s.replace("/", ".");
                    s = s.substring(0, s.indexOf(".class"));

                    Class c = Class.forName(s);
                    if (c.getSuperclass().equals(Number.class)) {
                        System.out.println(c.getName());
                    }
                }
            }
        }
    }
}