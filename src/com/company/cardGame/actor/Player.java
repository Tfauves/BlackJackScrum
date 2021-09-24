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

    private String getAvailableActions() {
        StringBuilder outPut = new StringBuilder();
        outPut.append("0. Quit\n1. Hit\n 2. Stand");
        // TODO: 9/23/2021 add logic for double.
        // TODO: 9/23/2021 1. confirm first turn.
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
        System.out.println("1. Hit\n2. Stand\n0. Quit");
        //get selected action
        return Console.getInt(0,2,"", "Invalid action");
    }
}