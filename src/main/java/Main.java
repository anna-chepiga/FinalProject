import java.io.IOException;
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

                Enum.PlasticCard card = Enum.PlasticCard.valueOf(kindOfCard);

                String cardNumber;
                int numberOfNumeral;

                switch (card) {
                    case BankCard:
                        cardNumber = getData(in);
                        numberOfNumeral = cardNumber.length();

                        if (numberOfNumeral == 16) {
                            calculate(cardNumber);
                        } else {
                            System.out.println("Number of numerals of BankCard must be 16!");
                        }
                        break;

                    case DiscountCard:
                        cardNumber = getData(in);
                        numberOfNumeral = cardNumber.length();

                        if (numberOfNumeral == 13 || numberOfNumeral == 15 || numberOfNumeral == 16) {
                            calculate(cardNumber);
                        } else {
                            System.out.println("Number of numerals of DiscountCard must be 13, 15 or 16!");
                        }
                        break;

                    case IMEINumber:
                        cardNumber = getData(in);
                        numberOfNumeral = cardNumber.length();

                        if (numberOfNumeral == 15) {
                            calculate(cardNumber);
                        } else {
                            System.out.println("Number of numerals of IMEINumber must be 15!");
                        }
                        break;

                    case SocialSecurityCode:
                        cardNumber = getData(in);
                        numberOfNumeral = cardNumber.length();

                        if (numberOfNumeral == 9) {
                            calculate(cardNumber);
                        } else {
                            System.out.println("Number of numerals of SocialSecurityCode must be 9!");
                        }
                        break;

                    case NumberOfRailwayCarriage:
                        cardNumber = getData(in);
                        numberOfNumeral = cardNumber.length();

                        if (numberOfNumeral == 8) {
                            calculate(cardNumber);
                        } else {
                            System.out.println("Number of numerals of NumberOfRailwayCarriage must be 8!");
                        }
                        break;

                    case OUT:
                        System.exit(1);
                        break;
                }
                System.out.println("If you need to calculate number of another card, please, select kind of card\n" +
                        "or enter OUT for exit.");

            } catch (IllegalArgumentException ex) {
                System.out.println("[Error] You enter wrong information! Please, choose kind of card!");
            } catch (InputMismatchException ex) {
                System.out.println("[Error] You enter wrong number of card! Please, enter numerals!");
            }
        }
    }

    private static String getData(Scanner in) {
        System.out.println("Enter number of your card: ");
        return Long.toString(in.nextLong());
    }

    private static void calculate(String data) {
        int result = LuhnAlgorithm.getSum(data);
        int controlNumber = LuhnAlgorithm.getControlNumber(result);

        if (controlNumber == 0) {
            System.out.println("Number of card is correct!");
        } else {
            System.out.println("Control sum of numerals of your card: " + result + ".\n" +
                    "Control number of numerals of your card: " + controlNumber + ".");
        }
    }
}
