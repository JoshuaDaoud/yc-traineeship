package com.jdh.eetkraam;


import com.jdh.eetkraam.exception.NoCustomerInLineException;
import com.jdh.eetkraam.manager.FoodTruck;

public class Main {

    final static FoodTruck foodtruck = FoodTruck.getInstance();

    public static void main(String[] args) {
            try {
                foodtruck.openForBusiness();
            } catch (NoCustomerInLineException e) {
                e.printStackTrace();
            }
    }
}
