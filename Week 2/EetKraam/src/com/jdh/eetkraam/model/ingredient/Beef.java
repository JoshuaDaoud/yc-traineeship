package com.jdh.eetkraam.model.ingredient;

import com.jdh.eetkraam.cooking.Grillable;

public class Beef extends Ingredient implements Grillable {

    /** This String represents the name of the ingredient */
    private final static String name = "Beef";

    /** This double represents the price of the ingredient */
    private static double price = 1.50;

    /** boolean that represents whether this ingredient is grilled */
    private boolean isGrilled;

    private static int preparationTimeInMilliSeconds = 4000;

    public Beef() {
        super(name, price, preparationTimeInMilliSeconds);
    }

    @Override
    public boolean isGrilled() {
        return isGrilled;
    }

    @Override
    public void setIsGrilled(boolean isGrilled) {
        System.out.println("===================================");
        System.out.println(name + " is being grilled");
        this.isGrilled = isGrilled;
    }

    @Override
    public int getPreparationTimeInMilliSeconds() {
        return preparationTimeInMilliSeconds;
    }
}