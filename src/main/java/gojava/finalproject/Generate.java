package gojava.finalproject;

import java.util.ArrayList;
import java.util.Scanner;

public class Generate {
    private static Scanner in = new Scanner(System.in);

    public static String numeralsIB() {
        System.out.println("For generation new cards enter first SIX numerals of Issuing Bank: ");

        String bankID = in.next();
        if (bankID.length() != 6) {
            System.out.println("Number of numerals of Issuing Bank must be 6!");
            numeralsIB();
        }
        return bankID;
    }

    public static String cardNumber() {
        System.out.println("Enter TEN number of last issued bank card. " +
                "If you create new cards, enter TEN zeros: ");

        String initCardNumber = in.next();
        if (initCardNumber.length() != 10) {
            System.out.println("Number of numerals of bank card must be 10!");
            cardNumber();
        }
        return initCardNumber;
    }

    public static int cardAmount() {
        System.out.println("Enter amount of cards you need to generate/need to have: ");

        int amountOfCards = in.nextInt();
        if (amountOfCards < 0) {
            System.out.println("Amount of cards must be positive number!");
            cardAmount();
        }
        return amountOfCards;
    }

    public static void generateNewCards(String bankID, String initCardNumber, int amountOfCards) {
        ArrayList<String> result = LuhnAlgorithm.generateCards(bankID, initCardNumber, amountOfCards);

        System.out.println("New numbers of cards: " + result);
        if (result.size() < amountOfCards) {
            System.out.println("It was not possible to generate " + amountOfCards + " cards. " +
                    "There were no valid combinations for the amount of cards you need. " +
                    "New possible numbers of cards: " + result);
        }
    }
}


