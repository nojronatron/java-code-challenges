package myJava.code.Sorters;

import java.util.ArrayList;

public class Quicksort {
  /**
   * Entrypoint for Quicksort algorithm.
   * 
   * @param numberArray
   * @throws NullPointerException
   */
  public static void quickSort(int[] numberArray) throws NullPointerException {
    if (numberArray.length < 2) {
      return;
    }

    int firstIdx = 0;
    int lastIdx = numberArray.length - 1;
    Quicksort.quicksorter(firstIdx, lastIdx, numberArray);
    return;
  }

  /**
   * Recursively searches a subarray and sorts it in-place using Quicksort
   * technique.
   * Uses code developed directly from Rod Stephens' Essential Algorithms
   * pseudocode (C)2013.
   * 
   * @param firstIdx
   * @param lastIdx
   * @param numberArray
   */
  public static void quicksorter(int firstIdx, int lastIdx, int[] numberArray) {
    int arrayLength = lastIdx - firstIdx + 1;

    // return if the array has fewer than 2 elements.
    if (firstIdx >= lastIdx) {
      return;
    }

    // find a useful dividing value and store it
    int dividingIdx = getDividingIdx(firstIdx, arrayLength, numberArray);
    int dividerValue = numberArray[dividingIdx];

    // swap the 1st array item with the dividing value
    swap(firstIdx, dividingIdx, numberArray);

    int low = firstIdx;
    int high = lastIdx;
    boolean keepGoing = true;

    while (keepGoing) {
      // find value on the right side of array that is smaller than dividing value
      while (numberArray[high] >= dividerValue) {
        high--;
        if (high <= low) {
          // high now holds index of element with value smaller than dividing value
          // break out of the inner while loop
          break;
        }
      }

      if (high <= low) {
        // if right-side and left-side indices have met
        // copy the dividing value into the low index
        numberArray[low] = dividerValue;
        // break out of the outer while loop
        break;
      }

      // overwrite left-side index with value from right-side index
      numberArray[low] = numberArray[high];
      // value is on the correct side of dividing value
      low++;

      // find value on left side of array that is greater than dividing value
      while (numberArray[low] < dividerValue) {
        low++;
        if (low >= high) {
          // low now holds index of element with value greater than dividing value
          // break out of the inner while loop
          break;
        }
      }

      if (low >= high) {
        // if right-side and left-side indices have met
        // copy the dividing value into the high index
        low = high;
        numberArray[high] = dividerValue;
        // break out of the outer while loop
        break;
      } else {
        // I can only assume this is what Stephens intends
        numberArray[high] = numberArray[low];
      }
    }

    // recursively call quicksorter for elements prior to low index
    quicksorter(firstIdx, low - 1, numberArray);
    // recursively call quicksorter for elements after low index
    quicksorter(low + 1, lastIdx, numberArray);
    return;
  }

  /**
   * Return the index of the element with the 'middle' value.
   * 
   * @param firstIdx
   * @param arrayLength
   * @param numberArray
   * @return int value
   */
  public static int getDividingIdx(int firstIdx, int arrayLength, int[] numberArray) {
    int midIdx = getMiddleIndex(firstIdx, arrayLength);
    int lastIdx = arrayLength - 1 + firstIdx;
    ArrayList<Integer> subArr = new ArrayList<>();
    // 1, 2, 3
    int higher = Math.max(numberArray[firstIdx], numberArray[midIdx]); // 2
    subArr.add(Math.max(higher, numberArray[lastIdx])); // 3
    int lower = Math.min(numberArray[firstIdx], numberArray[midIdx]); // 1
    subArr.add(Math.min(lower, numberArray[lastIdx])); // 1

    if (!subArr.contains(numberArray[firstIdx])) {
      return firstIdx;
    }

    if (!subArr.contains(numberArray[midIdx])) {
      return midIdx;
    }

    return lastIdx;
  }

  /**
   * Calculate the middle index of an arrayLength sized sub-array starting at
   * firstIdx.
   * 
   * @param firstIdx
   * @param arrayLength
   * @return the 'middle' element ID
   */
  public static int getMiddleIndex(int firstIdx, int arrayLength) {
    if (arrayLength % 2 == 0) {
      return (arrayLength / 2) + firstIdx;
    } else {
      return ((arrayLength - 1) / 2) + firstIdx;
    }
  }

  /**
   * Swap values in-place if value at leftIdx is greater than value at rightIdx.
   * 
   * @param leftIdx
   * @param rightIdx
   * @param numberArray
   */
  public static void swap(int leftIdx, int rightIdx, int[] numberArray) {
    int temp = numberArray[leftIdx];
    numberArray[leftIdx] = numberArray[rightIdx];
    numberArray[rightIdx] = temp;
    return;
  }
}
