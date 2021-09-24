package com.company;

import com.company.cardGame.actor.Dealer;
import com.company.cardGame.actor.Player;
import com.company.cardGame.blackJack.Actor;
import com.company.cardGame.blackJack.Hand;
import com.company.cardGame.deck.Deck;
import com.company.cardGame.deck.StandardDeck;
import com.company.util.Console;

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
//        myhand.addCard(cardDeck.deal());
//        myhand.addCard(cardDeck.deal());
//        System.out.println(myhand.displayHand());
//        myhand.addCard(cardDeck.deal());
//        myhand.addCard(cardDeck.deal());
//        System.out.println(myhand.displayHand());
//        System.out.println(myhand.getValue());
        Actor dealer = new Player(Console.getString("Player name?", true));
        Hand myhand  = new Hand(dealer);
        myhand.addCard(cardDeck.deal());
        myhand.addCard(cardDeck.deal());
//        System.out.println(myhand.displayHand());
//        System.out.println(myhand.getValue());
        while (dealer.getAction(myhand) == Actor.HIT) {
            myhand.addCard(cardDeck.deal());
            System.out.println("HIT");
//            System.out.println(myhand.displayHand());
//            System.out.println(myhand.getValue());
        }
        System.out.println("Done");
    }
}
