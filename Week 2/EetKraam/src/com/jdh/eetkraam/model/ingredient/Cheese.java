package com.jdh.eetkraam.model.ingredient;

public class Cheese extends Ingredient {

    /** This String represents the name of the ingredient */
    private final static String name = "Cheese";

    /** This double represents the price of the ingredient */
    private static double price = 1.50;

    private static int preparationTimeInMilliSeconds = 1000;

    public Cheese() {
        super(name, price, preparationTimeInMilliSeconds);
    }

    @Override
    public int getPreparationTimeInMilliSeconds() {
        return preparationTimeInMilliSeconds;
    }

}
