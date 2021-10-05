package com.company.cardGame.actor;

import com.company.cardGame.blackJack.Actor;
import com.company.cardGame.blackJack.Hand;

public class Dealer implements Actor {
    public int STAND_VALUE = 17;

    public String getName() {
        return "Jasper";
    }

    @Override
    public int getBalance() {
        return 0;
    }

    @Override
    public int placeBet() {
        return 0;
    }

    @Override
    public void addBalance(double amount) {
        return;
    }

    public int getAction(Hand hand) {
        return hand.getValue() < STAND_VALUE ? HIT : STAND;
    }

    @Override
    public int getAction(Hand hand, Hand dealer) {
        return 0;
    }
}
