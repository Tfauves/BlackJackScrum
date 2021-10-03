package com.company.cardGame.blackJack;

public interface Actor {
    int HIT = 1;
    int STAND = 2;
    int DOUBLE = 3;
    int SPLIT = 4;
    int QUIT = 0;

    // TODO: 9/30/2021 create a new Actor with my own logic based on what cards they had vs what the dealer has.
    String getName();
    int getBalance();
    int placeBet();
    int getAction(Hand hand); // TODO: 9/30/2021 change signature to get dealer hand and refactor.
    void addBalance(double amount);
    //int getAction(Hand hand, List<Cards> cards); cardCounter version
}
