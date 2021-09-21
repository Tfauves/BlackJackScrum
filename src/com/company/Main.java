package com.company;

import com.company.cardGame.deck.CheatersDeck;
import com.company.cardGame.deck.Deck;

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
