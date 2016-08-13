package gojava.finalproject;

import java.io.IOException;
import java.lang.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    private static Validate validate = new Validate();
    private static Generate generate = new Generate();

    public static void main(String[] args) throws IOException {
        System.out.println(" Dear user!\n" +
                "This program used for validation a variety of identification number to protect against " +
                "accidental errors and for generation number of new card.\n" +
                "If you need to do this choose VALIDATE or GENERATE or enter OUT for exit:");

        try {
            Scanner choice = new Scanner(System.in);

            if (choice.equals("VALIDATE")) {
                validate.validateOfCard();
            } else if (choice.equals("GENERATE")) {
                generate.generateOfCard();
            } else if (choice.equals("OUT")) {
                System.exit(1);
            }
        } catch (IllegalArgumentException ex) {
            System.out.println("[Error] You enter wrong information! Please, choose kind of card!");
        } catch (InputMismatchException ex) {
            System.out.println("[Error] Please, select kind of card again and enter numerals in number of card!");
        }
    }
}

