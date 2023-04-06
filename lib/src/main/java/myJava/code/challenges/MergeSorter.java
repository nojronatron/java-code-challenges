package myJava.code.challenges;

public class MergeSorter {
  /*
   * Entry point to the algorithms starts recursion
   * Because sorting is done in place no return needed
   */
  public void mergeSort(int[] inputArr) {
    int arrStart = 0;
    partition(arrStart, inputArr.length - 1, inputArr);
  }

  /*
   * Recursively find midpoint in input array until length 1
   * then return forces previous recursed function to call
   * merge function to put sub arrays into sorted order
   */
  public void partition(int arrStart, int arrEnd, int[] inputArr) {
    if (arrStart == arrEnd) {
      return;
    }

    int arrStartEndDiff = arrEnd - arrStart;
    int mid = arrStartEndDiff % 2 == 0 ? arrStartEndDiff / 2 : (arrStartEndDiff + 1) / 2;
    mid += arrStart;
    int leftEnd = mid - 1;

    partition(arrStart, leftEnd, inputArr);
    partition(mid, arrEnd, inputArr);
    merge(arrStart, mid, arrEnd, inputArr);
  }

  /*
   * Alternate between left and right halves to copy items to temp array
   * Temp array items then copied over input array in sorted order
   */
  public void merge(int start, int midPoint, int end, int[] inputArr) {
    int leftIDX = start;
    int rightIDX = midPoint;
    int tempIDX = start;
    int[] tempArray = new int[inputArr.length];

    while (leftIDX < midPoint && rightIDX <= end) {
      // copy left item to temp array if in correct position
      if (inputArr[leftIDX] <= inputArr[rightIDX]) {
        tempArray[tempIDX] = inputArr[leftIDX];
        leftIDX++;
      } else {
        // copy right item to temp array to correct position
        tempArray[tempIDX] = inputArr[rightIDX];
        rightIDX++;
      }
      tempIDX++;
    }

    // copy left-side array items to temp array
    for (int fillIDX = leftIDX; fillIDX < midPoint; fillIDX++) {
      tempArray[tempIDX] = inputArr[fillIDX];
      tempIDX++;
    }

    // copy right-side array items to temp array
    for (int fillIDX = rightIDX; fillIDX <= end; fillIDX++) {
      tempArray[tempIDX] = inputArr[fillIDX];
      tempIDX++;
    }

    // only copy if end is greater than start
    if (end + 1 - start >= 0)
      System.arraycopy(tempArray, start, inputArr, start, end + 1 - start);
  }
}
