package com.kademika.day12.frame06starGate;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Ricky on 13.09.14.
 */
public class Portal extends JComponent {

    private ImageIcon icon;
    private int x;
    private int y;
    private JFrame parent;
    private int scaleFactor = 100;
    private volatile boolean isOpen;

    public Portal(JFrame frame) {
        parent = frame;
        init();
    }

    public void init() {
        StringBuilder builder = new StringBuilder();
        builder.append("StarGateImgz");
        builder.append(System.getProperty("file.separator"));
        builder.append("portal.gif");

        String fileName = builder.toString();

        try {
            icon = new ImageIcon(fileName);
        } catch (Exception e) {
            //ignore
        }

        x = parent.getWidth() - 50 - icon.getIconWidth() / scaleFactor / 2;
        y = parent.getHeight() / 2 - icon.getIconHeight() / scaleFactor / 2;
    }

    public void openPortal() {
        int max = scaleFactor;
        for (int i = 1; i < max; i++) {
            scaleFactor -= 1;
            try {
                Thread.currentThread().sleep(10);
            } catch (InterruptedException e) {
//                ignore
            }
        }
        isOpen = true;
    }

    public void closePortal() {
        int min = scaleFactor;
        for (int i = 100; i > min; i--) {
            scaleFactor += 1;
            try {
                Thread.currentThread().sleep(10);
            } catch (InterruptedException e) {
//                ignore
            }
        }
        isOpen = false;
    }

    public void draw(Graphics g) {
        x = parent.getWidth() - 50 - icon.getIconWidth() / scaleFactor / 2;
        y = parent.getHeight() / 2 - icon.getIconHeight() / scaleFactor / 2;

        g.drawImage(icon.getImage(), x, y, icon.getIconWidth() / scaleFactor, icon.getIconHeight() / scaleFactor,
                null, null);
    }

    public boolean isOpen() {
        return isOpen;
    }

    public boolean shipIsNear(int shipX) {
        return x - shipX <= 200 || (shipX - x > 0 && shipX == x);
    }
}
