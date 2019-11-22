package com.jdh.blackjack.model;

public class Card {

    /** constant int that represents the points for the ace card */
    public static final int ACE_POINTS = 11;

    /** constant int that represents the points for the Jack, Queen and King face cards */
    private static final int JACK_QUEEN_KING_POINTS = 10;

    /** Suit enum that represents the symbol of the card */
    private Suit suit;

    /** int value that represents the number of the card */
    private int number;

    /** Face enum that represents the face symbol of the card */
    private Face face;

    /** int variable that contains the value of the card */
    private int points;

    public Card(Suit suit, int number) {
        this.suit = suit;
        this.number = number;
        this.points = number;
    }

    public Card(Suit suit, Face face) {
        this.suit = suit;
        this.face = face;
        this.points = (face == Face.ACE) ? ACE_POINTS : JACK_QUEEN_KING_POINTS;
    }

    public Face getFace() {
        return face;
    }


    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        builder.append("Card{");
        if (this.number != 0) builder.append("number=" + this.number);
        if (this.face != null) builder.append("face=" + this.face);
        builder.append(", suit=" + this.suit);
        builder.append(", points=" + this.points);
        builder.append("}");

        return builder.toString();
    }
}
