package com.company.cardGame.blackJack;

import com.company.cardGame.actor.Dealer;
import com.company.cardGame.actor.Player;
import com.company.cardGame.deck.Deck;
import com.company.cardGame.deck.StandardDeck;
import com.company.util.Console;

import java.util.ArrayList;
import java.util.List;

public class Table {
    // TODO: 9/29/2021 remove the line below.
   // private Hand player = new Hand(new Player("player"));
    // TODO: 9/29/2021 try to implement multiple hands.
    private List<Hand> hands = new ArrayList<>();
    // TODO: 9/29/2021 try to elimate use of list for players.
    private List<Actor> players = new ArrayList<>();
    private Hand dealer = new Hand(new Dealer());
    private Deck deck;
    public static final int BUST_VALUE = 21;

    public Table() {
        int playerCount = Console.getInt("How many player?", 1, 6, "invalid input");
        for (int count = 0; count < playerCount; count++) {
            Player newPlayer = new Player("Player" + (count + 1) + ": ");
            players.add(newPlayer);
            hands.add(new Hand(newPlayer));

        }

    }

    public void playARound() {
        deck = new StandardDeck();
        deck.shuffle();
        for (Hand player : hands) {
        player.placeBet();

        }
        deal();
        displayTable();
        while (turn(player)) {}
        System.out.println(player.displayHand());
        while (turn(dealer));
        displayTable();
        determineWinner();
        System.out.println(player.getBalance());
    }

    private void deal() {
       for (int count = 0; count < 2; count++) {
           //list of hands
           dealer.addCard(deck.draw());
           for (Hand player : hands) {
           player.addCard(deck.draw());
           }
       }
    }

    private void displayTable() {
        StringBuilder outPut = new StringBuilder();
        outPut.append(dealer.getName()).append(" ").append(dealer.displayHand()).append("\n");
        for (Hand player : hands) {
        outPut.append(player.getName()).append(" ").append(player.displayHand()).append(" | ");
        }
        System.out.println(outPut);
    }

    private void determineWinner() {
        if (player.getValue() > BUST_VALUE) {
            System.out.println("player busted");
            return;
        }
        if (player.getValue() > dealer.getValue() || dealer.getValue() > BUST_VALUE) {
            System.out.println("Player Wins");
            player.payOut(Hand.NORMAL_PAYOUT);
            return;
        }
        if (player.getValue() == dealer.getValue()) {
            System.out.println("Push");
            player.payOut(Hand.PUSH_PAYOUT);
            return;
        }
        System.out.println("Dealer Wins");
    }

    private boolean turn(Hand activeHand) {
        System.out.println(dealer.getName() + " " + dealer.displayHand());
        int action = activeHand.getAction();
        return switch (action) {
            case Actor.QUIT -> stand(activeHand);
            case Actor.HIT -> hit(activeHand);
            case Actor.STAND -> stand(activeHand);
            case Actor.DOUBLE -> doubleDown(activeHand);
            case Actor.SPLIT -> split(activeHand);
            default -> false;
        };
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
        System.out.println("Doubled Down");
        hit(activeHand);
        stand(activeHand);
        return false;
    }

    private boolean split(Hand activeHand) {

        System.out.println("two hands");
        return doubleDown(activeHand);
    }


}
