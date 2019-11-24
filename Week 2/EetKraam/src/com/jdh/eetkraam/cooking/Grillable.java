package com.jdh.eetkraam.cooking;


public interface Grillable {

    /**
     * This method checks whether the Ingredient is grilled or not
     * @return boolean
     */
    boolean isGrilled();

    /**
     * This method sets the grilled boolean value
     * @param isGrilled
     */
    void setIsGrilled(boolean isGrilled);

}
