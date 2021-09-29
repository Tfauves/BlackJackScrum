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
            System.out.println(dealer.getName() + " " + dealer.displayHand());
            int action = activeHand.getAction();
            switch (action) {
                case Actor.QUIT -> stand(activeHand);
                case Actor.HIT -> hit(activeHand);
                case Actor.STAND -> stand(activeHand);
                case Actor.DOUBLE -> doubleDown(activeHand);
                case Actor.SPLIT -> split(activeHand);
                default -> false;
            }
//            System.out.println(activeHand.displayHand() + "\n" + activeHand.getValue());


    }

    private boolean hit(Hand activeHand) {
        // TODO: 9/27/2021 hit
        activeHand.addCard(deck.draw());
        System.out.println("Hit Me");
        if (activeHand.getValue() > BUST_VALUE) {
            System.out.println("Busted");
            return false;
        }
        return true;
    }

    private boolean stand(Hand activeHand) {
        // TODO: 9/27/2021 stand
        System.out.println("Wave Hand");
        return false;
    }

    private boolean doubleDown(Hand activeHand) {
        // TODO: 9/27/2021 doubleDown
        activeHand.doubleBet();
        System.out.println("Double Down");
        hit(activeHand);
        stand(activeHand);
        return false;
    }

    private boolean split(Hand activeHand) {

        System.out.println("two hands");
        return doubleDown(activeHand);
    }


}
