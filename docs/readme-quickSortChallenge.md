# Quicksort Challenge

Attempt to develop a quicksort algorithm, develop tests to confirm functionality, and provide algorithmic analysis and a retrospective for learning purposes.

## About Quicksort

Minimal research into Quick Sort reveals these properties of the algorithm:

- Unstable sort: Could change the relational location of value pairs.
- Divide-and-conquer: Uses a partitioning and comparison method.
- In-place: The input array is sorted in-place, so no return value is expected.
- Recursive: The algorithms will call itself and reuse code to perform the sorting operations.

## Approach

Quicksort uses divide-and-conquer approach, so a _pivot_ index needs to be determined for sorting values at each pass, and a partitioning function splits the input array (and subsequent array and sub-arrays) into smaller sub-arrays. How exactly to determine the pivot index is worth considering in terms of overall efficiency, size of the input, or range of values in the input array. For my solution, I simply picked the _last index of the array_.

Since quicksort is an unstable sort, my solution does not consider the starting relative order of the elements. For example, a KV Array like `[ {3, 'charlie'}, {11 'king'}, {1, 'alpha'}, {2, 'bravo'}, {11, 'kilo'}, {4, 'delta'}, {0, 'null'} ]` contains duplicate key 11. While the algorithms sorts the array it will not consider any difference between `{11, 'king'}` and `{11, 'kilo'}`. Object with value 'king' could indeed end up at following 'kilo'. If the algorithms was stable, '11, king' would always appear earlier in the sorted array than '11, kilo' with this provided input array. There are other ways to make the sorting algorithm stable but I will not address it here given the expectation that Quicksort is _not_ a stable sorting algorithm.

Recursion is used to call functions repeatedly until an exit condition is met. In this case, there is no need to break a sub-array of size less than 3 into smaller components, so that will be the exit condition.

### Additional Design Considerations

- [ ] I want to be able to sort any Number types, to applying an appropriate Generic Interface will be necessary.
- [ ] In the future it would be great to allow sorting other types beyond Numbers.

## Pseudocode

```text
DECLARE: Function Quicksort
INPUT: Array NumberArray
OUTPUT: void
THROWS: n/a

IF: NumberArray Length EQ 0
  RETURN: void
INITIALIZE: FirstIdx <- 0
INITIALIZE: LastIdx <- NumberArray Length - 1
INITIALIZE: TempIdx <- LastIdx = FirstIdx + 1
IF: TempIdx Less Than 2
  RETURN: void
INITIALIZE: MiddleIdx <- 0
IF: TempIdx Modulo 2 EQ 0
  THEN REASSIGN: MiddleIdx <- TempIdx / 2
  ELSE REASSIGN: MiddleIdx <- (TempIdx - 1) / 2
INITIALIZE: LeftIdx <- CALL LeftLoop <- FirstIdx, MiddleIdx, NumberArray
INITIALIZE: RightIdx <- CALL RightLoop <- MiddleIdx, NumberArray
CALL: Swap <- LeftIdx, RightIdx
CALL: Function Quicksort <- FirstIdx, MiddleIdx, LastIdx, NumberArray
RETURN: void
```

```text
DECLARE: Function LeftLoop
INPUT: LeftIDX, MiddleIDX, NumberArray
OUTPUT: Number
THROWS: n/a

IF: LeftIDX Equals MiddleIDX
  RETURN: MiddleIDX
INITIALIZE: StoredIDX <- LeftIDX
ITERATE: IDX from LeftIDX to MiddleIDX Increment 1
  IF: NumberArray at IDX Greater Or Equal NumberArray at MiddleIDX
    REASSIGN: StoredIDX <- IDX
    BREAK
RETURN: StoredIDX
```

```text
DECLARE: Function RightLoop
INPUT: MiddleIDX, RightIDX, NumberArray
OUTPUT: Number
THROWS: n/a

IF: MiddleIDX Equals RightIDX
  RETURN: MiddleIDX
INITIALIZE: StoredIDX <- MiddleIDX
ITERATE: IDX from RightIDX to MiddleIDX Decrement 1
  IF: NumberArray at RightIDX Less Than NumberARray at MIddleIDX
    REASSIGN: StoredIDX <- IDX
RETURN: StoredIDX
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

The first-shot implementation attempted to swap values around based on value comparisons and where they were in the array (by index). The pseudocode was based largely on reading the first few paragraphs of the [Wikipedia Article on Quicksort](https://en.wikipedia.org/wiki/Quicksort) (but without going into lots of detail). The descriptions were lacking terminology that I could translate to effective code, and the animated depiction was a little misleading.

- Problem: It did not pass all of the tests. Failing tests were:- Large Random Input; Duplicate elements in unsorted array.

The second-shot implementation used a modified approach based in-part on the reading mentioned above, and _[Essential Algorithms (Wiley) by Rod Stephens]_. Essential Algorithms has been helpful in the past, and it sticks to using pseudocode to depict what the algorithm does, without being tied to a specific language. Sometimes the pseudocode is a little vague or several sentences describe what a section of code should do, intertwined with actual pseudocode. It is an unexpected approach. The basic idea is this:

- Pick a middle index (I chose to simply pick _the_ middle index) and store its value as the 'pivot value', and store the middle index as a 'hole index'.
- From the lowest index (left idx) compare its value to pivot value. If it is greater than pivot value then swap left index value and hole index.
- Then, from the highest index (right side) compare values to pivot and swap the lower-value with the hold index.
- Once the lower- and higher- value index iterations have completed, call a recursive Partition function that again performs the pivoting function.
- Once all sub-arrays of the input array have been sorted using the pivoting function, it should exit and the input array should then be sorted.

A third attempt at solving this challenge will appear here.

## Algorithm Analysis

Pseudocode Time:

- A new analysis will be written once Pseudocode has been written.

Pseudocode Space:

- A new analysis will be written once Pseudocode has been written.

## Retrospectives

The first try code would not pass all tests. Seems like input arrays with duplicate values are not fully sorted before an exit condition is encountered.

After reading a little bit more about Quicksort, it appears that my swap mechanism should really be an enhanced _shift_ that moves the midpoint by 'rotating' the left-most higher-than-mid value and the right-most lower-than-mid value. The trouble with this technique (after exploring it will step-throughs) is the rotation does not always keep lower-value items nearest the start of the array, and can in some cases change a well-placed element into a very wrong index position, never to be returned to a proper index.

My second attempt was able to pass more tests, but not all of them. After some additional reading I decided to implement Stephen's pseudocode as Java and run my tests against it (they all passed). Analyzing his algorithm it turns out:

- Partitioning doesn't have to result in two equal (mostly) sides of an existing array.
- Tracking when an element value is in the correct position helps when determining the size of the next partition to recursively sort.
- There are several situations where the algorithm actually calls itself with invalid values like `lo=6, hi=4` which is surprising but the index values check at the beginning causes an immediate return, saving processing cycles and additional conditional statements elsewhere.

## Footer

Return to [Sorting Algorithms readme](./readme-sortingAlgorithms.md)

Return to [Root README](../README.md)
