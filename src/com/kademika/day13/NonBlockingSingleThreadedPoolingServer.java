package com.kademika.day13;

import java.io.IOError;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

/**
 * Created by ricky on 10/27/14.
 */
public class NonBlockingSingleThreadedPoolingServer {

    private static Collection<SocketChannel> channels = new HashSet<>();

    public static void main(String[] args) throws Exception {

        ServerSocketChannel ssc = ServerSocketChannel.open();
        ssc.bind(new InetSocketAddress("localhost", 8080));

        ssc.configureBlocking(false);

        while (true) {
            Thread.currentThread().sleep(500);
            SocketChannel sc = ssc.accept(); // non blocking - usually null
            if (sc != null) {
                System.out.println("Connection from " + sc);

                sc.configureBlocking(false);
                channels.add(sc);
            }

            for (Iterator<SocketChannel> it = channels.iterator(); it.hasNext(); ) {
                SocketChannel channel = it.next();
                try {
                    ByteBuffer buffer = ByteBuffer.allocate(1024);

                    int read = channel.read(buffer);
                    if (read == -1) {
                        it.remove();
                    } else if (read != 0) {
                        buffer.flip();
                        for (int i = 0; i < buffer.limit(); i++) {
                            buffer.put(i, (byte) Utils.transmogrify(buffer.get(i)));
                        }
                        channel.write(buffer);
                    }
                } catch (IOException e) {
                    System.out.println("Connection problem - " + e);
                    it.remove();
                }
            }

        }

    }
}
