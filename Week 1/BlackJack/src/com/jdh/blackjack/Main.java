package com.jdh.blackjack;

import com.jdh.blackjack.model.Card;
import com.jdh.blackjack.model.Face;
import com.jdh.blackjack.model.Suit;

import java.util.Random;
import java.util.Scanner;

public class Main {

    /** constant int variable that represents the number of cards in a deck */
    private static final int NUMBER_OF_CARDS_IN_DECK = 52;

    /** constant int variable that represents the number of cards in a suit */
    private static final int NUMBER_OF_CARDS_IN_SUIT = 13;

    private static final Suit[] SUITS = {Suit.HEARTS, Suit.DIAMONDS, Suit.SPADES, Suit.CLUBS};

    public static void main(String[] args) {
        // create the (empty / static) deck of cards
        Card[] deck = new Card[NUMBER_OF_CARDS_IN_DECK];
        // initialize a counter for every color
        int index = 0;
        //loop through the whole deck and assign a card in every index
        for(int i = 0; i < SUITS.length; i++) {
            for(int j = 2; j < NUMBER_OF_CARDS_IN_SUIT + 2; j++) {  // because every suit begins with 2
                if (j <= 10) {
                    deck[index++] = new Card(SUITS[i], j);
                } else {
                    deck[index++] = new Card(SUITS[i], new Main().getFaceCard(j));
                }
            }
        }

        // Shuffle the deck
        new Main().shuffleDeck(deck);

        for(int i = 0; i < deck.length; i++){
            System.out.println(deck[i]);
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Do you like to play the next BlackJack game? Type Y to play and N for no.");

        String userInputPlaysGame = scanner.nextLine().toUpperCase();

        // Check for userinput, only accepts Y / N
        while(!userInputPlaysGame.equals("Y") && !userInputPlaysGame.equals("N")) {
            System.out.println("Wrong answer! Type Y to play and N for no.");
            userInputPlaysGame = scanner.nextLine().toUpperCase();
            System.out.println("You answered " + userInputPlaysGame);
        }

        if (userInputPlaysGame.equals("Y")) {
            System.out.println("I want to play a game");
            System.out.println("Dealer gives you two cards of the deck");


        }

    }

    /**
     * This method returns the right face card that corresponds to each number
     * @param indexInSuit
     * @return
     */
    private Face getFaceCard(int indexInSuit) {
        Face face = null;
        switch(indexInSuit) {
            case 11:
                face = Face.JACK;
                break;
            case 12:
                face = Face.QUEEN;
                break;
            case 13:
                face = Face.KING;
                break;
            case 14:
                face = Face.ACE;
                break;
        }
        return face;
    }

    /**
     * This method shuffles the deck by swapping random Card objects with eachother
     * @param deck
     */
    private void shuffleDeck(Card[] deck) {
        System.out.println("Kaarten worden nu geschud");
        final Random random = new Random();

        for (int i = 0; i < deck.length; i++) { //iterate through the deck
            int randomIndexToSwap = random.nextInt(deck.length); //get a random number between 0 and the length of the array
            Card temp = deck[randomIndexToSwap]; // get a random card
            deck[randomIndexToSwap] = deck[i]; //assign another random card with a card of the current index
            deck[i] = temp; //assign the card of the current index with the random card
        }
    }

}
