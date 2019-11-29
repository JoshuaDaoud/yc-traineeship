package com.jdh.eetkraam.manager;

import com.jdh.eetkraam.model.burger.Burger;
import com.jdh.eetkraam.model.ingredient.Beef;
import com.jdh.eetkraam.model.ingredient.Chicken;
import com.jdh.eetkraam.model.ingredient.Ingredient;

import java.util.Iterator;

final class Cook {

    /**
     * This method will start the preparation of the burger dish
     * @param burger
     */
    void prepareDish(Burger burger) {
        Burger grilledBurger = burger;
        Ingredient baseIngredient = null;

        for (Iterator<Ingredient> iterator = grilledBurger.getIngredients().iterator(); iterator.hasNext();) {
            Ingredient ingredient = iterator.next();
            try {
                ingredient.setPrepared(true);
                Thread.sleep(ingredient.getPreparationTimeInMilliSeconds());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        if (grilledBurger.getBaseIngredient() instanceof Chicken) {
            baseIngredient = (Chicken) grilledBurger.getBaseIngredient();
            ((Chicken) baseIngredient).setIsGrilled(true);
        } else if (grilledBurger.getBaseIngredient() instanceof Beef) {
            baseIngredient = (Beef) grilledBurger.getBaseIngredient();
            ((Beef) baseIngredient).setIsGrilled(true);
        }
    }


}
