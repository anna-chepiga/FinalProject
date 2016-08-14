package gojava.finalproject;

import java.util.ArrayList;
import java.util.Scanner;

public class Generate {
    private static Scanner in = new Scanner(System.in);

    public static String getNumeralsIssuingBank() {
        System.out.println("For generation new cards enter first SIX numerals of Issuing Bank: ");

        for (; ; ) {
            String bankID = in.next();
            if (bankID.length() != 6 | !checkDigits(bankID)) {
                System.out.println("Please make sure you enter 6 numerals and try again!");
            } else {
                return bankID;
            }
        }
    }

    public static String getCardNumber() {
        System.out.println("Enter TEN number of last issued bank card. " +
                "If you create new cards, enter TEN zeros: ");

        for (; ; ) {
            String initCardNumber = in.next();
            if (initCardNumber.length() != 10 | !checkDigits(initCardNumber)) {
                System.out.println("Please make sure you enter 10 numerals and try again!");
            } else {
                return initCardNumber;
            }
        }
    }

    public static int getCardAmount() {
        System.out.println("Enter amount of cards you need to generate/need to have: ");

        for (; ; ) {
            int amount = in.nextInt();
            if (amount < 0) {
                System.out.println("Amount should be a positive number! Try again!");
            } else {
                return amount;
            }
        }
    }

    public static boolean checkDigits(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (!Character.isDigit(input.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static void generateNewCards(String bankID, String initCardNumber, int amountOfCards) {
        ArrayList<String> result = LuhnAlgorithm.generateCards(bankID, initCardNumber, amountOfCards);

        if (result.size() == amountOfCards) {
            System.out.println("New numbers of cards: " + result);
        } else {
            System.out.println("It was not possible to generate " + amountOfCards + " cards. " +
                    "There were no valid combinations for the amount of cards you need. " +
                    "New possible numbers of cards: " + result);
        }
    }
}


