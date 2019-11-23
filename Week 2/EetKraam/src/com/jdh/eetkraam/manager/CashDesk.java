package com.jdh.eetkraam.manager;

public class CashDesk {

    private static CashDesk cashDesk;

    private CashDesk() {}

    public static CashDesk getInstance() {
        if (cashDesk == null) {
            cashDesk = new CashDesk();
        }
        return cashDesk;
    }


}
