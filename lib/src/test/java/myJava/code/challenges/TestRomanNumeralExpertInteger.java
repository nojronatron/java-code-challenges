package myJava.code.challenges;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestRomanNumeralExpertInteger {
    @Test
    public void test_nineteenHundredReturnsMCM() {
        int testInput = 1900;
        String expectedResult = "MCM";
        String actualResult = RomanNumeralExpert.toRomanNumerals(testInput);
        assertEquals(expectedResult, actualResult);
    }
    @Test
    public void test_sixhundredThirtyFourReturnsDCXXXIV() {
        int testInput = 634;
        String expectedResult = "DCXXXIV";
        String actualResult = RomanNumeralExpert.toRomanNumerals(testInput);
        assertEquals(expectedResult, actualResult);
    }
    @Test
    public void test_twoThousandTwentyReturnsMMXX() {
        int testInput = 2020;
        String expectedResult = "MMXX";
        String actualResult = RomanNumeralExpert.toRomanNumerals(testInput);
        assertEquals(expectedResult, actualResult);
    }
    @Test
    public void test_twoThousandNinetyNineReturnsMMXCIX() {
        int testInput = 2099;
        String expectedResult = "MMXCIX";
        String actualResult = RomanNumeralExpert.toRomanNumerals(testInput);
        assertEquals(expectedResult, actualResult);
    }
    @Test
    public void test_zeroDoesNotThrow() {
        int testInput = 0;
        assertDoesNotThrow(()->{
            RomanNumeralExpert.toRomanNumerals(testInput);
        });
    }
    @Test
    public void test_negativeNumberDoesNotThrow() {
        int testInput = -1;
        assertDoesNotThrow(()->{
            RomanNumeralExpert.toRomanNumerals(testInput);
        });
    }
    @Test
    public void test_zeroReturnsEmptyString() {
        int testInput = 0;
        String expectedResult = "";
        String actualResult = RomanNumeralExpert.toRomanNumerals(testInput);
        assertEquals(expectedResult, actualResult);
    }
    @Test
    public void test_oneOrTwoOrThreeReturnOnlyICharacters() {
        int testInputOne = 1;
        int testInputTwo = 2;
        int testInputThree = 3;

        String expectedResultOne = "I";
        String expectedResultTwo = "II";
        String expectedResultThree = "III";

        String actualResultOne = RomanNumeralExpert.toRomanNumerals(testInputOne);
        assertEquals(expectedResultOne, actualResultOne);
        String actualResultTwo = RomanNumeralExpert.toRomanNumerals(testInputTwo);
        assertEquals(expectedResultTwo, actualResultTwo);
        String actualResultThree = RomanNumeralExpert.toRomanNumerals(testInputThree);
        assertEquals(expectedResultThree, actualResultThree);
    }
    @Test
    public void test_TensEndingInFourReturnProperly() {
        int testInputFourteen = 14;
        int testInputTwentyFour = 24;
        int testInputFortyFour = 44;
        int testInputNinetyFour = 94;

        String expectedFourteenResult = "XIV";
        String expectedTwentyFourResult = "XXIV";
        String expectedFortyFourResult = "XLIV";
        String expectedNinetyFourResult = "XCIV";

        String actualFourteenResult = RomanNumeralExpert.toRomanNumerals(testInputFourteen);
        assertEquals(expectedFourteenResult, actualFourteenResult);
        String actualTwentyFourResult = RomanNumeralExpert.toRomanNumerals(testInputTwentyFour);
        assertEquals(expectedTwentyFourResult, actualTwentyFourResult);
        String actualFortyFourResult = RomanNumeralExpert.toRomanNumerals(testInputFortyFour);
        assertEquals(expectedFortyFourResult, actualFortyFourResult);
        String actualNinetyFourResult = RomanNumeralExpert.toRomanNumerals(testInputNinetyFour);
        assertEquals(expectedNinetyFourResult, actualNinetyFourResult);
    }
    @Test
    public void test_HundredsEndingInNineReturnProperly() {
        int testInputOneHundredNine = 109;
        int testInputOneHundredFortyNine = 149;
        int testInputTwoHundredThirtyNine = 239;
        int testInputNineHundredNinetyNine = 999;

        String expectedOneHundredNineResult = "CIX";
        String expectedOneHundredFortyNineResult = "CXLIX";
        String expectedTwoHundredThirtyNineResult = "CCXXXIX";
        String expectedNineHundredNinetyNineResult = "CMXCIX";

        String actualFourteenResult = RomanNumeralExpert.toRomanNumerals(testInputOneHundredNine);
        assertEquals(expectedOneHundredNineResult, actualFourteenResult);
        String actualTwentyFourResult = RomanNumeralExpert.toRomanNumerals(testInputOneHundredFortyNine);
        assertEquals(expectedOneHundredFortyNineResult, actualTwentyFourResult);
        String actualFortyFourResult = RomanNumeralExpert.toRomanNumerals(testInputTwoHundredThirtyNine);
        assertEquals(expectedTwoHundredThirtyNineResult, actualFortyFourResult);
        String actualNinetyFourResult = RomanNumeralExpert.toRomanNumerals(testInputNineHundredNinetyNine);
        assertEquals(expectedNineHundredNinetyNineResult, actualNinetyFourResult);
    }
    @Test
    public void test_FourThousandNineHundredNinetyNineReturnsCorrectValue() {
        int testInput = 4999;
        String expectedResult = "M~VCMXCIX";
        String actualResult = RomanNumeralExpert.toRomanNumerals(testInput);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void test_FourThousandFourHundredNinetyFourReturnsCorrectValue() {
        int testInput = 4494;
        String expectedResult = "M~VCDXCIV";
        String actualResult = RomanNumeralExpert.toRomanNumerals(testInput);
        assertEquals(expectedResult, actualResult);
    }
}
