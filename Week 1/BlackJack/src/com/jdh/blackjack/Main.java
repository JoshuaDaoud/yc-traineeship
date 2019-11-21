package com.jdh.blackjack;

import com.jdh.blackjack.manager.Dealer;
import com.jdh.blackjack.manager.Hand;

import java.util.Scanner;

public class Main {

    final static Dealer dealer = Dealer.getInstance();
    final static Hand hand = Hand.getInstance();
    final static Scanner scanner = new Scanner(System.in);

    private static final int BLACK_JACK = 21;

    public static void main(String[] args) {
        System.out.println("Do you like to play the next BlackJack game? Type Y to play and N for no.");

        String userInputPlaysGame = scanner.nextLine().toUpperCase();

        // Check for userinput, only accepts Y / N
        while(!userInputPlaysGame.equals("Y") && !userInputPlaysGame.equals("N")) {
            System.out.println("Wrong answer! Type Y to play and N for no.");
            userInputPlaysGame = scanner.nextLine().toUpperCase();
            System.out.println("You answered " + userInputPlaysGame);
        }

        if (userInputPlaysGame.equals("Y")) {
            hand.obtainCardFromDeck(dealer.getCardFromDeck());
            hand.obtainCardFromDeck(dealer.getCardFromDeck());
            hand.showHand();

            new Main().playGame();

            if (hand.getTotalPoints() > BLACK_JACK) {
                System.out.println("BUSTED");
            } else if (hand.getTotalPoints() == BLACK_JACK) {
                System.out.println("BLACK JACK!");
            }
//            else if (hand.getTotalPoints() > BLACK_JACK && hand.hasAceInHand()) {
//
//            }

        } else {
            new Main().quitGame(userInputPlaysGame);
        }
    }

    private void playGame() {
        while(hand.getTotalPoints() < BLACK_JACK) {
            boolean hasAceInHand = hand.hasAceInHand();
            dealer.askForNextMove();

            String userInputNextAction = scanner.nextLine().toUpperCase();
            while((!userInputNextAction.equals("S") && !userInputNextAction.equals("C") && !userInputNextAction.equals("Q"))) {
                System.out.println("Wrong answer!");
                userInputNextAction = scanner.nextLine().toUpperCase();
            }

            if (userInputNextAction.equals("Q")) {
                new Main().quitGame(userInputNextAction);
                break;
            } else if (userInputNextAction.equals("S")) {
                hand.showHand();
            } else if (userInputNextAction.equals("C")) {
                hand.obtainCardFromDeck(dealer.getCardFromDeck());
                hand.showHand();
            }
        }

    }

    /**
     * This method will print the exit text
     * @param input
     */
    private void quitGame(String input){
        System.out.println("You answered " + input);
        System.out.println("Thank you for playing");
    }

}
