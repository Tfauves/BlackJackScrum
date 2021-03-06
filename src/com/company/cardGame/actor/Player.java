package com.company.cardGame.actor;

import com.company.cardGame.blackJack.Actor;
import com.company.cardGame.blackJack.Hand;
import com.company.util.Console;

public class Player implements Actor {
    private final String name;
    private int balance = 1000;
    private int actionsCount;

    public Player(String name, int startingBalance) {
        this.name = name;
        balance = startingBalance;
    }

    public Player(String name) {
        this.name = name;
    }

    @Override
    public String getName() {

        return name;
    }

    @Override
    public int getBalance() {
        return balance;
    }

    @Override
    public int placeBet() {
        int bet = Console.getInt(
                "Enter a bet 1 - " + balance, 1,
                balance,
                "invalid bet"
        );
        balance -= bet;
        return bet;
    }

    private String getAvailableActions(Hand hand) {
        actionsCount = 2;
        StringBuilder outPut = new StringBuilder();
        outPut.append("0. Quit\n1. Hit\n2. Stand");
        if (hand.size() == 2 && balance >= hand.getBet() ) {
            outPut.append("\n3. Double");
            actionsCount++;
            if (hand.canSplit()) {
                outPut.append("\n4. Split");
                actionsCount++;
            }
        }
        return outPut.toString();
    }

    @Override
    public int getAction(Hand hand) {
        //display hand and value
        System.out.println(hand.displayHand());
        System.out.println(hand.getValue());
        return Console.getInt(getAvailableActions(hand), 0,  actionsCount,"invalid action");
    }

    public int getAction(Hand hand, Hand dealer) {
        return 0;
    }

    @Override
    public void addBalance(double amount) {

    }

    public void addBalance(int amount) {
        balance += amount;
    }
}
