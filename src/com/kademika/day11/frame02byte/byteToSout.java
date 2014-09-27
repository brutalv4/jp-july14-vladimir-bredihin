package com.kademika.day11.frame02byte;

/**
 * Created by Ricky on 26.07.14.
 */
public class byteToSout {

    public static void main(String[] args) {

        for (int i = 0; i < 300; i++) {
            byte b = (byte) i;
            if (i % 128 == 0) {
                System.out.println();
            }
            System.out.print(b + " ");
        }

    }

}
