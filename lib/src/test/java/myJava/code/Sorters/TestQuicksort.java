package myJava.code.Sorters;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestQuicksort {
  @Test
  public void test_swapValues() {
    Integer[] inputArr = { -2, -1, 0, 1, 2 };
    int leftIdx = 0;
    int rightIdx = 0;
    Integer[] expectedAlpha = { -2, -1, 0, 1, 2 };

    Quicksort.swap(leftIdx, rightIdx, inputArr);
    assertArrayEquals(expectedAlpha, inputArr);

    leftIdx = 1;
    rightIdx = 3;
    Integer[] expectedBravo = { -2, 1, 0, -1, 2 };

    Quicksort.swap(leftIdx, rightIdx, inputArr);
    assertArrayEquals(expectedBravo, inputArr);

    Quicksort.swap(rightIdx, leftIdx, inputArr);
    assertArrayEquals(expectedAlpha, inputArr);

    leftIdx = 0;
    rightIdx = 2;
    Integer[] expectedCharlie = { 0, -1, -2, 1, 2 };

    Quicksort.swap(leftIdx, rightIdx, inputArr);
    assertArrayEquals(expectedCharlie, inputArr);
  }

  @Test
  public void test_GeMiddleIndexFunction() {
    int first = 0;
    int length = 3;
    int expectedResult = 1;
    assertEquals(expectedResult, Quicksort.getMiddleIndex(first, length));

    first = 0;
    length = 2;
    expectedResult = 1;
    assertEquals(expectedResult, Quicksort.getMiddleIndex(first, length));

    first = 10;
    length = 3;
    expectedResult = 11;
    assertEquals(expectedResult, Quicksort.getMiddleIndex(first, length));

    first = 2;
    length = 3;
    expectedResult = 3;
    assertEquals(expectedResult, Quicksort.getMiddleIndex(first, length));

    first = 10;
    length = 100;
    expectedResult = 60;
    assertEquals(expectedResult, Quicksort.getMiddleIndex(first, length));

    first = 10;
    length = 99;
    expectedResult = 59;
    assertEquals(expectedResult, Quicksort.getMiddleIndex(first, length));
  }

  @Test
  public void test_GetDigidingIdxFunction() {
    Integer[] inputArr = { 5, 4, 3, 2, 1 };
    int first = 0;
    int length = inputArr.length;
    int expectedResult = 2;
    assertEquals(expectedResult, Quicksort.getDividingIdx(first, length, inputArr));

    first = 0;
    length = 2;
    expectedResult = 1;
    assertEquals(expectedResult, Quicksort.getDividingIdx(first, length, inputArr));

    first = 0;
    length = 1;
    expectedResult = 0;
    assertEquals(expectedResult, Quicksort.getDividingIdx(first, length, inputArr));

    first = 2;
    length = 3;
    expectedResult = 3;
    assertEquals(expectedResult, Quicksort.getDividingIdx(first, length, inputArr));

    first = 1;
    length = 3;
    expectedResult = 2;
    assertEquals(expectedResult, Quicksort.getDividingIdx(first, length, inputArr));
  }

  @Test
  public void test_quicksorterTwoTests() {
    int leftIdx = 0;
    Integer[] inputArr = { 5, 4, 3, 2, 1 };
    Integer[] expectedResult = { 1, 2, 3, 4, 5 };
    printArray(inputArr);
    Quicksort.quicksorter(leftIdx, inputArr.length - 1, inputArr);
    printArray(inputArr);
    assertArrayEquals(expectedResult, inputArr);

    leftIdx = 0;
    inputArr = new Integer[] { 2, 1 };
    expectedResult = new Integer[] { 1, 2 };
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
    var inputArr = new Integer[] { 15, 5, -5, 0, 20, -10, 10 };
    var expectedResult = new Integer[] { -10, -5, 0, 5, 10, 15, 20 };
    printArray(inputArr);
    Quicksort.quickSort(inputArr);
    printArray(inputArr);
    assertArrayEquals(expectedResult, inputArr);
  }

  @Test
  public void test_goldenPathFloat() {
    var inputArr = new Float[] { 15.1f, 5.2f, -5.3f, 0.4f, 20.5f, -10.6f, 10.7f };
    var expectedResult = new Float[] { -10.6f, -5.3f, 0.4f, 5.2f, 10.7f, 15.1f, 20.5f };
    printArray(inputArr);
    Quicksort.quickSort(inputArr);
    printArray(inputArr);
    assertArrayEquals(expectedResult, inputArr);
  }

  @Test
  public void test_goldenPathDouble() {
    var inputArr = new Double[] { 15.1d, 5.2d, -5.3d, 0.4d, 20.5d, -10.6d, 10.7d };
    var expectedResult = new Double[] { -10.6d, -5.3d, 0.4d, 5.2d, 10.7d, 15.1d, 20.5d };
    printArray(inputArr);
    Quicksort.quickSort(inputArr);
    printArray(inputArr);
    assertArrayEquals(expectedResult, inputArr);
  }

  @Test
  public void test_goldenPathStrings() {
    var inputArr = new String[] { "foxtrot", "delta", "bravo", "charlie", "golf", "alpha", "echo" };
    var expectedResult = new String[] { "alpha", "bravo", "charlie", "delta", "echo", "foxtrot", "golf" };
    printArray(inputArr);
    Quicksort.quickSort(inputArr);
    printArray(inputArr);
    assertArrayEquals(expectedResult, inputArr);
  }

  @Test
  public void test_goldenPathCharacters() {
    var inputArr = new Character[] { 'f', 'd', 'b', 'c', 'g', 'a', 'e' };
    var expectedResult = new Character[] { 'a', 'b', 'c', 'd', 'e', 'f', 'g' };
    printArray(inputArr);
    Quicksort.quickSort(inputArr);
    printArray(inputArr);
    assertArrayEquals(expectedResult, inputArr);
  }

  @Test
  public void test_largeRandomInput() {
    int expectedLength = 5_000_000;
    Integer[] duplicateArr = new Integer[expectedLength];
    Integer[] inputArr = new Integer[expectedLength];
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
    Integer[] duplicateArr = new Integer[expectedLength];
    Integer[] inputArr = new Integer[expectedLength];
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
    var inputArr = new Integer[] { 11 };
    var expectedResult = new Integer[] { 11 };
    printArray(inputArr);
    Quicksort.quickSort(inputArr);
    printArray(inputArr);
    assertArrayEquals(expectedResult, inputArr);
  }

  @Test
  public void test_twoElementSortedReturnsSorted() {
    var inputArr = new Integer[] { 0, 10 };
    var expectedResult = new Integer[] { 0, 10 };
    printArray(inputArr);
    Quicksort.quickSort(inputArr);
    printArray(inputArr);
    assertArrayEquals(expectedResult, inputArr);
  }

  @Test
  public void test_twoElementUnsortedReturnsSorted() {
    var inputArr = new Integer[] { 10, 0 };
    var expectedResult = new Integer[] { 0, 10 };
    printArray(inputArr);
    Quicksort.quickSort(inputArr);
    printArray(inputArr);
    assertArrayEquals(expectedResult, inputArr);
  }

  @Test
  public void test_duplicateElementsInArrayUnsortedReturnsSorted() {
    var inputArr = new Integer[] { -10, 5, 10, 5, 0 };
    var expectedResult = new Integer[] { -10, 0, 5, 5, 10 };
    printArray(inputArr);
    Quicksort.quickSort(inputArr);
    printArray(inputArr);
    assertArrayEquals(expectedResult, inputArr);
  }

  @Test
  public void test_multipleDuplicateElementsInArrayUnsortedReturnsSorted() {
    var inputArr = new Integer[] { 10, -10, 5, -10, 5, 10 };
    var expectedResult = new Integer[] { -10, -10, 5, 5, 10, 10 };
    printArray(inputArr);
    Quicksort.quickSort(inputArr);
    printArray(inputArr);
    assertArrayEquals(expectedResult, inputArr);
  }

  @Test
  public void test_firstAndLastElementSwappedReturnsSorted() {
    Integer[] inputArr = new Integer[] { 60, 20, 30, 40, 50, 10 };
    Integer[] expectedResult = new Integer[] { 10, 20, 30, 40, 50, 60 };
    printArray(inputArr);
    Quicksort.quickSort(inputArr);
    printArray(inputArr);
    assertArrayEquals(expectedResult, inputArr);
  }

  private static <T extends Comparable<T>> void printArray(T[] arr) {
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
