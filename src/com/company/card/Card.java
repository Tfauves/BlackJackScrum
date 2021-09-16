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
        String outPut = "";
        switch (faceValue) {
            case 1 -> outPut = "AC";
            case 11 -> outPut = "JK";
            case 12 -> outPut = "QU";
            case 13 -> outPut = "KI";
            default -> outPut = faceValue == 10 ? Integer.toString(faceValue) : " " + faceValue;
            //            case 0 -> output = "JR"; //joker
        };
        return outPut + " " + suit;
    }

}
