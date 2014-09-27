package com.kademika.day10.shop.util;

import com.kademika.day10.shop.objectz.*;

public class Staticz {

	public static final String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

	/**
	 * 
	 * @param string
	 * @return alphabet location of first char of string
	 */
	public static int getCharIndexAtAlphabet(String string) {
		return alphabet.indexOf(string.charAt(0));
	}

	/**
	 * fill store with
	 * 
	 * @param store
	 * @param customers
	 */
	public static void fillStoreWithCustomers(Store store, Customer[] customers) {
        for (int i = 0; i <= customers.length && customers[i] != null ; i++) {
            store.addCustomerToDB(customers[i]);
        }
	}

	/**
	 * fill store with Car[]
	 * 
	 * @param store
	 * @param cars
	 */
	public static void fillStoreWithCars(Store store, Car[] cars) {
		for (int i = 0; i <= cars.length && cars[i] != null ; i++) {
			store.addCarToStorage(cars[i]);
		}
	}

	public static void fillStoreWithTransactions(Store store,
			Transaction[] trans) {
        for (int i = 0; i <= trans.length && trans[i] != null ; i++) {
            store.addTransactionToDB(trans[i]);
        }
	}

//	public static void printPricesCarsAvailable(Store store) {
//		for (Car car : store.getCarsAvailable()) {
//			System.out.println("(" + car.getCatNum() + ") " + car.toString()
//					+ " - $" + car.getPrice());
//		}
//	}

//	public static void printCarsAvailable(Store store) {
//		Car[] cars = store.getCarsAvailable();
//		for (int i = 0; i < cars.length; i++) {
//			if (cars[i] != null) {
//				int count = 1;
//				for (int j = i + 1; j < cars.length; j++) {
//					if (cars[i].toString().contains(cars[j].toString())) {
//						count++;
//						cars[j] = null;
//					}
//				}
//				System.out.println(cars[i] + " - " + count + " available");
//			}
//		}
//	}

//	public static void printCustomersInfo(Store store) {
//		for (Customer customer : store.getCustomersInfo()) {
//			System.out.println("(" + customer.getId() + ") " + customer + " - "
//					+ customer.getCategory());
//		}
//	}

//	public static void printTransactions(Store store, int dayCount,
//			boolean detailed) {
//		Transaction[] transactions = store.getTransactions();
//		for (int i = transactions.length - dayCount - 1; i < transactions.length
//				&& dayCount > 0; i++) {
//			if (transactions[i] != null) {
//				int count = transactions[i].getQuantity();
//				String dateStr = transactions[i].getDate();
//				for (int j = i + 1; j < transactions.length
//						&& transactions[j].getDate().contains(dateStr); j++) {
//					count += transactions[j].getQuantity();
//					transactions[j] = detailed ? transactions[j] : null;
//				}
//				if (detailed) {
//					System.out.println(transactions[i].toString());
//				} else {
//					System.out.println(transactions[i].getDate() + " - qty."
//							+ count);
//					dayCount--;
//				}
//			}
//		}
//	}

//	public static void printCatalogByCategory(Store store, String category) {
//		Car[] cars = store.getCarsAvailable();
//		if (category.contains("BodyType")) {
//			for (BodyType body : BodyType.values()) {
//				String tempString = "";
//				int tmp = 0;
//				for (int i = 0; i < cars.length; i++) {
//					if (cars[i] != null && body == cars[i].getBodyType()) {
//						if (tmp++ == 0) {
//							System.out.println();
//							System.out.println(body);
//							System.out.println("------------------");
//						}
//						if (!tempString.contains(cars[i].toString())) {
//							System.out.println(cars[i]);
//							tempString = cars[i].toString();
//						}
//						cars[i] = null;
//					}
//				}
//			}
//		}
//	}
//
	public static void printLastTransaction(Store store) {
		System.out.println(store.getLastTransaction());
	}

	public static String[] getTransactionFields() {
		return new String[] { "#", "Date", "Buyer", "Car", "Price, $",
				"Quantity", "Comment" };
	}

	public static Object[][] getTransactionsTable(Store store) {
		Object[][] result = new Object[store.getTransactionsLastId() + 1][getTransactionFields().length];
		int i = 0;
		for (Object o : store.getTransactions()) {
            Transaction t = (Transaction) o;
			result[i] = new Object[] { t.getNumber(), t.getDate(),
					t.getCustomer(), t.getBuyingItem(), t.getPrice(),
					t.getQuantity(), t.getComment() };
			i++;
		}

		return result;
	}

}
