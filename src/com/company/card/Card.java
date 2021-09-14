package com.company.card;

public class Card {
    private final String suit;
    private final int faceValue;

    public Card(String suit, int faceValue) {
        this.suit = suit;
        this.faceValue = faceValue;
    }

    public int getFaceValue() {
        return faceValue;
    }
    public String toString() {
        return faceValue + " " + suit ;
    }

    public String display() {
        return switch (faceValue) {
            case 1 -> "AC";
            case 11 -> "JK";
            case 12 -> "QU";
            case 13 -> "KI";
            default -> " ";
        };
    }

}
