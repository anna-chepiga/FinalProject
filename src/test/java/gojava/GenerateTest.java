package gojava;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;


import static org.junit.Assert.*;

public class GenerateTest {
    @Rule
    public final TextFromStandardInputStream systemInMock
            = TextFromStandardInputStream.emptyStandardInputStream();

    @Rule
    public final SystemOutRule out = new SystemOutRule().enableLog();


    @Test
    public void getNumeralsIssuingBank() throws Exception {
        systemInMock.provideLines("555555");
        String actual = Generate.getNumeralsIssuingBank();

        assertEquals("555555", actual);
    }

    @Test
    public void getCardNumber() throws Exception {
        systemInMock.provideLines("1122334455");
        String actual = Generate.getCardNumber();
        String expected = "1122334455";

        assertEquals(expected, actual);
    }

    @Test
    public void getCardAmount() throws Exception {
        systemInMock.provideLines("5");
        int actual = Generate.getCardAmount();
        int expected = 5;

        assertEquals(expected, actual);
    }

    @Test
    public void checkDigitsTrue() throws Exception {
        boolean expected = Generate.checkDigits("559988");

        assertTrue(expected);
    }

    @Test
    public void checkDigitsFalse() throws Exception {
        boolean expected = Generate.checkDigits("55pp,,");

        assertFalse(expected);
    }

    @Test
    public void generateNewCardsOK() throws Exception {
        String ok = "New numbers of cards: [5555551111111118, 5555551111111126, 5555551111111134]";
        systemInMock.provideLines(ok);
        Generate.generateNewCards("555555", "1111111111", 3);

        assertEquals(ok, out.getLog().trim());
        out.clearLog();

        String notEnough = "It was not possible to generate 10 cards. " +
                "There were no valid combinations for the amount of cards you need. " +
                "New possible numbers of cards: [5555559999999991]";

        systemInMock.provideLines(notEnough);
        out.clearLog();

        Generate.generateNewCards("555555", "9999999985", 10);
        assertEquals(notEnough, out.getLog().trim());
    }
}