package myJava.code.challenges;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;


public class TestRomanNumeralExpertString {
    @Test
    public void test_nineteenHundredReturnsMCM() {
        String testInput = "1900";
        String expectedResult = "MCM";
        String actualResult = RomanNumeralExpert.toRomanNumerals(testInput);
        assertEquals(expectedResult, actualResult);
    }
    @Test
    public void test_sixhundredThirtyFourReturnsDCXXXIV() {
        String testInput = "634";
        String expectedResult = "DCXXXIV";
        String actualResult = RomanNumeralExpert.toRomanNumerals(testInput);
        assertEquals(expectedResult, actualResult);
    }
    @Test
    public void test_twoThousandTwentyReturnsMMXX() {
        String testInput = "2020";
        String expectedResult = "MMXX";
        String actualResult = RomanNumeralExpert.toRomanNumerals(testInput);
        assertEquals(expectedResult, actualResult);
    }
    @Test
    public void test_twoThousandNinetyNineReturnsMMXCIX() {
        String testInput = "2099";
        String expectedResult = "MMXCIX";
        String actualResult = RomanNumeralExpert.toRomanNumerals(testInput);
        assertEquals(expectedResult, actualResult);
    }
    @Test
    public void test_zeroLengthInputDoesNotThrow() {
        String testInput = "";
        assertDoesNotThrow(()->{
            RomanNumeralExpert.toRomanNumerals(testInput);
        });
    }
    @Test
    public void test_negativeNumberDoesNotThrow() {
        String testInput = "-1";
        assertDoesNotThrow(()->{
            RomanNumeralExpert.toRomanNumerals(testInput);
        });
    }
    @Test
    public void test_zeroReturnsEmptyString() {
        String testInput = "0";
        String expectedResult = "";
        String actualResult = RomanNumeralExpert.toRomanNumerals(testInput);
        assertEquals(expectedResult, actualResult);
    }
    @Test
    public void test_oneOrTwoOrThreeReturnOnlyICharacters() {
        String testInputOne = "1";
        String testInputTwo = "2";
        String testInputThree = "3";

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
        String testInputFourteen = "14";
        String testInputTwentyFour = "24";
        String testInputFortyFour = "44";
        String testInputNinetyFour = "94";

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
        String testInputOneHundredNine = "109";
        String testInputOneHundredFortyNine = "149";
        String testInputTwoHundredThirtyNine = "239";
        String testInputNineHundredNinetyNine = "999";

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
        String testInput = "4999";
        String expectedResult = "M~VCMXCIX";
        String actualResult = RomanNumeralExpert.toRomanNumerals(testInput);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void test_FourThousandFourHundredNinetyFourReturnsCorrectValue() {
        String testInput = "4494";
        String expectedResult = "M~VCDXCIV";
        String actualResult = RomanNumeralExpert.toRomanNumerals(testInput);
        assertEquals(expectedResult, actualResult);
    }
}
