package com.company.card;

import com.company.Deck;

import java.util.Arrays;
import java.util.Scanner;

public class CheatersDeck implements Deck {
    private Card chosenCard;
    private Scanner scanner = new Scanner(System.in);
    public final String[] SUITS = {"Diamond", "Spade", "Heart", "Club"
    };
    public final String[] FACE_VALUE = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"
    };

    public void shuffle() {}

    public void printDeck() {

    }

    public Card deal() {

        System.out.println(Arrays.toString(SUITS));
        System.out.println("Which suit? (1-4)");
        try {
            int suitIndex = Integer.parseInt(scanner.nextLine()) - 1;
            System.out.println(Arrays.toString(FACE_VALUE));
            System.out.println("Which value? (1-13)");
            int valueIndex = Integer.parseInt(scanner.nextLine()) - 1;
            chosenCard = new Card(SUITS[suitIndex], FACE_VALUE[valueIndex]);
        } catch (Exception e) {
            System.out.println("Invalid choice! SELECT again: ");
        }
        return chosenCard;
    }
}
