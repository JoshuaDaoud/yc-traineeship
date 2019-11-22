package com.jdh.blackjack.manager;

import com.jdh.blackjack.model.Card;
import com.jdh.blackjack.model.Face;

import java.util.ArrayList;

public class Hand {

    /** ArrayList that contains the Card objects in the users hand */
    private ArrayList<Card> cardList = new ArrayList<>();

    /** int value that represents the total points in its hand */
    private int totalPoints = 0;

    /** int constant that represents the difference in points of an ace card and one point */
    private static final int ACE_CARD_SUBTRACTION = 10;

    public Hand() {
//        cardList.add(new Card(Suit.CLUBS, Face.ACE));
//        cardList.add(new Card(Suit.HEARTS, 3));
//        cardList.add(new Card(Suit.CLUBS, Face.ACE));
//
//        totalPoints = 25;
    }

    /**
     * This method adds a Card object to the ArrayList and computes the totalPoints variable
     * @param card
     */
    public void obtainCardFromDeck(Card card) {
        cardList.add(card);
        totalPoints += card.getPoints();
    }

    /**
     * This method prints out the cards in hand and total points
     */
    public void showHand() {
        System.out.println("==============================================");
        for(Card card : cardList) {
            System.out.println(card);
        }
        System.out.println("Total points in hand: " + totalPoints);
    }

    public int getTotalPoints() {
        return totalPoints;
    }

    /**
     * This method checks if the ArrayList contains an ace which has eleven points
     * @return boolean that represents whether the ArrayList contains an ace with eleven points
     */
    public boolean hasAceInHandWithElevenPoints() {
        boolean hasAceInHand = false;
        for (Card card : cardList){
            if (card.getFace() == Face.ACE && card.getPoints() == Card.ACE_POINTS) {
                hasAceInHand = true;
                break;
            }
        }
        return hasAceInHand;
    }

    /**
     * This method does a couple of things if the ace card with eleven points is found:
     * 1. Sets the card points from 11 to 1
     * 2. Subtracts totalPoints with 10
     * 3. Show "new" cards in hand
     */
    public void setAcePointsToOne() {
        for (Card card : cardList){
            if (card.getFace() == Face.ACE && card.getPoints() == Card.ACE_POINTS) {
                card.setPoints(1);
                this.totalPoints -= ACE_CARD_SUBTRACTION;

                System.out.println("==============================================");
                System.out.println("Ace points converted from 11 to 1");

                showHand();
                break;
            }
        }
    }

}
