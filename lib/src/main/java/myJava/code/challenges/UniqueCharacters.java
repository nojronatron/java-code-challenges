package myJava.code.challenges;

import myJava.code.models.MyHashtable;

public class UniqueCharacters {
    private final MyHashtable hashmap;

    public UniqueCharacters() {
        this.hashmap = new MyHashtable();
    }

    /**
     * Accepts a String of characters and returns true if all characters are unique, false if not.
     * Case-sensitive. Ignores punctuation and space characters.
     * @param strInput String
     * @return boolean
     */
    public boolean uniqueCharacters(String strInput) {
        String tempString = strInput.replaceAll("\\W", "");
        char[] characters = tempString.toCharArray();

        for(char character: characters) {
            String currentChar = String.valueOf(character);
            if (hashmap.has(currentChar)) {
                return false;
            }
            hashmap.set(currentChar, 0);
        }
        return true;
    }
}
