# Challenge: Find Largest Possible Sum From Three Numbers In A Collection

## Input and Output

Example inputs were:

```java
public class CodeChallenge {
    ArrayList<Integer> Input1 = { 18,3,42,17,9,27 };
    ArrayList<Integer> Input2 = { 4,0,-5,3,-1,-6,2 };
}
```

Example expected outputs:

```java
public class CodeChallenge {
    int expectedResult = 20_412; // the underscore is used for readability and represents a comma
    int expectedResult = 24;
}
```

## Breaking Down The Problem

The expected input will a collection of type:int, a primitive Integer type that requires less memory than the public final class Integer.

The expected output will be a single value of type:int.

When comparing Integer values there must be something to compare against. Consider finding a larger or smaller value when all you have is an input that could be anything. Using Integer's built-in Constant 'MIN_VALUE' is a good starting point for comparing an input: Either it is the same value or larger.

Traversing through a collection can be done using its indices or otherwise calling an iterator function to get each value exactly once.

Determining a single largest value is fairly easy - just compare the current iteration value with the stored variable value. But how to do this to find the top three variables?

- Could use a Queue to compare and only store larger-than-peek values, but this implies tracking up to three values somewhere within the Queue or otherwise re-enqueuing the value(s). Not bad!
- Use another Array type like a Set and compare each 'current value' against each item stored in the array. There is a free iteration capability here that could be useful.
- Use additional variables and just manually test each one. This sounds very boring and not too efficient, but this is the route I took because traversing the three storage variables was simple to implement and go me to code before running out of time.

When to return the solution? When done looking at all values in the input collection, return the product of the three captured 'largest values'.

This challenge included multiplication which gets complicated when a zero-value is involved, so an added check was necessary to eliminate those from the final 'largest' value set, avoiding an unnecessary zero-value result.

## First Attempt

In this first attempt I approached the problem without using a data structure, relying only on an algorithm. Probably not the best idea I've ever had.

The primary issues with the code:

- The function does not effectively reuse code (no data structure).
- The function does not effectively test for 0 value(s) in the collection, so will fall-over (see test_TwoItemCollectionsInputsReturnExpectedValues).

To get around these weaknesses:

- Additional code was necessary in the Java implementation.
- A test was updated to pass when the condition failed (just for automated test runners in GitHub).

This first attempt code and test suite will be named with the suffix _Basic, and referred to as the Basic Solution.

### Basic Solution Pseudocode

Pseudocode was not completed during the timed challenge. Instead, the algorithm was defined, and then a code solution was created. Therefore, the following Pseudocode was created *based on the completed code* rather than the usual other way around.

```text
DECLARE: Class TechInterview
MEMBERS: Method LargestProduct()

DECLARE: Function LargestProduct
INPUT: Collection of type Integer
OUTPUT: An Integer
THROWS: n/a
TEST: arrList Collection Size is less than 1
    TRUE: RETURN 0
TEST: arrList Collection Size is 1
    TRUE: RETURN arrList at index 0
INITIALIZE: Variable firstValue, secondValue, and thirdValue, as the minimum value of an Integer
ITERATE: Each Item in arrList as currentValue
    TEST: currentValue is 0
        TRUE: Skip to next iteration
    TEST: currentValue is greater than firstValue
        TRUE:
            INITIALIZE: Integer tempValue <- firstValue
            ASSIGN: firstValue <- currentValue
            ASSIGN: currentValue <- tempValue
    TEST: currentValue is greater than secondValue
        TRUE:
            INITIALIZE: Integer tempValue <- secondValue
            ASSIGN: secondValue <- currentValue
            ASSIGN: currentValue <- tempValue
    TEST: currentValue is greater than thirdValue
        TRUE:
            ASSIGN: thirdValue <- currentValue
RETURN: firstValue * secondValue * thirdValue 
```

Note: There are bugs with this pseudocode. Given that this was a timed challenge, debugging the code can soak up a lot of time that just is not available.

## Edge Cases

- Input is a very short array, perhaps only one or two items.
- Input has only three items but one or more of them is a zero.
- Input is a very long array, perhaps thousands of items.
- All zeroes in the input array or any length.

Non-Integer types will not be accepted by the function because of Java's strongly-typed nature.

## Algorithm Analysis

### Basic Algorithm Analysis

Time Efficiency: O(n)

Space Efficiency: O(1)

Problem? It fails to meet Edge Case requirements, so efficiency doesn't really matter.

## Code and Test Cases

### Code

The Challenge Code can be found in these packages:

- [myJava.code.challenge BASIC](../lib/src/main/java/myJava/code/challenges/LargestPossibleProduct_Basic.java).
- [myJava.code.challenge STACK](../lib/src/main/java/myJava/code/challenges/LargestPossibleProduct_Stack.java).

### Tests

Test for this Challenge Code can be found in these packages:

- [myJava.code.challenge BASIC](../lib/src/test/java/myJava/code/challenges/TestLargestPossibleProduct_Basic.java).
- [myJava.code.challenge STACK](../lib/src/test/java/myJava/code/challenges/TestLargestPossibleProduct_Stack.java).

## Key Takeaways

- When defaulting a value into variables that might be used in the final calculation, be careful to filter-out those values so only the input values are used.
- Use a Data Structure and reap the benefits of code-reuse, efficiency, and a complete solution.

## Footer

Return to [root readme](../README.md)
