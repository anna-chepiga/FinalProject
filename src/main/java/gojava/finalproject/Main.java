package gojava.finalproject;

import java.io.IOException;
import java.lang.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println(" Dear user!\n" +
                "This program is used for validation a variety of identification numbers to protect against " +
                "accidental errors; and for generation number of new card.\n" +
                "If you need to do this choose VALIDATE or GENERATE or enter OUT for exit:");

        Scanner in = new Scanner(System.in);


        for (; ; ) {
            String choice = in.next();

            if (choice.equals("VALIDATE")) {
                Validate.getParams();
                String cardType = Validate.getCardType();
                PlasticCards cardEnum = Validate.getEnum(cardType);
                Validate.validateOfCard(cardEnum);
                continueProgram();
            } else if (choice.equals("GENERATE")) {
                String numeralsIB = Generate.numeralsIB();
                String cardNumber = Generate.cardNumber();
                int cardAmount = Generate.cardAmount();
                Generate.generateNewCards(numeralsIB, cardNumber, cardAmount);
                continueProgram();
            } else if (choice.equals("OUT")) {
                System.exit(1);
            } else {
                System.out.println("Choose VALIDATE or GENERATE or enter OUT for exit: ");
            }
        }
    }

    public static void continueProgram() {
        System.out.println("\nIf you need to continue use this program, choose VALIDATE or GENERATE\n" +
                "or enter OUT for exit.");
    }
}

