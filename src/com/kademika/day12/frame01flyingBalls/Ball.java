package com.kademika.day12.frame01flyingBalls;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

/**
 * Created by Ricky on 28.08.14.
 */
public class Ball extends JComponent {

    private int x;
    private int y;
    private int dimension;
    private JFrame parent;

    private int xSign = 1;
    private int ySign = 1;

    private Color color;

    private long speed;

    public Ball(JFrame frame) {
        parent = frame;
       createRandomBall();
    }

    private void createRandomBall() {
        x = new Random().nextInt(parent.getWidth());
        y = new Random().nextInt(parent.getHeight());
        color = new Color(new Random().nextInt(255), new Random().nextInt(255), new Random().nextInt(255));

        while (dimension <= 10) {
            dimension = new Random().nextInt(30);
        }

        while (speed <= 2) {
            speed = (long) new Random().nextInt(45);
        }
    }

    public void move() {
        if (x >= parent.getWidth() - dimension) {
             xSign = -1;
        } else if (x <= 0) {
            xSign = 1;
        }

        x += 2 * xSign;

        if (y >= parent.getHeight() - dimension) {
            ySign = -1;
        } else if (y <= 0) {
            ySign = 1;
        }

        y += 1 * ySign;
    }

    public void draw(Graphics g) {
        g.setColor(color);
        g.fillOval(x, y, dimension, dimension);
    }

    public long getSpeed() {
        return speed;
    }
}
