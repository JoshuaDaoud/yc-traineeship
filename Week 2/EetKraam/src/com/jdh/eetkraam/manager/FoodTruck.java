package com.jdh.eetkraam.manager;

import com.jdh.eetkraam.exception.NoCustomerInLineException;
import com.jdh.eetkraam.model.Customer;
import com.jdh.eetkraam.model.burger.Burger;
import java.util.Random;

public final class FoodTruck {

    /** FoodTruck singleton instance */
    private static FoodTruck foodTruck;

    /** Cook object that is responsible for preparing the dishes */
    private final Cook cook = new Cook();

    /** WaitingQueue singleton instance */
    private final WaitingQueue waitingQueue = new WaitingQueue();

    /** CashDesk singleton instance */
    private static CashDesk cashDesk = CashDesk.getInstance();

    private FoodTruck() { }

    {
        System.out.println("The foodtruck is open for business!");
    }

    /**
     * This method returns a single instance of the class
     * @return FoodTruck
     */
    public static FoodTruck getInstance() {
        if (foodTruck == null) {
            foodTruck = new FoodTruck();
        }
        return foodTruck;
    }

    /**
     * This method is the start of the application
     * @throws NoCustomerInLineException
     */
    public void openForBusiness() throws NoCustomerInLineException {
            Thread thread = new WaitingLineThread();
            thread.start();

            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            while (true) { //TODO:
                if (waitingQueue.isEmpty()) {
                    throw new NoCustomerInLineException("Waiting line is empty");
                }

                Customer firstCustomer = waitingQueue.getFirstCustomer();
                cook.prepareDish(firstCustomer.getBurger());

                obtainProfit(firstCustomer.getBurger(), firstCustomer.getTip());
                waitingQueue.dequeue();
            }
    }

    /**
     * This method prints out the current profit
     * @param burger
     * @param tip
     */
    private void obtainProfit(Burger burger, double tip) {
        cashDesk.addProfit(burger.getTotalBurgerPrice());
        System.out.println("===================================");
        System.out.println("Customer payed " + burger.getTotalBurgerPrice());
        System.out.println("Profit is now: " + cashDesk.getProfit());
    }

    /**
     * This inner class runs in a different thread where Customer objects are randomly added in the waitingline
     */
    private class WaitingLineThread extends Thread {

        Random random = new Random();

        @Override
        public void run() {
            int low = 5;
            int high = 10;
            int secondsTillNewCustomerArrives = random.nextInt(high - low) + low;

            while (true) {
                try {
                    Thread.sleep(secondsTillNewCustomerArrives * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                waitingQueue.enqueue(new Customer());
                secondsTillNewCustomerArrives = random.nextInt(high - low) + low;
            }
        }
    }

}
