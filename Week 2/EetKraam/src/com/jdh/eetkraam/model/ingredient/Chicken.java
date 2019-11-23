package com.jdh.eetkraam.model.ingredient;

public class Chicken extends Ingredient {

    /** This String represents the name of the ingredient */
    private final static String name = "Chicken";

    /** This double represents the price of the ingredient */
    private static double price = 1.50;

    public Chicken() {
        super(name, price);
    }

}