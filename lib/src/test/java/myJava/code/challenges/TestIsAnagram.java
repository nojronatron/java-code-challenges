package myJava.code.challenges;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestIsAnagram {
    @Test
    public void test_canInstantiateAnagramExpert() {
        AnagramExpert sut = new AnagramExpert();
        assertNotNull(sut);
    }
    @Test
    public void test_tacoCatReturnsTrue() {
        String anagramInput = "tacocat";
        AnagramExpert sut = new AnagramExpert();
        assertTrue(sut.isAnagram(anagramInput));
    }
    @Test
    public void test_caseSensitiveAnagramReturnsTrue() {
        String anagramInput = "tAcoCaT";
        AnagramExpert sut = new AnagramExpert();
        assertTrue(sut.isAnagram(anagramInput));
    }
    @Test
    public void test_nonAnagramReturnsFalse() {
        String nonAnagramInput = "burgerdog";
        AnagramExpert sut = new AnagramExpert();
        assertTrue(sut.isAnagram(nonAnagramInput));
    }
}
