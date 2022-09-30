# Stacks

Stacks are a simple data structure and are commonly used. Consider the call stack of an application as a prime example.

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
INPUT: A value
OUTPUT: Nothing

```

POP: Popping the Stack will return the item at the TOP of the stack.

PEEK: Allows viewing the TOP item in the Stack without POPping it off the Stack.

## Big-O Analysis

PUSH: No traversal is necessary to add an item to the stack. Takes the new value and assign it's NEXT to the TOP ref, then reassign TOP ref to the new value/node. Time: O(1); Space: O(1).

POP: No traversal is necessary to remove an item from the stack. Takes the value from the TOP ref and reassign TOP's next as the new TOP, then return the value to the caller.

PEEK: No traversal is necessary to view the value on the TOP ref node. Takes the TOP Value and returns that to the caller without changing any REF linkages.

## Unit Tests

## Code

## Resources and Acknowledgements

## Footer

Return to [root readme](../README.md)
