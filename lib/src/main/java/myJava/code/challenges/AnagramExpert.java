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
}
