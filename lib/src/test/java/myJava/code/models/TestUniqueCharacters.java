package myJava.code.models;

import myJava.code.challenges.UniqueCharacters;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestUniqueCharacters {
    @Test
    public void test_CanInstantiateUniqueCharactersClass() {
        UniqueCharacters sut = new UniqueCharacters();
        assertNotNull(sut);
    }

    @Test
    public void test_happyPathWithSpaces() {
        UniqueCharacters sut = new UniqueCharacters();
        String inputString = "a b c d e f";
        boolean actualResult = sut.uniqueCharacters(inputString);
        assertTrue(actualResult);
    }

    @Test
    public void test_happyPathNoSpaces() {
        UniqueCharacters sut = new UniqueCharacters();
        String inputString = "abcdef";
        boolean actualResult = sut.uniqueCharacters(inputString);
        assertTrue(actualResult);
    }

    @Test
    public void test_happyPathPunctuation() {
        UniqueCharacters sut = new UniqueCharacters();
        String inputString = "a!b?c,d.e;f:!?,.;:";  //  all punctuation is not unique
        boolean actualResult = sut.uniqueCharacters(inputString);
        assertTrue(actualResult);
    }

    @Test
    public void test_happyPathCaseSensitive() {
        UniqueCharacters sut = new UniqueCharacters();
        String inputString = "aAbBcCdDeEfF";  //  case-sensitivity makes 'a' not equal to 'A'
        boolean actualResult = sut.uniqueCharacters(inputString);
        assertTrue(actualResult);
    }

    @Test
    public void test_duplicateLowerCaseCharacters() {
        UniqueCharacters sut = new UniqueCharacters();
        String inputString = "aAbBcCdDeEafF";
        boolean actualResult = sut.uniqueCharacters(inputString);
        assertFalse(actualResult);
    }

    @Test
    public void test_duplicateUpperCaseCharacters() {
        UniqueCharacters sut = new UniqueCharacters();
        String inputString = "DabcdDe";
        boolean actualResult = sut.uniqueCharacters(inputString);
        assertFalse(actualResult);
    }

    @Test
    public void test_quickBrownFoxReturnsFalse() {
        UniqueCharacters sut = new UniqueCharacters();
        String inputString = "The quick brown fox jumps over the lazy dog";
        boolean actualResult = sut.uniqueCharacters(inputString);
        assertFalse(actualResult);
    }

    @Test
    public void test_iLoveCatsReturnsTrue() {
        UniqueCharacters sut = new UniqueCharacters();
        String inputString = "I love cats";
        boolean actualResult = sut.uniqueCharacters(inputString);
        assertTrue(actualResult);
    }

    @Test
    public void test_donaldTheDuckReturnsFalse() {
        UniqueCharacters sut = new UniqueCharacters();
        String inputString = "Donald the duck";
        boolean actualResult = sut.uniqueCharacters(inputString);
        assertFalse(actualResult);
    }
}
