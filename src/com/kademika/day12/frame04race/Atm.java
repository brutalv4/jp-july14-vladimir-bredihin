package com.kademika.day12.frame04race;

/**
 * Created by Ricky on 09.09.14.
 */
public interface Atm {

    public void checkBalance(long accountId);

    public void withdrawMoney(long accountId, int amount);
}
