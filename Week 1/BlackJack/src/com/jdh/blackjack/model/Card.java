package com.jdh.blackjack.model;

public class Card {

    /** constant int that represents the points for the ace card */
    private static final int ACE_POINTS = 11;

    /** constant int that represents the points for the Jack, Queen and King face cards */
    private static final int JACK_QUEEN_KING_POINTS = 10;

    private Suit suit;

    private int number;

    private Face face;

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

    public Suit getSuit() {
        return suit;
    }

    public void setSuit(Suit suit) {
        this.suit = suit;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Face getFace() {
        return face;
    }

    public void setFace(Face face) {
        this.face = face;
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
