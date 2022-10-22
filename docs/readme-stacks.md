# Stacks

Stacks are a simple data structure and are commonly used to solve coding problems.

Consider the call stack of an application as a prime example of the use of a Stack data structure.

Create a Stack as a Class and implement Fields and Methods to get the Stack behavior.

## Terminology

FILO: First In Last Out. The first item added to the Stack will be the last item returned by the Stack.

LIFO: Last In First Out: The last item added to the Stack will be the first item returned by the Stack.

## Fields

TOP: A reference pointing to the last item 'pushed' into the Stack.

BOTTOM: A reference pointing to the very first item 'pushed' into the Stack. It will be the last item to be 'popped' out of the Stack.

## Methods

### PUSH

Pushing a value to the Stack will add the current item to the TOP of the Stack.

Pseudocode:

```text
DEFINE: Method Push
INPUT: A Value
OUTPUT: Nothing
INSTANTIATE: Node newNode <- input value
IF: Bottom is NOT equal to Top
    ASSIGN: newNode.Next <- Top
    ASSIGN: Top <- newNode
IF: Bottom is equal to Top AND Stack IsEmpty returns FALSE
    ASSIGN: Top <- newNode
    ASSIGN: Top.Next <- Bottom
IF: IsEmpty returns TRUE
    ASSIGN: Top <- newNode
    ASSIGN: Bottom <- newNode
```

*Note*: With every new call to Push, the logic detects when there are few or no values stored in the Stack so that the TOP and BOTTOM references are managed properly.

### POP

Popping the Stack will return the item at the TOP of the stack.

If there are no items in the Stack, POP will raise an exception.

Top and Bottom references must be updated when there are 2 or fewer Nodes in the Stack.

Pseudocode:

```text
DEFINE: Method Pop
INPUT: Nothing
OUTPUT: A Value
IF: Stack.IsEmpty equals TRUE
    RETURN: Null Pointer Exception
INSTANTIATE: tempNode <- Top
IF: Top Equals Bottom
    ASSIGN: Bottom = null
    ASSIGN: Top = null;
ELSE IF: Top.Next Equals Bottom
    ASSIGN: Top.Next = null
    ASSIGN: Bottom = Top
ELSE:
    ASSIGN: Top <- Top.Next
RETURN: tempNode.Value
```

*Note*: This could be refactored to eliminate the else-if and else statements.

A NullPointerException class could optionally be added to the method using the `throws` method keyword.

### PEEK

Allows viewing the TOP item in the Stack without 'popping' it off the Stack.

If there are no items in the Stack, PEEK will raise an exception.

Pseudocode:

```text
DEFINE: Method Peek
INPUT: Nothing
OUTPUT: A Value
IF: Stack.IsEmpty
    RETURN: Null Pointer Exception
ELSE:
    RETURN: Top.Value
```

*Note*: The Null Pointer Exception should be raised using the method keyword `throws`.

### IS EMPTY

Returns true if the Stack is empty, false if there are items in the Stack.

Pseudocode:

```text
DEFINE: Method IsEmpty
INPUT: Nothing
OUTPUT: Boolean
IF: Top equals Bottom
    IF: Top equals Null
        RETURN: True
ELSE:
    RETURN: False
```

*Note*: This method can be refactored to a single boolean return statement, see actual code.

## Big-O Analysis

PUSH: No traversal is necessary to add an item to the stack. Individual reassignments are performed and are all O(1) in time. A Node is created and added to the Stack, incrementing total storage at a 1:1 ratio. Time: O(1); Space: O(1).

POP: No traversal is necessary to remove an item from the stack. Individual reassignments (including nullification) are performed, which are all O(1) in time. A temporary Node is created, and then destroyed. Time: O(1); Space: O(1).

PEEK: No traversal is necessary to view the value on the TOP ref node. No temporary Nodes or variables are created, so no additional storage is consumed. Time: O(1); Space: O(1);

ISEMPTY: No traversal is performed, only an O(1) comparison of TOP and BOTTOM nodes is done. Time: O(1); Space: O(1);

Overall Performance: Time: O(1); Space: O(1).

## Code

[MyStack Code](../lib/src/main/java/myJava/code/models/MyStack.java)

## Unit Tests

Approach:

- Implement JUnit Jupiter test framework.
- Ensure the Stack Class can be instantiated.

Test Happy Paths:
- IsEmpty() returns true when empty, false in any case when there are 1 or more items in the Stack.
- Pop() returns the Value stored in Top and removes it from the Stack if the Stack has items in it, otherwise it raises an exception.
- Push(value) adds an item to the Stack whether the Stack is empty or not.
- Peek() returns the value of Top if the Stack has items in it, otherwise it raises an exception.

Test Edge Cases (non-exhaustive list):

- Test adding and removing multiple values, verifying size increases and decreases as expected.
- Test peek function with zero items in Stack throws Null Pointer Exception.
- Test peek function with, one, few, and many items, verifying top's value is returned but size stays the same.
- Test pop function with zero items in Stack throws Null Pointer Exception.

[Unit Test File](../lib/src/test/java/myJava/code/models/TestMyStack.java)

## Resources and Acknowledgements

- Code Fellows Common Curriculum: Data Structures and Algorithms

## Footer

Return to [root readme](../README.md)
