package com.jdh.eetkraam.model;

import com.jdh.eetkraam.model.burger.Burger;
import com.jdh.eetkraam.model.burger.CheeseBurger;
import com.jdh.eetkraam.model.burger.ChickenBurger;
import com.jdh.eetkraam.model.burger.JoshuaBaconBurger;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * This class represents a customer in line
 */
public class Customer {

    /** The burger this costumer is ordering */
    private Burger burger;

    /** The tip of the customer it starts with */
    private double tip;

    {
        System.out.println("===================================");
        System.out.println("Customer gets in line...");
        this.burger = chooseRandomBurger();
        this.tip = setRandomTip();
    }

    public Burger getBurger() {
        return burger;
    }

    public double getTip() {
        return tip;
    }

    /**
     * This method does a couple of things:
     * 1. Pick random Burger subclass from list
     * 2. Creates a new instance and put it in an Object wrapper
     * 3. Cast the instance into the appropriate Burger subclass
     * @return Burger object
     */
    private Burger chooseRandomBurger() {
        // Create a list of all Burger subclasses
        List<Class<? extends Burger>> possibleClasses = Arrays.asList(JoshuaBaconBurger.class, ChickenBurger.class, CheeseBurger.class);
        // create a random object
        final Random random = new Random();
        // get random number between the length of the subclass list
        int burgerIndex = random.nextInt(possibleClasses.size());
        // get subclass and put it in a Class wrapper
        final Class randomBurgerClass = possibleClasses.get(burgerIndex);
        // declare burger
        Burger burger = null;

        try {
            // instantiate a new burger and put it in an Object wrapper
            Object object = randomBurgerClass.newInstance();
            // cast to appropriate burger subclass
            if (object instanceof CheeseBurger) {
                burger = (CheeseBurger) object;
            } else if (object instanceof JoshuaBaconBurger){
                burger = (JoshuaBaconBurger) object;
            } else if (object instanceof ChickenBurger){
                burger = (ChickenBurger) object;
            }

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }

        System.out.println("New customer ordered the " + burger.getName());

        return burger;
    }

    /**
     * This method creates a random tip of a customer
     * @return
     */
    private double setRandomTip() {
        Random random = new Random();
        int low = 5; // lowest possible tip a customer can give
        int high = 20; // highest possible tip a customer can give
        int tip = random.nextInt(high - low) + low;
        return Double.valueOf(tip); // return double
    }
}
