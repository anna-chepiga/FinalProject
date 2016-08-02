public class LuhnAlorithm {
    public static int getControlSum(String card) {
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

    public static int getControlNumber(int sum) {
        if (sum % 10 == 0) {
            return 0;
        } else
            return sum % 10;
    }
}
