package com.company.card;

public class Card {
    public final String suit;
    public final String faceValue;

    public Card(String suit, String faceValue) {
        this.suit = suit;
        this.faceValue =faceValue;
    }

    public String toString() {
        return faceValue + " " + suit ;
    }
}
