# Rotate Matrix of Integers

With only 40 minutes and a Miro board, design an algorithm that will 'rotate' a 3x3 matrix of integers clockwise 90 degrees.

Analyze the solution in Big O notation, develop an approach to testing, step through the algorithm, and write Java Code.

## Overview

A matrix is simply an array with multiple arrays within it.

Traversing a 2-dimensional matrix requires a nested-loop structure, to create addresses for the rows and "columns" within the matrix.

Rotating items within the matrix means moving an item from its current location to a new location.

A 90-degree rotation clockwise would move an item in the top-left corner of the matrix, to the top-right corner.

My solution utilizes nested loops and a queue to pull-apart the input arrays, and reconstruct them in a new array with the integers "rotated" 90-degrees clockwise.

## Attempted Algorithm

```text
If inputArray length is less than 3 then return an empty array.
Create an output array of type int[][].
Instantiate a Queue.
Iterate OuterIdx from 0 to 2:
    Iterate InnerIdx from 0 to 2:
        Enqueue value InputArray at [outerIdx][innerIdx]
        Increment InnerIdx
    Increment OuterIdx
Iterate InnerIdx from 2 to 0:
    Iterate OuterIdx from 0 to 2:
        Assign OutputArray at [outerIdx][innerIdx] value from dequeue
        Increment OuterIdx
    Decrement InnerIdx
Return OutputArray
```

There is plenty of room for refactoring here, but with the limited time that was not possible.

## Pseudocode

The pseudocode below was produced *after* actual unit tests were written, and actual Java code was implemented and debugged.

```text
DECLARE: Function Rotate
INPUT: Array of Arrays of type Integer InputArr
OUTPUT: Array of Arrays of type Integer ResultArr

IF: InputArr length is less than 3 OR InputArr Index 0 length is less than 3:
    RETURN: Empty Array of Arrays of type Integer
INSTANTIATE: ResultArr <- New Integer Array of Arrays With Rows of InputArr length and Cols of InputArr at 0 length
INSTANTIATE: Queue <- New Queue of type Integer
INSTANTIATE: OuterLength <- InputArr length
INSTANTIATE: InnerLength <- InputArr at 0 Length
ITERATE: Integer OuterIDX <- 0 to OuterLength increment 1:
    ITERATE: Integer InnerIdx <- 0 to InnerLength increment 1:
        ASSIGN: Queue Enqueue <- InputArr at OuterIDX at InnerIdx
ASSIGN: OuterLength <- ResultArray at 0 Length
ITERATE: Integer Col <- OuterLength-1 to 0 decrement 1:
    ITERATE: Integer Row <- 0 to InnerLength - 1 increment 1:
        ASSIGN: ResultArr at Row at Col <- Queue Dequeue
RETURN: ResultArr
```

### Pseudocode Comments

There is probably some other, more efficient approach to solving this problem.

This solution was developed:

1. Under a strict time limit to start with (see Attempted Algorithm, above).
2. Refined using actual unit tests and actual Java code.

The biggest concern with performance of this algorithm is that with large inputs, the time to complete will grow at a very high rate due to O(N^2) nested iterators.

## Java Code

See the actual code [here in the repo](../lib/src/main/java/myJava/code/challenges/RotateMatrix.java)

## Test Approach

Use JUnit Jupiter.

Test happy paths. The challenge included 2 example input-output sets of data so those are the happiest paths of all:

- Input `[[1,1,1],[2,2,2],[3,3,3]]` => `[[3,2,1],[3,2,1],[3,2,1]]`
- Input `[[3,2,1],[3,2,1],[3,2,1]]` => `[[3,3,3],[2,2,2],[1,1,1]]`

Test multiple rotations:

- 0 to 180: `[[1,1,1],[2,2,2],[3,3,3]]` => `[[3,3,3],[2,2,2],[1,1,1]]`
- 90 to 270: `[[3,2,1],[3,2,1],[3,2,1]]` = `[[1,2,3],[1,2,3],[1,2,3]]`

Test empty or too small inputs:

- ~~`[]` => `[]`~~
- `[[]]` => `[]`
- `[[1,1,1]]` => `[]`
- `[[1,1,1],[2,2,2]]` => `[]`
- `[[1,1,1,1],[2,2,2,2]]`  => `[]`
- `[[1,1],[2,2],[3,3]]` => `[]`

### Unit Tests

See the actual unit tests [here in the repo](../lib/src/test/java/myJava/code/challenges/TestRotateMatrix.java)

## Retrospective

### What Went Well

- Relaxed and confident I could find an answer to the solution throughout the experience.
- Did not worry about getting the algorithm to be efficient, nor the code to be 100% exact.
- Went back to step-through to find a bug in my algorithm, which I then went back and fixed.
- As soon as I mentioned a test case, I went a wrote a test approach section and a few simple test cases.
- My algorithm includes an if statement that catches a bad input.

### What Needs Work

- Initializing an int[] requires a starting size `[inputArray.length]` or an initial array `int[] temp = { 1, 2, 3 };` (I should know this).
- Initializing a 2d array requires `int[][] foo = {{ 1, 2, 3}, ...}`. I know this, too.
- Review different ways to traverse multidimensional arrays to gain more confidence and get to a solution more quickly next time.
- I can take a second out of the challenge time to make the Java Method 'static' and it will make testing much easier.
- While it is okay to use 'outer' and 'inner' for looping through a 2D array, in cases like this one, it might have been easier to understand to use 'row' and 'col'.
- When transcoding from Algorithm to Pseudocode (or Pseudocode to actual Code), be sure to actually write the code as you planned it (don't insert new bugs by not writing what is written).
- Using 'magic numbers' will ensure buggy code, especially for things like for-loops where we are used to writing temporary variables. In this case, we need to use the actual dimensional variables.

### Other Key Takeaways

- Unit tests can have bugs too!
- Whenever approaching a matrix or nested array problem, stick with 'Row and Col' terminology and be prepared to translate that to 'Outer and Inner' within a basic top-to-bottom, left-to-right traversal through the matrix.

## Footer

Return to [ROOT README](../README.md)
