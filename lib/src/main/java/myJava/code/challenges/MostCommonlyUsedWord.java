package myJava.code.challenges;

import myJava.code.models.MyHashtable;
import org.apache.commons.math3.util.Pair;
import java.util.Locale;

public class MostCommonlyUsedWord {
    private final MyHashtable hashtable = new MyHashtable();

    /***
     * Function accepts a string of space-separated words and returns the first most-commonly appearing word in lower-case.
     * Punctuation is ignored entirely.
     * @param inputString String
     * @return String
     */
    public String getMostCommonWord(String inputString) {
        final String REGEX_STRING = "[^a-zA-Z0-9_\\s]";
        final String REPLACEMENT_VARIABLE = "";
        String punctuationFreeString = inputString.replaceAll(REGEX_STRING, REPLACEMENT_VARIABLE);

        final String delimiter = " ";
        final String[] wordList = punctuationFreeString.split(delimiter);

        Pair<String,Integer> mostCommonWord = new Pair<>("", 0);

        if (inputString.equals("") || inputString.equals(" ")) {
            return inputString;
        }

        for (String word: wordList) {
            if (word.equals("") || word.equals(" ")) {
                continue;   //  avoids polluting hashtable with empty or blank strings
            }

            String tempWord = word.toLowerCase(Locale.ROOT);

            if (hashtable.has(tempWord)) {
                int existingWordCount = hashtable.get(tempWord);
                existingWordCount++;
                hashtable.set(tempWord, existingWordCount);

                if (existingWordCount > mostCommonWord.getValue()) {
                    mostCommonWord = new Pair<>(tempWord, existingWordCount);
                }
            } else {
                hashtable.set(tempWord, 1);
            }
        }
        return mostCommonWord.getKey();
    }
}
