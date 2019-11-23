package com.jdh.eetkraam.model.ingredient;

public class Beef extends Ingredient {

    /** This String represents the name of the ingredient */
    private final static String name = "Beef";

    /** This double represents the price of the ingredient */
    private static double price = 1.50;

    public Beef() {
        super(name, price);
    }

}