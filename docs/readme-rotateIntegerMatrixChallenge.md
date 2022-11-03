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

I will update this section with Pseudocode that represents the working Java solution after it is built and fully tested.

## Test Approach

Use JUnit Jupiter.

Test happy paths. The challenge included 2 example input-output sets of data so those are the happiest paths of all:

- Input `[[1,1,1],[2,2,2],[3,3,3]]` => `[[3,2,1],[3,2,1],[3,2,1]]`
- Input `[[3,2,1],[3,2,1],[3,2,1]]` => `[[3,3,3],[2,2,2],[1,1,1]]`

Test multiple rotations:

- 0 to 180: `[[1,1,1],[2,2,2],[3,3,3]]` => `[[3,3,3],[2,2,2],[1,1,1]]`
- 90 to 270: `[[3,2,1],[3,2,1],[3,2,1]]` = `[[1,2,3],[1,2,3],[1,2,3]]`

Test empty or too small inputs:

- `[]` => `[]`
- `[[]]` => `[[]]`
- etc
