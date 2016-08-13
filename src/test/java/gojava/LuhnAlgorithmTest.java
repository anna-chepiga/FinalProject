package gojava;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class LuhnAlgorithmTest {
    @Test
    public void calculateSumEvenNumber() throws Exception {
        String evenNumber = "1111222233334444";
        int actual = LuhnAlgorithm.calculateSum(evenNumber);
        int expected = 60;

        assertEquals(expected, actual);
    }

    @Test
    public void calculateSumOddNumber() throws Exception {
        String oddNumber = "111122223333444";
        int actual = LuhnAlgorithm.calculateSum(oddNumber);
        int expected = 56;

        assertEquals(expected, actual);
    }

    @Test
    public void isCardMod10True() throws Exception {
        int cardSum = 50;
        boolean actual = LuhnAlgorithm.isCardMod10(cardSum);

        assertTrue(actual);
    }

    @Test
    public void isCardMod10False() throws Exception {
        int cardSum = 55;
        boolean actual = LuhnAlgorithm.isCardMod10(cardSum);

        assertFalse(actual);
    }

    @Test
    public void generateCardsOK() throws Exception {
        ArrayList<String> actual = LuhnAlgorithm.generateCards("555555", "0000000000", 3);
        ArrayList<String> expected = new ArrayList<>(Arrays.asList("5555550000000002", "5555550000000010", "5555550000000028"));

        assertEquals(expected, actual);
    }

    @Test
    public void generateCardsNull() throws Exception {
        ArrayList<String> actual = LuhnAlgorithm.generateCards("555555", "9999999999", 3);
        assertNull(actual);
    }
}