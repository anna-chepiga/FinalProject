package ua.goit.finalproject.cards;

public class SSC extends Card {
   @Override
   public String getCardType() {
      return "Social Security Code";
   }

   @Override
   public int getAmountOfNumbers() {
      return 9;
   }
}