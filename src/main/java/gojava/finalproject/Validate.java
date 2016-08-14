package gojava.finalproject;

import java.util.Scanner;

public class Validate {
    private static Scanner in = new Scanner(System.in);

    public static void getParams() {
        System.out.println(" For validation of card number choose kind of card:\n" +
                "BankCard,\nDiscountCard,\nIMEINumber,\nSocialSecurityCode,\nNumberOfRailwayCarriage");
    }

    public static String getCardType() {
        return in.next();
    }

    public static PlasticCards getEnum(String cardType) {
        PlasticCards[] values = PlasticCards.values();
        for (PlasticCards value : values) {
            if (value.name().equals(cardType)) {
                return PlasticCards.valueOf(cardType);
            }
        }
        return null;
    }

    public static void validateOfCard(PlasticCards card) {
        if (card != null) {
            String cardNumber = getNumberOfCard();
            int numberOfNumeral = cardNumber.length();

            switch (card) {
                case BankCard:
                    if (numberOfNumeral == 16) {
                        getCardData(cardNumber, card);
                    } else {
                        System.out.println("Number of numerals of BankCard must be 16!");
                        validateOfCard(PlasticCards.BankCard);
                    }
                    break;
                case DiscountCard:
                    if (numberOfNumeral == 13 || numberOfNumeral == 15 || numberOfNumeral == 16) {
                        getCardData(cardNumber, card);
                    } else {
                        System.out.println("Number of numerals of DiscountCard must be 13, 15 or 16!");
                        validateOfCard(PlasticCards.DiscountCard);
                    }
                    break;
                case IMEINumber:
                    if (numberOfNumeral == 15) {
                        getCardData(cardNumber, card);
                    } else {
                        System.out.println("Number of numerals of IMEINumber must be 15!");
                        validateOfCard(PlasticCards.IMEINumber);
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
                        validateOfCard(PlasticCards.NumberOfRailwayCarriage);
                    }
                    break;
            }
        } else {
            System.out.println("Enter correct card type!");
            validateOfCard(getEnum(getCardType()));
        }
    }

    private static String getNumberOfCard() {
        System.out.println("Enter number of your card: ");

        for (; ; ) {
            String number = in.next();

            if (!checkDigits(number)) {
                System.out.println("Make sure you enter only numbers!");
            } else {
                return number;
            }
        }
    }

    private static boolean checkDigits(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (!Character.isDigit(input.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    private static void getCardData(String cardNumber, PlasticCards card) {
        int result = LuhnAlgorithm.calculateSum(cardNumber);

        Card newCard = new Card(card.name(), cardNumber);

        if (LuhnAlgorithm.isCardMod10(result)) {
            System.out.println(newCard + " is correct!");
        } else {
            System.out.println(newCard + " isn't correct!");
        }
    }
}
