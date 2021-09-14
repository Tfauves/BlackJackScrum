package com.company;

import com.company.card.Card;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StandardDeck implements Deck {
    private final List<Card> cards = new ArrayList<>();
    public final String[] SUITS = {"Diamond", "Spade", "Heart", "Club"
    };
    public final int[] FACE_VALUE = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13
    };

    public StandardDeck() {
        for (String suit : SUITS) {
            for (int value : FACE_VALUE) {
                cards.add(new Card(suit, value));
            }
        }
    }

    public void printDeck() {
        System.out.println(cards);
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public Card deal() {
        return cards.remove(cards.size() -1);
    }

    public List<Card> getCards() {
        return cards;
    }
}
