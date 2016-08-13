package gojava.finalproject;

import java.util.Scanner;

public class Validate {
    public static void validateOfCard() {
        System.out.println(" For validation number of card choose kind of card:\n" +
                "BankCard,\nDiscountCard,\nIMEINumber,\nSocialSecurityCode,\nNumberOfRailwayCarriage");

        for (; ; ) {
            Scanner in = new Scanner(System.in);
            String kindOfCard = in.next();

            PlasticCards card = PlasticCards.valueOf(kindOfCard);

            String cardNumber;
            int numberOfNumeral;

            getNumberOfCard();

            cardNumber = Long.toString(in.nextLong());
            numberOfNumeral = cardNumber.length();

            switch (card) {
                case BankCard:
                    if (numberOfNumeral == 16) {
                        getCardData(cardNumber, card);
                    } else {
                        System.out.println("Number of numerals of BankCard must be 16!");
                    }
                    break;
                case DiscountCard:
                    if (numberOfNumeral == 13 || numberOfNumeral == 15 || numberOfNumeral == 16) {
                        getCardData(cardNumber, card);
                    } else {
                        System.out.println("Number of numerals of DiscountCard must be 13, 15 or 16!");
                    }
                    break;
                case IMEINumber:
                    if (numberOfNumeral == 15) {
                        getCardData(cardNumber, card);
                    } else {
                        System.out.println("Number of numerals of IMEINumber must be 15!");
                    }
                    break;
                case SocialSecurityCode:
                    if (numberOfNumeral == 9) {
                        getCardData(cardNumber, card);
                    } else {
                        System.out.println("Number of numerals of SocialSecurityCode must be 9!");
                    }
                    break;
                case NumberOfRailwayCarriage:
                    if (numberOfNumeral == 8) {
                        getCardData(cardNumber, card);
                    } else {
                        System.out.println("Number of numerals of NumberOfRailwayCarriage must be 8!");
                    }
                    break;
            }

            System.out.println("\nIf you need to calculate number of another card, please, select kind of card: ");
        }
    }

    private static void getNumberOfCard() {
        System.out.println("Enter number of your card: ");
    }

    private static void getCardData(String cardNumber, PlasticCards card) {
        int result = LuhnAlgorithm.calculateSum(cardNumber);

        Card newCard = new Card(card.name(), cardNumber, result);

        // в классе Card toString() поменять на
        // "The number of your " + cardType + " with number " + cardNumber +" is " + sum;
        // if работает как-то странно
        if (LuhnAlgorithm.isCardMod10(0)) {
            System.out.println(newCard + " is correct!");
        } else  {
            System.out.println(newCard + " card isn't correct!");
        }
    }
}
