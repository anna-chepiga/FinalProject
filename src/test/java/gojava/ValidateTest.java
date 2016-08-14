package gojava;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import static org.junit.Assert.*;

public class ValidateTest {
    @Rule
    public final TextFromStandardInputStream systemInMock
            = TextFromStandardInputStream.emptyStandardInputStream();

    @Rule
    public final SystemOutRule out = new SystemOutRule().enableLog();

    @Test
    public void getEnum() throws Exception {
        PlasticCards card = PlasticCards.BankCard;
        assertEquals(card, Validate.getEnum("BankCard"));

        card = PlasticCards.DiscountCard;
        assertEquals(card, Validate.getEnum("DiscountCard"));

        card = PlasticCards.IMEINumber;
        assertEquals(card, Validate.getEnum("IMEINumber"));

        card = PlasticCards.SocialSecurityCode;
        assertEquals(card, Validate.getEnum("SocialSecurityCode"));

        card = PlasticCards.NumberOfRailwayCarriage;
        assertEquals(card, Validate.getEnum("NumberOfRailwayCarriage"));

        assertNull(Validate.getEnum("blahblahblah"));
    }

    @Test
    public void validateOfCard() throws Exception {
        systemInMock.provideLines("1111222233334444");
        Validate.validateOfCard(PlasticCards.DiscountCard);
        String expected = "Enter number of your card: " + (char) 0x0D + (char) 0x0A + "DiscountCard with number 1111222233334444 is correct!\n";

        assertEquals(expected, out.getLog());
    }
}