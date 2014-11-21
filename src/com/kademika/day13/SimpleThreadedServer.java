package com.kademika.day13;

import java.io.IOError;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Ricky on 20.10.14.
 */
public class SimpleThreadedServer {

    public static void main(String[] args) throws Exception {
        ServerSocket ss = new ServerSocket(8080);
        while (true) {
            final Socket socket = ss.accept(); // blocking call never null

            new Thread(new Runnable() {

                @Override
                public void run() {
//                    Utils.process(socket);
                }
            }).start();

        }
    }
}
