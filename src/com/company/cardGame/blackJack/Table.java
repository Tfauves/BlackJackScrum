package com.company.cardGame.blackJack;

import com.company.cardGame.actor.Dealer;
import com.company.cardGame.actor.MyActor;
import com.company.cardGame.actor.Player;
import com.company.cardGame.deck.CheatersDeck;
import com.company.cardGame.deck.Deck;
import com.company.cardGame.deck.StandardDeck;
import com.company.util.Console;

import java.util.ArrayList;
import java.util.List;

public class Table {
    private List<Hand> hands = new ArrayList<>();
    private Hand dealer = new Hand(new Dealer());
    private Hand my = new Hand(new MyActor());
    private Deck deck;
    public static final int BUST_VALUE = 21;
    private int playerCount = 0;

    public Table() {
        playerCount = Console.getInt("How many player?", 1, 6, "invalid input");
        for (int count = 0; count < playerCount; count++) {
            Player newPlayer = new Player("Player" + (count + 1) + ": ");
            hands.add(new Hand(newPlayer));
        }
    }

    public void playGame() {
        while (true) {
            playARound();
        }
    }

    public void playARound() {
        deck = new StandardDeck();
//        deck = new CheatersDeck();
        deck.shuffle();
        getBets();
        deal();
        displayTable();
        playerTurns();
        my.revealHand();
        while(turn(my));
        dealer.revealHand();
        while (turn(dealer));
        displayTable();
        endRound();
    }

    private void getBets() {
        for (Hand player : hands) {
            player.placeBet();
        }
    }

    private void playerTurns() {
        for (int count = 0; count < hands.size(); count++) {
            Hand player = hands.get(count);
            player.revealHand();
            while(true) {
                if (!turn(player)) break;
            }
            System.out.println(player.displayHand());
            Console.getString("Enter to start next turn", false);
        }
    }

    private void endRound() {
        for (Hand player : hands) {
            determineWinner(player);
            System.out.println(player.getBalance());
            player.discardHand();
        }
        dealer.discardHand();
        while (hands.size() > playerCount) {
            hands.remove(hands.size() -1);
        }
    }

    private void deal() {
       for (int count = 0; count < 2; count++) {
           //list of hands
           dealer.addCard(count == 0 ? deck.draw() : deck.flipDraw());;
           for (Hand player : hands) {
               player.addCard(count == 0 ? deck.draw() : deck.flipDraw());
//               player.addCard(deck.draw());
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

    private void determineWinner(Hand player) {

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
        if (player.getValue() == BUST_VALUE) {
            System.out.println("BlackJack");
            player.payOut(Hand.BLACK_JACK);
            return;
        }

        System.out.println("Dealer Wins");
    }

    private boolean turn(Hand activeHand) {
        System.out.println(dealer.getName() + " " + dealer.displayHand());
        System.out.println(activeHand.getName());
        int action = activeHand.getAction();
        return switch (action) {
            case Actor.QUIT -> quit();
            case Actor.HIT -> hit(activeHand);
            case Actor.STAND -> stand(activeHand);
            case Actor.DOUBLE -> doubleDown(activeHand);
            case Actor.SPLIT -> split(activeHand);
            default -> false;
        };
    }

    private boolean quit() {
        System.exit(0);
        return false;
    }

    private boolean hit(Hand activeHand) {
        activeHand.addCard(deck.flipDraw());
        System.out.println("Hit Me");
        if (activeHand.getValue() > BUST_VALUE) {
            System.out.println("Busted");
            return false;
        }
        return true;
    }

    private boolean stand(Hand activeHand) {
        System.out.println("Wave Hand");
        return false;
    }

    private boolean doubleDown(Hand activeHand) {
        activeHand.doubleBet();
        System.out.println("Doubled Down");
        hit(activeHand);
        stand(activeHand);
        return false;
    }

    private boolean split(Hand activeHand) {
        System.out.println("two hands");
        activeHand.doubleBet();
        Hand newHand = activeHand.splitHand();
        activeHand.addCard(deck.flipDraw());
        newHand.addCard(deck.flipDraw());
        hands.add(newHand);

        return true;
    }

}
