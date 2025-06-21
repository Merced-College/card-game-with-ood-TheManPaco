/**
 * CardGame.java
 * Author: Francisco Vazquez
 * Date: June 20, 2025
 * 
 * This program implements a card game that deals cards to a player,
 * checks for pairs, sorts cards, and provides various game statistics.
 * Enhanced features include:
 * - Card sorting by suit and value
 * - Multiple hand evaluation methods
 * - Game statistics tracking
 * - Better error handling
 */

//package cardGame;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class CardGame {

    private static ArrayList<Card> deckOfCards = new ArrayList<Card>();
    private static ArrayList<Card> playerCards = new ArrayList<Card>();
    // New statistics tracking variables
    private static int gamesPlayed = 0;
    private static int pairsFound = 0;
    private static int cardsDealt = 0;


    public static void main(String[] args) {

        Scanner input = null;
        try {
            input = new Scanner(new File("cards.txt"));
        } catch (FileNotFoundException e) {
            // error
            System.out.println("error");
            e.printStackTrace();
        }

        while(input.hasNext()) {
            String[] fields  = input.nextLine().split(",");
            //	public Card(String cardSuit, String cardName, int cardValue, String cardPicture) {
            Card newCard = new Card(fields[0], fields[1].trim(),
                    Integer.parseInt(fields[2].trim()), fields[3]);
            deckOfCards.add(newCard);	
        }

        shuffle();

        //for(Card c: deckOfCards)
            //System.out.println(c);

        //deal the player 5 cards
        for(int i = 0; i < 5; i++) {
            playerCards.add(deckOfCards.remove(i));
            cardsDealt++;
        }
        
        gamesPlayed++;
        
        System.out.println("Players cards (unsorted):");
        for(Card c: playerCards)
            System.out.println(c);
            
        sortPlayerCards();
        
        System.out.println("\nPlayers cards (sorted):");
        for(Card c: playerCards)
            System.out.println(c);

        boolean hasPair = checkFor2Kind();
        if (hasPair) pairsFound++;
        System.out.println("\nPair found: " + hasPair);
        
        printGameStats();
    }//end main

    public static void shuffle() {

        //shuffling the cards by deleting and reinserting
        for (int i = 0; i < deckOfCards.size(); i++) {
            int index = (int) (Math.random()*deckOfCards.size());
            Card c = deckOfCards.remove(index);
            //System.out.println("c is " + c + ", index is " + index);
            deckOfCards.add(c);
        }
    }

    //check for 2 of a kind in the players hand
    public static boolean checkFor2Kind() {

        int count = 0;
        for(int i = 0; i < playerCards.size() - 1; i++) {
            Card current = playerCards.get(i);
            Card next = playerCards.get(i+1);
            
            for(int j = i+1; j < playerCards.size(); j++) {
                next = playerCards.get(j);
                //System.out.println(" comparing " + current);
                //System.out.println(" to " + next);
                if(current.equals(next))
                    count++;
            }//end of inner for
            if(count == 1)
                return true;

        }//end outer for
        return false;
    }

    /**
     * Sorts the player's cards by suit and then by value
     */
    public static void sortPlayerCards() {
        Collections.sort(playerCards, new Comparator<Card>() {
            @Override
            public int compare(Card c1, Card c2) {
                int suitCompare = c1.getCardSuit().compareTo(c2.getCardSuit());
                if (suitCompare != 0) {
                    return suitCompare;
                }
                return Integer.compare(c1.getCardValue(), c2.getCardValue());
            }
        });
    }

    /**
     * Checks for three of a kind in the player's hand
     * @return true if three of a kind is found, false otherwise
     */
    public static boolean checkFor3Kind() {
        int count;
        for (int i = 0; i < playerCards.size() - 2; i++) {
            count = 1;
            Card current = playerCards.get(i);
            
            for (int j = i + 1; j < playerCards.size(); j++) {
                if (current.equals(playerCards.get(j))) {
                    count++;
                }
            }
            if (count == 3) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if all cards in player's hand are of the same suit (flush)
     * @return true if flush is found, false otherwise
     */
    public static boolean checkForFlush() {
        if (playerCards.isEmpty()) return false;
        String suit = playerCards.get(0).getCardSuit();
        for (Card card : playerCards) {
            if (!card.getCardSuit().equals(suit)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Calculates and returns the total value of cards in player's hand
     * @return total value
     */
    public static int calculateHandValue() {
        int total = 0;
        for (Card card : playerCards) {
            total += card.getCardValue();
        }
        return total;
    }

    /**
     * Prints game statistics
     */
    public static void printGameStats() {
        System.out.println("\n=== Game Statistics ===");
        System.out.println("Games Played: " + gamesPlayed);
        System.out.println("Pairs Found: " + pairsFound);
        System.out.println("Cards Dealt: " + cardsDealt);
        System.out.println("Current Hand Value: " + calculateHandValue());
        if (checkForFlush()) {
            System.out.println("You have a flush!");
        }
        if (checkFor3Kind()) {
            System.out.println("You have three of a kind!");
        }
        System.out.println("====================\n");
    }
}//end class
