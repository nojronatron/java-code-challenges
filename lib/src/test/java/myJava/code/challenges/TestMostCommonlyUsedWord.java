package myJava.code.challenges;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestMostCommonlyUsedWord {

    @Test
    void test_MosCommonWordEmptyOrSpace() {
        MostCommonlyUsedWord sut = new MostCommonlyUsedWord();
        assertEquals("", sut.getMostCommonWord(""));
        assertEquals(" ", sut.getMostCommonWord(" "));
    }

    @Test
    void test_MostCommonWordIsThe() {
        String sentence = "The quick brown fox jumped over the lazy brown dog.";
        String expectedResult = "the";
        MostCommonlyUsedWord sut = new MostCommonlyUsedWord();
        String actualResult = sut.getMostCommonWord(sentence);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void test_MostCommonWordIsAlpha() {
        String words = "alpha alpha alpha bravo charlie delta echo foxtrot alpha golf hotel india juliet alpha kilo lima mike november oscar alpha papa quebec romeo alpha sierra tango uniform victor alpha whiskey xray yankee zulu";
        String expectedResult = "alpha";
        MostCommonlyUsedWord sut = new MostCommonlyUsedWord();
        String actualResult = sut.getMostCommonWord(words);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void test_MostCommonWordAlphaTextInsensitive() {
        String words = "Alpha Alpha Alpha bravo charlie delta echo foxtrot Alpha golf hotel india juliet alpha kilo lima mike november oscar alpha papa quebec romeo alpha sierra tango uniform victor alpha whiskey xray yankee zulu";
        String expectedResult = "alpha";
        MostCommonlyUsedWord sut = new MostCommonlyUsedWord();
        String actualResult = sut.getMostCommonWord(words);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void test_MostCommonWordLoremIpsum() {
        String lorem = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.";
        MostCommonlyUsedWord sut = new MostCommonlyUsedWord();
        assertDoesNotThrow(()->{
            String mostCommonWord = sut.getMostCommonWord(lorem);
            System.out.println("Lorem most common word is: " + mostCommonWord);
        });
    }

    @Test
    void test_MostCommonWordAmongPunctuation() {
        String sentence = "The! quick!! brown??? fox . .. jumped ,,,over the, lazy?? brown: dog;.";
        String expectedResult = "the";
        MostCommonlyUsedWord sut = new MostCommonlyUsedWord();
        String actualResult = sut.getMostCommonWord(sentence);
        assertEquals(expectedResult, actualResult);
    }
}
