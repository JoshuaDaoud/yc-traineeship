package com.jdh.eetkraam.manager;

import com.jdh.eetkraam.exception.NoCustomerInLineException;
import com.jdh.eetkraam.model.Customer;
import com.jdh.eetkraam.model.burger.Burger;
import java.util.Random;

public final class FoodTruck {

    private static FoodTruck foodTruck;

    private final CashDesk cashDesk = CashDesk.getInstance();

    private final Cook cook = Cook.getInstance();

    private final WaitingQueue<Customer> waitingQueue = WaitingQueue.getInstance();

    private static double profit = 0;

    private FoodTruck() { }

    {
        System.out.println("The foodtruck is open for business!");
    }

    public static FoodTruck getInstance() {
        if (foodTruck == null) {
            foodTruck = new FoodTruck();
        }
        return foodTruck;
    }

    public void openForBusiness() throws NoCustomerInLineException {

        synchronized (WaitingQueue.class) {

            Thread thread = new WaitingLineThread();
            thread.start();

            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            while (true) {
                if (waitingQueue.isEmpty()) {
                    throw new NoCustomerInLineException("Waiting line is empty");
                }

                Customer firstCustomer = waitingQueue.getFirstCustomer();
                cook.prepareDish(firstCustomer.getBurger());

                obtainProfit(firstCustomer.getBurger(), firstCustomer.getTip());

                waitingQueue.dequeue();
            }
        }
    }

    private void obtainProfit(Burger burger, double tip) {
        profit += burger.getTotalBurgerPrice();
        System.out.println("===================================");
        System.out.println("Profit is now: " + profit);
    }

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
