package com.jdh.blackjack;

import com.jdh.blackjack.manager.Dealer;
import com.jdh.blackjack.manager.Hand;
import com.jdh.blackjack.model.Player;

import java.util.Scanner;

public class Main {

    /** Dealer object that is a singleton instance */
    final static Dealer dealer = Dealer.getInstance();
    final static Player player = Player.getInstance();

//    /** Hand object that is a singleton instance */
//    final static Hand hand = new Hand();

    /** Scanner object to handle userinput */
    final static Scanner scanner = new Scanner(System.in);

    /** constant int variable that represents black jack */
    public static final int BLACK_JACK = 21;

    public static void main(String[] args) throws InterruptedException{
        System.out.println("Do you like to play the next BlackJack game? Type Y to play and N for no.");

        String userInputPlaysGame = scanner.nextLine().toUpperCase();

        // Check for userinput, only accepts Y / N
        while(!userInputPlaysGame.equals("Y") && !userInputPlaysGame.equals("N")) {
            System.out.println("Wrong answer! Type Y to play and N for no.");
            userInputPlaysGame = scanner.nextLine().toUpperCase();
            System.out.println("You answered " + userInputPlaysGame);
        }

        // if user sends Y
        if (userInputPlaysGame.equals("Y")) {
            player.getPlayerHand().obtainCardFromDeck(dealer.getCardFromDeck());
            player.getPlayerHand().obtainCardFromDeck(dealer.getCardFromDeck());
            player.getPlayerHand().showHand();

            // play the game
            new Main().playGame();

        } else {
            new Main().quitGame(userInputPlaysGame);
        }
    }

    /**
     * This (recursive) method will start the Black Jack game
     * and will call itself if the player is busted BUT has an ace card in the Hand object
     */
    private void playGame() throws InterruptedException{
        // If total points in users hand is below 21, keep iterating
        while(player.getPlayerHand().getTotalPoints() < BLACK_JACK) {
            dealer.askForNextMove();
            String userInputNextAction = scanner.nextLine().toUpperCase();

            // if userinput does not equals S / Q / C, keep iterating
            while(!userInputNextAction.equals("S") && !userInputNextAction.equals("C") && !userInputNextAction.equals("Q") && !userInputNextAction.equals("P")) {
                System.out.println("Wrong answer!");
                userInputNextAction = scanner.nextLine().toUpperCase();
            }

            // do something based on user input
            if (userInputNextAction.equals("Q")) {
                new Main().quitGame(userInputNextAction);
                break;
            } else if (userInputNextAction.equals("S")) {
                player.getPlayerHand().showHand();
            } else if (userInputNextAction.equals("C")) {
                player.getPlayerHand().obtainCardFromDeck(dealer.getCardFromDeck());
                player.getPlayerHand().showHand();
            } else if (userInputNextAction.equals("P")) {
                dealer.dealerPlaysGame(player.getPlayerHand().getTotalPoints());
                break;
            }
        }

        // if user has an ace card with eleven points, convert it to one point and call itself
        if (player.getPlayerHand().getTotalPoints() > BLACK_JACK && player.getPlayerHand().hasAceInHandWithElevenPoints()) {
            player.getPlayerHand().setAcePointsToOne();
            playGame();
        } else if (player.getPlayerHand().getTotalPoints() > BLACK_JACK) {
            System.out.println("BUSTED");
        } else if (player.getPlayerHand().getTotalPoints() == BLACK_JACK) {
            System.out.println("BLACK JACK");
            dealer.dealerPlaysGame(player.getPlayerHand().getTotalPoints());
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
