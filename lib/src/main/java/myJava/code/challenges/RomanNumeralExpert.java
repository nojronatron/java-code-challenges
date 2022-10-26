package myJava.code.challenges;

import myJava.code.models.MyStack;

import java.util.Locale;

public class RomanNumeralExpert {
    public static String toRomanNumerals(String inputNumbers) {

        if (inputNumbers.length() < 1) {
            return "";
        }

        String[] romanNumerals = {"I", "V", "X", "L", "C", "D", "M", "~V"};
        int idx = 0;
        MyStack numberStack = new MyStack();
        String[] inputArr = inputNumbers.split("");

        for (String item : inputArr) {
            if (item.equals("-")) {
                return "";
            }

            int intItem = Integer.parseInt(item);
            numberStack.push(intItem);
        }

        StringBuilder result = new StringBuilder();

        while (!numberStack.isEmpty()) {
            int currentValue = (int) numberStack.pop();
            idx = idx + 2;

            if (currentValue > 0 && currentValue < 4) {
                for (int i = 0; i < currentValue; i++) {
                    result.insert(0, romanNumerals[idx - 2]);
                }
            }

            if (currentValue == 4) {
                result.insert(0, romanNumerals[idx - 1]);
                result.insert(0, romanNumerals[idx - 2]);
            }

            if (currentValue > 4 && currentValue < 9) {
                result.insert(0, romanNumerals[idx - 1]);
                currentValue -= 5;

                for (int i = 0; i < currentValue; i++) {
                    result.insert(1, romanNumerals[idx - 2]);
                }
            }

            if (currentValue == 9) {
                result.insert(0, romanNumerals[idx]).insert(0, romanNumerals[idx - 2]);
            }
        }

        return result.toString();
    }

    public static String toRomanNumerals(int inputNumbers) {

    }
}

