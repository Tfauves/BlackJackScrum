package com.company.cardGame.blackJack;

public interface Actor {
    String getName();
    int getBalance();
    int getBet(int wallet);
    int getAction(Hand hand);
    //int getAction(Hand hand, List<Cards> cards); cardCounter version
}
