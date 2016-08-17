public class BankCard extends Card {
    public BankCard(String cardNumber) {
        super.cardNumber = cardNumber;
    }

    public BankCard() {
    }

    @Override
    public String getCardType() {
        return "Bank card";
    }

    @Override
    public int getAmountOfNumbers() {
        return 16;
    }

    @Override
    public String toString() {
        return super.cardNumber;
    }
}