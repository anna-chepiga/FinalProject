package gojava.finalproject;

import java.io.IOException;
import java.lang.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println(" Dear user!\n " +
                "This program validates a variety of identification number to protect against accidental errors.\n " +
                "If you need to do this, please, choose kind of card:\n" +
                "BankCard,\nDiscountCard,\nIMEINumber,\nSocialSecurityCode,\nNumberOfRailwayCarriage,\n" +
                " or enter OUT for exit:");

        for (; ; ) {
            try {
                Scanner in = new Scanner(System.in);
                String kindOfCard = in.next();

                PlasticCards card = PlasticCards.valueOf(kindOfCard);

                String cardNumber;
                int numberOfNumeral;

                switch (card) {
                    case BankCard:
                        getNumberOfCard();

                        cardNumber = Long.toString(in.nextLong());
                        numberOfNumeral = cardNumber.length();

                        if (numberOfNumeral == 16) {
                            getCardData(cardNumber, card);
                        } else {
                            System.out.println("Number of numerals of BankCard must be 16!");
                        }
                        break;
                    case DiscountCard:
                        getNumberOfCard();

                        cardNumber = Long.toString(in.nextLong());
                        numberOfNumeral = cardNumber.length();

                        if (numberOfNumeral == 13 || numberOfNumeral == 15 || numberOfNumeral == 16) {
                            getCardData(cardNumber, card);
                        } else {
                            System.out.println("Number of numerals of DiscountCard must be 13, 15 or 16!");
                        }
                        break;
                    case IMEINumber:
                        getNumberOfCard();

                        cardNumber = Long.toString(in.nextLong());
                        numberOfNumeral = cardNumber.length();

                        if (numberOfNumeral == 15) {
                            getCardData(cardNumber, card);
                        } else {
                            System.out.println("Number of numerals of IMEINumber must be 15!");
                        }
                        break;
                    case SocialSecurityCode:
                        getNumberOfCard();

                        cardNumber = Long.toString(in.nextLong());
                        numberOfNumeral = cardNumber.length();

                        if (numberOfNumeral == 9) {
                            getCardData(cardNumber, card);
                        } else {
                            System.out.println("Number of numerals of SocialSecurityCode must be 9!");
                        }
                        break;
                    case NumberOfRailwayCarriage:
                        getNumberOfCard();

                        cardNumber = Long.toString(in.nextLong());
                        numberOfNumeral = cardNumber.length();

                        if (numberOfNumeral == 8) {
                            getCardData(cardNumber, card);
                        } else {
                            System.out.println("Number of numerals of NumberOfRailwayCarriage must be 8!");
                        }
                        break;
                    case OUT:
                        System.exit(1);
                        break;
                }

                System.out.println("\nIf you need to calculate number of another card, please, select kind of card\n" +
                        "or enter OUT for exit.");
            } catch (IllegalArgumentException ex) {
                System.out.println("[Error] You enter wrong information! Please, choose kind of card!");
            } catch (InputMismatchException ex) {
                System.out.println("[Error] Please, select kind of card again and enter numerals in number of card!");
            }
        }
    }

    private static void getNumberOfCard() {
        System.out.println("Enter number of your card: ");
    }

    private static void getCardData(String cardNumber, PlasticCards card) {
        int result = LuhnAlgorithm.getSum(cardNumber);
        int controlNumber = LuhnAlgorithm.getControlNumber(result);

        Card newCard = new Card(card.name(), cardNumber, result, controlNumber);

        if (controlNumber == 0) {
            System.out.println("The number is correct:\n" + newCard);
        } else {
            System.out.println("The number isn't correct:\n" + newCard);
        }
    }
}