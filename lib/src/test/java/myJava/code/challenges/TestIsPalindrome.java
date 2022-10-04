package myJava.code.challenges;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestIsPalindrome {
    @Test
    public void test_canInstantiatePalindromeExpert() {
        PalindromeExpert sut = new PalindromeExpert();
        assertNotNull(sut);
    }
    @Test
    public void test_tacoCatReturnsTrue() {
        String palindromeInput = "tacocat";
        PalindromeExpert sut = new PalindromeExpert();
        assertTrue(sut.enhancedIsPalindrome(palindromeInput));
    }
    @Test
    public void test_caseSensitivePalindromeReturnsTrue() {
        String palindromeInput = "tAcoCaT";
        PalindromeExpert sut = new PalindromeExpert();
        assertTrue(sut.enhancedIsPalindrome(palindromeInput));
    }
    @Test
    public void test_nonPalindromeReturnsFalse() {
        String nonPalindromeInput = "burgerdog";
        PalindromeExpert sut = new PalindromeExpert();
        assertFalse(sut.enhancedIsPalindrome(nonPalindromeInput));
    }
    @Test
    public void test_verySmallPalindrome() {
        String palindromeInput = "a";
        PalindromeExpert sut = new PalindromeExpert();
        assertTrue(sut.enhancedIsPalindrome(palindromeInput));
    }
    @Test
    public void test_smallPalindrome() {
        String palindromeInput = "bb";
        PalindromeExpert sut = new PalindromeExpert();
        assertTrue(sut.enhancedIsPalindrome(palindromeInput));
    }
    @Test
    public void test_threeCharPalindrome() {
        String palindromeInput = "ccc";
        PalindromeExpert sut = new PalindromeExpert();
        assertTrue(sut.enhancedIsPalindrome(palindromeInput));
    }
    @Test
    public void test_fourCharPalindrome() {
        String palindromeInput = "dood";
        PalindromeExpert sut = new PalindromeExpert();
        assertTrue(sut.enhancedIsPalindrome(palindromeInput));
    }
    @Test
    public void test_eightCharPalindrome() {
        String palindromeInput = "grannarg";
        PalindromeExpert sut = new PalindromeExpert();
        assertTrue(sut.enhancedIsPalindrome(palindromeInput));
    }
    // End: Single string input unit tests

    // Begin: Two-input strings unit tests
    @Test
    public void test_unityReturnsTrue() {
        String palindromeInput1 = "TACO";
        String palindromeInput2 = "ocat";
        PalindromeExpert sut = new PalindromeExpert();
        assertTrue(sut.enhancedIsPalindrome(palindromeInput1, palindromeInput2));
    }
    @Test
    public void test_caseSensitivePalindromesReturnsTrue() {
        String palindromeInput1 = "unity";
        String palindromeInput2 = "YTINU";
        PalindromeExpert sut = new PalindromeExpert();
        assertTrue(sut.enhancedIsPalindrome(palindromeInput1, palindromeInput2));
    }
    @Test
    public void test_nonPalindromesReturnsFalse() {
        String nonPalindromeInput1 = "burger";
        String nonPalindromeInput2 = "dog";
        PalindromeExpert sut = new PalindromeExpert();
        assertFalse(sut.enhancedIsPalindrome(nonPalindromeInput1, nonPalindromeInput2));
    }
}
