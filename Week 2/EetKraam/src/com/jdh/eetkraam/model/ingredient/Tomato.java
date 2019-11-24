package com.jdh.eetkraam.model.ingredient;

public class Tomato extends Ingredient{

    /** This String represents the name of the ingredient */
    private final static String name = "Tomato";

    /** This double represents the price of the ingredient */
    private static double price = 1.0;

    private static int preparationTimeInMilliSeconds = 1000;

    public Tomato() {
        super(name, price, preparationTimeInMilliSeconds);
    }

    @Override
    public int getPreparationTimeInMilliSeconds() {
        return preparationTimeInMilliSeconds;
    }

}
