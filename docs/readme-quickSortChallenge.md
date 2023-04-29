# Quicksort Challenge

Attempt to develop a quicksort algorithm, develop tests to confirm functionality, and provide algorithmic analysis and a retrospective for learning purposes.

## About Quicksort

Minimal research into Quick Sort reveals these properties of the algorithm:

- Unstable sort: Could change the relational location of value pairs.
- Divide-and-conquer: Uses a partitioning and comparison method.
- In-place: The input array is sorted in-place, so no return value is expected.
- Recursive: The algorithms will call itself and reuse code to perform the sorting operations.

## Solution Approach

Quicksort uses divide-and-conquer approach, so a _middle_ index needs to be located, partitioning the input array into two. How exactly to determine the middle index is worth considering in terms of overall efficiency, size of the input, or range of values in the input array. In my case I simply cut the array in half.

Since quicksort is an unstable sort, my solution does not consider the starting relative order of the elements. For example, a KVA array like `[ {3, 'charlie'}, {11 'king'}, {1, 'alpha'}, {2, 'bravo'}, {11, 'kilo'}, {4, 'delta'}, {0, 'null'}]` contains a duplicate value, 11. While the algorithms sorts the array it will not consider any difference between `{11, 'king'}` and `{11, 'kilo'}`. Object with value 'king' could indeed end up at following 'kilo'. If the algorithms was stable, '11, king' would always appear earlier in the sorted array than '11, kilo' with this provided input array.

Recusion is used to call functions over and again, until an exit condition is met. In this case, there is no need to break a sub-array of size less than 3 into 2 components, so that will be the exit condition.

### Additional Design Considerations

- [ ] I want to be able to sort any Number types, to applying an appropriate Generic Interface will be necessary.
- [ ] In the future it would be great to allow sorting other types beyond Numbers.

## Pseudocode

### First Attempt

```text
DECLARE: Function Quicksort
INPUT: Array NumberArray
OUTPUT: void
THROWS: NullPointerException?
IF: NumberArray Size Less Than 2
  RETURN: void
INITIALIZE: LeftIdx <- 0
INITIALIZE: RightIdx <- NumberArray Size - 1
CALL: Function Partition <- LeftIdx, RightIdx, NumberArray
RETURN: void

DECLARE: Function Partition
INPUT: Number LeftIdx, Number RightIdx, NumberArray
THROWS: nothing
INITIALIZE: TempLen <- RightIdx - LeftIdx
IF: TempLen Less Than 2
  RETURN:  void
INITIALIZE: MidIdx <- TempLen Divided By 2
IF: TempLen Modulo 2 Not Equals 0
  REASSIGN: MidIdx <- (MidIdx + 1) Divided By 2
REASSIGN: MidIdx <- MidIdx + LeftIdx
CALL: IterateLeft <- LeftIdx, MidIdx, RightIdx, NumberArray
IF: LeftIdx Less Than MidIdx
  CALL: Partition <- LeftIdx, MidIdx, NumberArray
IF: MidIdx Less Than RightIdx
  CALL: Partition <- MidIdx, RightIdx, NumberArray
RETURN: void

DECLARE: Function IterateLeft
INPUT: LeftIdx, MidIdx, RightIdx, NumberArray
OUTPUT: void
ITERATE: From LeftIdx to MidIdx Step +1
  IF: NumberArray at (Iterator Index) Greater Than NumberArray at MidIdx
      CALL: IterateRight <- LeftIdx, MidIdx, RightIdx, NumberArray
RETURN: void

DECLARE: Function IterateRight
INPUT: LeftIdx, MidIdx, RightIdx, NumberArray
OUTPUT: void
ITERATE: From RightIdx to MidIdx Step -1
  IF: NumberArray at RightIdx Less Than NumberArray at MidIdx
    CALL: Swap <- LeftIdx, RightIdx, NumberArray
    RETURN: void
RETURN: void

DECLARE: Function Swap
INPUTS: LeftIdx, RightIdx, NumberArray
OUTPUT: void
INITIALIZE: TempValue <- NumberArray at LeftIdx
REASSIGN: NumberArray at LeftIdx <- NumberArray at RightIdx
REASSIGN: NumberArray at RightIdx <- TempValue
RETURN: void
```

## Test Approach and Cases

As with the other Sorting algorithms, there are a number of tests that should be run. In the case of the first-attempt pseudocode, additional tests were developed for the helpful functions 'swap()', 'iterateRight()', and 'iterateLeft()'. The inputs were limited with these tests, knowing that a larger number of tests will be run against the static 'quicksort()' function itself.

- Golden Path: `[15, 5, -5, 0, 20, -10, 10]` is sorted to `[-10, -5, 0, 5, 10, 15, 20]`.
- Single element array is not altered.
- Two element sorted and unsorted arrays are sorted.
- A large randomized input is sorted. Timing is included to ensure the maximum number of elements can be sorted within about 1 second.
- Array with duplicate elements is sorted.
- Mostly-sorted array (first and last elements swapped) is sorted.

## Implementation

The first-shot implementation (see pseudocode) does not pass all of the tests. Failing tests are:

- Large Random Input.
- Duplicate elements in unsorted array.

A second attempt at solving this challenge will be done to update this readme, pseudocode, and actual code.

## Algorithm Analysis

Pseudocode Time:

- Using a partitioning technique means iterations through the array are distributed in smaller preportions.
- Using recursion instead of end-to-end iterating saves on processing (or re-processing) array values that are already set in place.
- Stepping through the pseudocode shows that a 6-element array can be sorted in less than n^2 but more than just n.
- Initial estimate of worst-case performance in time is O(n log n). A low-risk gamble would be O(n^2).

Pseudocode Space:

- The Algorithm functions pass index numbers and reference to the Array.
- Very few additional local values are generated, and index pointers are stored in the execution stack during recursive calls.
- Initial estimate of worst-case performance in space is O(log(n)).

## Retrospective

The first try code would not pass all tests. Seems like input arrays with duplicate values are not sorted fully.

After reading a little bit more about Quicksort, it appears that my swap mechanism should really be an enhanced _shift_ that moves the midpoint by 'rotating' the left-most higher-than-mid value and the right-most

## Footer

Return to [Sorting Algorithms readme](./readme-sortingAlgorithms.md)

Return to [Root README](../README.md)
