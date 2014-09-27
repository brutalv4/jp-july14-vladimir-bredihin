package com.kademika.day11.frame02byte;

import java.io.ByteArrayInputStream;

/**
 * Created by Ricky on 26.07.14.
 */
public class PrintStreamData {

    public static void main(String[] args) {
        byte[] bytes = {63, 26, 75, -110, 12, 4, 18};

        ByteArrayInputStream inputStream = new ByteArrayInputStream(bytes);
        printStreamData(inputStream);
    }

    public static void printStreamData(ByteArrayInputStream stream) {

        int i;
        while ((i = stream.read()) != -1) {
            System.out.print(i + " ");
        }
    }
}
