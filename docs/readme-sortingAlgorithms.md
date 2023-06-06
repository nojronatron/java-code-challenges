# Sorting Algorithms

There are many ways to sort values within various data structures.

This project will store record of my learnings while studying and applying sorting algorithm fundamentals, for just a few of the more common algorithms.

Java code (and tests of course) are stored in this project after all design steps are completed.

Not all sort algorithms will be explored and, in some cases, alternate algorithms might be employed and in these cases documentation will discuss the decision making process and the implementation.

## Some Overview Notes About Sorting Algorithms

Historically challenging and engaging topic in computer science.

Research in the 1950's discovered many variations of algorithms to get the job done, with various computational requirements in time or processing power, and memory utilization.

It has been proven that:

- Comparison sort algorithms have a fundamental performance requirement of O(n log n).
- Non-comparison sorting algorithms have better performance, all else being equal.
- Small array sorting tends to be fast and space-efficient (arrays less than 20 elements in size).
- Larger array sorting optimization is an open research topic.

### Sorting Algorithm Classifications

Computational Complexity:

- Best, Worst, and Average case behavior, in Big-O notation, tends to plateau at O(n log n), with parallel sort approaching O(log^2 n) and non-optimized near or at O(n^2).

Memory Usage:

- "In Place" algorithms test to need O(1) in space.
- Some sorting algorithms will need O(log n) in space.

Recursion:

- Some are purely recursive.
- Others do not utilize recursion at all.
- Some will have recursive methods.

Stability:

- "Maintain the relative order of records with equal keys".
- Same-value elements, when moved, stay in the same relative order, while being moved to new indexes.
- Non-stable sorts can cause undesirable re-ordering of elements upon a secondary sort, e.g. Sort by Last Name, then by First Name.
- Stability is not a concern when equal elements are indistinguishable e.g. Integers vs Tuples (or KVPs).

Comparison Sort:

- Examine values between only 2 elements.

General Method of Sorting:

- Removing and inserting elements.
- Swapping/Exchanging elements.
- Merging elements.
- Partitioning elements.
- Selecting elements.

Serial vs. Parallel Sorting:

- Single-threaded or otherwise only operating on one focus of elements at a time.
- Multithreaded or otherwise performing sort operations in parallel on the same input.

Adaptive:

- If the input is pre-sorted, does that affect the runtime?
- Non-adaptive will attempt to sort an already sorted input.

Online:

- Can sort a constant stream of input values/elements.

### Leveraging Constraints in Sorting Algorithms

Not all sorting algorithms can sort all input data.

- Some are limited to Integers or other Number-types.
- Some are better with smaller inputs, but much worse with larger inputs and applying a constraint to use them only for smaller inputs is a good optimization step.
- Some are better suited for larger inputs, but much worse with smaller inputs. Again, applying constraints to keep these algorithms executing on an appropriate input size is a good optimization step.
- Some can accepts a streamed input and sort the data 'on the fly', others must work on a known-quantity input.
- Some require knowing the bounds of the input data, e.g. Bucket Sort. If the start and end Keys cannot be identified, Bucket Sort will not be able to adapt to optimize processing for that input.

### Commonly Used Sort Algorithms

- Insertion Sort: Small data sets.
- Heapsort, Mergesort, and Quicksort: Efficient algorithms for larger data sets.
- Hybrid Sorting Algorithms: Leverage Insertion Sort at the top and recursive methods at the bottom.
- Timsort: Android, Java, and Python implement this. Is a "hybrid of Mergesort, Insertion Sort, and some additional logic". _[Wikipedia Sorting_Algorithms]_
- Introsort: Hybrid Quicksort and Heapsort. Utilized in some C++ and DotNET implementations. _[Wikipedia Sorting_Algorithms]_
- Counting Sort and Radix Sort: Used with restricted input data or certain constraints on the input.

## Design Steps to Solving Sort Algorithm Challenges

1. Understand the problem, and break it down into its most simple parts.
2. Write an algorithm that will solve the problem, in plain english.
3. Step through the problem to completion to weed out bugs.
4. Write an analysis of the algorithm using Big-O notation.
5. Write out the test approach, golden path, and some edge cases.
6. Write Pseudocode.
7. Write Java code.

