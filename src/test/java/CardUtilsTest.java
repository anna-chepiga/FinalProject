import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class CardUtilsTest {
    private CardUtils utils = new CardUtils();

    @Test
    public void selectCard() throws Exception {
        assertNotNull(utils.selectCard("BankCard"));
        assertNotNull(utils.selectCard("DiscountCard"));
        assertNotNull(utils.selectCard("IMEINumber"));
        assertNotNull(utils.selectCard("SocialSecurityCode"));
        assertNotNull(utils.selectCard("NumberOfRailwayCarriage"));
        assertNull(utils.selectCard("sdlfdsklf"));
    }

    @Test
    public void checkAmount() throws Exception {
        Card card = new BankCard();
        assertTrue(utils.checkAmount("1111222233334444", card));
        assertFalse(utils.checkAmount("111122223334444", card));

        card = new DiscountCard();
        assertTrue(utils.checkAmount("111222333444555", card));
        assertFalse(utils.checkAmount("11122233344455", card));

        card = new IMEINumber();
        assertTrue(utils.checkAmount("111222333444555", card));
        assertFalse(utils.checkAmount("1112223334445555", card));

        card = new NumberOfRailwayCarriage();
        assertTrue(utils.checkAmount("11112222", card));
        assertFalse(utils.checkAmount("111122223", card));

        card = new SocialSecurityCode();
        assertTrue(utils.checkAmount("111222333", card));
        assertFalse(utils.checkAmount("1112223336", card));
    }

    @Test
    public void checkDigits() throws Exception {
        assertTrue(utils.checkDigits("123456789"));
        assertFalse(utils.checkDigits("ggjjuu--,,"));
    }

    @Test
    public void generateCards() throws Exception {
        ArrayList<String> cardNumbers = new ArrayList<>(Arrays.asList("1111119999999982", "1111119999999990"));

        String actual = utils.generateCards(cardNumbers, 5);
        String expected = "It was not possible to generate 5 cards.\n" +
                "There was not enough combinations for this amount.\n" +
                "New possible numbers of cards are:\n" +
                "[1111119999999982, 1111119999999990]";

        assertEquals(expected, actual);

        actual = utils.generateCards(cardNumbers, 2);
        expected = "New valid cards are [1111119999999982, 1111119999999990]";

        assertEquals(expected, actual);
    }
}