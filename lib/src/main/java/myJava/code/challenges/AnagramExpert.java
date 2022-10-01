package myJava.code.challenges;

import myJava.code.models.MyStack;

public class AnagramExpert {
    private MyStack charStack;
    public AnagramExpert() {
        this.charStack = new MyStack();
    }

    public boolean isAnagram(String stringInput) {
        char[] characters = stringInput.toCharArray();
        int arrCount = characters.length;
        int halfLength = arrCount % 2 == 0 ? arrCount / 2 : (arrCount - 1) / 2;
        // change: allowed iterating up to and including halfLength
        for(int idx=0; idx<halfLength; idx++) {
            this.charStack.push(characters[idx]);
        }
        for(int idx=halfLength; idx <= arrCount-1; idx++) {
            char tempChar = (char)charStack.pop();
            if (Character.toLowerCase(characters[idx]) != Character.toLowerCase(tempChar)) {
                return false;
            }
        }
        return true;
    }

    public boolean enhancedIsAnagram(String stringInput) {
        char[] characters = stringInput.toCharArray();
        int maxIndex = characters.length - 1;
        int maxLeftIdx = 0;

        if (characters.length % 2 != 0) {
            maxLeftIdx = (maxIndex / 2) - 1;
        } else {
            maxLeftIdx = maxIndex / 2;
        }

        for (int idx=0; idx<=maxLeftIdx; idx++) {
            charStack.push(characters[idx]);
        }

        maxLeftIdx = characters.length % 2 != 0 ? maxLeftIdx + 1 : maxLeftIdx;

        while (!charStack.isEmpty()){
            maxLeftIdx++;
            if (Character.toLowerCase((char)charStack.pop()) != Character.toLowerCase(characters[maxLeftIdx])) {
                return false;
            }
        }
        return true;
    }
}
