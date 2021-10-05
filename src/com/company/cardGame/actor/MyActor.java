package com.company.cardGame.actor;

import com.company.cardGame.blackJack.Actor;
import com.company.cardGame.blackJack.Hand;

public class MyActor implements Actor {

    @Override
    public String getName() {
        return null;
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
    public int getAction(Hand hand) {
        return 0;
    }

    @Override
    public void addBalance(double amount) {

    }
}
