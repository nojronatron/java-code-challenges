package myJava.code.Sorters;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestQuicksort {
  @Test
  public void test_swapValues() {
    int[] inputArr = { -2, -1, 0, 1, 2 };
    int leftIdx = 0;
    int rightIdx = 0;
    int[] expectedAlpha = { -2, -1, 0, 1, 2 };

    Quicksort.swap(leftIdx, rightIdx, inputArr);
    assertArrayEquals(expectedAlpha, inputArr);

    leftIdx = 1;
    rightIdx = 3;
    int[] expectedBravo = { -2, 1, 0, -1, 2 };

    Quicksort.swap(leftIdx, rightIdx, inputArr);
    assertArrayEquals(expectedBravo, inputArr);

    Quicksort.swap(rightIdx, leftIdx, inputArr);
    assertArrayEquals(expectedAlpha, inputArr);

    leftIdx = 0;
    rightIdx = 2;
    int[] expectedCharlie = { 0, -1, -2, 1, 2 };

    Quicksort.swap(leftIdx, rightIdx, inputArr);
    assertArrayEquals(expectedCharlie, inputArr);
  }

  @Test
  public void test_quicksorterTwoTests() {
    int leftIdx = 0;
    int[] inputArr = { 5, 4, 3, 2, 1 };
    int[] expectedResult = { 1, 2, 3, 4, 5 };
    printArray(inputArr);
    Quicksort.quicksorter(leftIdx, inputArr.length - 1, inputArr);
    printArray(inputArr);
    assertArrayEquals(expectedResult, inputArr);

    leftIdx = 0;
    inputArr = new int[] { 2, 1 };
    expectedResult = new int[] { 1, 2 };
    printArray(inputArr);
    Quicksort.quicksorter(leftIdx, inputArr.length - 1, inputArr);
    printArray(inputArr);
    assertArrayEquals(expectedResult, inputArr);
  }

  @Test
  public void test_GetMiddleIndexLengthTwo() {
    int firstIdx = 0;
    int length = 2;
    int expectedResult = 1;
    int actualResult = Quicksort.getMiddleIndex(firstIdx, length);
    assertEquals(expectedResult, actualResult);
  }

  @Test
  public void test_GetMiddleIndexLengthThree() {
    int firstIdx = 0;
    int length = 3;
    int expectedResult = 1;
    int actualResult = Quicksort.getMiddleIndex(firstIdx, length);
    assertEquals(expectedResult, actualResult);
  }

  @Test
  public void test_GetMiddleIndexLengthFour() {
    int firstIdx = 0;
    int length = 4;
    int expectedResult = 2;
    int actualResult = Quicksort.getMiddleIndex(firstIdx, length);
    assertEquals(expectedResult, actualResult);
  }

  @Test
  public void test_GetMiddleIndexLengthFive() {
    int firstIdx = 0;
    int length = 5;
    int expectedResult = 2;
    int actualResult = Quicksort.getMiddleIndex(firstIdx, length);
    assertEquals(expectedResult, actualResult);
  }

  @Test
  public void test_goldenPath() {
    var inputArr = new int[] { 15, 5, -5, 0, 20, -10, 10 };
    var expectedResult = new int[] { -10, -5, 0, 5, 10, 15, 20 };
    printArray(inputArr);
    Quicksort.quickSort(inputArr);
    printArray(inputArr);
    assertArrayEquals(expectedResult, inputArr);
  }

  @Test
  public void test_largeRandomInput() {
    int expectedLength = 5_000_000;
    int[] duplicateArr = new int[expectedLength];
    int[] inputArr = new int[expectedLength];
    Random rand = new Random();
    int counter = 0;
    while (counter < expectedLength) {
      int randNum = rand.nextInt(expectedLength);
      inputArr[counter] = randNum;
      duplicateArr[counter] = randNum;
      counter++;
    }
    var expectedArr = Arrays.stream(duplicateArr).sorted().toArray();

    Quicksort.quickSort(inputArr);
    assertArrayEquals(expectedArr, inputArr);
  }

  @Test
  public void test_SmallRandomInput() {
    int expectedLength = 15;
    int[] duplicateArr = new int[expectedLength];
    int[] inputArr = new int[expectedLength];
    Random rand = new Random();
    int counter = 0;
    while (counter < expectedLength) {
      int randNum = rand.nextInt(expectedLength);
      inputArr[counter] = randNum;
      duplicateArr[counter] = randNum;
      counter++;
    }
    var expectedArr = Arrays.stream(duplicateArr).sorted().toArray();

    Quicksort.quickSort(inputArr);
    assertArrayEquals(expectedArr, inputArr);
  }

  @Test
  public void test_singleElementReturnsSorted() {
    var inputArr = new int[] { 11 };
    var expectedResult = new int[] { 11 };
    printArray(inputArr);
    Quicksort.quickSort(inputArr);
    printArray(inputArr);
    assertArrayEquals(expectedResult, inputArr);
  }

  @Test
  public void test_twoElementSortedReturnsSorted() {
    var inputArr = new int[] { 0, 10 };
    var expectedResult = new int[] { 0, 10 };
    printArray(inputArr);
    Quicksort.quickSort(inputArr);
    printArray(inputArr);
    assertArrayEquals(expectedResult, inputArr);
  }

  @Test
  public void test_twoElementUnsortedReturnsSorted() {
    var inputArr = new int[] { 10, 0 };
    var expectedResult = new int[] { 0, 10 };
    printArray(inputArr);
    Quicksort.quickSort(inputArr);
    printArray(inputArr);
    assertArrayEquals(expectedResult, inputArr);
  }

  @Test
  public void test_duplicateElementsInArrayUnsortedReturnsSorted() {
    var inputArr = new int[] { -10, 5, 10, 5, 0 };
    var expectedResult = new int[] { -10, 0, 5, 5, 10 };
    printArray(inputArr);
    Quicksort.quickSort(inputArr);
    printArray(inputArr);
    assertArrayEquals(expectedResult, inputArr);
  }

  @Test
  public void test_multipleDuplicateElementsInArrayUnsortedReturnsSorted() {
    var inputArr = new int[] { 10, -10, 5, -10, 5, 10 };
    var expectedResult = new int[] { -10, -10, 5, 5, 10, 10 };
    printArray(inputArr);
    Quicksort.quickSort(inputArr);
    printArray(inputArr);
    assertArrayEquals(expectedResult, inputArr);
  }

  @Test
  public void test_firstAndLastElementSwappedReturnsSorted() {
    int[] inputArr = new int[] { 60, 20, 30, 40, 50, 10 };
    int[] expectedResult = new int[] { 10, 20, 30, 40, 50, 60 };
    printArray(inputArr);
    Quicksort.quickSort(inputArr);
    printArray(inputArr);
    assertArrayEquals(expectedResult, inputArr);
  }

  private static void printArray(int[] arr) {
    String leftBracket = "[";
    String rightBracket = "]";
    String comma = ",";
    StringBuilder result = new StringBuilder(leftBracket);
    for (int idx = 0; idx < arr.length; idx++) {
      result.append(arr[idx]).append(comma);
    }
    result.delete(result.length() - 1, result.length());
    result.append(rightBracket);
    System.out.printf("Current array contents: %s%n", result);
  }

}
