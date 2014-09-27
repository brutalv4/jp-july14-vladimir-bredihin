package com.kademika.day11.frame02byte;

import java.io.ByteArrayInputStream;

/**
 * Created by Ricky on 26.07.14.
 */
public class ByteArrayInputStreamReader {

    public static void main(String[] args) {

        byte[] bytes = {63, 64, 65, 66, 67, -27, -128, 0};
        ByteArrayInputStream in = new ByteArrayInputStream(bytes);

        int i;
        while ((i = in.read()) != -1) {
            System.out.print(i + " ");
        }
    }
}
