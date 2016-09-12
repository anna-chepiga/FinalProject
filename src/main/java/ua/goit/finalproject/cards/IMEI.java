package ua.goit.finalproject.cards;

public class IMEI extends Card {
   @Override
   public String getCardType() {
      return "IMEI Number";
   }

   @Override
   public int getAmountOfNumbers() {
      return 15;
   }
}