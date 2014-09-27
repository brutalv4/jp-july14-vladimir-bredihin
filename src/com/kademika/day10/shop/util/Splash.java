package com.kademika.day10.shop.util;

import java.awt.SplashScreen;

public class Splash {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
        SplashScreen screen = SplashScreen.getSplashScreen();
		Thread.sleep(3900);
		
//		Graphics2D g = screen.createGraphics();
//		g.setColor(Color.BLACK);
//		g.drawString("now loading...", 255, 100);
//		screen.update();
//		Thread.sleep(5000);
	}

}
