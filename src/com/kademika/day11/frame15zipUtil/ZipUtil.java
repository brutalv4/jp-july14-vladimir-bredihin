package com.kademika.day11.frame15zipUtil;

import java.io.*;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

/**
 * Created by Ricky on 02.08.14.
 */
public class ZipUtil {

    private static final int BUFFER_SIZE = 8 * 1024;
    private String operation;
    private File source;
    private File dest;
    private String fileName;
    private String archiveName;
    private ArrayList<File> files;

    public static void main(String[] args) {

        ZipUtil util = new ZipUtil();
        util.process(args);
    }

    private void process(String[] args) {
        files = new ArrayList<>();

        if (args.length != 0) {

            operation = args[0];

            resolveNames(args);

            if (operation.equals("zip") && fileName == null) {
                System.out.println("Error! Specify a valid filename to operate!");
                return;
            }

            if (operation.equals("unzip") && archiveName == null) {
                System.out.println("Error! Specify a valid archive name to operate!");
                return;
            }

            perform();

        } else {
//                RTFM
            System.out.println("Unknown command \"" + args[0] + "\"");
            System.out.println("Usage: ZipUtil [unzip|zip -f [file1 file2..fileN]] -a [archive name]");
        }
    }

    private void resolveNames(String[] args) {

//        check for filenames in args
        for (int i = 1; i < args.length; i++) {
            if (args[i].equals("-f") && !args[i].equals("-a")) {
                fileName = args[i + 1];
            }

            if (args[i].equals("-a")) {
                archiveName = args[i + 1];
            }
        }

//        if archive name not resolved identify new one
        if (operation.equals("zip") && archiveName == null) {
            StringBuilder destName = new StringBuilder();
            String[] nameFields = fileName.split("\\.");

            if (nameFields.length > 1) {
                for (int i = 0; i < nameFields.length - 1; i++) {
                    destName.append((i == 0) ? "" : ".");
                    destName.append(nameFields[i]);
                }
            } else {
                destName.append(nameFields[0]);
            }

            destName.append(".zip");

            archiveName = destName.toString();
        }

//        if new folder name not resolved identify new one
        if (operation.equals("unzip") && fileName == null) {
            StringBuilder destName = new StringBuilder();
            String[] nameFields = archiveName.split("\\.");

            if (nameFields.length > 1) {
                for (int i = 0; i < nameFields.length - 1; i++) {
                    destName.append((i == 0) ? "" : ".");
                    destName.append(nameFields[i]);
                }
            } else {
                destName.append(nameFields[0]);
            }

            fileName = destName.toString();
        }
    }

    private void perform() {

        resolveSides();

//            should be recursive here
        listFiles(source);

        if (operation.equals("zip")) {
            zip();
        } else {
            unzip();
        }
    }

    private void resolveSides() {

        if (operation.equals("zip")) {
            source = new File(fileName);
            dest = new File(archiveName);
        } else {
            source = new File(archiveName);
            dest = new File(fileName);
            if (!dest.exists()) {
                dest.mkdir();
            }
        }
    }

    private void listFiles(File file) {
        if (file.listFiles() != null) {
            for (File f : file.listFiles()) {
                if (f.isDirectory()) {
                    files.add(f);
                    listFiles(f);
                }
                if (!files.contains(f)) {
                    files.add(f);
                }
            }
        } else {
            files.add(file);
        }
    }

    private void zip() {

//          new 8 Kb buffer
        byte[] buffer = new byte[BUFFER_SIZE];

        try (
                ZipOutputStream oStream = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(dest)))
                ){
            for (File file : files) {

//                do I need empty folder entry?
                if (file.isDirectory()) {
                    continue;
                }

                BufferedInputStream iStream = new BufferedInputStream(new FileInputStream(file));

                ZipEntry zipEntry = new ZipEntry(file.getPath());
                oStream.putNextEntry(zipEntry);

                while (iStream.read(buffer) > 0) {
                    oStream.write(buffer);
                }

                oStream.closeEntry();
                iStream.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void unzip() {

//          new 8 Kb buffer
        byte[] buffer = new byte[BUFFER_SIZE];

        for (File file : files) {

            try (
                    ZipFile zipFile = new ZipFile(file);
            ) {
                Enumeration entries = zipFile.entries();

                while (entries.hasMoreElements()) {
                    ZipEntry zipEntry = (ZipEntry) entries.nextElement();
                    BufferedInputStream iStream = new BufferedInputStream(zipFile.getInputStream(zipEntry));

                    StringBuilder newName = new StringBuilder();
                    newName.append(dest);
                    newName.append(File.separator);
                    newName.append(zipEntry.getName());

                    File newFile = new File(newName.toString());

                    if (!new File(newFile.getParent()).exists()) {
                        new File(newFile.getParent()).mkdirs();
                    }

                    BufferedOutputStream oStream = new BufferedOutputStream(new FileOutputStream(newFile));

                    while (iStream.read(buffer) > 0) {
                        oStream.write(buffer);
                    }
                    oStream.close();
                    iStream.close();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}