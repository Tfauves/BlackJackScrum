package com.company.cardGame.actor;

import com.company.cardGame.blackJack.Actor;
import com.company.cardGame.blackJack.Hand;

public class Dealer implements Actor {
    public String getName() {
        return "Arnell";
    }

    public int getBalance() {
        return 0;
    }

    @Override
    public int getBet(int w) {
        return 0;
    }

    public int getAction(Hand hand) {

        return 0;
    }
}
