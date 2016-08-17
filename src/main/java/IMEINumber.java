public class IMEINumber extends Card {
    @Override
    public String getCardType() {
        return "IMEI number";
    }

    @Override
    public int getAmountOfNumbers() {
        return 15;
    }
}
