package myJava.code.challenges;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestSelectionSort {
    @Test
    void test_goldenPathSortsInputInPlace() {
        int[] inputArr = new int[]{10, 20, 5, 15, -5, 0};
        int[] expectedArr = new int[]{-5, 0, 5, 10, 15, 20};
        SelectionSorter.selectionSort(inputArr);
        assertArrayEquals(expectedArr, inputArr);
    }

    @Test
    public void test_whiteboardExampleSortedInPlace() {
        int[] inputArr = new int[]{10, 15, 5, 25, -5, -10, 0, 20};
        int[] expectedArr = new int[]{-10, -5, 0, 5, 10, 15, 20, 25};
        SelectionSorter.selectionSort(inputArr);
        assertArrayEquals(expectedArr, inputArr);
    }

    @Test
    public void test_firstAndLastElementsSwappedIsReturnedInSortedOrder() {
        int[] inputArr = new int[]{60, 20, 30, 40, 50, 10};
        int[] expectedArr = new int[]{10, 20, 30, 40, 50, 60};
        SelectionSorter.selectionSort(inputArr);
        assertArrayEquals(expectedArr, inputArr);
    }

    @Test
    public void test_twoElementUnsortedArrayIsReturnedInSortedOrder() {
        int[] inputArr = new int[]{2, 1};
        int[] expectedArr = new int[]{1, 2};
        SelectionSorter.selectionSort(inputArr);
        assertArrayEquals(expectedArr, inputArr);
    }

    @Test
    public void test_twoElementSortedArrayIsReturnedInSortedOrder() {
        int[] inputArr = new int[]{1, 2};
        int[] expectedArr = new int[]{1, 2};
        SelectionSorter.selectionSort(inputArr);
        assertArrayEquals(expectedArr, inputArr);
    }

    @Test
    public void test_largeUnsortedArrayIsReturnedInSortedOrder() {
        int expectedLength = 72_000;
        int[] duplicateArr = new int[expectedLength];
        int[] inputArr = new int[expectedLength];
        Random rand = new Random();
        int counter = 0;
        while (counter < expectedLength) {
            int randNum = rand.nextInt();
            inputArr[counter] = randNum;
            duplicateArr[counter] = randNum;
            counter++;
        }
        var expectedArr = Arrays.stream(duplicateArr).sorted().toArray();
        SelectionSorter.selectionSort(inputArr);
        assertArrayEquals(expectedArr, inputArr);
    }

    @Test
    public void test_arrayWithDuplicateElementsIsReturnedInSortedOrder() {
        int[] inputArr = new int[]{30, 20, 30, 20, 10, 10};
        int[] expectedArr = new int[]{10, 10, 20, 20, 30, 30};
        SelectionSorter.selectionSort(inputArr);
        assertArrayEquals(expectedArr, inputArr);
    }

    @Test
    public void test_zeroLengthArrayIsReturnedUnchanged() {
        int[] inputArr = new int[0];
        int expectedArrayLength = 0;
        SelectionSorter.selectionSort(inputArr);
        assertEquals(expectedArrayLength, inputArr.length);
    }

    @Test
    public void test_allNegativeValuesSortedLowestToHighest() {
        int[] inputArr = new int[]{-10, -20, -5, -15, -25, -30};
        int[] expectedArr = new int[]{-30, -25, -20, -15, -10, -5};
        SelectionSorter.selectionSort(inputArr);
        assertArrayEquals(expectedArr, inputArr);
    }
}
