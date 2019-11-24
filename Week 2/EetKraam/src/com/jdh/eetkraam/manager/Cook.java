package com.jdh.eetkraam.manager;

import com.jdh.eetkraam.model.burger.Burger;
import com.jdh.eetkraam.model.ingredient.Beef;
import com.jdh.eetkraam.model.ingredient.Chicken;
import com.jdh.eetkraam.model.ingredient.Ingredient;

import java.util.Iterator;

final class Cook {

    private static Cook cook;

    private Cook (){}

    static Cook getInstance() {
        if (cook == null) {
            cook = new Cook();
        }
        return cook;
    }

    /**
     * This method will start the preparation of the burger dish
     * @param burger
     */
    void prepareDish(Burger burger) {
        WaitingQueue queue = WaitingQueue.getInstance();
        Burger grilledBurger = burger;
        Ingredient baseIngredient = null;



        for (Ingredient ingredient : grilledBurger.getIngredients()) {
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
