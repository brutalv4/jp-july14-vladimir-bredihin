package com.kademika.day12.frame06starGate;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by Ricky on 13.09.14.
 */
public class StarGate {

    private JComponent panel;
    private Ship ship;
    private Portal portal;

    public StarGate() {
        init();
    }

    public static void main(String[] args) {
        new StarGate();
    }

    private void init() {
        initPanel();

        // move to secondary display
//        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
//        GraphicsDevice[] screens = ge.getScreenDevices();
//        JFrame frame = new JFrame("StarGate", screens[1].getDefaultConfiguration());

        JFrame frame = new JFrame("StarGate");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setMinimumSize(new Dimension(1024, 600));
        frame.setLocationRelativeTo(null);
        frame.getContentPane().add(panel);

        ship = new Ship(frame);
        portal = new Portal(frame);

        frame.setVisible(true);
        frame.pack();

        portalAction();
        shipAction();
        screenUpdate();
    }

    private void initPanel() {
        panel = new JComponent() {
            Image background = getBg();

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(background, 0, 0, getParent().getWidth(), getParent().getHeight(), this);
                ship.draw(g);
                portal.draw(g);
            }

            private BufferedImage getBg() {
                BufferedImage result = null;

                try {
                    result = ImageIO.read(new File("bg.png"));
                } catch (IOException e) {
                    e.printStackTrace();
                }

                return result;
            }
        };
    }

    private void screenUpdate() {

        while (true) {
            try {
                Thread.sleep(60 / 1000);
            } catch (InterruptedException e) {
//                ignore
            }
            panel.repaint();
        }
    }

    private void shipAction() {

        new Thread(new Runnable() {
            @Override
            public void run() {
                Thread.currentThread().setName("z Ship Thread");

//                eternal loop
                while (true) {
                    try {
                        // ship flies until gets close to portal
                        while (!portal.shipIsNear(ship.getX())) {
                            ship.move();
                            Thread.currentThread().sleep(10);
                        }

                        // notify portal
                        synchronized (portal) {
                            portal.notify();
                        }

                        // & wait
                        synchronized (ship) {
                            ship.wait();
                        }

                        // enter the portal
                        while (portal.shipIsNear(ship.getX()) && portal.isOpen()) {
                            ship.move();
                            Thread.currentThread().sleep(20);
                        }

                        // notify portal to close
                        synchronized (portal) {
                            portal.notify();
                        }

                    } catch (InterruptedException e) {
//                        ignore
                    }

                }
            }
        }).start();
    }

    private void portalAction() {

        new Thread(new Runnable() {
            @Override
            public void run() {
                Thread.currentThread().setName("z Portal Thread");

//                eternal loop
                while (true) {

                    try {
                        // waiting for ship to arive
                        synchronized (portal) {
                            portal.wait();
                        }

                        // open portal
                        portal.openPortal();

                        // notify ship that's portal's opened
                        synchronized (ship) {
                            ship.notify();
                        }

                        // & wait while ship entering portal
                        synchronized (portal) {
                            portal.wait();
                        }

                        // close portal
                        portal.closePortal();

                    } catch (InterruptedException e) {
//                        ignore
                    }
                }
            }
        }).start();
    }
}
