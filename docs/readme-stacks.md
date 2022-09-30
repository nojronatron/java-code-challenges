# Stacks

Stacks are a simple data structure and are commonly used.

Consider the call stack of an application as a prime example.

Create a Stack as a Class and implement Fields and Methods to get the Stack behavior.

## Terminology

FILO: First In Last Out. The first item added to the Stack will be the last item returned by the Stack.

LIFO: Last In First Out: The last item added to the Stack will be the first item returned by the Stack.

## Fields

TOP: A reference pointing to the last item PUSHed to the Stack.

BOTTOM: A reference pointing to the very first item PUSHED to the Stack. It will be the last item POPped.

## Methods

### PUSH

Pushing a value to the Stack will add the current item to the TOP of the Stack.

Pseudocode:

```text
DEFINE: Method Push
INPUT: A Value
OUTPUT: Nothing
INSTANTIATE: Node newNode <- input value
IF: Stack.IsEmpty
    ASSIGN: Top <- newNode
    ASSIGN: Bottom <- newNode
ELSE:
    IF: Bottom is equal to Top
        ASSIGN: Top <- newNode
        ASSIGN: Top.Next <- Bottom
    ELSE:
        ASSIGN: newNode.Next <- Top
        ASSIGN: Top <- newNode
```

### POP

Popping the Stack will return the item at the TOP of the stack.

If there are no items in the Stack, POP will raise an exception.

Pseudocode:

```text
DEFINE: Method Pop
INPUT: Nothing
OUTPUT: A Value
IF: Stack.IsEmpty equals TRUE
    RETURN: An Exception
ELSE:
    INSTANTIATE: tempNode <- Top
    ASSIGN: Top <- Top.Next
    ASSIGN: tempNode.Next <- NULL
    RETURN: tempNode.Value
```

### PEEK

Allows viewing the TOP item in the Stack without POPping it off the Stack.

If there are no items in the Stack, PEEK will raise an exception.

Pseudocode:

```text
DEFINE: Method Peek
INPUT: Nothing
OUTPUT: A Value
IF: Stack.IsEmpty
    RETURN: Exception
ELSE:
    RETURN: Top.Value
```

## IS EMPTY

Returns true if the Stack is empty, false if there are items in the Stack.

Pseudocode:

```text
DEFINE: Method IsEmpty
INPUT: Nothing
OUTPUT: Integer
IF: Top equals Bottom
    IF: Top equals Null
        RETURN: True
ELSE:
    RETURN: False
```

## Big-O Analysis

PUSH: No traversal is necessary to add an item to the stack. Takes the new value and assign it's NEXT to the TOP ref, then reassign TOP ref to the new value/node. Time: O(1); Space: O(1).

POP: No traversal is necessary to remove an item from the stack. Takes the value from the TOP ref and reassign TOP's next as the new TOP, then return the value to the caller.

PEEK: No traversal is necessary to view the value on the TOP ref node. Takes the TOP Value and returns that to the caller without changing any REF linkages.

ISEMPTY: No traversal is performed, only an O(1) comparison of TOP and BOTTOM nodes.

Overall Performance:

Time: O(1)

Space: O(1)

## Code

[MyStack Code](../lib/src/main/java/myJava/code/models/MyStack.java)

## Unit Tests

Approach:

- Implement JUnit Jupiter test framework.
- Ensure the Stack Class can be instantiated.

Test Happy Paths:
- IsEmpty() returns true when empty, false in any case when there are 1 or more items in the Stack.
- Peek() returns the Value stored in Top and removes it from the Stack if the Stack has items in it, otherwise it raises an exception.
- Push(value) adds an item to the Stack whether the Stack is empty or not.
- Pop() returns the value of Top if the Stack has items in it, otherwise it raises an exception.

Test Edge Cases (non-exhaustive list):

- Test adding and removing multiple values, verifying size increases and decreases as expected.
- Test peek function with zero, one, few, and many items, verifying top's value is returned but size stays the same.

[Unit Test File](../lib/src/test/java/myJava/code/models/TestMyStack.java)

## Resources and Acknowledgements

- Code Fellows Common Curriculum: Data Structures and Algorithms

## Footer

Return to [root readme](../README.md)
