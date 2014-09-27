package com.kademika.day12.frame17executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by Ricky on 24.09.14.
 */
public class SingleTaskExecutorDemo {

    public static void main(String[] args) throws Exception{

        ExecutorService executor = Executors.newSingleThreadExecutor();

        try {
            Future<Integer> future = executor.submit(new Task());

            System.out.println(future.get());
        } finally {
            executor.shutdown();
        }

    }
}
