package myJava.code.challenges;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class TestMergeSorter {
    @Test public void test_goldenPath(){
        var sut = new int[]{ 15, 5, -5, 0, 20, -10, 10};
        var sorter = new MergeSorter();
        var expectedResult = new int[]{-10, -5, 0, 5, 10, 15, 20};
        sorter.mergeSort(sut);
        assertArrayEquals(expectedResult, sut);
    }
    @Test public void test_largeRandomInput(){
        int expectedLength = 64_000;
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
        var sorter = new MergeSorter();
        sorter.mergeSort(inputArr);
        assertArrayEquals(expectedArr, inputArr);
    }
    @Test public void test_singleElementReturnsSorted(){
        var sut = new int[]{11};
        var sorter = new MergeSorter();
        var expectedResult = new int[]{11};
        sorter.mergeSort(sut);
        assertArrayEquals(expectedResult, sut);
    }
    @Test public void test_twoElementSortedReturnsSorted(){
        var sut = new int[]{0, 10};
        var sorter = new MergeSorter();
        var expectedResult = new int[]{0, 10};
        sorter.mergeSort(sut);
        assertArrayEquals(expectedResult, sut);
    }
    @Test public void test_twoElementUnsortedReturnsSorted(){
        var sut = new int[]{10, 0};
        var sorter = new MergeSorter();
        var expectedResult = new int[]{0, 10};
        sorter.mergeSort(sut);
        assertArrayEquals(expectedResult, sut);
    }
    @Test public void test_duplicateElementsInArrayUnsortedReturnsSorted(){
        var sut = new int[]{-10, 5, 10, 5, 0};
        var sorter = new MergeSorter();
        var expectedResult = new int[]{-10, 0, 5, 5, 10};
        sorter.mergeSort(sut);
        assertArrayEquals(expectedResult, sut);
    }
    @Test public void test_firstAndLastElementSwappedReturnsSorted(){
        int[] sut = new int[]{60, 20, 30, 40, 50, 10};
        int[] expectedResult = new int[]{10, 20, 30, 40, 50, 60};
        var sorter = new MergeSorter();
        sorter.mergeSort(sut);
        assertArrayEquals(expectedResult, sut);
    }
}
