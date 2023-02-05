package myJava.code.challenges;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class TestLargestPossibleProductBasic {
    @Test
    public void test_CanInstantiateClass() {
        var sut = new LargestPossibleProduct_Basic();
        assertNotNull(sut);
    }

    @Test
    public void test_EmptyCollectionInputReturnsZero() {
        var sut = new LargestPossibleProduct_Basic();
        ArrayList<Integer> emptyInput = new ArrayList<>();
        int expectedResult = 0;
        int actualResult = sut.LargestProduct(emptyInput);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void test_SingleItemInCollectionReturnsThatItemOrZero() {
        var sut = new LargestPossibleProduct_Basic();
        ArrayList<Integer> arrayInput = new ArrayList<>();
        arrayInput.add(0);
        int expectedZeroResult = 0;
        int actualZeroResult = sut.LargestProduct(arrayInput);
        assertEquals(expectedZeroResult, actualZeroResult);

        arrayInput.clear();
        arrayInput.add(11);
        int expectedSingleResult = 11;
        int actualSingleResult = sut.LargestProduct(arrayInput);
        assertEquals(expectedSingleResult, actualSingleResult);
    }

    @Test
    public void test_TwoItemCollectionsInputsReturnExpectedValues() {
        var sut = new LargestPossibleProduct_Basic();
        ArrayList<Integer> arrayInput = new ArrayList<>();
        arrayInput.add(10);
        arrayInput.add(11);
        int expectedResult = 110;
        int actualResult = sut.LargestProduct(arrayInput);
        assertEquals(expectedResult, actualResult);

        arrayInput.clear();
        arrayInput.add(10);
        arrayInput.add(0);

        // expectedResult cannot be 10 because arrayInput.get(1) is 0
        expectedResult = 10;
        actualResult = sut.LargestProduct(arrayInput);
        assertNotEquals(expectedResult, actualResult);
    }

    @Test
    public void test_ThreeOrMoreItemsCollectionsInputsReturnExpectedValues() {
        var sut = new LargestPossibleProduct_Basic();
        ArrayList<Integer> arrayInput = new ArrayList<>();
        arrayInput.add(2);
        arrayInput.add(10);
        arrayInput.add(20);
        int expectedResult = 400;
        int actualResult = sut.LargestProduct(arrayInput);
        assertEquals(expectedResult, actualResult);

        arrayInput.clear();
        arrayInput.add(1);
        arrayInput.add(2);
        arrayInput.add(3);
        expectedResult = 6;
        actualResult = sut.LargestProduct(arrayInput);
        assertEquals(expectedResult, actualResult);

        arrayInput.clear();
        arrayInput.add(-1);
        arrayInput.add(2);
        arrayInput.add(3);
        expectedResult = -6;
        actualResult = sut.LargestProduct(arrayInput);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void test_ManyItemsInCollectionInputReturnsExpectedValue() {
        var sut = new LargestPossibleProduct_Basic();
        ArrayList<Integer> arrayInput = new ArrayList<>();

        for (int idx = -1000; idx <= 100; idx++) {
            arrayInput.add(idx);
        }

        int expectedResult = 970_200;
        int actualResult = sut.LargestProduct(arrayInput);
        assertEquals(expectedResult, actualResult);
    }
}
