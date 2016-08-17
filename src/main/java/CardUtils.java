import java.util.ArrayList;

public class CardUtils {
    public Card selectCard(String cardType) {
        switch (cardType) {
            case "BankCard":
                return new BankCard();
            case "DiscountCard":
                return new DiscountCard();
            case "IMEINumber":
                return new IMEINumber();
            case "SocialSecurityCode":
                return new SocialSecurityCode();
            case "NumberOfRailwayCarriage":
                return new NumberOfRailwayCarriage();
            default:
                return null;
        }
    }

    public Card createCard(String cardType) {
        Card card;

        for (; ; ) {
            card = selectCard(cardType);
            if (card == null) {
                System.out.println("Enter correct card type!");
                cardType = ScannerUtils.readString();
            } else return card;
        }
    }

    public String getNumberOfCard(Card card) {
        String number;
        boolean amount;

        for (; ; ) {
            number = ScannerUtils.readString();
            amount = checkAmount(number, card);

            if (!checkDigits(number)) {
                System.out.println("Make sure you enter only numbers");
            } else if (!amount) {
                System.out.println(card.checkAmountOfNumbers());
            } else
                return number;
        }
    }

    public String getBankID() {
        String bankID;

        for (; ; ) {
            bankID = ScannerUtils.readString();

            if (!checkDigits(bankID) | bankID.length() != 6) {
                System.out.println("Make sure you enter 6 numerals");
            } else
                return bankID;
        }
    }

    public String getIssuedCard() {
        String issuedCard;

        for (; ; ) {
            issuedCard = ScannerUtils.readString();

            if (!checkDigits(issuedCard) | issuedCard.length() != 10) {
                System.out.println("Make sure you enter 10 numerals");
            } else
                return issuedCard;
        }

    }

    public boolean checkDigits(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (!Character.isDigit(input.charAt(i))) {
                return false;
            }
        }

        return true;
    }

    public boolean checkAmount(String number, Card card) {
        return number.length() == card.getAmountOfNumbers();
    }

    public int getAmount() {
        int amount;

        for (; ; ) {
            amount = ScannerUtils.readNumber();
            if (amount <= 0) {
                System.out.println("Amount should be a positive number");
            } else
                return amount;
        }
    }

    public String generateCards(ArrayList<String> validNumbers, int amount) {
        ArrayList<Card> validCards = new ArrayList<>();

        for (String cardNumber : validNumbers) {
            validCards.add(new BankCard(cardNumber));
        }

        //ArrayList<Card> validCards = cardNumbers.stream().map(BankCard::new).collect(Collectors.toCollection(ArrayList::new));

        if (validCards.size() == amount) {
            return "New valid cards are " + validCards.toString();
        } else
            return "It was not possible to generate " + amount + " cards.\n" +
                    "There was not enough combinations for this amount.\n" +
                    "New possible numbers of cards are:\n" + validCards.toString();
    }
}