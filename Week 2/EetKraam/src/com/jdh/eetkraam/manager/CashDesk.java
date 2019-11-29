package com.jdh.eetkraam.manager;

final class CashDesk {

    /** Singleton CashDesk instance */
    private static CashDesk cashDesk;

    /** double that represents the profit */
    private static double profit = 0;

    private CashDesk() {}

    static CashDesk getInstance() {
        if (cashDesk == null) {
            cashDesk = new CashDesk();
        }
        return cashDesk;
    }

    double getProfit() {
        return profit;
    }

    void addProfit(double profit) {
        this.profit += profit;
    }
}
