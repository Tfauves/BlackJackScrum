package com.company.cardGame.blackJack;

import com.company.cardGame.actor.Dealer;
import com.company.cardGame.actor.Player;
import com.company.cardGame.deck.Deck;
import com.company.cardGame.deck.StandardDeck;

public class Table {
    Hand player = new Hand(new Player("player"));
    Hand dealer = new Hand(new Dealer());
    Deck deck;
    int BUST_VALUE = 21;

    public void playARound() {
        deck = new StandardDeck();
        deck.shuffle();
        deal();
        displayTable();
        while (turn(player)) {}

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
        outPut.append("Player: ").append(player.displayHand());
        System.out.println(outPut);

    }

    private void determineWinner() {
        if (player.getValue() > BUST_VALUE) {
            System.out.println("player busted");
            return;
        }
        if (player.getValue() > dealer.getValue() || dealer.getValue() > BUST_VALUE) {
            System.out.println("Player Wins");
            return;
        }
        if (player.getValue() == dealer.getValue()) {
            System.out.println("Push");
            return;
        }
        System.out.println("Dealer Wins");
    }

    private boolean turn(Hand activeHand) {
            System.out.println("Dealer: " + dealer.displayHand());
            int action = activeHand.getAction();
            switch (action) {
                case 0 -> stand(activeHand);
                case 1 -> hit(activeHand);
                case 2 -> stand(activeHand);
                case 3 -> doubleDown(activeHand);
                case 4 -> split(activeHand);
                default -> {
                    System.out.println("ERROR bad action");
                    return false;
                }
            }
//            System.out.println(activeHand.displayHand() + "\n" + activeHand.getValue());


    }

    private void hit(Hand activeHand) {
        // TODO: 9/27/2021 hit
        activeHand.addCard(deck.draw());
        System.out.println("Hit Me");
    }

    private void stand(Hand activeHand) {
        // TODO: 9/27/2021 stand
        System.out.println("Wave Hand");
    }

    private void doubleDown(Hand activeHand) {
        // TODO: 9/27/2021 doubleDown
        activeHand.doubleBet();
        System.out.println("Double Down");
        hit(activeHand);
        stand(activeHand);
    }

    private void split(Hand activeHand) {

        doubleDown(activeHand);
        System.out.println("two hands");
    }


}
