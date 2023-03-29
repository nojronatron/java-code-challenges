package myJava.code.challenges;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestCountCharsInFile {
    @Test
    public void test_mainRejectsLessThanTwoInputs() {
        String[] zero = new String[]{};
        String[] filename = new String[]{"filename"};
        String[] character = new String[]{"c"};
        String expectedResult = "Invalid input. Enter a filename with path and extension, and a single-character search term.";

        var zeroArgsResult = CountCharsInFile.main(zero);
        assertEquals(expectedResult, zeroArgsResult);

        var filenameArgResult = CountCharsInFile.main(filename);
        assertEquals(expectedResult, filenameArgResult);

        var characterArgResult = CountCharsInFile.main(character);
        assertEquals(expectedResult, characterArgResult);
    }

    @Test
    public void test_filenameInputLessThanTwoLongWillReturnMessage() {
        String expectedResult = "Invalid input. Enter a filename with path and extension, and a single-character search term.";

        String[] inputArgOne = new String[]{"a", "o"};
        var shortFilenameResult = CountCharsInFile.main(inputArgOne);
        assertEquals(expectedResult, shortFilenameResult);

        String[] inputArgNone = new String[]{"", "o"};
        var noFilenameResult = CountCharsInFile.main(inputArgNone);
        assertEquals(expectedResult, noFilenameResult);
    }

    @Test
    public void test_searchCharMustBeOneLengthOnly() {
        String expectedResult = "Invalid input. Enter a filename with path and extension, and a single-character search term.";

        String[] inputArgZero = new String[]{"filename.ext", ""};
        var noCharacterArgResult = CountCharsInFile.main(inputArgZero);
        assertEquals(expectedResult, noCharacterArgResult);

        String[] inputArgTwo = new String[]{"", "ab"};
        var twoCharacterArgResult = CountCharsInFile.main(inputArgTwo);
        assertEquals(expectedResult, twoCharacterArgResult);
    }

    @Test
    public void test_getCharsCharIsCaseSensitive() {
        // compare 'L' count vs 'l' count.
        String filename = "src/main/resources/LoremIpsum.txt";
        String[] inputArgsCapital = new String[]{filename, "L"};

        String expectedCapitalResult = "Found L 1 times in src/main/resources/LoremIpsum.txt.";
        var capitalResult = CountCharsInFile.main(inputArgsCapital);
        assertEquals(expectedCapitalResult, capitalResult);

        String expectedLowerResult = "Found l 5 times in src/main/resources/LoremIpsum.txt.";
        String[] inputArgsLower = new String[]{filename, "l"};
        var lowerResult = CountCharsInFile.main(inputArgsLower);
        assertEquals(expectedLowerResult, lowerResult);
    }

    @Test
    public void test_mainFileNotFoundReturnsMessage() {
        StringBuilder expectedResult = new StringBuilder("Error occurred accessing file ");
        String filename = "NonExistentFile.txt";
        expectedResult.append(filename).append(".");

        String[] inputArgsCapital = new String[]{filename, "L"};
        var capitalResult = CountCharsInFile.main(inputArgsCapital);
        assertEquals(expectedResult.toString(), capitalResult);
    }

    @Test
    public void test_getCharsFileNotFoundThrows() {
        String filename = "NonExistentFile.txt";
        assertThrows(Exception.class, () -> {
            CountCharsInFile.getCount(filename, "L");
        });
    }

    @Test
    public void test_getCharsGoldenPath() {
        String filename = "src/main/resources/LoremIpsum.txt";
        String character = "a";
        int expectedResult = 7;
        int actualResult = assertDoesNotThrow(() -> CountCharsInFile.getCount(filename, character));
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void test_getChars_o_returnsTen() {
        String filename = "src/main/resources/LoremIpsum.txt";
        String character = "o";
        int expectedResult = 10;
        int actualResult = assertDoesNotThrow(() -> CountCharsInFile.getCount(filename, character));
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void test_getChars_z_returnsZero() {
        String filename = "src/main/resources/LoremIpsum.txt";
        String character = "z";
        int expectedResult = 0;
        int actualResult = assertDoesNotThrow(() -> CountCharsInFile.getCount(filename, character));
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void test_getChars_1_returnsZero() {
        String filename = "src/main/resources/LoremIpsum.txt";
        String character = "1";
        int expectedResult = 0;
        int actualResult = assertDoesNotThrow(() -> CountCharsInFile.getCount(filename, character));
        assertEquals(expectedResult, actualResult);
    }
}
