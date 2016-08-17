public class DiscountCard extends Card {
    @Override
    public String getCardType() {
        return "Discount card";
    }

    @Override
    public int getAmountOfNumbers() {
        return 15;
    }
}
