package com.kademika.day11.frame11charCharsetsEncoding;

/**
 * Created by Ricky on 28.07.14.
 */
public class AsciiChart {

    public static void main(String[] args) {
        int start = 32;
        int finish = 127;

        for (int i = start; i <= finish; i++) {
            System.out.write(i);
            if (i % 8 == 7) {
                System.out.println();
            } else {
                System.out.write('\t');
            }
        }
    }
}
