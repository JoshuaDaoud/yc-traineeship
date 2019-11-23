package com.jdh.eetkraam.manager;

public final class FoodTruck {

    private static FoodTruck foodTruck;

    private final CashDesk cashDesk = CashDesk.getInstance();

    private FoodTruck() { }

    public static FoodTruck getInstance() {
        if (foodTruck == null) {
            foodTruck = new FoodTruck();
        }
        return foodTruck;
    }

}
