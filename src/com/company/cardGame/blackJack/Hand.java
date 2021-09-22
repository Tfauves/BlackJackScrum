package com.company.cardGame.blackJack;

import com.company.cardGame.deck.Card;
import com.company.cardGame.deck.Deck;

import java.util.ArrayList;
import java.util.List;

public class Hand {
    private List<Card> cards = new ArrayList<>();
    private int bet = 0;
//    private Player player;

    public void addCard(Card card) {
        cards.add(card);
    }

//    public void addCard(Deck deck) {
//        addCard(deck.deal());
//    }

    public String displayHand() {
        String outPut = "";
        for (Card card : cards) {
            outPut += card.display() + " ";
        }
        return outPut.toString().trim();
    }

    public String displayValue() {
        int score = 0;
        for (Card card : cards) {
            int value  = card.getFaceValue();
            switch (value) {
                case 1 -> score += 1;
                case 11, 12, 13 -> score += 10;
                default -> score += value;
            }
        }
        return Integer.toString(score);
    }


}
