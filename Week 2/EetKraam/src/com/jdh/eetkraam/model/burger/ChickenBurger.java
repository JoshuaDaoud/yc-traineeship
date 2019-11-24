package com.jdh.eetkraam.model.burger;

import com.jdh.eetkraam.model.ingredient.*;

import java.util.ArrayList;
import java.util.List;

public class ChickenBurger extends Burger {

    /** Name of the burger */
    private final static String name = "Chickenburger";

    private final static List<Ingredient> ingredients = new ArrayList<>();

    private static Ingredient baseIngredient = new Chicken();

    {
        ingredients.add(baseIngredient);
        ingredients.add(new Tomato());
        ingredients.add(new Cheese());
    }

    public ChickenBurger() {
        super(name, ingredients);
    }

    @Override
    public Ingredient getBaseIngredient() {
        return baseIngredient;
    }
}