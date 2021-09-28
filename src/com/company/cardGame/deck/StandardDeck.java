package com.company.cardGame.deck;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StandardDeck implements Deck {
    private final List<Card> cards = new ArrayList<>();
    public final String[] SUITS = {"♦", "♠", "♣", "♥"
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

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public Card draw() {
        return cards.remove(cards.size() -1);
    }

    public List<Card> getCards() {
        return cards;
    }
}
