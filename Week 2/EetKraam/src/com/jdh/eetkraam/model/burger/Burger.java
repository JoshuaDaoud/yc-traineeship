package com.jdh.eetkraam.model.burger;

import com.jdh.eetkraam.exception.IngredientNotFoundException;
import com.jdh.eetkraam.model.ingredient.Ingredient;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents a burger containing different Ingredient objects
 */
public abstract class Burger {

    /** Name of the burger */
    private String name;

    /** This List contains Ingredient objects */
    private List<Ingredient> ingredients = new ArrayList<>();

    public Burger(String name, List<Ingredient> ingredients) {
        this.name = name;
        this.ingredients = ingredients;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public String getName() {
        return name;
    }

    /**
     * This method adds an Ingredient object to a NEWLY created List of Ingredient objects
     * @param ingredient Ingredient object that is added
     * @return List<Ingredient>
     */
    public List<Ingredient> addIngredient(Ingredient ingredient) {
        List<Ingredient> newIngredients = ingredients;
        newIngredients.add(ingredient);
        return newIngredients;
    }

    /**
     * This method creates a new List of Ingredients and omit the Ingredient passed as an argument
     * @param ingredient Ingredient object that is omitted from the NEWLY created List
     * @return List<Ingredient>
     */
    public List<Ingredient> removeIngredient(Ingredient ingredient) throws IngredientNotFoundException {
        List<Ingredient> newIngredients = ingredients;
        if (newIngredients.contains(ingredient)) {
            newIngredients.remove(ingredient);
        } else {
            throw new IngredientNotFoundException(ingredient.getName() + " not found in burgerdish");
        }
        return newIngredients;
    }

    /**
     * This method returns the total burgerprice by summing up the ingredient prices
     * @return
     */
    public double getBurgerPrice() {
        return ingredients.stream().mapToDouble(p -> p.getPrice()).sum();
    }

    @Override
    public String toString() {
        return "Burger{" +
                "name='" + name + '\'' +
                ", ingredients=" + ingredients +
                '}';
    }
}
