package myJava.code.challenges;

import myJava.code.models.MyStack;

import java.util.Locale;

public class RomanNumeralExpert {
    public static String toRomanNumerals(String inputNumbers) {
        String result = "";

        if (inputNumbers.length() < 1) {
            return result;
        }

        String[] romanNumerals = {"I", "V", "X", "L", "C", "D", "M", "~V"};
        int idx = 0;
        MyStack numberStack = new MyStack();
        String[] inputArr = inputNumbers.split("");

        for(String item: inputArr) {
            if (item.equals("-")) {
                return result;
            }

            int intItem = Integer.parseInt(item);
            numberStack.push(intItem);
        }

        while (!numberStack.isEmpty()) {
            int currentValue = (int)numberStack.pop();
            idx = idx + 2;

            if (currentValue > 0 && currentValue < 4) {
                for(int i=0; i < currentValue; i++) {
                    result = romanNumerals[idx-2] + result;
                }
            }

            if (currentValue == 4) {
                result = romanNumerals[idx-2] + romanNumerals[idx-1] + result;
            }

            if (currentValue > 4 && currentValue < 9) {
                String tempRN = romanNumerals[idx-1];
                currentValue = currentValue - 5;
                for (int i=0; i < currentValue; i++) {
                    result = romanNumerals[idx-2] + result;
                }
                result = tempRN + result;
            }

            if (currentValue == 9) {
                result = romanNumerals[idx-2] + romanNumerals[idx] + result;
            }
        }

        return result;
    }
}
