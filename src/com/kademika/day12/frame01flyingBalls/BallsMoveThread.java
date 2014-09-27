package com.kademika.day12.frame01flyingBalls;

import java.util.List;

/**
 * Created by Ricky on 04.09.14.
 */
public class BallsMoveThread implements Runnable {

    private Ball ball;

    public BallsMoveThread() {
    }

    @Override
    public void run() {
//        System.out.println(Thread.currentThread().getName() + " running!");
        while (true) {
                ball.move();
                try {
                    Thread.sleep(ball.getSpeed());
                } catch (InterruptedException e) {
            }
        }
    }

    public void setBall(Ball ball) {
        this.ball = ball;
    }
}
