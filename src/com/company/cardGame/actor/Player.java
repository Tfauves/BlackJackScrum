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
        startingBalance = startingBalance;
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
    public int getBet() {
        return Console.getInt("Enter a bet between 1 " + balance, 1,balance, "invalid bet");
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
        //display available actions
        //get selected action

        return Console.getInt(getAvailableActions(hand), 0,  actionsCount,"Invalid action");
    }
}
