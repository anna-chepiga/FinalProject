import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Dear user!\n " +
                "This program validates a variety of identification number to protect against accidental errors.\n " +
                "If you need to do this, please, choose kind of card:\n" +
                "BankCard,\n DiscountCard,\n IMEINumber,\n SocialSecurityCode,\n NumberOfRailwayCarriage,\n" +
                "or enter OUT for exit: ");

        for (; ; ) {
            try {
                Scanner in = new Scanner(System.in);
                String kindOfCard = in.next();

                Enum.PlasticCards card = Enum.PlasticCards.valueOf(kindOfCard);

                String data;
                int numberOfNumeral;

                switch (card) {
                    case BankCard:
                        data = data(in);
                        numberOfNumeral = data.length();

                        if (numberOfNumeral == 16) {
                            int result = LuhnAlgorithm.getSum(data);
                            int controlNumber = LuhnAlgorithm.getControlNumber(result);

                            System.out.println("Control number of numerals of your card: " + controlNumber);
                        } else {
                            System.out.println("Number of numerals of BankCard must be 16!");
                        }
                        break;

                    case DiscountCard:
                        data = data(in);
                        numberOfNumeral = data.length();

                        if (numberOfNumeral == 13 || numberOfNumeral == 15 || numberOfNumeral == 16) {
                            int result = LuhnAlgorithm.getSum(data);
                            int controlNumber = LuhnAlgorithm.getControlNumber(result);

                            System.out.println("Control number of numerals of your card: " + controlNumber);
                        } else {
                            System.out.println("You enter wrong number of card! Try again");
                        }
                        break;

                    case IMEINumber:
                        data = data(in);
                        numberOfNumeral = data.length();

                        if (numberOfNumeral == 15) {
                            int result = LuhnAlgorithm.getSum(data);
                            int controlNumber = LuhnAlgorithm.getControlNumber(result);

                            System.out.println("Control number of numerals of your card: " + controlNumber);
                        } else {
                            System.out.println("Number of numerals of IMEINumber must be 15!");
                        }
                        break;

                    case SocialSecurityCode:
                        data = data(in);
                        numberOfNumeral = data.length();

                        if (numberOfNumeral == 9) {
                            int result = LuhnAlgorithm.getSum(data);
                            int controlNumber = LuhnAlgorithm.getControlNumber(result);

                            System.out.println("Control number of numerals of your card: " + controlNumber);
                        } else {
                            System.out.println("Number of numerals of SocialSecurityCode must be 9!");
                        }
                        break;

                    case NumberOfRailwayCarriage:
                        data = data(in);
                        numberOfNumeral = data.length();

                        if (numberOfNumeral == 8) {
                            int result = LuhnAlgorithm.getSum(data);
                            int controlNumber = LuhnAlgorithm.getControlNumber(result);

                            System.out.println("Control number of numerals of your card: " + controlNumber);
                        } else {
                            System.out.println("Number of numerals of NumberOfRailwayCarriage must be 8!");
                        }
                        break;

                    case OUT:
                        System.exit(1);
                        break;
                }
                System.out.println("If you need to calculate number of another card, please, select kind of card\n" +
                        " or enter OUT for exit.");

            } catch (IllegalArgumentException ex) {
                System.out.println("[Error] You enter wrong information! Please, choose kind of card!");
            } catch (InputMismatchException ex) {
                System.out.println("[Error] You enter wrong number of card! Please, enter numerals!");
            }
        }
    }

    private static String data(Scanner in) {
        System.out.println("Enter number of your card: ");
        return in.next();
    }
}
