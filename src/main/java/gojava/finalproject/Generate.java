package gojava.finalproject;

import java.util.ArrayList;
import java.util.Scanner;

public class Generate {
    public static void generateOfCard(){
        System.out.println("For generation new cards enter first SIX number of Issuing Bank: ");

        Scanner in = new Scanner(System.in);

        String bankID = in.next();
        if (bankID.length() != 6) {
            System.out.println("Number of numerals of Issuing Bank must be 6!");
        }

        System.out.println("Enter TEN number of last issued validity bank card. " +
                "If you create new cards, enter TEN zeros: ");
        String initCardNumber = in.next();
        if (initCardNumber.length() != 10) {
            System.out.println("Number of numerals of bank card must be 10!");
        }

        System.out.println("Enter amount of cards for create: ");
        int amountOfCards = in.nextInt();
        if (amountOfCards < 0 ) {
            System.out.println("Amount of cards must be positive number!");
        }

        ArrayList<String> result = LuhnAlgorithm.generateCards(bankID, initCardNumber, amountOfCards);
        System.out.println("New number of card: " + result);

//        проверка на колличество заказанных и возможных карт
//        if (amountOfCards !=          ) {

//        }
    }

}
