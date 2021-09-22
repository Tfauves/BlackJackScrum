package com.company;

import com.company.cardGame.blackJack.Hand;
import com.company.cardGame.deck.CheatersDeck;
import com.company.cardGame.deck.Deck;
import com.company.cardGame.deck.StandardDeck;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Deck cardDeck = new StandardDeck();
        cardDeck.shuffle();
//        System.out.println(cardDeck.deal().display());
//        System.out.println(cardDeck.deal().display());
//        System.out.println(cardDeck.deal().display());
//        System.out.println(cardDeck.deal().display());
//        System.out.println(cardDeck.deal().display());
//        System.out.println(cardDeck.deal().display());
        Hand myhand = new Hand();
        myhand.addCard(cardDeck.deal());
        myhand.addCard(cardDeck.deal());
        System.out.println(myhand.displayHand());
        myhand.addCard(cardDeck.deal());
        myhand.addCard(cardDeck.deal());
        System.out.println(myhand.displayHand());
        System.out.println(myhand.displayValue());
    }
}
