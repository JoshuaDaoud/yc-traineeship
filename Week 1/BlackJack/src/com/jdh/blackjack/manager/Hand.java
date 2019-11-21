package com.jdh.blackjack.manager;

import com.jdh.blackjack.model.Card;
import com.jdh.blackjack.model.Face;

import java.util.ArrayList;

public class Hand {

    private static Hand hand;

    private ArrayList<Card> cardList = new ArrayList<>();

    private Hand() {}

    private int totalPoints = 0;

    private boolean hasAceInHand = false;

    public static Hand getInstance() {
        if (hand == null) {
            hand = new Hand();
        }
        return hand;
    }

    public void obtainCardFromDeck(Card card) {
        cardList.add(card);
        totalPoints += card.getPoints();
    }

    /**
     * This method prints out the cards in hand and total points
     */
    public void showHand() {
        for(Card card : cardList) {
            System.out.println(card);
        }
        System.out.println("Total points in hand: " + totalPoints);
    }

    public int getTotalPoints() {
        return totalPoints;
    }

    public boolean hasAceInHand() {
        boolean hasAceInHand = false;
        for (Card card : cardList){
            if (card.getFace() == Face.ACE) {
                hasAceInHand = true;
                break;
            }
        }
        return hasAceInHand;
    }

    public Card returnAce() {
        Card ace = null;
        for (Card card : cardList){
            if (card.getFace() == Face.ACE) {
                ace = card;
                break;
            }
        }
        return ace;
    }

}
