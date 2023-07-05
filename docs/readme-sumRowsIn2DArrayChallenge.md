# Challenge: Sum Rows in 2D Array

## Problem Statement

Write a function to add up the sum of each row in a matrix of arbitrary size and return an array with the appropriate values.

### Questions to Ask

Are the values in the matrix always integers? Yes

Will the matrix always be square? No

Will any row contain zeros? Yes

Will any row contain negative numbers? Yes

Will any row contain null? Yes

Would any input array be null or empty? Yes

Should the function return an empty array if the input array is null or empty? Yes

How should the function handle null values within the matrix? Treat them as zero.

## Input/Output Examples

Example 1:

```java
// input
[
  [1, 2, 3],
  [4, 5, 6],
  [7, 8, 9]
]
```

```java
// output:
[6, 16, 24]
```

Example 2:

```java
// input
[
  [-1, 2, null],
  [4, -5, 6]
]
```

```java
// output:
[1, 5]
```

## Test Approach and Cases

Use JUnit Jupiter test framework.

Golden Path:

- Input and output are same as Example 1 above, and function does not throw.

Additional Tests:

- Matrix containing Nulls does not throw and nulls are counted as zeros: `[ [null, null], [null, 1] ] => [0, 1]`
- Matrix containing negatives does not throw and negatives are counted: `[ [ -1, -2 ], [ -3, 4 ] ] => [ -3, 1 ]`
- Matrix containing MAX_VAL and or MIN_VAL values does not throw (will "roll over" and sum values): `[ [ MAX_VAL, MAX_VAL ], [ MIN_VAL, MIN_VAL ] ] => [ -2, 0 ]`

## Algorithm Design

- Output must be stored as an array of values, so we will need to create an array of the appropriate size.
- A variable must be initialized to store interim summed values within each row.
- Interim sum values variable must be reset between each row.
- A loop must iterate through each row of the matrix.
- A nested loop must iterate through each value in each row.
- Each value must be added to the interim sum variable -- if null then it is actually 0, otherwise it is the value at the current index.
- The interim sum variable must be added to the output array after each row is processed.
- The output array must be returned.

## Algorithm Analysis

Time: The algorithm must process each and every value within the matrix, so the time complexity is O(n) where n is the number of values in the matrix.

Space:

- Time expired before I completed Space analysis, so the following is a post-event analysis.
- The algorithm stores every value in the input matrix array, so the space complexity is O(n).

## Pseudocode

## Java Code and Unit Tests

## Retrospective

## Footer

Return to [Root README](../README.md)
