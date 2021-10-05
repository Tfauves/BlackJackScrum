package com.company.cardGame.actor;

import com.company.cardGame.blackJack.Actor;
import com.company.cardGame.blackJack.Hand;

public class MyActor implements Actor {
    public int STAND_VALUE = 18;
    private int balance = 1000;


    @Override
    public String getName() {
        return "Tfauves";
    }

    @Override
    public int getBalance() {
        return balance;
    }

    @Override
    public int placeBet() {
        return 0;
    }

    @Override
    public int getAction(Hand hand) {
        if (hand.getValue() < STAND_VALUE) {
            return HIT;
        }
        return 0;
    }

    @Override
    public int getAction(Hand hand, Hand dealer) {
        return 0;
    }

    @Override
    public void addBalance(double amount) {
        balance += amount;
    }
}
