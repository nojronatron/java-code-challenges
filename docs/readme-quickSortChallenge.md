# Quicksort Challenge

Attempt to develop a quicksort algorithm, develop tests to confirm functionality, and provide algorithmic analysis and a retrospective for learning purposes.

## About Quicksort

Minimal research into Quick Sort reveals these properties of the algorithm:

- Unstable sort: Could change the relational location of value pairs.
- Divide-and-conquer: Uses a partitioning and comparison method.
- In-place: The input array is sorted in-place, so no return value is expected.
- Recursive: The algorithms will call itself and reuse code to perform the sorting operations.

Note: A properly implemented Quicksort algorithms is parallelizable.

## Approach

Original attempts to create a Quicksort algorithm proved to be difficult, so I studied the algorithm presented in _[Essential Algorithms (Wiley) by Rod Stephens]_ among other sources. The final Pseudocode and implemented code will be based directly on Stephens' book. The following comments are a collection of my thoughts made while designing my own, and while studying Stephens' solution.

Quicksort uses divide-and-conquer approach, so a _pivot_ index needs to be determined for sorting values at each pass, and a partitioning function splits the input array (and subsequent sub-arrays) into even smaller sub-arrays. How exactly to determine the pivot index is worth considering in terms of overall efficiency, size of the input, or range of values in the input array. For my solution, I will pick a middle value of a selection from the first index, a middle-ish index, and the last index of the input array.

Since quicksort is an unstable sort, the solution does not consider the starting relative order of the elements. For example, a KV Array like `[ {3, 'charlie'}, {11 'king'}, {1, 'alpha'}, {2, 'bravo'}, {11, 'kilo'}, {4, 'delta'}, {0, 'null'} ]` contains duplicate key 11. While the algorithms sorts the array it will not consider any difference between `{11, 'king'}` and `{11, 'kilo'}`. An Object with value 'king' could end up at following 'kilo'. If the algorithm was stable, '11, king' would always appear earlier in the sorted array than '11, kilo' with this provided input array. There are other ways to make the sorting algorithm stable but I will not address it here given the expectation that Quicksort is _not_ a stable sorting algorithm.

Recursion is used to call functions repeatedly until an exit condition is met. In this case, there is no need to break a sub-array of size less than 2 into smaller components because an array of a single element _is sorted_.

### Additional Design Considerations

- [ ] I want to be able to sort any Number types, to applying an appropriate Generic Interface will be necessary.
- [ ] In the future it would be great to allow sorting other types beyond Numbers.

## Pseudocode

See _[Essential Algorithms (Wiley) by Rod Stephens]_ for the source.

```text
DECLARE: Function Quicksort
INPUT: Array NumberArray
OUTPUT: void
THROWS: n/a

IF: NumberArray Length Less Than 2
  RETURN: void
INITIALIZE: FirstIdx <- 0
INITIALIZE: LastIdx <- NumberArray Length - 1
CALL: Sorter <-FirstIdx, LastIdx, NumberArray
RETURN: void
```

```text
DECLARE: Funtion Sorter
INPUT: Number FirstIDX, Number LastIDX, Array NumberArray
OUTPUT: void
THROWS: n/a

IF: FirstIdx Greater or Equal LastIDX
  RETURN: void
INITIALIZE: DividerValue <- NumberArray at FirstIDX
INITIALIZE: Low <- FirstIDX
INITIALIZE: High <- LastIDX
ITERATE: Do While True
  ITERATE: Do While NumberArray at High Greater Or Equal DividerValue
    REASSIGN: High <- High - 1
    IF: High Less Or Equal Low
      EXECUTE: Break out of this Iterating structure
  IF: High Less Or Equal Low
    REASSIGN: NumberArray at Low <- DividerValue
    EXECUTE: Break out of the OUTER Iterating structure
  REASSIGN: NumberArray at Low <- NumberArray at High
  REASSIGN: Low <- Low + 1
  ITERATE: Do While NumberArray at Low Less Than DividerValue
    REASSIGN: Low <- Low + 1
    IF: Low Greater Or Equal To High
      EXECUTE: Break out of this Iterating structure
  IF: Low Greater Or Equal To High
    REASSIGN: Low <- High
    REASSIGN: NumberArray at High <- DividerValue
    EXECUTE: Break out of the OUTER Iterating structure
  REASSIGN: NumberArray at High <- NumberArray at Low
CALL: Sorter <- FirstIDX, Low - 1, NumbersArray
CALL: Sorter <- Low + 1, LastIDX, NumbersArray
RETURN: void
```

