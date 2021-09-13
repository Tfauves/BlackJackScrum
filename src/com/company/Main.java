package com.company;

import com.company.card.CheatersDeck;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Deck cardDeck = new CheatersDeck();
        cardDeck.shuffle();
        cardDeck.printDeck();

        for (int i = 0; i < 5; i++) {
            System.out.println(cardDeck.deal());
        }
    }
}
