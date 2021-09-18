package com.company;

import com.company.card.CheatersDeck;
import com.company.card.Deck;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Deck cardDeck = new CheatersDeck();
        cardDeck.shuffle();
        System.out.println(cardDeck.deal().display());
        System.out.println(cardDeck.deal().display());
        System.out.println(cardDeck.deal().display());
        System.out.println(cardDeck.deal().display());
        System.out.println(cardDeck.deal().display());
        System.out.println(cardDeck.deal().display());
    }
}