## Test Approach and Cases

As with the other Sorting algorithms, there are a number of tests that should be run. After the first two attempts, additional functions were eliminated and I stuck to Stephens' recommendation. Many tests will be run again the 'quicksort()' function to verify functionality and ability to handle edge cases, usual cases, and does not throw.

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

The third attempt is an implementation based _directly_ off of Stephens' work. The implementation does the following:

1. Tests for an array of size 1, and returns if true.
2. Creates variable to store a Divider value, using the 1st array item. Note: I intent to implement a means to select a more 'median' value.
3. Moves item values less than Divider value to the front of the array.
4. Moves item values greater than or equal to Divider value to the end of the array.
5. Implement a main (outer) looping structure to drive processing.
6. Search the array in reverse order to find item nearest end that has value less than Dividing value. The found item will be moved into the index where Dividing Value came from and a new 'hole' index where the found value came from.
7. When the left and right side search index numbers are equal (or cross-over each other) the searching is completed and the Dividing value is placed at the location where the indices have met.
8. Move the found value to the lower half of the array.
9. Search the array from start to finish for the first item value that is greater or equal than Dividing value, and move that item into the 'hole', storing the 'hole' IDX where the found value was.
10. Same as step 7.
11. Move the found value to the upper half of the array.
12. Call the Quicksort function recursively using the last Index of sub-array LEFT of the Dividing value's Index, and the first Index of the sub-array.
13. Call the Quicksort function recursively using the last Index of the sub-array RIGHT of the Dividing value's Index, and the first Index RIGHT of the Dividing value's index.
14. If the algorithm reaches this point, it is done and the array is now sorted.

## Algorithm Analysis

Analyses provided by _[Essential Algorithms (Wiley) by Rod Stephens]_.

Pseudocode Expected Performance in Time:

- O(n^2).
- Better performance (depending on input) could be as good as O(n log n) performance in time.

Pseudocode Expected Performance in Space:

- O(n).
- A constant storage space is necessary for this algorithm that is related to the input size 1:1.

Note: Using Stacks as storage for this algorithm will increase expected storage space of a Quicksort algorithm, over recursion.

## Retrospectives

The first try code would not pass all tests. Seems like input arrays with duplicate values are not fully sorted before an exit condition is encountered.

After reading a little bit more about Quicksort, it appears that my swap mechanism should really be an enhanced _shift_ that moves the midpoint by 'rotating' the left-most higher-than-mid value and the right-most lower-than-mid value. The trouble with this technique (after exploring it will step-throughs) is the rotation does not always keep lower-value items nearest the start of the array, and can in some cases change a well-placed element into a very wrong index position, never to be returned to a proper index.

My second attempt was able to pass more tests, but not all of them. After some additional reading I decided to implement Stephen's pseudocode as Java and run my tests against it (they all passed). Analyzing his algorithm it turns out:

- Partitioning doesn't have to result in two equal (mostly) sides of an existing array.
- Tracking when an element value is in the correct position helps when determining the size of the next partition to recursively sort.
- There are several situations where the algorithm actually calls itself with invalid values like `lo=6, hi=4` which is surprising but the index values check at the beginning causes an immediate return, saving processing cycles and additional conditional statements elsewhere.

In my third attempt I was close however there were edge cases that would:

- Continue executing endlessly due to poorly configured exit conditions.
- Sort the array properly but fail to exit and instead begin to 'un-sort' the data before exiting.

I took this as a hint to just study a working Quicksort algorithm and get a better understanding of what it is doing (and how), implement it, add a feature (picking a Dividing value), testing the solution, and moving on.

- Avoid tracking values an instead track indices and do comparisons.
- Make decisions based on index counters within the array, and whether the current index value is greater, lesser, or equal to the target value.
- Avoid breaking out code into separate methods while developing an algorithm, instead write as few as possible.
- Once an algorithm is working and as unit testing is added, refactor the code for simpler testing, readability, and modularity.
- Timebox code challenges. After performing the seven steps, analyze the solution, research a better solution, and prepare to try the challenge again some other time.

## Footer

Return to [Sorting Algorithms readme](./readme-sortingAlgorithms.md)

Return to [Root README](../README.md)
