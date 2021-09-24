package com.company;

import com.company.cardGame.actor.Dealer;
import com.company.cardGame.blackJack.Actor;
import com.company.cardGame.blackJack.Hand;
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
//        myhand.addCard(cardDeck.deal());
//        myhand.addCard(cardDeck.deal());
//        System.out.println(myhand.displayHand());
//        myhand.addCard(cardDeck.deal());
//        myhand.addCard(cardDeck.deal());
//        System.out.println(myhand.displayHand());
//        System.out.println(myhand.getValue());
        Actor dealer = new Dealer();
        myhand.addCard(cardDeck.deal());
        myhand.addCard(cardDeck.deal());
        System.out.println(myhand.displayHand());
        System.out.println(myhand.getValue());
        while (dealer.getAction(myhand) != Actor.STAND) {
            myhand.addCard(cardDeck.deal());
            System.out.println("HIT");
            System.out.println(myhand.displayHand());
            System.out.println(myhand.getValue());
        }
        System.out.println("Done");
    }
}
