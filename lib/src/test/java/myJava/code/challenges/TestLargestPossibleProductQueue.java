package myJava.code.challenges;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TestLargestPossibleProductQueue {
    @Test
    public void test_CanInstantiateClass() {
        var sut = new LargestPossibleProductQueue();
        assertNotNull(sut);
    }

    @Test
    public void test_EmptyCollectionInputReturnsZero() {
        var sut = new LargestPossibleProductQueue();
        ArrayList<Integer> emptyInput = new ArrayList<>();
        int expectedResult = 0;
        int actualResult = sut.largestProduct(emptyInput);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void test_SingleItemInCollectionReturnsThatItemOrZero() {
        var sut = new LargestPossibleProductQueue();
        ArrayList<Integer> arrayInput = new ArrayList<>();
        arrayInput.add(0);
        int expectedZeroResult = 0;
        int actualZeroResult = sut.largestProduct(arrayInput);
        assertEquals(expectedZeroResult, actualZeroResult);

        arrayInput.clear();
        arrayInput.add(11);
        int expectedSingleResult = 11;
        int actualSingleResult = sut.largestProduct(arrayInput);
        assertEquals(expectedSingleResult, actualSingleResult);
    }

    @Test
    public void test_TwoItemCollectionsInputsReturnExpectedValues() {
        var sut = new LargestPossibleProductQueue();
        ArrayList<Integer> arrayInput = new ArrayList<>();
        arrayInput.add(10);
        arrayInput.add(11);
        int expectedResult = 110;
        int actualResult = sut.largestProduct(arrayInput);
        assertEquals(expectedResult, actualResult);

        arrayInput.clear();
        arrayInput.add(10);
        arrayInput.add(0);

        expectedResult = 10;
        actualResult = sut.largestProduct(arrayInput);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void test_ThreeOrMoreItemsCollectionsInputsReturnExpectedValues() {
        var sut = new LargestPossibleProductQueue();
        ArrayList<Integer> arrayInput = new ArrayList<>();
        arrayInput.add(2);
        arrayInput.add(10);
        arrayInput.add(20);
        int expectedResult = 400;
        int actualResult = sut.largestProduct(arrayInput);
        assertEquals(expectedResult, actualResult);

        arrayInput.clear();
        arrayInput.add(1);
        arrayInput.add(2);
        arrayInput.add(3);
        expectedResult = 6;
        actualResult = sut.largestProduct(arrayInput);
        assertEquals(expectedResult, actualResult);

        arrayInput.clear();
        arrayInput.add(-1);
        arrayInput.add(2);
        arrayInput.add(3);
        expectedResult = -6;
        actualResult = sut.largestProduct(arrayInput);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void test_ManyItemsInCollectionInputReturnsExpectedValue() {
        var sut = new LargestPossibleProductQueue();
        ArrayList<Integer> arrayInput = new ArrayList<>();

        for (int idx = -1000; idx <= 100; idx++) {
            arrayInput.add(idx);
        }

        int expectedResult = 970_200;
        int actualResult = sut.largestProduct(arrayInput);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void test_ExampleInputOneReturnsExampleOutputOne() {
        var sut = new LargestPossibleProductQueue();
        ArrayList<Integer> arrayInput = new ArrayList<>();
        arrayInput.add(18);
        arrayInput.add(3);
        arrayInput.add(42);
        arrayInput.add(17);
        arrayInput.add(9);
        arrayInput.add(27);
        int expectedResult = 20_412;
        int actualResult = sut.largestProduct(arrayInput);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void test_ExampleInputWithNegativeNumbersReturnsExampleOutputTwo() {
        var sut = new LargestPossibleProductQueue();
        ArrayList<Integer> arrayInput = new ArrayList<>();
        arrayInput.add(4);
        arrayInput.add(0);
        arrayInput.add(-5);
        arrayInput.add(3);
        arrayInput.add(-1);
        arrayInput.add(-6);
        arrayInput.add(2);
        int expectedResult = 24;
        int actualResult = sut.largestProduct(arrayInput);
        assertEquals(expectedResult, actualResult);
    }
}
