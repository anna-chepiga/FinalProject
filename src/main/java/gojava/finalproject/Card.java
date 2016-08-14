package gojava.finalproject;

public class Card {
    private String cardType;
    private String cardNumber;


    public Card(String cardType, String cardNumber) {
        this.cardType = cardType;
        this.cardNumber = cardNumber;
    }

    @Override
    public String toString() {
        return cardType + " with number " + cardNumber;
    }
}