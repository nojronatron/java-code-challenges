# Sorting Algorithms

There are many ways to sort values within various data structures.

This project will store record of my learnings while studying and applying sorting algorithm fundamentals, for just a few of the more common algorithms.

Java code (and tests of course) are stored in this project after all design steps are completed.

Not all sort algorithms will be explored and, in some cases, alternate algorithms might be employed and in these cases documentation will discuss the decision making process and the implementation.

## Design Steps

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

- [X] First Shot Sorting (solving without preparatory studying)
- [X] Insertion Sort
- [ ] Bubble Sort
- [ ] Heap Sort
- [ ] Quick Sort
- [ ] Merge Sort
- [ ] Counting Sort
- [ ] Bucket Sort

-- -

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

``` text
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

### Insertion Sort JavaCode

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

-- -

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

### First Shot Retrospective

Overall, the algorithm is short, clear, and does the job. Some improvements in the design would be:

- Return should be void if this is an in-place operating function.
- Using an inner while iteration instead of nested for loops to control the indexing is very inefficient.
- Eliminating the test for sorted or not and allowing the iterators to run their course in a staggered fashion should fully sort the array and save a few lines of code.

Since completing this challenge I have updated the Java Code to implement the retrospective improvements with these results:

- Big-O in Time significantly reduced. For a 6-element array, O(2.5n) is achieved, and the time to complete an array of 100,000 elements is cut in half compared to the original algorithm design.
- Code is even simpler and easier to read.

## Footer

Return to [Root README](../README.md)
