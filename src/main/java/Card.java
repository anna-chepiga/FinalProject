public class Card {
    private String cardType;
    private String cardNumber;
    private int sum;
    private int controlNumber;

    public Card(String cardType, String cardNumber, int sum, int controlNumber) {
        this.cardType = cardType;
        this.cardNumber = cardNumber;
        this.sum = sum;
        this.controlNumber = controlNumber;
    }

    @Override
    public String toString() {
        return "The sum of your " + cardType + " with number " + cardNumber +
                " is " + sum + ", the control number is " + controlNumber + ".";
    }
}


