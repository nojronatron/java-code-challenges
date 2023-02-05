package myJava.code.challenges;

import java.util.ArrayList;

public class LargestPossibleProductBasic {
    public int LargestProduct(ArrayList<Integer> arrList) {
        if (arrList.size() < 1) {
            return 0;
        }
        if (arrList.size() == 1) {
            // weakness is if an input is zero
            return arrList.get(0);
        }
        if (arrList.size() == 2) {
            // weakness is if an input is zero
            return arrList.get(0) * arrList.get(1);
        }
        int firstValue = Integer.MIN_VALUE;
        int secondValue = Integer.MIN_VALUE;
        int thirdValue = Integer.MIN_VALUE;
        for (int currentValue : arrList) {
            if (currentValue == 0) {
                continue;
            }
            if (currentValue > firstValue) {
                int tempValue = firstValue;
                firstValue = currentValue;
                currentValue = tempValue;
            }
            if (currentValue > secondValue) {
                int tempValue = secondValue;
                secondValue = currentValue;
                currentValue = tempValue;
            }
            if (currentValue > thirdValue) {
                thirdValue = currentValue;
            }
        }

        return firstValue * secondValue * thirdValue;
    }
}
