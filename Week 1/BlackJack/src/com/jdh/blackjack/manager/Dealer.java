package com.jdh.blackjack.manager;

import com.jdh.blackjack.Main;
import com.jdh.blackjack.model.Card;

public class Dealer {

    /** Deck object that contains all cards */
    private Deck deck;

    /** Dealer object */
    private static Dealer dealer;

    private Hand dealerHand;

    private Dealer() {
        deck = new Deck();
        dealerHand = new Hand();
    }

    /**
     * Method that creates a singleton object of the class
     *
     * @return Dealer
     */
    public static Dealer getInstance() {
        if (dealer == null) {
            dealer = new Dealer();
        }
        return dealer;
    }

    /**
     * This method removes a card from the deck and returns it to the dealer
     * @return Card
     */
    public Card getCardFromDeck() {
        System.out.println("Dealer gets card from the deck");
        return deck.removeCardFromDeck();
    }

    /**
     * This method asks the user what his / her next move is
     */
    public void askForNextMove() {
        System.out.println("==============================================");
        System.out.println("What is your next move?");
        System.out.println("Send S to show cards in hand");
        System.out.println("Send C to ask for a new card");
        System.out.println("Send P to pass");
        System.out.println("Send Q to quit");
    }

    public void dealerPlaysGame(int playersTotalPoints) throws InterruptedException{
        System.out.println("==============================================");
        System.out.println("It is the turn of the bank");

        dealerHand.obtainCardFromDeck(getCardFromDeck()); // base card 1
        dealerHand.obtainCardFromDeck(getCardFromDeck()); // base card 2
        dealerHand.showHand();
        Thread.sleep(4000);

        getCardsForDealer(playersTotalPoints);

        determineWinner(playersTotalPoints, dealerHand.getTotalPoints());
    }

    private void determineWinner(int playersTotalPoints, int dealerTotalPoints) {
        System.out.println("The bank has " + dealerTotalPoints + " points");
        System.out.println("You have " + playersTotalPoints + " points");
        if (dealerTotalPoints > playersTotalPoints && dealerTotalPoints <= Main.BLACK_JACK) {
            System.out.println("BANK IS THE WINNER");
        } else if(dealerTotalPoints == playersTotalPoints) {
            System.out.println("BANK IS THE WINNER");
        } else {
            System.out.println("YOU ARE THE WINNER");
        }

    }

    private void getCardsForDealer(int playersTotalPoints) throws InterruptedException{
        while (dealerHand.getTotalPoints() <= playersTotalPoints) {
            dealerHand.obtainCardFromDeck(getCardFromDeck());
            dealerHand.showHand();
            Thread.sleep(4000);
        }
        if (dealerHand.hasAceInHandWithElevenPoints()) {
            dealerHand.setAcePointsToOne();
            getCardsForDealer(playersTotalPoints);
        }
    }
}
