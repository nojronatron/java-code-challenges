package myJava.code.Sorters;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestQuicksort {
  @Test
  public void test_SwapFunction() {
    int[] inputArr = { 5, 2, 3, 4, 1 };
    int leftItem = 0;
    int rightItem = 4;
    int[] expectedResult = { 1, 2, 3, 4, 5 };
    printArray(inputArr);
    myJava.code.Sorters.Quicksort.swap(leftItem, rightItem, inputArr);
    printArray(inputArr);
    assertArrayEquals(expectedResult, inputArr);
  }

  @Test
  public void test_GetMiddleFunction() {
    int first = 1;
    int last = 3;
    int expectedResult = 2;
    assertEquals(expectedResult, myJava.code.Sorters.Quicksort.getMiddle(first, last));

    first = 0;
    last = 2;
    expectedResult = 1;
    assertEquals(expectedResult, myJava.code.Sorters.Quicksort.getMiddle(first, last));

    first = 0;
    last = 1;
    expectedResult = 1;
    assertEquals(expectedResult, myJava.code.Sorters.Quicksort.getMiddle(first, last));

    first = 0;
    last = 10;
    expectedResult = 5;
    assertEquals(expectedResult, myJava.code.Sorters.Quicksort.getMiddle(first, last));

    first = 10;
    last = 20;
    expectedResult = 15;
    assertEquals(expectedResult, myJava.code.Sorters.Quicksort.getMiddle(first, last));
  }

  @Test
  public void test_MoveFunction() {
    int[] inputArr = { 4, 2, 3, 4, 1 };
    int newValIdx = 4;
    int holeIdx = 0;
    int[] expectedResult = { 1, 2, 3, 4, 1 };
    printArray(inputArr);
    myJava.code.Sorters.Quicksort.move(newValIdx, holeIdx, inputArr);
    printArray(inputArr);
    assertArrayEquals(expectedResult, inputArr);
  }

  @Test
  public void test_Pivoter() {
    int leftIdx = 0;
    int[] inputArr = { 5, 4, 3, 2, 1 };
    int[] expectedResult = { 1, 2, 3, 4, 5 };
    printArray(inputArr);
    myJava.code.Sorters.Quicksort.pivoter(leftIdx, inputArr.length - 1, inputArr);
    printArray(inputArr);
    assertArrayEquals(expectedResult, inputArr);

    leftIdx = 0;
    inputArr = new int[] { 2, 1 };
    expectedResult = new int[] { 1, 2 };
    printArray(inputArr);
    myJava.code.Sorters.Quicksort.pivoter(leftIdx, inputArr.length - 1, inputArr);
    printArray(inputArr);
    assertArrayEquals(expectedResult, inputArr);
  }

  @Test
  public void test_PartitionFunctionExitsWithOnlyTwoElements() {
    int[] inputArr = { 2, 1 };
    int leftItem = 0;
    int rightItem = 1;
    int[] expectedResult = { 1, 2 };
    printArray(inputArr);
    myJava.code.Sorters.Quicksort.partition(leftItem, rightItem, inputArr);
    printArray(inputArr);
    assertArrayEquals(expectedResult, inputArr);
  }

  @Test
  public void test_PartitionFunctionProcessesWithThreeElements() {
    int[] inputArr = { 3, 2, 1 };
    int leftItem = 0;
    int rightItem = 2;
    int[] expectedResult = { 2, 1, 3 };
    printArray(inputArr);
    myJava.code.Sorters.Quicksort.partition(leftItem, rightItem, inputArr);
    printArray(inputArr);
    assertArrayEquals(expectedResult, inputArr);
  }

  @Test
  public void test_PartitionFunctionProcessesWithFourElements() {
    int[] inputArr = { 4, 3, 2, 1 };
    int leftItem = 0;
    int rightItem = 3;
    int[] expectedResult = { 2, 3, 1, 4 };
    printArray(inputArr);
    myJava.code.Sorters.Quicksort.partition(leftItem, rightItem, inputArr);
    printArray(inputArr);
    assertArrayEquals(expectedResult, inputArr);
  }

  @Test
  public void test_goldenPath() {
    var inputArr = new int[] { 15, 5, -5, 0, 20, -10, 10 };
    var expectedResult = new int[] { -10, -5, 0, 5, 10, 15, 20 };
    printArray(inputArr);
    myJava.code.Sorters.Quicksort.quickSort(inputArr);
    printArray(inputArr);
    assertArrayEquals(expectedResult, inputArr);
  }

  @Test
  public void test_largeRandomInput() {
    int expectedLength = 6_000_000;
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

    myJava.code.Sorters.Quicksort.quickSort(inputArr);
    assertArrayEquals(expectedArr, inputArr);
  }

  @Test
  public void test_singleElementReturnsSorted() {
    var inputArr = new int[] { 11 };
    var expectedResult = new int[] { 11 };
    printArray(inputArr);
    myJava.code.Sorters.Quicksort.quickSort(inputArr);
    printArray(inputArr);
    assertArrayEquals(expectedResult, inputArr);
  }

  @Test
  public void test_twoElementSortedReturnsSorted() {
    var inputArr = new int[] { 0, 10 };
    var expectedResult = new int[] { 0, 10 };
    printArray(inputArr);
    myJava.code.Sorters.Quicksort.quickSort(inputArr);
    printArray(inputArr);
    assertArrayEquals(expectedResult, inputArr);
  }

  @Test
  public void test_twoElementUnsortedReturnsSorted() {
    var inputArr = new int[] { 10, 0 };
    var expectedResult = new int[] { 0, 10 };
    printArray(inputArr);
    myJava.code.Sorters.Quicksort.quickSort(inputArr);
    printArray(inputArr);
    assertArrayEquals(expectedResult, inputArr);
  }

  @Test
  public void test_duplicateElementsInArrayUnsortedReturnsSorted() {
    var inputArr = new int[] { -10, 5, 10, 5, 0 };
    var expectedResult = new int[] { -10, 0, 5, 5, 10 };
    printArray(inputArr);
    myJava.code.Sorters.Quicksort.quickSort(inputArr);
    printArray(inputArr);
    assertArrayEquals(expectedResult, inputArr);
  }

  @Test
  public void test_firstAndLastElementSwappedReturnsSorted() {
    int[] inputArr = new int[] { 60, 20, 30, 40, 50, 10 };
    int[] expectedResult = new int[] { 10, 20, 30, 40, 50, 60 };
    printArray(inputArr);
    myJava.code.Sorters.Quicksort.quickSort(inputArr);
    printArray(inputArr);
    assertArrayEquals(expectedResult, inputArr);
  }

  private static void printArray(int[] arr) {
    StringBuilder result = new StringBuilder("[");
    for (int idx = 0; idx < arr.length; idx++) {
      result.append(arr[idx]).append(",");
    }
    result.delete(result.length() - 1, result.length());
    result.append("]");
    System.out.printf("Current array contents: %s%n", result);
  }

}
