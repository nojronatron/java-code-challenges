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
        assertTrue(sut.enhancedIsAnagram(anagramInput));
    }
    @Test
    public void test_caseSensitiveAnagramReturnsTrue() {
        String anagramInput = "tAcoCaT";
        AnagramExpert sut = new AnagramExpert();
        assertTrue(sut.enhancedIsAnagram(anagramInput));
    }
    @Test
    public void test_nonAnagramReturnsFalse() {
        String nonAnagramInput = "burgerdog";
        AnagramExpert sut = new AnagramExpert();
        assertFalse(sut.enhancedIsAnagram(nonAnagramInput));
    }
    @Test
    public void test_verySmallAnagram() {
        String anagramInput = "a";
        AnagramExpert sut = new AnagramExpert();
        assertTrue(sut.enhancedIsAnagram(anagramInput));
    }
    @Test
    public void test_smallAnagram() {
        String anagramInput = "bb";
        AnagramExpert sut = new AnagramExpert();
        assertTrue(sut.enhancedIsAnagram(anagramInput));
    }
    @Test
    public void test_threeCharAnagram() {
        String anagramInput = "ccc";
        AnagramExpert sut = new AnagramExpert();
        assertTrue(sut.enhancedIsAnagram(anagramInput));
    }
    @Test
    public void test_fourCharAnagram() {
        String anagramInput = "dood";
        AnagramExpert sut = new AnagramExpert();
        assertTrue(sut.enhancedIsAnagram(anagramInput));
    }
    @Test
    public void test_eightCharAnagram() {
        String anagramInput = "grannarg";
        AnagramExpert sut = new AnagramExpert();
        assertTrue(sut.enhancedIsAnagram(anagramInput));
    }
}
