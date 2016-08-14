package gojava.finalproject;

import java.util.ArrayList;

public class LuhnAlgorithm {
    /**
     * Returns the sum of numerals sequence calculated based on Luhn algorithm.
     * The sum is presented as {@code Integer} number. The algorithm works as follows:
     * The counting of the numerals begins from left to right.
     * The odd numbers are included in the sum without changes.
     * The even numbers are doubled. If the result of multiplication is greater than 9,
     * the numbers in the result are added. Example: 8 * 2 = 16; 16 greater than 9. The end result is 1 + 6 = 7.
     *
     * @param card the number of plastic card presented as {@code String}.
     * @return the sum of the numerals in plastic card number.
     */
    public static int calculateSum(String card) {
        char[] cardChars = card.toCharArray();
        int[] cardInts = new int[cardChars.length];

        for (int i = 0; i < cardChars.length; i++) {
            cardInts[i] = Character.getNumericValue(cardChars[i]);
        }

        int sum = 0;

        for (int i = 0; i < cardInts.length; i++) {
            if (i % 2 == 0) {
                cardInts[i] *= 2;
                if (cardInts[i] > 9) {
                    cardInts[i] -= 9;
                }
            }
            sum += cardInts[i];
        }
        return sum;
    }

    /**
     * Checks if the sum of the plastic card numbers is a multiple of 10.
     * @param sum the sum of card number numerals presented as {@code Integer} number.
     * @return {@code true} if the sum is a multiple of 10; {@code false} otherwise.
     */

    public static boolean isCardMod10(int sum) {
        return sum % 10 == 0;
    }

    /**
     * Creates an {@code ArrayList} of valid card numbers. The sum of full card number is checked
     * to be a multiple of 10; then the last number is discarded and considered as a control number.
     * The sum of numbers left is calculated again and multiplied by 9. The last number in the result
     * should be the same as the control number. If both conditions are met, the card is considered valid.
     * Example: card number 5555550000000002, the full sum is 20, the sum of 15 first numbers
     * multiplied by 9 is 162, control number is 2, conclusion: the card is valid.
     * @param bankID the first 6 digits of the card number which is a unique bank ID
     *               containing information about bank branch/division/department and other special details
     *               about card issuer.
     * @param initCardNumber 10 numbers of the bank card left, further calculation is based on these numbers.
     * @param amountOfCards amount of valid cards that meet all requirements.
     * @return the {@code ArrayList} of valid cards.
     */

    public static ArrayList<String> generateCards(String bankID, String initCardNumber, int amountOfCards) {
        ArrayList<String> validCardsList = new ArrayList<>();
        boolean cardMod10;

        int bankIDSum = calculateSum(bankID);
        long initCardNumberLong = Long.parseLong(initCardNumber);

        do {
            initCardNumberLong++;
            initCardNumber = String.format("%010d", initCardNumberLong);

            if (initCardNumber.length() > 10) break;

            int cardSum = calculateSum(initCardNumber);
            int finalSum = bankIDSum + cardSum;
            cardMod10 = isCardMod10(finalSum);

            String smallCard = String.copyValueOf(initCardNumber.toCharArray(), 0, initCardNumber.length() - 1);
            String smallCardSum = String.valueOf((calculateSum(smallCard) + bankIDSum) * 9);

            char lastCharSmallCard = smallCardSum.charAt(smallCardSum.length() - 1);
            int lastIntSmallCard = Character.getNumericValue(lastCharSmallCard);

            char lastCharFullCard = initCardNumber.charAt(initCardNumber.length() - 1);
            int lastIntFullCard = Character.getNumericValue(lastCharFullCard);

            StringBuilder validCard = new StringBuilder();

            if (cardMod10 && lastIntSmallCard == lastIntFullCard) {
                validCard.append(bankID).append(initCardNumber);
                validCardsList.add(validCard.toString());
                amountOfCards--;
            }
        } while (amountOfCards > 0);

        return validCardsList;
    }
}