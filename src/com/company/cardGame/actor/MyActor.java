package com.company.cardGame.actor;

import com.company.cardGame.blackJack.Actor;
import com.company.cardGame.blackJack.Hand;

public class MyActor implements Actor {
    public int STAND_VALUE = 17;
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
        return balance / 2;
    }

    @Override
    public int getAction(Hand hand) {

        if (hand.getCard(0).getRank() == 8 && hand.getCard(1).getRank() == 8) {
            return SPLIT;
        }
        if (hand.getValue() == 11) {
            return DOUBLE;
        }
        if (hand.getValue() < STAND_VALUE) {

            return HIT;
        }
        return STAND;
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
