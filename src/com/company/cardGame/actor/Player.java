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
