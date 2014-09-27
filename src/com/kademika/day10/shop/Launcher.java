package com.kademika.day10.shop;

import com.kademika.day10.shop.objectz.Store;
import com.kademika.day10.shop.objectz.TestData;
import com.kademika.day10.shop.util.GUI;
import com.kademika.day10.shop.util.Staticz;

public class Launcher {

	public static void main(String[] args) throws InterruptedException {

		Store store = new Store();

		Staticz.fillStoreWithCars(store, TestData.createCars());
		Staticz.fillStoreWithCustomers(store, TestData.createCustomers());
		Staticz.fillStoreWithTransactions(store, TestData.createTransactions());

		GUI gui = new GUI(store);
	}

}
