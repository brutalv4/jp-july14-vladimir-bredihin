package com.kademika.day10.shop.objectz;

import com.kademika.day10.shop.util.Staticz;

import java.text.SimpleDateFormat;
import java.util.*;

public class Store<T extends Car> {

    private List<T> carsAvailable;
    private int carsCount;
    private List<Transaction> transactions;
    private int transactionsLastId = -1;
    private List<Customer> customers;
    private int customersCount;

    public Store() {
        init();
    }

    public void init() {
        carsAvailable = new ArrayList<>();
        customers = new ArrayList<>();
        transactions = new ArrayList<>();
    }

    public void addCarToStorage(T car) {
        int idx = Staticz.getCharIndexAtAlphabet(car.getManufacturer());
//        car.setCatNum(idx + "_" + i);
        carsAvailable.add(car);
        carsCount++;
    }

    public void addCustomerToDB(Customer customer) {
        int idx = Staticz.getCharIndexAtAlphabet(customer.getFullName());
        customer.setId(idx + "_" + customersCount);
        customers.add(customer);
        customersCount++;
    }

    public void addTransactionToDB(Transaction trans) {
        int i = this.getTransactionsLastId();
        trans.setNumber(++i);
        transactions.add(trans);
        transactionsLastId++;
    }

    public int getTransactionsLastId() {
        return transactionsLastId;
    }

    public List<T> getCarsAvailable() {
        return new ArrayList<>(carsAvailable);
    }

//    public Customer[] getCustomersInfo() {
//        int tmp = 0;
//        Customer[] result = new Customer[this.customersCount];
//        for (int i = 0; i < this.customers.length; i++) {
//            for (int j = 0; this.customers[i][j] != null; j++) {
//                result[tmp++] = customers[i][j];
//            }
//        }
//        return result;
//    }

    public <T> void sellCar(String catNum, int qty, Customer customer) {

        // Let's found our car in DB by catalog number
        Car c = getCarByCatalogNumber(catNum);

        applyDiscount(c);

        Transaction t = new Transaction();
        t.setBuyingItem(c.toString());
        t.setCustomer(customer.toString());
        t.setDate(new SimpleDateFormat("yyyy/MM/dd").format(new Date()));
        t.setPrice(c.getPrice());
        t.setQuantity(qty);

        if (hasDiscount(c)) {
            t.setComment("Discount - " + getDiscountAmount(c) + "$");
        }

        // Let's add our new customer to DB, let's pretend it's a new one =)
        this.addCustomerToDB(customer);

        // Let's add new Transaction to DB
        this.addTransactionToDB(t);

        Staticz.printLastTransaction(this);
    }

    public List<Transaction> getTransactions() {
        return new ArrayList<>(transactions);
    }

    public Transaction getLastTransaction() {
        return transactions.get(transactionsLastId);
    }

    public Car getCarByCatalogNumber(String catNum) {
        if (catNum == null) {
            throw new IllegalStateException("No such car were found!");
        }
        Car result = null;

        Iterator j = carsAvailable.iterator();

        while (j.hasNext()) {
            result = (Car) j.next();
            if (result.getCatNum().contains(catNum))
                break;
        }

        return result;
    }

    public boolean hasDiscount(Car car) {
        int thisYear = new GregorianCalendar().get(Calendar.YEAR);
        if (thisYear - car.getModelYear() >= 1) {
            return true;
        }
        return false;
    }

    private void applyDiscount(Car car) {
        if (hasDiscount(car)) {
            int newPrice = car.getPrice() - getDiscountAmount(car);
            car.setPrice(newPrice);
        }
    }

    public int getDiscountAmount(Car car) {
        int result = 0;

        int thisYear = new GregorianCalendar().get(Calendar.YEAR);
        int modelYear = car.getModelYear();

        if (thisYear - modelYear == 1) {
            result = 500;
        } else if (thisYear - modelYear >= 2) {
            result = 1000;
        }

        return result;
    }
}
