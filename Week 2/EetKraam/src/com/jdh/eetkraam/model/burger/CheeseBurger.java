package com.jdh.eetkraam.model.burger;

import com.jdh.eetkraam.model.ingredient.*;

import java.util.ArrayList;
import java.util.List;

/**
 * This immutable class represents a CheeseBurger burger
 */
public final class CheeseBurger extends Burger {

    /** Name of the burger */
    private final static String name = "Cheeseburger";

    private final static List<Ingredient> ingredients = new ArrayList<>();

    {
        System.out.println("Adding default ingredients to cheeseburger");
        ingredients.add(new Beef());
        ingredients.add(new Tomato());
        ingredients.add(new Cheese());
        ingredients.add(new Jalapeno());
    }

    public CheeseBurger(){
        super(name, ingredients);
    }

}
