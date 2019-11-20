package com.jdh.blackjack.model;

import java.util.ArrayList;

public class Hand {

    /** This ArrayList represents the hand of the user */
    private ArrayList<Card> hand = new ArrayList<>();

    public Hand(ArrayList<Card> hand) {
        this.hand = hand;
    }

    public ArrayList<Card> getHand() {
        return hand;
    }
}
