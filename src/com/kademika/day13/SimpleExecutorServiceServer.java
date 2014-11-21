package com.kademika.day13;

import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by ricky on 10/25/14.
 */
public class SimpleExecutorServiceServer {

    public static void main(String[] args) throws  Exception {
        ServerSocketChannel ssc = ServerSocketChannel.open();
        ssc.bind(new InetSocketAddress("localhost", 8080));

        ExecutorService pool = Executors.newFixedThreadPool(1000);

        while (true) {
            final SocketChannel socketChannel = ssc.accept(); // blocking call never null

            pool.submit(new Runnable() {
                @Override
                public void run() {
                    Utils.process(socketChannel);
                }
            });
        }

    }
}