The first 4 or 5 steps will be done on a whiteboard, either Miro or a physical dry-erase board. The essence of those efforts will be recorded here.

Steps 4 through 7 will be recorded in this project directly.

## Table of Sort Algorithms

Here is a table of sort algorithms that (over time) will be explored:

- [x] First Shot Sorting (solving without preparatory studying) [first shot sort and bubble sort](#first-shot-java-code)
- [x] Insertion Sort (simple sorter) [insertion sort](#insertion-sort-java-code)
- [x] Selection Sort (simple sorter) [selection sort](#selection-sort-java-code)
- [x] Bubble Sort (educational, variants are Comb and Exchange) [first shot sort and bubble sort](#first-shot-java-code)
- [ ] Heap Sort (efficient)
- [x] Quicksort (efficient) [quicksort](./readme-quickSortChallenge.md)
- [x] Merge Sort (efficient) [mergesort challenge](./readme-mergesortChallenge.md)
- [ ] Shell Sort (efficient)
- [ ] Counting Sort (distribution sort)
- [ ] Bucket Sort (distribution sort; Integers only)
- [ ] Tree Sort (Used to balance BSTs)

---

## Selection Sort

### Selection Sort Approach and Algorithm

Selection sort attempts to sort by finding the location of the smallest value in a segment of an array and moving it to the beginning index.

Whenever the algorithm moves the current smallest value to the start of the array, it increments the starting index, and does another search, this time ignoring the previous 'smallest value'.

Selection sort repeats these steps until the last 2 indices of the input array have been examined (and perhaps swapped), and then returns the array.

Selection sort works on the input array, sorting it _in place_, so it does not need to return anything.

### Selection Sort Step Through

1. Find minimum value from 1st index through to the last, storing the lowest value index.
2. Swap the value at minimum value index with the first element in the array.
3. Increment the starting element index.
4. Repeat steps 1-3 using the new starting element index.

### Selection Sort Analysis

Selection sort will use nested iterators to 'walk' through the elements:

- The outer loop will be the minimum index, starting at index 0 and ending at 1 less than input array length.
- The inner loop will increment the 'current index', starting at index 1 and ending at the last element in the array (length - 1).
- This arrangement causes the nested loop to operate on less than n^2 elements. For a eight element array, total time would be O(7 + 6 + 5 + 4 + 3 + 2 +1), or about 28 cycles.

In Time: O(n^2) because the nested loops do not reduce the execution time enough to be factored down to O(n log n).

In Space: O(1) because the algorithm performs an in-place sort, creating a constant additional space regardless of the size of the input.

### Selection Sort Test Approach and Tests

Test Framework: JUnit Jupiter

Golden Path: Input `10, 20, 5, 15, -5, 0` results in output `-5, 0, 5, 10, 15, 20`.

Additional Tests:

- Array is sorted except for the 1st and last elements are swapped `[ 60, 20, 30, 40, 50, 10 ]` returns `[10, 20, 30, 40, 50, 60]`
- A two element array in reverse order is returned in correct order: `[ 2, 1 ]` returns `[ 1, 2 ]`
- A two element array is in sorted order and returned unchanged: `[ 1, 2 ]` returns `[ 2, 1 ]`
- Very large array of unsorted inputs is returned sorted.
- Arrays with duplicate integers is properly sorted: `[ 30, 20, 30, 20, 10, 10 ]` returns `[ 10, 10, 20, 20, 30, 30 ]`
- A zero-length array input is returned unchanged.
- A single-length array input is returned unchanged.
- An array with all negative integers is properly sorted: `[ -60, -20, -30, -40, -50, -10 ]` returns `[ -60, -50, -40, -30, -20, -10 ]`

[SelectionSort Test Library](../lib/src/test/java/myJava/code/challenges/TestSelectionSort.java)

### Selection Sort Pseudocode

```text
DECLARE: Static Function SelectionSorter
INPUT: An Array of Numbers
OUTPUT: Nothing
THROWS: n/a

TEST: InputArr size is less than 2 elements
    RETURN: void
INITIALIZE: MinValIndex <- 0
INITIALIZE: MinVal <- Value of InputArr at MinValIndex
ITERATE: From IterationIndex = 0 to InputArr size - 2, increment 1
    REASSIGN: MinValIndex <- IterationIndex
    ITERATE: From CurrentIndex = 1 to InputArr size - 1, increment 1
        TEST: Value of InputArr at CurrentIndex is less than Value of InputArr at IterationIndex
            REASSIGN: MinValIndex <- CurrentIndex
    REASSIGN: MinVal <- InputArr at MinValIndex
    REASSIGN: InputArr at CurrentIndex <- InputArr at IterationIndex
    REASSIGN: InputArr at IterationIndex <- MinVal
RETURN: Void
```

### Selection Sort Java Code

[SelectionSorter Java Code](../lib/src/main/java/myJava/code/challenges/SelectionSorter.java)

### Selection Sort Retrospective

- Selection Sort tends to be a bit quicker sorting arrays than Insertion Sort.
- Selection Sort requires less code overall than Insertion Sort (which required a LinkedList with the ability to convert LL to an array).
- No value replacement is necessary until the inner iterator has completed finding the index of the lowest value element.
- Value replacement is only necessary if the index of the minimum value has been changed.
- Swapping two values in-place requires creation of a temp variable to store value A, then value A can be replaced with value B, then value B can be replaced with the temp value (A).

---

## Insertion Sort

The goal of insertion sort takes input items and places them in-order into an empty collection or data structure.

### Insertion Sort Approach and Algorithm

Insertion Sort utilizes a Linked List, and adds array items one at a time, inserting or adding them depending on value comparisons.

The Linked List must have the following members:

- Field: Head
- Function: GetNext()
- Function: Add
- Function: ToArray() :arrow-left: Custom for this challenge
- Function: AddSort() :arrow-left: Custom for this challenge

Once all array items have been added to the Linked List, an traversal is performed to copy values from head to tail (not including null) into a new, sorted array.

The sorted array is returned to the caller.

Insertion Sort Algorithm:

1. Return null if null or empty is input.
2. Instantiate the Linked List with the 1st item in the input array.
3. For each element of input array, add the element in low-to-high sorted order into the Linked List.
4. Once done, call `ToArray()` and return the results to the caller.

Linked List Function ADD SORT Algorithm:

1. Function accepts an Integer Value and returns nothing.
2. Create new variable NewNode using input Value.
3. Create new reference Current Node and set to Linked List Head.
4. Iterate over the next code block until Current reference is null.
5. If Current Node is Head and Input Value is less than Head value, insert New Node as Head, then exit this function.
6. If Current Node Next is null then set Current Node Next reference as New Node, then exit this function.
7. If Current Node is less than or equal to Input Value AND input Value is less than Current Node Next ref's value, set New Node Next reference to Current Node Next, and set Current Node Next to New Node, and then exit this function.
8. As a final step in the While Iteration, replace Current Node ref with Current Node Next Ref (traversing to next Node in the Linked List), and continue to the next iteration.
9. End of function after all iterations of While loop have run without exiting.

Helper Function ToArray Algorithm:

1. Function takes input integer array, an integer Size, and returns a new array of integers.
2. Create a new integer array Result Array set to Size, as received via input.
3. Create an integer variable IDX and assign value 0.
4. Create Node reference Current and reference Linked List Head.
5. Create an iteration that executes while Current is not null.
6. Assign Result Array at IDX the value of Current Value.
7. Reassign Current to Current Next reference.
8. Increment IDX by 1.
9. Return ResultArr and exit the function.

### Insertion Sort Step Through

Stepping through the algorithm revealed a few bugs in my initial design:

- Handle duplicate values in input array: Of the four possible states (including null), Equals must be checked otherwise the value will not get added to the Linked List.
- Utilize a 'Previous' reference: This is only necessary when input value is less than or equal to the current value, and the current value is not Head.
- While utilizing an `ArrayList<T>` can be convenient, doing so adds to storage use and adds steps while converting it back to an integer Array, which is another O(n) operation, further increasing time to execute.

### Insertion Sort Analysis

There are three items to consider in analysing space and time:

1. Parent function Insertion sort
2. LinkedList custom function AddSort
3. Helper function ToArray.

Insertion Sort:

- Time: O(n). Code execution time grows as input grows given a while loop that traverses n-1 input elements.
- Space: O(n). Storage is added by n-elements to enable returning a result.

AddSort - TIME:

- Inserting a new Head Node is an O(1) operation.
- Traversing a Linked List could be as bad as O(n), so inserting a Node at the tail is O(n).
- One detail that matters with very small inputs is the entire algorithm only operates upon n-1 elements, which is effectively O(n).
- Overall, the worst-case performance in Time is O(n).

AddSort - SPACE:

- A new Node is created every time this function executes, but only one, regardless of the input size (value).
- Overall, O(1) in Space.

ToArray:

- Time: In order to get the values from the LinkedList into an array, each element MUST be traversed at least once, therefore O(n) in every case.
- Space: A new integer array is created, equaling the size of the original input array (but sorted), so O(n).

### Insertion Sort Test Approach

Since this is Java, JUnit Jupiter will be used.

Golden Path: Input `10, 20, 5, 15, -5, 0` results in output `-5, 0, 5, 10, 15, 20`.

Edge Cases:

- Array is sorted except for the 1st and last elements are swapped `[ 60, 20, 30, 40, 50, 10 ]` returns `[10, 20, 30, 40, 50, 60]`
- A two element array in reverse order is returned in correct order: `[ 2, 1 ]` returns `[ 1, 2 ]`
- A two element array is in sorted order and returned unchanged: `[ 1, 2 ]` returns `[ 2, 1 ]`
- Very large array of unsorted inputs is returned sorted.
- Arrays with duplicate integers is properly sorted: `[ 30, 20, 30, 20, 10, 10 ]` returns `[ 10, 10, 20, 20, 30, 30 ]`
- A zero-length array input is returned unchanged.
- An array with all negative integers is properly sorted: `[ -60, -20, -30, -40, -50, -10 ]` returns `[ -60, -50, -40, -30, -20, -10 ]`

#### Insertion Sort Tests

[TestInsertionSorter](../lib/src/test/java/myJava/code/challenges/TestInsertionSort.java)

### Insertion Sort Pseudocode

The parent class:

```text
DECLARE: Class InsertionSorter
DECLARE: Field LinkedList <- null
```

Main Function InsertionSort:

```text
DECLARE: Static Function InsertionSort
INPUT: Integer Array InputArr
OUTPUT: Integer Array

TEST: InputArr length is less than 1
    RETURN: Integer Array <- new []
INSTANTIATE: LL <- new LinkedList <- InputArr at index 0
INITIALIZE: Integer Idx <- 1
ITERATE: While Idx is less than InputArr Length
    CALL: LL AddSort <- InputArr at Idx
    INCREMENT: Idx <- +1
INITIALIZE: Integer Array ResultArr of size InputArray Length
ASSIGN: Integer Array ResultArr <- ToArray
RETURN: ResultArr
```

LinkedList Function AddSort:

```text
DECLARE Static Function AddSort
INPUT: Integer InputValue
OUTPUT: Void

INSTANTIATE: Node Current <- Head
INSTANTIATE: Node NewNode <- New Node <- InputValue
ITERATE: While Current is not Null
    TEST: Current is Head AND NewNode is LESS or EQUAL to Head
        REASSIGN: NewNode Next <- Head
        REASSIGN: LL Head <- NewNode
        RETURN: (void)
    TEST: Current GetNext is Null
        TEST: Current Next equals Null
            REASSIGN: Current Next <- NewNode
            RETURN: (void)
        TEST: Current LESS or EQUAL to NewNode AND NewNode LESS than Current Next Node
            REASSIGN: NewNode Next <- Current Next
            REASSIGN: Current Next <- New Node
            RETURN: (void)
    REASSIGN: Current <- Current Next
```

Helper Function ToArray:

```text
DECLARE: Static Function ToArray
INPUT: LinkedList LL, Integer size
OUTPUT: Integer Array

INITIALIZE: Integer Array ResultArr <- New Array <- Size InputArr Length
INITIALIZE: Integer IDX <- 0
INSTANTIATE: LL Node Current <- LL GetHead
ITERATE: While Current is not Null
    ASSIGN: ResultArr at IDX <- Current Value
    REASSIGN: Current <- Current Next
    INCREMENT: IDX <- +1
RETURN: ResultArr
```

### Insertion Sort Java Code

[InsertionSorter](../lib/src/main/java/myJava/code/challenges/InsertionSorter.java)

### Insertion Sort Retrospective

While writing the Java code I got a little hung up on static vs instance methods and generics:

- Static methods were helpful in that I didn't have to worry about instantiating the Class level, nor manage any shared Fields.
- Once I stopped adding Generic capabilities to an implementation that would only take Integers, I completed coding quickly.
- Again, once I stopped adding Generics, utilizing static fields was a little simpler (although generic static methods are great, they are best suited for other scenarios).

For the most part the code operates as expected, written almost exactly as the Pseudocode is written:

- Added parameters to AddSort and ToArray methods to make up for not instantiating a Class to store shared Field data.
- Converted primitive comparison operators to `compareTo()` functions to support the generic `LLNode<J>` class.
- Had to add a case for when `Current Node value` equals `inputValue` because only differing values are compared in the Pseudocode logic. This is what test cases are for!
- I had to redesign the solution a 2nd time because I failed to correctly handle cases of equality and the Tail Add case.

The ToArray function could easily be rewritten as a LinkedList built-in function.

A tribute to LL Cool J: `LLNode<J>`

---

## First Shot Sorting Algorithm

Create a function that sorts an array of numbers.

Questions:

- In-place sort? Yes
- Numbers meaning Integers (whole numbers)? Yes
- Sort meaning -infinity < 0 < +infinity? Yes

Example input: `10, 20, 5, 15, -5, 0`

Expected output: `-5, 0, 5, 10, 15, 20`

### First Shot Approach and Algorithm

Function will sort the values within the input array in-place.

- Don't bother processing an array that does not have at least 2 elements.
- Create a tracking mechanism that will allow detection of a sorted array.
- Use index pointer variables to track locations within the input array.
- Compare values as pointer 'left' and pointer 'right' and swap index values of the array in-place.
- Iterate through the array by incrementing both pointers.
- Test whether any changes were made in-place to the array during a full iteration, if not, exit the iteration.
- Return the edited, sorted array.

### First Shot Step Through

1. If input array length is less than 2 return input array.
2. Create a variable IsSorted and set to False.
3. Create an iteration that continues until IsSorted is True.
4. Set IsSorted to True.
5. Initialize a variable LeftIdx for tracking one comparison element and set it to 0.
6. Initialize a variable RightIdx for tracking a second comparison element that will always be 1 index ahead of LeftIdx.
7. Create an iteration that continues until RightIdx equals input array length.
8. Compare: LeftIdx Value greater than RightIdx Value? Swap values between LeftIdx and RightIdx and then set IsSorted to False.
9. Increment LeftIdx and RightIdx by 1 each.
10. Once both iterators have exited return input array.

### First Shot Algorithm Analysis

Time: O(n^2)

- Multiple iterators means each input will cause several lines of code to run multiple times.
- An entire sweep of input array is necessary to verify it is fully sorted.
- There are no checks to finish early during any iteration.

Space: O(1)

- The algorithm does in-place editing of the input array.
- Three temporary variables store values no matter how many elements are in the input.

### First Shot Test Approach

Framework: JUnit Jupiter

Golden Path:

- Input: `[10, 20, 5, 15, -5, 0]`
- Output: `[-5, 0, 5, 10, 15, 20]`

Edge Cases:

- Array is sorted except for the 1st and last elements are swapped `[ 60, 20, 30, 40, 50, 10 ]` returns `[10, 20, 30, 40, 50, 60]`
- A two element array in reverse order is returned in correct order: `[ 2, 1 ]` returns `[ 1, 2 ]`
- A two element array is in sorted order and returned unchanged: `[ 1, 2 ]` returns `[ 2, 1 ]`
- Very large array of unsorted inputs is returned sorted.
- Arrays with duplicate integers is properly sorted: `[ 30, 20, 30, 20, 10, 10 ]` returns `[ 10, 10, 20, 20, 30, 30 ]`
- A zero-length array input is returned unchanged.

Note: I could have added a test containing only negative numbers to address a question in the problem definition.

FirstSort Method [Tests](../lib/src/test/java/myJava/code/challenges/TestFirstSort.java)

BubbleSort Method [Tests](../lib/src/test/java/myJava/code/challenges/TestBubbleSorter.java)

### First Shot Pseudocode

```text
DECLARE: Function FirstSort
INPUT: Primitive integer array IntArr
OUTPUT: Sorted primitive integer array
TEST: IntArr Length is less than 2:
    RETURN: IntArr
INITIALIZE: Boolean IsSorted <- false
ITERATE: While IsSorted is false
    REASSIGN: IsSorted <- true
    INITIALIZE: Integer LeftIdx <- 0
    INITIALIZE: Integer RightIDX <- 1
    ITERATE: While RightIDX is less than IntArr Length
        TEST: IntArr at LeftIdx value greater than IntArr at RightIdx ?
            INITIALIZE: Integer TempValue <- IntArr at LeftIdx
            REASSIGN: IntArr at LeftIdx <- IntArr at RightIdx
            REASSIGN: IntArr at RightIdx <- TempValue
            REASSIGN: IsSorted <- false
        INCREMENT: LeftIDX <- +1
        INCREMENT: RightIDX <- +1
RETURN: IntArr
```

### First Shot Java Code

[FirstSort Java Code](../lib/src/main/java/myJava/code/challenges/FirstSort.java)

[BubbleSorter Java Code](../lib/src/main/java/myJava/code/challenges/BubbleSorter.java)

### First Shot Retrospective

Overall, the algorithm is short, clear, and does the job. Some improvements in the design would be:

- Return should be void if this is an in-place operating function.
- Using an inner iteration instead of calculating a secondary value to control the indexing is very inefficient.
- Eliminating the test for sorted or not and allowing the iterators to run their course in a staggered fashion should fully sort the array and save a few lines of code.

Since completing this challenge I have updated the Java Code to implement the retrospective improvements with these results:

- Big-O in Time significantly reduced. For a 6-element array, O(2.5n) is achieved, and the time to complete an array of 100,000 elements is cut in half compared to the original algorithm design.
- Code is even simpler and easier to read.

After further code challenge studying, it is clear that I wrote a Bubble Sort algorithm.

[Bubble Sort - Wikipedia](https://en.wikipedia.org/wiki/Bubble_sort)

#### Bubble Sort Pseudocode

```test
FUNCTION: BubbleSort
INPUT: Integer Array InputArr
OUTPUT: void
THROWS: n/a
IF: InputArr Length is Greater Than 1
    INITIALIZE: SortedCount <- 0
    ITERATE: While SortedCount Less Than InputArr Length - 1
        INITIALIZE: Idx <- 0
        ITERATE: While Idx Less Than InputArr Length - 1
            IF: InputArr at Idx value is Greater Than InputArr at Idx + 1
                REASSIGN: SortedCount <- 0
                INITIALIZE: TempValue <- InputArr at Idx value
                REASSIGN: InputArr at Idx <- InputArr at Idx + 1 value
                REASSIGN: InputArr at Idx + 1 <- TempValue
            ELSE:
                REASSIGN: SortedCount <- Increment 1
            REASSIGN: Idx <- Increment 1
```

#### Bubble Sort Analysis

Time: Due to nested iterating structures, worst-case is O(n^2)

Space: This algorithm sorts arrays in-place. Worst-case is O(1) for any number of elements.

## References

[Wikipedia](https://en.wikipedia.org/wiki/Sorting_algorithm) article Sorting Algorithms

CodeFellows Sorting Algorithms Curriculum.

## Footer

Return to [Root README](../README.md)
