package com.kademika.day12.frame04race;

/**
 * Created by Ricky on 09.09.14.
 */
public class GoodAtm implements Atm {

    @Override
    public void checkBalance(long accountId) {
        System.out.println(accountId + " going to withdraw some money.");
    }

    @Override
    public void withdrawMoney(long accountId, int amount) {
        if (allowWithdrawal(accountId, amount)) {
            updateBalance(accountId, amount, TransactionType.WITHDRAWAL);
        }
    }

    private boolean allowWithdrawal(long accountId, int amount) {
        return true;
    }

    private void updateBalance(long accountId, int amount, TransactionType type) {
        System.out.println("Successful " + type + " account: " + accountId + " amount: " + amount);
    }

    enum TransactionType {
        DEPOSIT, WITHDRAWAL
    }
}
