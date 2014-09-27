package com.kademika.day12.frame17executor;

import java.util.Random;
import java.util.concurrent.Callable;

/**
 * Created by Ricky on 24.09.14.
 */
public class Task implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        Random random = new Random();

        int result = 0;
        for (int i = 0; i < random.nextInt(Integer.MAX_VALUE); i++) {
            result++;
        }

        return result;
    }
}
