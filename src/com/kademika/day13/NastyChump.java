package com.kademika.day13;

import java.io.IOException;
import java.net.Socket;

/**
 * Created by ricky on 10/25/14.
 */
public class NastyChump {

    public static void main(String[] args) throws Exception {
        for (int i = 0; i < 3000; i++) {
            try {
                new Socket("localhost", 8080);
                System.out.println(i);
            } catch (IOException e) {
                System.out.println("Could not connect - " + e);
            }
        }
        Thread.currentThread().sleep(1000000000);
    }
}
