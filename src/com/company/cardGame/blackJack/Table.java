package com.company.cardGame.blackJack;

import com.company.cardGame.actor.Dealer;
import com.company.cardGame.actor.Player;
import com.company.cardGame.deck.Deck;
import com.company.cardGame.deck.StandardDeck;

public class Table {
    Hand player = new Hand(new Player("player"));
    Hand dealer = new Hand(new Dealer());
    Deck deck;

    public void playARound() {
        deck = new StandardDeck();
        deck.shuffle();

    }

    private void deal() {
       for (int count = 0; count < 2; count++) {
           player.addCard(deck.draw());
           dealer.addCard(deck.draw());
       }
    }

    private void displayTable() {
        StringBuilder outPut = new StringBuilder();
        outPut.append("Dealer: ").append(dealer.displayHand()).append("\n");
        outPut.append("Player: ").append(player.displayHand()).append("\n");
        System.out.println(outPut);

    }

    private void determineWinner() {
        if (player.getValue() > dealer.getValue()) {
            System.out.println("Player Wins");
            return;
        }
        if (player.getValue() == dealer.getValue()) {
            System.out.println("Push");
            return;
        }
        System.out.println("Dealer Wins");

    }


}
