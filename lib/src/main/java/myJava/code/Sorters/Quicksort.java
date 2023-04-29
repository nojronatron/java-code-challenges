package myJava.code.Sorters;

public class Quicksort {
  public static void quickSort(int[] numberArray) throws NullPointerException {
    if (numberArray.length < 2) {
      return;
    }
    int leftIdx = 0;
    int rightIdx = numberArray.length - 1;
    Quicksort.partition(leftIdx, rightIdx, numberArray);
    return;
  }

  public static void partition(int leftIdx, int rightIdx, int[] numberArray) {
    int tempLen = rightIdx - leftIdx + 1;
    if (tempLen < 2) {
      return;
    }
    int midIdx = (tempLen % 2) != 0 ? (tempLen - 1) / 2 : tempLen / 2;
    midIdx = midIdx + leftIdx;
    Quicksort.iterateLeft(leftIdx, midIdx, rightIdx, numberArray);
    // if (leftIdx < midIdx) {
    Quicksort.partition(leftIdx, midIdx - 1, numberArray);
    // }
    // if (midIdx < rightIdx) {
    Quicksort.partition(midIdx, rightIdx, numberArray);
    // }
    return;
  }

  public static void iterateLeft(int leftIdx, int midIdx, int rightIdx, int[] numberArray) {
    for (int idx = leftIdx; idx <= midIdx; idx++) {
      if (numberArray[idx] >= numberArray[midIdx]) {
        Quicksort.iterateRight(idx, midIdx, rightIdx, numberArray);
      }
    }
    return;
  }

  public static void iterateRight(int leftIdx, int midIdx, int rightIdx, int[] numberArray) {
    for (int idx = rightIdx; idx >= midIdx; idx--) {
      if (numberArray[idx] <= numberArray[midIdx]) {
        Quicksort.swap(leftIdx, idx, numberArray);
        return;
      }
    }
    return;
  }

  public static void swap(int leftIdx, int rightIdx, int[] numberArray) {
    int temp = numberArray[leftIdx];
    numberArray[leftIdx] = numberArray[rightIdx];
    numberArray[rightIdx] = temp;
    return;
  }
}
