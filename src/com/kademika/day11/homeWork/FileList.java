package com.kademika.day11.homeWork;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Ricky on 05.08.14.
 */
public class FileList<T> implements SimpleList<T> {

    public static final java.lang.String FILE_NAME = "list.dat";
    public static final int BUFFER_SIZE = 8 * 1024;

    private List<T> data;
    private File dataFile;

    private boolean modified;

    public FileList() {
        init();
    }

    private void init() {

        data = new ArrayList<>();
        dataFile = new File(FILE_NAME);

        if (!dataFile.exists()) {
            // is this 1st run?
            try {
                dataFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        readData();
    }

    private void readData() {

        StringBuilder builder = new StringBuilder();

        try (BufferedInputStream iStream = new BufferedInputStream(new FileInputStream(dataFile))) {

               byte[] buffer = new byte[BUFFER_SIZE];

               while (iStream.read(buffer) != -1) {
                   builder.append(new String(buffer));
               }

           } catch (IOException e) {
               e.printStackTrace();
           }

        if (!builder.toString().isEmpty()) {
            for (String s : builder.toString().split(System.getProperty("line.separator"))) {
                T t = (T) s.replaceAll(String.valueOf((char) 0), "");
                data.add(t);
            }

            modified = false;
        }

    }

    private void saveData() {

        if (!modified) {
            return;
        }

        try (OutputStream oStream = new BufferedOutputStream(new FileOutputStream(dataFile))) {

            Iterator<T> it = data.iterator();
            while (it.hasNext()) {

                T object = it.next();

                StringBuilder builder = new StringBuilder();
                builder.append(object);
                if (it.hasNext()) {
                    builder.append(System.getProperty("line.separator"));
                }

                byte[] bytes = builder.toString().getBytes();
                oStream.write(bytes);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void add(T object) {
        data.add(object);
        modified = true;

        saveData();
    }

    @Override
    public boolean contains(T object) {
        return data.contains(object);
    }

    @Override
    public void remove(T object) {
        if (data.contains(object)) {
            data.remove(object);
            modified = true;
        } else {
            System.out.println("List doesn't contains " + object.toString());
        }

        saveData();
    }

    @Override
    public int size() {
        return data.size();
    }

    @Override
    public Iterator<T> iterator() {

        Iterator<T> iterator = new Iterator<T>() {

            private Iterator iterator = data.iterator();

            @Override

            public boolean hasNext() {
                return iterator.hasNext();
            }

            @Override
            public T next() {
                return (T) iterator.next();
            }

            @Override
            public void remove() {
                iterator.remove();
                modified = true;
                saveData();
            }
        };

        return iterator;
    }
}



