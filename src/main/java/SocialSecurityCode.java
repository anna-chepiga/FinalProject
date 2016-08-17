public class SocialSecurityCode extends Card {
    @Override
    public String getCardType() {
        return "Social security code";
    }

    @Override
    public int getAmountOfNumbers() {
        return 9;
    }
}
