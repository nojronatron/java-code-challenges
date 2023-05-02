package myJava.code.Sorters;

public class Quicksort {
  public static void quickSort(int[] numberArray) throws NullPointerException {
    if (numberArray.length < 2) {
      return;
    }
    int leftIdx = 0;
    int rightIdx = numberArray.length - 1;
    Quicksort.pivoter(leftIdx, rightIdx, numberArray);
    return;
  }

  public static void pivoter(int leftIdx, int rightIdx, int[] numberArray) {
    if (rightIdx - leftIdx < 1) {
      return;
    }
    if (rightIdx - leftIdx == 1) {
      if (numberArray[leftIdx] > numberArray[rightIdx]) {
        Quicksort.swap(leftIdx, rightIdx, numberArray);
      }
      return;
    }

    int lowerIdx = rightIdx;
    int greaterIdx = leftIdx;
    int midIdx = Quicksort.getMiddle(leftIdx, rightIdx);
    int holeIdx = Quicksort.getFirstHoleIdx(leftIdx, midIdx, rightIdx, numberArray);
    int tempValue = numberArray[holeIdx];
    int flipFlop = 1;

    while (lowerIdx >= greaterIdx) {
      if (flipFlop > 0) {
        if (numberArray[greaterIdx] >= tempValue) {
          Quicksort.move(greaterIdx, holeIdx, numberArray);
          holeIdx = greaterIdx;
          flipFlop = -1;
        }
        greaterIdx++;
      } else if (flipFlop < 0) {
        if (numberArray[lowerIdx] <= tempValue) {
          Quicksort.move(lowerIdx, holeIdx, numberArray);
          holeIdx = lowerIdx;
          flipFlop = 1;
        }
        lowerIdx--;
      }
    }

    numberArray[holeIdx] = tempValue;
    Quicksort.partition(leftIdx, rightIdx, numberArray);
    return;
  }

  public static int getFirstHoleIdx(int start, int mid, int end, int[] arr) {
    int midVal = arr[mid];
    int minVal = Integer.MAX_VALUE;
    int maxVal = Integer.MIN_VALUE;

    if (start <= mid - 1 && mid + 1 <= end) {
      for (int idx = 0; idx < 3; idx++) {
        minVal = Math.min(minVal, arr[idx]);
        maxVal = Math.max(maxVal, arr[idx]);
      }
    }

    boolean isMidVal = (maxVal, midVal, minVal) -> {
      return System.Math.min(maxVal, midVal) && System.Math.max(minVal, midVal);
    };

  }

  public static void move(int newValueIdx, int holeIdx, int[] numberArray) {
    numberArray[holeIdx] = numberArray[newValueIdx];
    return;
  }

  public static int getMiddle(int leftIdx, int rightIdx) {
    int tempLen = rightIdx - leftIdx + 1;
    int midIdx = tempLen % 2 == 0 ? tempLen / 2 : (tempLen - 1) / 2;
    midIdx += leftIdx;
    return midIdx;
  }

  public static void partition(int leftIdx, int rightIdx, int[] numberArray) {
    int tempLen = rightIdx - leftIdx + 1;
    if (tempLen < 2) {
      return;
    }

    int midIdx = Quicksort.getMiddle(leftIdx, rightIdx);
    // Quicksort.pivoter(leftIdx, midIdx - 1, numberArray);
    Quicksort.pivoter(leftIdx, midIdx, numberArray);
    Quicksort.pivoter(midIdx, rightIdx, numberArray);
    return;
  }

  public static void swap(int leftIdx, int rightIdx, int[] numberArray) {
    int temp = numberArray[leftIdx];
    numberArray[leftIdx] = numberArray[rightIdx];
    numberArray[rightIdx] = temp;
    return;
  }
}
