public abstract class Card {
    String cardNumber;

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public abstract String getCardType();

    public abstract int getAmountOfNumbers();

    public String checkAmountOfNumbers() {
        return getCardType() + " should contain " + getAmountOfNumbers() + " numerals.";
    }

    public String getCardInfo() {
        return "Your " + getCardType() + " with number " + getCardNumber();
    }
}