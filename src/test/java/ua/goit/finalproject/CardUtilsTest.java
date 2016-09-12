package ua.goit.finalproject;

import org.junit.Test;
import ua.goit.finalproject.exceptions.WrongAmountException;
import ua.goit.finalproject.exceptions.WrongCardNumberException;
import ua.goit.finalproject.exceptions.WrongCardTypeException;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class CardUtilsTest {
   private CardUtils utils = new CardUtils();

   @Test
   public void testSelectCard() throws Exception {
      assertNotNull(utils.selectCard("Bank"));
      assertNotNull(utils.selectCard("Discount"));
      assertNotNull(utils.selectCard("IMEI"));
      assertNotNull(utils.selectCard("SSC"));
      assertNotNull(utils.selectCard("Railway"));
   }

   @Test(expected = WrongCardTypeException.class)
   public void testSelectCardException() throws Exception {
      utils.selectCard("asdfasdf");
   }

   @Test(expected = WrongCardNumberException.class)
   public void testCheckBankID() throws Exception {
      utils.checkBankID("55447722");
   }

   @Test(expected = WrongCardNumberException.class)
   public void testCheckIssuedCard() throws Exception {
      utils.checkIssuedCard("555");
   }

   @Test(expected = WrongCardNumberException.class)
   public void testCheckDigits() throws Exception {
      utils.checkDigits("hello");
   }

   @Test(expected = WrongAmountException.class)
   public void testCheckAmount() throws Exception {
      utils.checkAmount(0);
      utils.checkAmount(-5);
   }

   @Test
   public void testGenerateCards() throws Exception {
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