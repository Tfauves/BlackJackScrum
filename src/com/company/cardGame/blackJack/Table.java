package com.company.cardGame.blackJack;

import com.company.cardGame.actor.Dealer;
import com.company.cardGame.actor.Player;
import com.company.cardGame.deck.Deck;
import com.company.cardGame.deck.StandardDeck;

public class Table {
    Hand playerHand = new Hand(new Player("player"));
    Hand dealer = new Hand(new Dealer());
    Deck deck;

    public void playARound() {
        deck = new StandardDeck();
        deck.shuffle();

    }

    private void deal() {
        deck.draw();
    }


}
