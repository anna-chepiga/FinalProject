package ua.goit.finalproject.cards;

import org.junit.Test;
import ua.goit.finalproject.exceptions.WrongAmountException;

import static org.junit.Assert.*;

public class CardTest {
   private Card card = new Bank();

   @Test(expected = WrongAmountException.class)
   public void testCheckAmount() throws Exception {
      card.checkAmount(10);
   }

   @Test
   public void testIsCardMod10() throws Exception {
      assertTrue(card.isCardMod10(50));
      assertFalse(card.isCardMod10(55));
   }

   @Test
   public void testGetCardInfo() throws Exception {
      card.setCardNumber("1111222233334444");
      String expected = "Your Bank Card with number 1111222233334444";

      assertEquals(expected, card.getCardInfo());
   }
}