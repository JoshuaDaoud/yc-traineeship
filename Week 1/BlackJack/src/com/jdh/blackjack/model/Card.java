package com.jdh.blackjack.model;

public class Card {

    private Suit suit;

    private int number;

    private Face face;

   public Card(Suit suit, int number) {
        this.suit = suit;
        this.number = number;
    }

    public Card(Suit suit, Face face) {
        this.suit = suit;
        this.face = face;
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

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        builder.append("Card{suit=" + this.suit);
        if (this.number != 0) builder.append(", number=" + this.number);
        if (this.face != null) builder.append(", face=" + this.face);
        builder.append("}");

        return builder.toString();
    }
}
