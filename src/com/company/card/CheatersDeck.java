package com.company.card;

import com.company.Console;
import com.company.Deck;

import java.util.Arrays;
import java.util.Scanner;

public class CheatersDeck implements Deck {
//    private Card chosenCard;
//    private Scanner scanner = new Scanner(System.in);
    public final String[] SUITS = {"Diamond", "Spade", "Heart", "Club"
    };
    public final int [] FACE_VALUE = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13
    };

    public void shuffle() {}

//
//    public Card deal() {
//
//        System.out.println(Arrays.toString(SUITS));
//        System.out.println("Which suit? (1-4)");
//        try {
//            int suitIndex = Integer.parseInt(scanner.nextLine()) - 1;
//            System.out.println(Arrays.toString(FACE_VALUE));
//            System.out.println("Which value? (1-13)");
//            int valueIndex = Integer.parseInt(scanner.nextLine()) - 1;
//            chosenCard = new Card(SUITS[suitIndex], FACE_VALUE[valueIndex]);
//        } catch (Exception e) {
//            System.out.println("Invalid choice! SELECT again: ");
//        }
//        return chosenCard;
//    }

    @Override
    public Card deal() {
        int faceValue = Console.getInt(1, 13, "enter number 1-13", "invalid entry");
        int suit = Console.getInt(1, 4, "1. \u2664 | 2. \u2665 | 3. \u2666 | 4. \u2667", "Invalid entry");
        return new Card(SUITS[suit - 1], faceValue);
    }
}
