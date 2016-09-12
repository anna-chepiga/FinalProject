package ua.goit.finalproject.cards;

public class Carriage extends Card {
   @Override
   public String getCardType() {
      return "Number Of Railway Carriage";
   }

   @Override
   public int getAmountOfNumbers() {
      return 8;
   }
}