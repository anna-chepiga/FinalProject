package gojava.finalproject;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

public class LuhnAlgorithmTest {

    @Test
    public void getSumEvenNumber() throws Exception {
        String evenNumber = "1111222233334444";
        int actual = LuhnAlgorithm.getSum(evenNumber);
        int expected = 60;

        assertEquals(expected, actual);
    }

    @Test
    public void getSumOddNumber() throws Exception {
        String oddNumber = "111122223333444";
        int actual = LuhnAlgorithm.getSum(oddNumber);
        int expected = 52;

        assertEquals(expected, actual);
    }

    @Ignore("situation not possible because of code semantic in Main class")
    @Test
    public void getSumNoNumber() throws Exception {
        String noNumber = "";
        int actual = LuhnAlgorithm.getSum(noNumber);
        int expected = 0;

        assertEquals(expected, actual);
    }

    @Ignore("situation not possible because of InputMismatchException in Main class ")
    @Test
    public void getSumNotNumerals() throws Exception {
        String noNumerals = "kk-oll;!kdya";
        int actual = LuhnAlgorithm.getSum(noNumerals);
        int expected = 237;

        assertEquals(expected, actual);

    }

    @Test
    public void getControlNumberZero() throws Exception {
        int actual = LuhnAlgorithm.getControlNumber(40);
        int expected = 0;

        assertEquals(expected, actual);
    }

    @Test
    public void getControlNumberNotZero() throws Exception {
        int actual = LuhnAlgorithm.getControlNumber(78);
        int expected = 8;

        assertEquals(expected, actual);
    }
}