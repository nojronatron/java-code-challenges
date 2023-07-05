package myJava.code.challenges;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestSumRowsIn2DArray {
  @Test
  void test_canInstantiateClass() {
    var sut = new SumRowsIn2DArray();
    assertNotNull(sut);
  }

  @Test
  void test_goldenPath() {
    var sut = new SumRowsIn2DArray();
    int[][] inputArr = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
    int[] expected = { 6, 15, 24 };
    int[] actual = sut.rowSums(inputArr);
    assertArrayEquals(expected, actual);
  }

  @Test
  void test_zeroesInMatrixAreCountedAsZeroes() {
    var sut = new SumRowsIn2DArray();
    int[][] inputArr = { { 1, 2, 0 }, { 0, 0, 0 }, { 0, 8, 9 } };
    int[] expected = { 3, 0, 17 };
    int[] actual = sut.rowSums(inputArr);
    assertArrayEquals(expected, actual);
  }

  @Test
  void test_nullsInRowCountedAsZeroAndDoesNotThrow() {
    var sut = new SumRowsIn2DArray();
    int[][] inputArr = { { 1, 2, 3 }, null, { 7, 8, 9 } };
    int[] expected = { 6, 0, 24 };
    int[] actual = sut.rowSums(inputArr);
    assertArrayEquals(expected, actual);
  }

  @Test
  void test_matrixWithMaxValDoesNotThrow() {
    var sut = new SumRowsIn2DArray();
    int[][] inputArr = { { Integer.MAX_VALUE, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
    int[] expected = { Integer.MAX_VALUE + 5, 15, 24 };
    int[] actual = sut.rowSums(inputArr);
    assertArrayEquals(expected, actual);
  }

  @Test
  void test_matrixWithMinValDoesNotThrow() {
    var sut = new SumRowsIn2DArray();
    int[][] inputArr = { { Integer.MIN_VALUE, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
    int[] expected = { Integer.MIN_VALUE + 5, 15, 24 };
    int[] actual = sut.rowSums(inputArr);
    assertArrayEquals(expected, actual);
  }
}
