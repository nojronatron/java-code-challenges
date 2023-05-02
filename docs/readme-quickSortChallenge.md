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

Since quicksort is an unstable sort, my solution does not consider the starting relative order of the elements. For example, a KV Array like `[ {3, 'charlie'}, {11 'king'}, {1, 'alpha'}, {2, 'bravo'}, {11, 'kilo'}, {4, 'delta'}, {0, 'null'} ]` contains duplicate key 11. While the algorithms sorts the array it will not consider any difference between `{11, 'king'}` and `{11, 'kilo'}`. Object with value 'king' could indeed end up at following 'kilo'. If the algorithms was stable, '11, king' would always appear earlier in the sorted array than '11, kilo' with this provided input array. There are other ways to make the sorting algorithm stable but I will not address it here given the expectation that Quicksort is _not_ a stable sorting algorithm generally.

Recursion is used to call functions repeatedly until an exit condition is met. In this case, there is no need to break a sub-array of size less than 3 into smaller components, so that will be the exit condition.

### Additional Design Considerations

- [ ] I want to be able to sort any Number types, to applying an appropriate Generic Interface will be necessary.
- [ ] In the future it would be great to allow sorting other types beyond Numbers.

## Pseudocode

```text
DECLARE: Function Quicksort
INPUT: Array NumberArray
OUTPUT: void
THROWS: NullPointerException
IF: NumberArray Size Less Than 2
  RETURN: void
INITIALIZE: LeftIdx <- 0
INITIALIZE: RightIdx <- NumberArray Size - 1
CALL: Function Pivoter <- LeftIdx, RightIdx, NumberArray
RETURN: void
```

```text
DECLARE: Function Pivoter
INPUT: Number FirstIdx, Number LastIdx, Array NumberArray
OUTPUT: void
IF: LastIdx - FirstIdx Less Than 1
  RETURN: void
IF: LastIdx - FirstIdx Equals 1
  IF: NumberArray at FirstIdx GT NumberArray at LastIdx
    CALL: Swap <- FirstIdx, LastIdx, NumberArray
  RETURN: void
INITIALIZE: Number LowerIdx <- LastIdx
INITIALIZE: Number GreaterIdx <- FirstIdx
INITIALIZE: Number HoleIdx <- Call: GetMiddle <- FirstIdx, LastIdx
INITIALIZE: Number TempValue <- NumberArray at HoleIdx
INITIALIZE: Number FlipFlop <- 1
ITERATE: While LowerIdx Greater Than HoleIdx
  IF: FlipFlop GT 0
    If: NumberArray at GreaterIdx Greater Than Or Equal to TempVal
      CALL: Function Move <- GreaterIdx, HoleIdx, NumberArray
      REASSIGN: HoleIdx <- GreaterIdx
      REASSIGN: FlipFlop <- -1
    INCREMENT: GreaterIdx <- 1
    NEXT: Iteration
  IF: FlipFlop LT 0
    IF: NumberArray at LowerIdx Less Than Or Equal to TempVal
      CALL: Function Move <- LowerIdx, HoleIdx, NumberArray
      REASSIGN: HoleIdx <- LowerIdx
      REASSIGN: FlipFlop <- 1
    DECREMENT: LowerIdx <- 1
    NEXT: Iteration
REASSIGN: NumberArray at HoleIdx <- TempVal
CALL: Function Partition <- FirstIdx, LastIdx, NumerArray
RETURN: void
```

```text
DECLARE: Function GetMiddle
INPUT: Number FirstIdx, Number LastIdx
OUTPUT: Number
INITIALIZE: TempLen <- RightIdx - LeftIdx
IF: TempLen Less Than 2
  RETURN: 0
INITIALIZE: MidIdx <- TempLen Divided By 2
IF: TempLen Modulo 2 Not Equals 0
  REASSIGN: MidIdx <- (MidIdx - 1) Divided By 2
REASSIGN: MidIdx <- MidIdx + LeftIdx
RETURN: MidIdx
```

