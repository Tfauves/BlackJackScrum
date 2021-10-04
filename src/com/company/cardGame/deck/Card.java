package com.company.cardGame.deck;

public class Card {
    private final String suit;
    private final int rank;
    private boolean isFaceDown = true;

    public Card(String suit, int rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public int getRank() {
        return rank;
    }

    public String toString() {
        return rank + " " + suit ;
    }

    public String display() {
        String outPut = "";
        if (isFaceDown) {
            return "<*>";
        }
        switch (rank) {
            case 1 -> outPut = "AC";
            case 11 -> outPut = "JK";
            case 12 -> outPut = "QU";
            case 13 -> outPut = "KI";
            default -> outPut = rank == 10 ? Integer.toString(rank) : " " + rank;
            //            case 0 -> output = "JR"; //joker
        };
        return outPut + " " + suit;
    }

    public void flip() {
        isFaceDown = !isFaceDown;
    }

    public boolean getIsFaceDown() {
        return isFaceDown;
    }

}
