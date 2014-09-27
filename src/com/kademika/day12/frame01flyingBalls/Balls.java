package com.kademika.day12.frame01flyingBalls;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * Created by Ricky on 28.08.14.
 */
public class Balls extends JComponent {

    public static void main(String[] args) throws Exception{
        new Balls();
    }

    public static final int WIDTH = 640;
    public static final int HEIGHT = 480;
    private JFrame frame;
    private List<Ball> balls;

    public Balls() {
        init();
    }

    private void init() {
        frame = new JFrame("BALLS");
        frame.setLocationRelativeTo(null);
        frame.setMinimumSize(new Dimension(WIDTH, HEIGHT));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.getContentPane().add(this);
        frame.pack();
        frame.setVisible(true);

        createBalls();
        action();
    }

    private void createBalls() {
        balls = new ArrayList<>();

        for (int i = 0; i < 50; i++) {
            balls.add(new Ball(frame));
        }
    }

    private void action() {
        for (Ball ball : balls) {
            BallsMoveThread ballsMoveThread = new BallsMoveThread();
            ballsMoveThread.setBall(ball);
            new Thread(ballsMoveThread).start();
        }

        try{
            while (true) {
                Thread.sleep(60 / 1000);
                repaint();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.CYAN);
        g.fillRect(0, 0, getParent().getWidth(), getParent().getHeight());
        for (Ball ball : balls) {
            ball.draw(g);
        }
    }
}