```text
DECLARE: Function Partition
INPUT: Number LeftIdx, Number RightIdx, NumberArray
THROWS: nothing
INITIALIZE: MidIdx <- Call Function GetMiddle <- LeftIdx, RightIdx
CALL: Pivoter <- LeftIdx, MidIdx-1, NumberArray
CALL: Pivoter <- MidIdx, RightIdx, NumberArray
RETURN: void
```

```text
DECLARE: Function Swap
INPUT: LeftIdx, RightIdx, NumberArray
OUTPUT: void
INITIALIZE: TempValue <- NumberArray at LeftIdx
REASSIGN: NumberArray at LeftIdx <- NumberArray at RightIdx
REASSIGN: NumberARray at RightIdx <- TempValue
RETURN: void
```

```text
DECLARE: Function Move
INPUT: HoleIdx, NewIdx, NumberArray
OUTPUT: void
REASSIGN: NumberArray at HoleIdx <- NumberArray at NewIdx
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

The first-shot implementation attempted to swap values around based on value comparisons and where they were in the array (by index). The pseudocode was based largely on reading the first few paragraphs of the [Wikipedia Article on Quicksort](https://en.wikipedia.org/wiki/Quicksort) (but without going into lots of detail). The descriptions were lacking terminology that I could translate to effective code, and the animated depiction was a little misleading.

- Problem: It did not pass all of the tests. Failing tests were:- Large Random Input; Duplicate elements in unsorted array.

The second-shot implementation used a modified approach based in-part on the reading mentioned above, and _[Essential Algorithms (Wiley) by Rod Stephens]_. Essential Algorithms has been helpful in the past, and it sticks to using pseudocode to depict what the algorithm does, without being tied to a specific language. Sometimes the pseudocode is a little vague or several sentences describe what a section of code should do, intertwined with actual pseudocode. It is an unexpected approach. The basic idea is this:

- Pick a middle index (I chose to simply pick _the_ middle index) and store its value as the 'pivot value', and store the middle index as a 'hole index'.
- From the lowest index (left idx) compare its value to pivot value. If it is greater than pivot value then swap left index value and hole index.
- Then, from the highest index (right side) compare values to pivot and swap the lower-value with the hold index.
- Once the lower- and higher- value index iterations have completed, call a recursive Partition function that again performs the pivoting function.
- Once all sub-arrays of the input array have been sorted using the pivoting function, it should exit and the input array should then be sorted.

## Algorithm Analysis

Pseudocode Time:

- Using a partitioning technique means iterations through the array are distributed in smaller preportions.
- Using recursion instead of end-to-end iterating saves on processing (or re-processing) array values that are already set in place.
- Stepping through the pseudocode using a 9-element array with at least 1 duplicated value can be sorted in less than 30 steps (approx 3N).
- Initial estimate of worst-case performance in time is O(n log n).

Pseudocode Space:

- The Algorithm functions pass index numbers and Array references rather than storing values in separate structures.
- Very few additional local values are generated, although a very small array will cause the Space to jump to an apparent O(n^2).
- Overall, storage is linear, and very quickly becomes insignificant as the input element count increases.
- Index pointers are stored in the execution stack during recursive calls.
- Initial estimate of worst-case performance in space is O(log(n)).

## Retrospectives

The first try code would not pass all tests. Seems like input arrays with duplicate values are not fully sorted before an exit condition is encountered.

After reading a little bit more about Quicksort, it appears that my swap mechanism should really be an enhanced _shift_ that moves the midpoint by 'rotating' the left-most higher-than-mid value and the right-most lower-than-mid value. The trouble with this technique (after exploring it will step-throughs) is the rotation does not always keep lower-value items nearest the start of the array, and can in some cases change a well-placed element into a very wrong index position, never to be returned to a proper index.

## Footer

Return to [Sorting Algorithms readme](./readme-sortingAlgorithms.md)

Return to [Root README](../README.md)
