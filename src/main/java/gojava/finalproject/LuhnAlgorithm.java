package gojava.finalproject;

public class LuhnAlgorithm {
    /**
     * Returns the sum of numerals sequence calculated based on Luhn algorithm.
     * The sum is presented as {@code Integer} number. The algorithm works as follows:
     * The counting of the numerals begins from right to left.
     * The odd numbers are included in the sum without changes.
     * The even numbers are doubled. If the result of multiplication is greater than 9,
     * the numbers in the result are added. Example: 8 * 2 = 16; 16 greater than 9. The end result is 1 + 6 = 7.
     *
     * @param card the number of plastic card presented as {@code String}.
     * @return the sum of the numerals in plastic card number.
     */
    public static int getSum(String card) {
        char[] chArray = card.toCharArray();
        int[] intArr = new int[chArray.length];

        for (int i = 0; i <= chArray.length - 1; i++) {
            intArr[i] = Character.getNumericValue(chArray[chArray.length - 1 - i]);
        }

        int sum = 0;

        for (int i = 0; i < intArr.length; i++) {
            if (i % 2 != 0) {
                intArr[i] = intArr[i] * 2;
                if (intArr[i] > 9) {
                    intArr[i] -= 9;
                }
            }
            sum = sum + intArr[i];
        }
        return sum;
    }

    /**
     * Returns the control number. The method receives the sum of numerals sequence of a plastic card number.
     * If the sum is a multiple of 10, it may be affirmed that the numerals sequence was entered correctly.
     * If the sum is not a multiple of 10, the incorrect sequence was used.
     * The control number is calculated by retrieving the difference to the preceded number which is a multiple of 10.
     *
     * @param sum the sum of plastic card numerals.
     * @return the value {@code 0} if the sum is multiple of 10;
     *         remainder in division by 10 if the sum is not divisible by 10.
     */
    public static int getControlNumber(int sum) {
        if (sum % 10 == 0) {
            return 0;
        } else return sum % 10;
    }
}