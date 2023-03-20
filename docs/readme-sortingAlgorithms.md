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
- [ ] Insertion Sort
- [ ] Bubble Sort
- [ ] Heap Sort
- [ ] Quick Sort
- [ ] Merge Sort
- [ ] Counting Sort
- [ ] Bucket Sort

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
