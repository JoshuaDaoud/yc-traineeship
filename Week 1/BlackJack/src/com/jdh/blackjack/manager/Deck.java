package com.jdh.blackjack.manager;

import com.jdh.blackjack.model.Card;
import com.jdh.blackjack.model.Face;
import com.jdh.blackjack.model.Suit;

import java.util.Random;

class Deck {

    /** constant int variable that represents the number of cards in a deck */
    private static final int NUMBER_OF_CARDS_IN_DECK = 52;

    /** constant int variable that represents the number of cards in a suit */
    private static final int NUMBER_OF_CARDS_IN_SUIT = 13;

    /** constant array containing all the suits */
    private static final Suit[] SUITS = {Suit.HEARTS, Suit.DIAMONDS, Suit.SPADES, Suit.CLUBS};

    private static Card[] deck;

    private static int deckIndex = 0;

    static {
        // create the (empty / static) deck of cards
        deck = new Card[NUMBER_OF_CARDS_IN_DECK];
        // initialize a counter for every color
        int index = 0;
        //loop through the whole deck and assign a card in every index
        for(int i = 0; i < SUITS.length; i++) {
            for(int j = 2; j < NUMBER_OF_CARDS_IN_SUIT + 2; j++) {  // because every suit begins with 2
                if (j <= 10) {
                    deck[index++] = new Card(SUITS[i], j);
                } else {
                    deck[index++] = new Card(SUITS[i], new Deck().getFaceCard(j));
                }
            }
        }

        // Shuffle the deck
        new Deck().shuffleDeck(deck);
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
    void shuffleDeck(Card[] deck) {
        System.out.println("Kaarten worden nu geschud");
        final Random random = new Random();

        for (int i = 0; i < deck.length; i++) { //iterate through the deck
            int randomIndexToSwap = random.nextInt(deck.length); //get a random number between 0 and the length of the array
            Card temp = deck[randomIndexToSwap]; // get a random card
            deck[randomIndexToSwap] = deck[i]; //assign another random card with a card of the current index
            deck[i] = temp; //assign the card of the current index with the random card
        }
    }

    /**
     * This method returns a card from the deck and keep up the index of the deck
     * @return
     */
    Card removeCardFromDeck() {
        return deck[deckIndex++];
    }
}
