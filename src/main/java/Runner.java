import java.util.ArrayList;

public class Runner {
    public static void main(String[] args) {
        System.out.println(" Dear user!\n" +
                "This program is used for validating a variety of identification numbers to protect against " +
                "accidental errors; and for generation number of new card.\n" +
                "If you need to do this choose VALIDATE or GENERATE or enter OUT for exit:");

        for (; ; ) {
            String choice = ScannerUtils.readString();

            switch (choice) {
                case "VALIDATE":
                    printValidationParams();
                    validate();
                    continueProgram();
                    break;
                case "GENERATE":
                    printGenerationParams();
                    generate();
                    continueProgram();
                    break;
                case "OUT":
                    System.exit(1);
                default:
                    System.out.println("Choose VALIDATE or GENERATE or enter OUT for exit:");
                    break;
            }
        }
    }

    private static void printValidationParams() {
        System.out.println("For validation of card number choose kind of card:\n" +
                "BankCard,\nDiscountCard,\nIMEINumber,\nSocialSecurityCode,\nNumberOfRailwayCarriage");
    }

    private static void validate() {
        CardUtils cardUtils = new CardUtils();
        Card card = cardUtils.createCard(ScannerUtils.readString());

        System.out.println("Enter number of your card");
        String cardNumber = cardUtils.getNumberOfCard(card);

        card.setCardNumber(cardNumber);

        int sum = LuhnAlgorithm.calculateSum(cardNumber);
        boolean isMod10 = LuhnAlgorithm.isCardMod10(sum);

        System.out.println(isMod10 ? card.getCardInfo() + " is correct" :
                card.getCardInfo() + " is not correct");
    }

    private static void printGenerationParams() {
        System.out.println("For generating new cards you would need to enter 6 digits of unique bank ID " +
                "and 10 numerals of last issued card.\nIf you need to create new cards from scratch, " +
                "enter 10 zeros.");
    }

    private static void generate() {
        CardUtils cardUtils = new CardUtils();

        System.out.println("Enter 6 numerals of bank ID");
        String bankID = cardUtils.getBankID();

        System.out.println("Enter 10 numerals of last issued card.");
        String issuedCard = cardUtils.getIssuedCard();

        System.out.println("Enter amount of cards you'd like to generate");
        int amount = cardUtils.getAmount();

        ArrayList<String> validNumbers = LuhnAlgorithm.generateCards(bankID, issuedCard, amount);
        String validCards = cardUtils.generateCards(validNumbers, amount);

        System.out.println(validCards);
    }

    private static void continueProgram() {
        System.out.println("\nIf you need to continue use this program, choose VALIDATE or GENERATE\n" +
                "or enter OUT for exit.");
    }
}