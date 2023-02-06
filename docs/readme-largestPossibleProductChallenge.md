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

## Second Attempt: Using a Stack

This time I implemented a custom generic Stack as a data structure to help solve the problem.

### Using a Stack: Code Design Comments

Issues with the designed code:

- I failed to check for an empty Stack in the returning portion of the function.
- Certain combinations of numbers within the collection will not get processed correctly.

### Using a Stack: Final Tested Code Comments

Overview:

- Created a static nested generic Stack class with a static nested generic Node class to fully encapsulate the entire solution.
- Leveraged isEmpty method on Stack class to avoid NullPointerException.
- Reworked main logic using three Stacks, filtering out any 0 value, loading empty Stacks so each holds only 1 item using a helper function.
- Reworked the final output logic (multiplication) to account for: zeroes in any Stack; any empty Stack.

### Using a Stack: Pseudocode

The following Pseudocode is here as practice and shows a partially complete solution, unable to properly sort certain Collection combinations:

```text
DECLARE: Class LargestPossibleProductsStack
DECLARE: Function LargestProduct
INPUT: "Collection" as a List of integers
OUTPUT: An integer
TEST: Collection Size is greater less than 1
    TRUE: Return 0
INITIALIZE: myStack <- new Stack of type Integer
ITERATE: Each CurrentItem in Collection
    TEST: CurrentItem equals 0
        TRUE: Continue with next iteration
    TEST: myStack is empty
        EXECUTE: myStack push <- CurrentItem
        EXECUTE: Continue with next iteration
    INITIALIZE: TempNumber <- myStack peek
    TEST: CurrentItem is larger than TempNumber
        TRUE: myStack push <- CurrentItem
        FALSE:
            EXECUTE: myStack pop
            EXECUTE: myStack push <- CurrentItem
            EXECUTE: myStack push <- TempNumber
TEST: myStack is empty
    TRUE: Return 0
INITIALIZE: idxMax <- Math minimum of Collection size and 3
INITIALIZE: Accumulator <- 1
ITERATE: IDX from 0 to idxMax
    TEST: myStack is NOT empty
        EXECUTE: Accumulator <- Accumulator times myStack pop
RETURN: Accumulator
```

This next pseudocode is a re-write of the above that solves bugs with empty Stacks, lingering zeroes, and incorrect sorting bugs.

```text
DECLARE: Class LargestPossibleProductsStack
DECLARE: Function LargestProduct
INPUT: "Collection" as a List of integers
OUTPUT: An integer
TEST: Collection Size is 0
    RETURN: 0
TEST: Collection Size is 1
    RETURN: Collection value at index 0
INSTANTIATE: myStackOne <- new Stack of type Integer
INSTANTIATE: myStackTwo <- new Stack of type Integer
INSTANTIATE: myStackThree <- new Stack of type Integer
ITERATE: Each CurrentItem in Collection
    TEST: CurrentItem is 0
        CONTINUE: next iteration
    TEST: myStackOne is empty
        EXECUTE: myStackOne <- push CurrentItem
        CONTINUE: next iteration
    TEST: myStackTWo is empty
        EXECUTE: myStackTwo <- push CurrentItem
        CONTINUE: next iteration
    TEST: myStackThree is empty
        EXECUTE: myStackThree <- push CurrentItem
        CONTINUE: next iteration
    INSTANTIATE: thisItem <- function StackSorter <- arguments myStackOne and CurrentItem
    ASSIGN: thisItem <- function StackSorter <- arguments myStackTwo and thisItem
    EXECUTE: function StackSorter <- arguments myStackThree and thisItem
INSTANTIATE: result <- 1
TEST: myStackOne is NOT empty
    EXECUTE: result <- result * myStackOne pop
TEST: myStackTwo is NOT empty
    EXECUTE: result <- result * myStackOne pop
TEST: myStackThree is NOT empty
    EXECUTE: result <- result * myStackOne pop
RETURN: result

DECLARE: Function StackSorter
INPUT: Stack reference and CurrentValue value
OUTPUT: An integer
TEST: CurrentValue is greater than Stack Peek:
    ASSIGN: TempValue <- Stack pop
    EXECUTE: Stack push <- CurrentValue
    RETURN: TempValue
RETURN: CurrentValue
```

This is a bunch of code, which tells me that the Stack data structure is not the best solution.

## Edge Cases

- Input is a very short array, perhaps only one or two items.
- Input has only three items but one or more of them is a zero.
- Input is a very long array, perhaps thousands of items.
- All zeroes in the input array or any length.
- Input example 1 (good variation of higher and lower values).
- Input example 2 (good variation of negative and positive values including 0).

Non-Integer types will not be accepted by the function because of Java's strongly-typed nature.

## Algorithm Analysis

### Basic Algorithm Analysis

Time Efficiency: O(n)

Space Efficiency: O(1)

Problem? It fails to meet Edge Case requirements, so efficiency doesn't really matter.

### Using a Stack Algorithm Analysis

Time: O(n)

Space: O(n) :arrow_right: I did not add code to limit the number of entries so the Stack *could* reach the same size as the input collection.

Problem? Only that Space O(n) is a little large for some scenarios, and this could be improved.

## Code and Test Cases

### Code

The Challenge Code can be found in these packages:

- [myJava.code.challenge BASIC](../lib/src/main/java/myJava/code/challenges/LargestPossibleProductBasic.java).
- [myJava.code.challenge STACK](../lib/src/main/java/myJava/code/challenges/LargestPossibleProductStack.java).

### Tests

Test for this Challenge Code can be found in these packages:

- [myJava.code.challenge BASIC](../lib/src/test/java/myJava/code/challenges/TestLargestPossibleProductBasic.java).
- [myJava.code.challenge STACK](../lib/src/test/java/myJava/code/challenges/TestLargestPossibleProductStack.java).

## Key Takeaways

- When defaulting a value into variables that might be used in the final calculation, be careful to filter-out those values so only the input values are used.
- Use a Data Structure and reap the benefits of code-reuse, efficiency, and a complete solution.
- Writing pseudocode can actually help write better code. In this case, my code was harder to read before writing pseudocode, which prompted refactoring multiple nested IF statements into a simpler, single level, logical set of IF statements with a single ELSE.

## Footer

Return to [root readme](../README.md)
