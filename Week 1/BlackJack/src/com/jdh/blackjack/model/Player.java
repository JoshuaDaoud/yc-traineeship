package com.jdh.blackjack.model;

import com.jdh.blackjack.manager.Hand;

public class Player {

    private static Player player;

    private Hand playerHand;

    private Player() { }

    public static Player getInstance() {
        if (player == null) {
            player = new Player();
        }
        return player;
    }

    {
        playerHand = new Hand();
    }

    public Hand getPlayerHand() {
        return playerHand;
    }
}
