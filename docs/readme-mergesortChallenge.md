# Merge Sort Challenge

Design a merge sort algorithm.

## First Shot

For starters, create a merge sort algorithm that will sort integer arrays in-place.

This was accomplished using a recursive splitting (divide and conquer) algorithm that would call a custom Merge method that would subsequently call a custom Shift method.

While this worked, it was not very efficient and didn't meet the actual requirements of a merge-sort algorithm (as it is known today).

### Approach

Partition the input array into smaller sub-arrays until each sub-array length is 1, using divide (by 2) and conquer.

Merge sub-arrays together starting with the smallest partitions, then merging larger partitions, until the array is sorted.

Values will be moved in-place on the input array - to make this happen indexes will be tracked and "passed around" between methods.

Finding the middle index of odd and even length arrays is best accomplished by checking if the length can be divided by 2 without remainders.

If there is a remainder then an offset is added so that the 'right sub-array' first index is identified as 'mid' and the 'left sub-array' last index will be one less than mid.

Partitioning will be done recursively.

Merging requires a set of nested iterators that will compare the left-most index to a set of indices to its right, and calling a Shift function to move smaller values from right-to-left.

The Shift function will use the index of the current value, and the index to its right that has a lower value, and _shift_ values, from right-to-left, until the current value is replaced with the lower value, and all values in between are _shifted right_.

There does not need to be a return from any of these methods, as the array is altered in-place.

## Second and Third Attempts

I kept getting stuck trying to move values to the correct locations in the input array, so I started doing some research.

The solution is to use a temporary array to store values, starting with the smallest value, so the temp array would have a sorted version of the currently scoped sub-array, and to then copy-back the temporary sub-array values int othe correct locations in the input array.

Where I was stuck was I didn't leverage an additional variable to track where I was in the temporary array, so the Merge function would either throw an index out of bounds, or would un-sort the items in the temp array or in-place moving.

I ended up looking at Rod Stephens' book *[Essential Algorithms, 2013 Wiley]* and adapted the pseudocode to my solution.

### Example Input and Output

Input: [10, 5, -5, 0, 20, -10, 10]

Expected Output: [-10, -5, 0, 5, 10, 15, 20]

### Pseudocode

```text
CLASS: MergeSorter
FIELDS: none

METHOD: MergeSort
INPUT: InputArray
OUTPUT: void
INITIALIZE: ArrayStart <- 0
CALL: Partition <- ArrayStart, InputArray length minus 1, InputArray
RETURN: void

METHOD: Partition
INPUT: ArrayStart, ArrayEnd, InputArray
OUTPUT: void
IF: ArrayStart equals ArrayEnd RETURN void
INITIALIZE: ArrayStartEndDiff <- ArrayEnd minus ArrayStart
INITIALIZE: Mid
IF: ArrayStartEndDiff modulo 2 Equals 0
    REASSIGN: Mid <- ArrayStartEndDiff divided by 2
ELSE:
    REASSIGN: Mid <- (ArrayStartEndDiff + 1) divided by 2
REASSIGN: Mid <- Mid plus ArrayStart // makes mid index relative to current sub-array size
INITIALIZE: LeftEnd <- Mid minus 1
CALL: Partition <- ArrayStart, LeftEnd, InputArray
CALL: Partition <- Mid, ArrayEnd, InputArray
CALL: Merge <- ArrayStart, Mid, ArrayEnd, InputArray
RETURN: void

Method: Merge
Input: ArrayStart, MidPoint, ArrayEnd, InputArray
OUTPUT: void
INITIALIZE: LeftIDX <- ArrayStart
INITIALIZE: RightIDX <- MidPoint
INITIALIZE: TempIDX <- ArrayStart
INITIALIZE: TempArray <- new Array of same length as InputArray
ITERATE: While LeftIDX less than MidPoint AND RightIDX less or equal to ArrayEnd
    IF: InputArray at LeftIDX less or equal to InputArray at RightIDX
        REASSIGN: TempArray at TempIDX <- InputArray at LeftIDX
        INCREMENT: LeftIDX <- 1
    ELSE:
        REASSIGN: TempArray at TempIDX <- InputArray at RightIDX
        INCREMENT: RightIDX <- 1
    INCREMENT: TempIDX <- 1
ITERATE: From LeftIDX less than MidPoint as FillIDX increment 1
    REASSIGN: TempArray at TempIDX <- InputArray at FillIDX
    INCREMENT: TempIDX <- 1
ITERATE: From RighttIDX less or equal ArrayEnd as FillIDX increment 1
    REASSIGN: TempArray at TempIDX <- InputArray at FillIDX
    INCREMENT: TempIDX <- 1
ITERATE: From ArrayStart less than or equal ArrayEnd as CopyBackIDX increment 1
    REASSIGN: InputArray at CopyBackIDX <- TempArray at CopyBack IDX
RETURN: void
```

## Algorithm Analysis

Time:

- The Partition function takes n-1 steps to isolate individual elements.
- The Merge function has four internal non-nested iterators that will compare and copy, or just copy, data from every index in a worst-case scenario.
- Some rough calculating using an input size of 7 elements array, the algorithms Time efficiency is roughly O(n).
- Further research indicates the algorithm should approach O(n log(n)) in Time.

Space:

- A temporary array is always created during the Merge function operation, which leads to some storage use of size N.
- Algorithm Space efficiency is therefor O(n).

## Test Approach and Cases

JUnit Jupiter test framework will be used.

The Golden Path is for the algorithm to properly sort an array input of [15, 5, -5, 0, 20, -10, 10] to the expected output of [-10, -5, 0, 5, 10, 15, 20].

Other Tests:

- A large, randomize input array is properly sorted.
- A single element array is returned (it is sorted if its only one element)
- Two element array is returned properly sorted.
- A sorted array is returned sorted.
- Arrays containing duplicate items are properly sorted (sort stability is _not_ tested).
- A sorted input array, except 1st and last elements are swapped, is returned sorted.

See the [Test Merge Sorter java file](../lib/src/test/java/myJava/code/challenges/TestMergeSorter.java)

## Java Code

See the [Merge Sorter class java file](../lib/src/main/java/myJava/code/challenges/MergeSorter.java)

## Retrospective Notes

- This was a particularly difficult challenge. While the 1st try took a few hours to design, code, and test (and it worked), it was not _the_ Merge Sort algorithm.
- I utilized my resources once I realized I had run out of ideas for managing the _merge_ process.
- The partitioning function came fairly easily including stop conditions for the recursive calls.
- Getting the "mid-point" calculation correct took me a couple tries. The *[Essential Algorithms (Wiley)]* book suggested a slightly different way to find "mid-point", but in the end it is just 1 or 2 clock ticks saved.
- I could have tried using a temporary array for the Merge function and maybe made progress without peaking at the book.
- There is a `System.arraycopy()` static method that could fold-up the last For iterating structure into a one-liner. Due to an unforeseen situation with IntelliJ IDEA, I left the 'arraycopy' function in the final code. Just call it O(n) there.

## Footer

Return to [Root README](../README.html)
