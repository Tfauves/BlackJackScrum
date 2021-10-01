package com.company.cardGame.blackJack;

import com.company.cardGame.deck.Card;

import java.util.ArrayList;
import java.util.List;

public class Hand {
    private List<Card> cards = new ArrayList<>();
    private int bet = 0;
    private Actor holder;

    public static final int PUSH_PAYOUT = 0;
    public static final int NORMAL_PAYOUT = 1;

    public Hand(Actor holder) {
        this.holder = holder;
    }

    public void addCard(Card card) {
        cards.add(card);
    }

//    public void addCard(Deck deck) {
//        addCard(deck.deal());
//    }

    public String displayHand() {
        StringBuilder outPut = new StringBuilder();
        for (Card card : cards) {
            outPut.append(card.display()).append(" ");
        }

        return outPut.toString().trim();
    }

    public int getValue() {
        int score = 0;
        boolean hasAce11 = false;
        for (Card card : cards) {
            int value  = card.getRank();
            switch (value) {
                case 1 -> {
                  value = score + 11 > 21 ? 1 : 11;
                  if (value == 11){
                      hasAce11 = true;
                  }
                    score += value;
                }
                case 11, 12, 13 -> score += 10;
                default -> score += value;
            }
            if (score > 21 && hasAce11) {
                score -= 10;
                hasAce11 = false;
            }
        }
        return score;
    }

    public int getAction() {
        return holder.getAction(this);
    }

    public int size() {
        return cards.size();
    }

    public int getBet() {
        return bet;
    }

    public void placeBet() {
        bet = holder.placeBet();
    }

    public int getBalance() {
        return holder.getBalance();
    }

    public String getName() {
        return holder.getName();
    }

    public boolean canSplit() {
        return cards.get(0).getRank() == cards.get(1).getRank();
    }

    public void doubleBet() {
        holder.addBalance(-bet);
        bet *= 2;
    }

    public void payOut(int type) {
        switch (type) {
            case PUSH_PAYOUT -> holder.getBalance();
            case NORMAL_PAYOUT -> holder.addBalance(bet * 2);
        }
    }

    public Card removeCard(int index) {
        return cards.remove(index);
    }

    public Hand splitHand() {
        bet = bet / 2;
        Hand hand = new Hand(holder);
        hand.addCard(cards.remove(1));
        hand.bet = bet;
        return hand;
    }

}