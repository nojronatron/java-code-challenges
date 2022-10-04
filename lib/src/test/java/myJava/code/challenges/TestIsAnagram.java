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
    public void test_ignoresPunctuation() {
        String anagramInput1 = "!,.?;:'punctuation";
        String anagramInput2 = "punctuation@#$%^&*()<>";
        AnagramExpert sut = new AnagramExpert();
        assertTrue(sut.isAnagram(anagramInput1, anagramInput2));
    }
    @Test
    public void test_debitCardBadCreditReturnsTrue() {
        String anagramInput1 = "debit card";
        String anagramInput2 = "bad credit";
        AnagramExpert sut = new AnagramExpert();
        assertTrue(sut.isAnagram(anagramInput1, anagramInput2));
    }
    @Test
    public void test_caseSensitiveAnagramReturnsTrue() {
        String anagramInput1 = "DORMITORY";
        String anagramInput2 = "dirty room";
        AnagramExpert sut = new AnagramExpert();
        assertTrue(sut.isAnagram(anagramInput1, anagramInput2));
    }
    @Test
    public void test_nonAnagramReturnsFalse() {
        String nonAnagramInput1 = "hamburger";
        String nonAnagramInput2 = "hotdog";
        AnagramExpert sut = new AnagramExpert();
        assertFalse(sut.isAnagram(nonAnagramInput1, nonAnagramInput2));
    }
    @Test
    public void test_verySmallAnagram() {
        String anagramInput1 = "la";
        String anagramInput2 = "al";
        AnagramExpert sut = new AnagramExpert();
        assertTrue(sut.isAnagram(anagramInput1, anagramInput2));
    }
    @Test
    public void test_smallAnagram() {
        String anagramInput1 = "pad";
        String anagramInput2 = "dap";
        AnagramExpert sut = new AnagramExpert();
        assertTrue(sut.isAnagram(anagramInput1, anagramInput2));
    }
    @Test
    public void test_largerAnagram() {
        String anagramInput1 = "William Shakespeare";
        String anagramInput2 = "I'll make a wise phrase";
        AnagramExpert sut = new AnagramExpert();
        assertTrue(sut.isAnagram(anagramInput1, anagramInput2));
    }
    @Test
    public void test_caseSensitiveAnagramsReturnsTrue() {
        String anagramInput1 = "listen";
        String anagramInput2 = "SILENT";
        AnagramExpert sut = new AnagramExpert();
        assertTrue(sut.isAnagram(anagramInput1, anagramInput2));
    }
}
