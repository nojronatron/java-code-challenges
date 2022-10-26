package myJava.code.challenges;

import myJava.code.models.MyStack;

public class RomanNumeralExpert {
    public static String toRomanNumerals(String inputNumbers) {
        String result = "";
        String[] romanNumerals = {"I", "V", "X", "L", "C", "D", "M", "~V"};
        int idx = 0;
        MyStack numberStack = new MyStack();
        char[] inputChars = inputNumbers.toCharArray();

        for (Character item: inputChars) {
            numberStack.push((int)item);
        }

        while (!numberStack.isEmpty()) {
            int currentValue = (int)numberStack.pop();
            idx = idx + 2;
            if (currentValue > 0 && currentValue < 4) {
                for(int i=0; i < currentValue; i++) {
                    result = romanNumerals[idx-2] + result;
                }
            } else if (currentValue == 4) {
                result = romanNumerals[idx-2] + result;
                result = romanNumerals[idx-1] + result;
            } else if (currentValue > 4 && currentValue < 9) {
                String tempRN = romanNumerals[idx-1];
                currentValue = currentValue - 5;
                for (int i=0; i < currentValue; i++) {
                    result = romanNumerals[idx-1] + result;
                }
            } else {
                result = romanNumerals[idx-2] + result;
                result = romanNumerals[idx] + result;
            }
        }

        return result;
    }
}
