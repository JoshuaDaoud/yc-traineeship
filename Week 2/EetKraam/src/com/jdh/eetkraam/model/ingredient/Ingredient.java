package com.jdh.eetkraam.model.ingredient;

/**
 * This class represents an ingredient for a burger
 */
public abstract class Ingredient {

    /** This String represents the name of the ingredient */
    private String name;

    /** This double represents the price of the ingredient */
    private double price;

    public Ingredient(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Ingredient{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
