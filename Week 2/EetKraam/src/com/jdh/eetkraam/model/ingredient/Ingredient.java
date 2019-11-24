package com.jdh.eetkraam.model.ingredient;

import com.jdh.eetkraam.cooking.Preparable;

/**
 * This class represents an ingredient for a burger
 */
public abstract class Ingredient implements Preparable {

    /** This String represents the name of the ingredient */
    private String name;

    /** This double represents the price of the ingredient */
    private double price;

    private boolean isPrepared;

    private int preparationTimeInMilliSeconds;

    public Ingredient(String name, double price, int preparationTimeInMilliSeconds) {
        this.name = name;
        this.price = price;
        this.preparationTimeInMilliSeconds = preparationTimeInMilliSeconds;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getPreparationTimeInMilliSeconds() {
        return preparationTimeInMilliSeconds;
    }

    @Override
    public void setPrepared(boolean isPrepared) {
        System.out.println("===================================");
        System.out.println(name + " is being prepared");
        this.isPrepared = isPrepared;
    }

    @Override
    public String toString() {
        return "Ingredient{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
