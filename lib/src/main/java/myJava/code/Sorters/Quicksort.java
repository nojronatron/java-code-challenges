package myJava.code.Sorters;

public class Quicksort {
  public static void quickSort(int[] numberArray) throws NullPointerException {
    // if (numberArray.length < 2) {
    // return;
    // }
    // int leftIdx = 0;
    // int rightIdx = numberArray.length - 1;
    // Quicksort.pivoter(leftIdx, rightIdx, numberArray);
    StephensQuicksort.quicksort(numberArray);
    return;
  }

  public static void pivoter(int leftIdx, int rightIdx, int[] numberArray) {
    return;
  }

  public static void move(int newValueIdx, int holeIdx, int[] numberArray) {
    return;
  }

  public static int getMiddle(int leftIdx, int rightIdx) {
    int tempLen = rightIdx - leftIdx + 1;
    int midIdx = tempLen % 2 == 0 ? tempLen / 2 : (tempLen - 1) / 2;
    midIdx += leftIdx;
    return midIdx;
  }

  public static void partition(int leftIdx, int rightIdx, int[] numberArray) {
    return;
  }

  public static void swap(int leftIdx, int rightIdx, int[] numberArray) {
    int temp = numberArray[leftIdx];
    numberArray[leftIdx] = numberArray[rightIdx];
    numberArray[rightIdx] = temp;
    return;
  }
}
