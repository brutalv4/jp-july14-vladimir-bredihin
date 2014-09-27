package com.kademika.day12.frame04race;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Ricky on 09.09.14.
 */
public class LegacyAtm implements Atm {

    private int balance;

    public LegacyAtm() {
        balance = 5000;
    }

    @Override
    public void checkBalance(long accountId) {
        System.out.println(accountId + " going to withdraw some money.");
    }

    @Override
    public void withdrawMoney(long accountId, int amount) {

        synchronized (this) {
            if (allowWithdrawal(accountId, amount)) {
                updateBalance(accountId, amount, TransactionType.WITHDRAWAL);
            } else {
                System.out.println("Not enough money on the account");
            }
        }
    }

    private boolean allowWithdrawal(long accountId, int amount) {
        return balance >= amount;
    }

    private void updateBalance(long accountId, int amount, TransactionType type) {
        balance -= amount;
        System.out.println("Successful " + type + " account: " + accountId + " amount: " + amount + ", " +
                "balance: " + balance);
    }

    enum TransactionType {
        DEPOSIT, WITHDRAWAL
    }

}
