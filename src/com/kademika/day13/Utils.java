package com.kademika.day13;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * Created by Ricky on 20.10.14.
 */
public class Utils {

    public static int transmogrify(int data) {
        if (Character.isLetter(data)) {
            return data ^ ' ';
        }
        return data;
    }

    public static void process(SocketChannel sc) {
        System.out.println("Connection from " + sc);

        try {
            ByteBuffer buffer = ByteBuffer.allocate(1024);

            int data;
            do {
                data = sc.read(buffer);

                buffer.flip();

                for (int i = 0; i < buffer.limit(); i++) {
                    buffer.put(i, (byte) transmogrify(buffer.get(i)));
                }
                sc.write(buffer);
                buffer.clear();
            } while (data != -1);
        } catch (IOException e) {
            System.out.println("Connection problem - " + e);
        }
    }


}
