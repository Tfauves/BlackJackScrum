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
        deal();
        displayTable();
        turn(player);
        turn(dealer);
        determineWinner();

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

    private void turn(Hand activeHand) {
        System.out.println("Dealer: " + dealer.displayHand());
        int action = activeHand.getAction();
        switch (action) {
            case 0 -> System.out.println("Quitting");
            case 1 -> System.out.println("Hit Me");
            case 2 -> System.out.println("Wave Hand");
            case 3 -> System.out.println("Double Down");
            case 4 -> System.out.println("two hands");
            default -> System.out.println("ERROR bad action");
        }
    }

    private void hit(Hand activeHand) {
        // TODO: 9/27/2021 hit
    }

    private void stand(Hand activeHand) {
        // TODO: 9/27/2021 stand
    }

    private void doubleDown(Hand activeHand) {
        // TODO: 9/27/2021 doubleDown
    }

    private void split(Hand activeHand) {
        doubleDown(activeHand);
    }


}
