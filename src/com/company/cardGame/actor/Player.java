package com.company.cardGame.actor;

import com.company.cardGame.blackJack.Actor;
import com.company.cardGame.blackJack.Hand;
import com.company.util.Console;

public class Player implements Actor {
    private final String name;
    private int balance = 1000;

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
        return Console.getInt(1,balance, "Enter a bet between 1 " + balance, "invalid bet");
    }

    private String getAvailableActions(Hand hand) {
        StringBuilder outPut = new StringBuilder();
        outPut.append("0. Quit\n1. Hit\n2. Stand");

        // TODO: 9/23/2021 add logic for double.
        // TODO: 9/23/2021 1. confirm first turn.
        if (hand.size() == 2 && balance >= hand.getBet() ) {
            outPut.append("\n3. Double");


        }

        // TODO: 9/23/2021 2. confirm player has enough funds.
        // TODO: 9/23/2021 add logic for split.
//        split can only be done if you can double and split must est for a pair.

        // TODO: 9/23/2021 3. add logic for split detect pair.
        return outPut.toString();
    }

    @Override
    public int getAction(Hand hand) {
        //display hand and value
        System.out.println(hand.displayHand());
        System.out.println(hand.getValue());
        //display available actions
        //get selected action
        return Console.getInt(0,3,getAvailableActions(hand), "Invalid action");
    }
}
