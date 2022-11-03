package myJava.code.challenges;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TestRotateMatrix {
    @Test
    void test_InstantiateRotateMatrixClass() {
        RotateMatrix sut = new RotateMatrix();
        assertNotNull(sut);
    }

    @Test
    void test_GoldenPathReturnsExpectedRotation() {
        int[][] actualInput = {{1, 1, 1}, {2, 2, 2}, {3, 3, 3}};
        int[][] expectedResult = {{3, 2, 1}, {3, 2, 1}, {3, 2, 1}};

        RotateMatrix sut = new RotateMatrix();
        var actualResult = sut.rotate(actualInput);
        assertArrayEquals(expectedResult, actualResult);
    }

    @Test
    void test_GoldenPathTwoReturnsExpectedRotation() {
        int[][] actualInput = {{3, 2, 1}, {3, 2, 1}, {3, 2, 1}};
        int[][] expectedResult = {{3, 3, 3}, {2, 2, 2}, {1, 1, 1}};

        RotateMatrix sut = new RotateMatrix();
        var actualResult = sut.rotate(actualInput);
        assertArrayEquals(expectedResult, actualResult);
    }

    @Test
    void test_ZeroToOneHundredEightyDegreesRotation() {
        int[][] actualInput = {{1, 1, 1}, {2, 2, 2}, {3, 3, 3}};
        int[][] expectedResult = {{3, 3, 3}, {2, 2, 2}, {1, 1, 1}};

        RotateMatrix sut = new RotateMatrix();
        var actualResult = sut.rotate(actualInput);
        assertArrayEquals(expectedResult, actualResult);
    }

    @Test
    void test_NinetyToTwoHundredSeventyDegreesRotation() {
        int[][] actualInput = {{3, 2, 1}, {3, 2, 1}, {3, 2, 1}};
        int[][] expectedResult = {{1, 2, 3}, {1, 2, 3}, {1, 2, 3}};

        RotateMatrix sut = new RotateMatrix();
        var actualResult = sut.rotate(actualInput);
        assertArrayEquals(expectedResult, actualResult);
    }

    @Test
    void test_EmptyInputReturnsEmptyArray() {
        int[][] actualInput = {{}};
        int[][] expectedResult = {{}};

        RotateMatrix sut = new RotateMatrix();
        var actualResult = sut.rotate(actualInput);
        assertArrayEquals(expectedResult, actualResult);
    }

    @Test
    void test_SingleLengthInputsReturnEmptyArray() {
        int[][] actualInput = {{1, 1, 1}};
        int[][] expectedResult = {{}};

        RotateMatrix sut = new RotateMatrix();
        var actualResult = sut.rotate(actualInput);
        assertArrayEquals(expectedResult, actualResult);
    }

    @Test
    void test_DoubleLengthInputsReturnsEmptyArray() {
        int[][] actualInput = {{1, 1, 1}, {2, 2, 2}};
        int[][] expectedResult = {{}};

        RotateMatrix sut = new RotateMatrix();
        var actualResult = sut.rotate(actualInput);
        assertArrayEquals(expectedResult, actualResult);
    }

    @Test
    void test_StillNotLongEnoughInputReturnsEmptyArray() {
        int[][] actualInput = {{1, 1, 1, 1}, {2, 2, 2, 2}};
        int[][] expectedResult = {{}};

        RotateMatrix sut = new RotateMatrix();
        var actualResult = sut.rotate(actualInput);
        assertArrayEquals(expectedResult, actualResult);
    }
}
