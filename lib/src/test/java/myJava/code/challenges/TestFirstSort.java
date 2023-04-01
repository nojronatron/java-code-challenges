package myJava.code.challenges;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestFirstSort {
    @Test
    public void test_goldenPath() {
        int[] inputArr = new int[]{10, 20, 5, 15, -5, 0};
        int[] expectedArr = new int[]{-5, 0, 5, 10, 15, 20};
        FirstSort.firstSort(inputArr);
        assertArrayEquals(expectedArr, inputArr);
    }

    @Test
    public void test_firstAndLastElementsSwappedIsReturnedInSortedOrder() {
        int[] inputArr = new int[]{60, 20, 30, 40, 50, 10};
        int[] expectedArr = new int[]{10, 20, 30, 40, 50, 60};
        FirstSort.firstSort(inputArr);
        assertArrayEquals(expectedArr, inputArr);
    }

    @Test
    public void test_twoElementUnsortedArrayIsReturnedInSortedOrder() {
        int[] inputArr = new int[]{2, 1};
        int[] expectedArr = new int[]{1, 2};
        FirstSort.firstSort(inputArr);
        assertArrayEquals(expectedArr, inputArr);
    }

    @Test
    public void test_twoElementSortedArrayIsReturnedInSortedOrder() {
        int[] inputArr = new int[]{1, 2};
        int[] expectedArr = new int[]{1, 2};
        FirstSort.firstSort(inputArr);
        assertArrayEquals(expectedArr, inputArr);
    }

    @Test
    public void test_largeUnsortedArrayIsReturnedInSortedOrder() {
        int expectedLength = 34_000;
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
        var expectedArray = Arrays.stream(duplicateArr).sorted().toArray();
        FirstSort.firstSort(inputArr);
        assertArrayEquals(expectedArray, inputArr);
    }

    @Test
    public void test_arrayWithDuplicateElementsIsReturnedInSortedOrder() {
        int[] inputArr = new int[]{30, 20, 30, 20, 10, 10};
        int[] expectedArr = new int[]{10, 10, 20, 20, 30, 30};
        FirstSort.firstSort(inputArr);
        assertArrayEquals(expectedArr, inputArr);
    }

    @Test
    public void test_zeroLengthArrayIsReturnedUnchanged() {
        int[] inputArr = new int[0];
        int expectedArrayLength = 0;
        FirstSort.firstSort(inputArr);
        assertEquals(expectedArrayLength, inputArr.length); // in-place sort
    }
}
