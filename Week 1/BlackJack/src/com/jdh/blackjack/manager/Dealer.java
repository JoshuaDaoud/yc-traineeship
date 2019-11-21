package com.jdh.blackjack.manager;

import com.jdh.blackjack.model.Card;

public class Dealer {

    private Deck deck;

    private static Dealer dealer;

    private Dealer() {
        deck = new Deck();
    }

    public static Dealer getInstance() {
        if (dealer == null) {
            dealer = new Dealer();
        }
        return dealer;
    }

    public Card getCardFromDeck() {
        System.out.println("Dealer gives card from the deck");
        return deck.removeCardFromDeck();
    }

    /**
     * This method asks the user what his / her next move is
     */
    public void askForNextMove() {
        System.out.println("======================");
        System.out.println("What is your next move?");
        System.out.println("Send S to show cards in hand");
        System.out.println("Send C to ask for a new card");
        System.out.println("Send Q to quit");
    }

}
