package com.jdh.eetkraam.model.burger;

import com.jdh.eetkraam.cooking.Grillable;
import com.jdh.eetkraam.model.ingredient.*;

import java.util.ArrayList;
import java.util.List;

public class JoshuaBaconBurger extends Burger {

    /** Name of the burger */
    private final static String name = "JBB";

    private final static List<Ingredient> ingredients = new ArrayList<>();

    private static Ingredient baseIngredient = new Beef();

    {
        ingredients.add(baseIngredient);
        ingredients.add(new Tomato());
        ingredients.add(new Cheese());
        ingredients.add(new Bacon());
    }

    public JoshuaBaconBurger() {
        super(name, ingredients);
    }

    @Override
    public Ingredient getBaseIngredient() {
        return baseIngredient;
    }
}
