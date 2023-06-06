package myJava.code.Sorters;

import java.util.ArrayList;

public class Quicksort {
  /**
   * Entrypoint for Quicksort algorithm for integer array.
   * 
   * @param numberArray
   * @throws NullPointerException
   */
  public static <T extends Comparable<T>> void quickSort(T[] numberArray) throws NullPointerException {
    if (numberArray.length < 2) {
      return;
    }

    int firstIdx = 0;
    int lastIdx = numberArray.length - 1;
    Quicksort.quicksorter(firstIdx, lastIdx, numberArray);
    return;
  }

  // public static void quickSort(int[] numberArray) throws NullPointerException {
  // if (numberArray.length < 2) {
  // return;
  // }

  // int firstIdx = 0;
  // int lastIdx = numberArray.length - 1;
  // Quicksort.quicksorter(firstIdx, lastIdx, numberArray);
  // return;
  // }

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
  public static <T extends Comparable<T>> void quicksorter(int firstIdx, int lastIdx, T[] numberArray) {
    int arrayLength = lastIdx - firstIdx + 1;

    // return if the array has fewer than 2 elements.
    if (firstIdx >= lastIdx) {
      return;
    }

    // find a useful dividing value and store it
    int dividingIdx = getDividingIdx(firstIdx, arrayLength, numberArray);
    T dividerValue = numberArray[dividingIdx];

    // swap the 1st array item with the dividing value
    swap(firstIdx, dividingIdx, numberArray);

    int low = firstIdx;
    int high = lastIdx;
    boolean keepGoing = true;

    while (keepGoing) {
      // find value on the right side of array that is smaller than dividing value
      while (numberArray[high].compareTo(dividerValue) > 0) {
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
      while (numberArray[low].compareTo(dividerValue) < 0) {
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
  public static <T extends Comparable<T>> int getDividingIdx(int firstIdx, int arrayLength, T[] numberArray) {
    int midIdx = getMiddleIndex(firstIdx, arrayLength);
    int lastIdx = arrayLength - 1 + firstIdx;
    ArrayList<T> subArr = new ArrayList<>();
    // 1, 2, 3
    // int higher = Math.max(numberArray[firstIdx], numberArray[midIdx]); // 2
    // subArr.add(Math.max(higher, numberArray[lastIdx])); // 3
    // int lower = Math.min(numberArray[firstIdx], numberArray[midIdx]); // 1
    // subArr.add(Math.min(lower, numberArray[lastIdx])); // 1
    T largerValue = numberArray[firstIdx].compareTo(numberArray[midIdx]) > 0 ? numberArray[firstIdx]
        : numberArray[midIdx];
    T largestValue = largerValue.compareTo(numberArray[lastIdx]) > 0 ? largerValue : numberArray[lastIdx];
    subArr.add(largestValue);
    T smallerValue = numberArray[firstIdx].compareTo(numberArray[midIdx]) < 0 ? numberArray[firstIdx]
        : numberArray[midIdx];
    T smallestValue = smallerValue.compareTo(numberArray[lastIdx]) < 0 ? smallerValue : numberArray[lastIdx];
    subArr.add(smallestValue);

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
  public static <T extends Comparable<T>> void swap(int leftIdx, int rightIdx, T[] numberArray) {
    T temp = numberArray[leftIdx];
    numberArray[leftIdx] = numberArray[rightIdx];
    numberArray[rightIdx] = temp;
    return;
  }
}
