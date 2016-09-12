package ua.goit.finalproject;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class LuhnAlgorithmTest {
   @Test
   public void testCalculateSumEvenNumber() throws Exception {
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
   public void testGenerateCardsOK() throws Exception {
      ArrayList<String> actual = LuhnAlgorithm.generateCards("555555", "0000000000", 2);
      ArrayList<String> expected = new ArrayList<>(Arrays.asList("5555550000000002", "5555550000000010"));

      assertEquals(expected, actual);
   }

   @Test
   public void generateCardsNotEnough() throws Exception {
      ArrayList<String> actual = LuhnAlgorithm.generateCards("333333", "9999999985", 10);
      ArrayList<String> expected = new ArrayList<>(Arrays.asList("3333339999999992"));

      assertEquals(expected, actual);
   }
}