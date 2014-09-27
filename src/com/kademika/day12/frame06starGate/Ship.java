package com.kademika.day12.frame06starGate;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Ricky on 13.09.14.
 */
public class Ship extends JComponent {

    private ArrayList<ImageIcon> icons;
    private int counter;
    private int x;
    private int y;
    private JFrame parent;

    public Ship(JFrame frame) {
        parent = frame;
        init();

        counter = new Random().nextInt(4);
    }

    public void init() {
        icons = new ArrayList<>();

        for (int i = 0; i <= 4; i++) {
            StringBuilder builder = new StringBuilder();
            builder.append("StarGateImgz");
            builder.append(System.getProperty("file.separator"));
            builder.append("ship");
            builder.append(String.valueOf(i));
            builder.append(".png");

            String fileName = builder.toString();

            try {
                icons.add(new ImageIcon(fileName));
            } catch (Exception e) {
                //ignore
            }
        }

    }

    public void draw(Graphics g) {
        ImageIcon icon = icons.get(counter);
        g.drawImage(icon.getImage(), x, parent.getHeight() / 2 - icon.getIconHeight() / 2, icon.getIconWidth(),
                icon.getIconHeight(), null, null);
    }

    public void move() {
        if (x >= parent.getWidth() + 50) {
            x = -300;

            // switch to next icon
            counter = new Random().nextInt(4);
        }
        x += 1;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
