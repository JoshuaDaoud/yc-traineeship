package com.jdh.eetkraam;


import com.jdh.eetkraam.exception.IngredientNotFoundException;
import com.jdh.eetkraam.manager.FoodTruck;
import com.jdh.eetkraam.model.burger.Burger;
import com.jdh.eetkraam.model.burger.JoshuaBaconBurger;
import com.jdh.eetkraam.model.ingredient.Chicken;

public class Main {

    final static FoodTruck foodtruck = FoodTruck.getInstance();

    public static void main(String[] args) {

        Burger burger = new JoshuaBaconBurger();

        Chicken chicken = new Chicken();
        try {
            burger.removeIngredient(chicken);
        } catch (IngredientNotFoundException e) {
            e.printStackTrace();
        }
    }
}
