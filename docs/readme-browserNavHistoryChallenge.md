# Browser Navigation History Challenge

Design a class that contains method that enable:

- Go to a web address.
- Back into the browser history.
- Forward through the browser history.

## Browser History Behavior

Browser History simply copies the address of visited web pages.

Back and Forward buttons allow travelling "through the history" to the previously accessed web address.

### Chrome

Accessed using `chrome://history` in the address bar.

This is a 'view' into the history of the user's browsed addresses, but it does not reflect how the Back and Forward buttons will operate, per se.

What happens is:

1. The currently viewing website always appears at the *top* of the list.
2. The previously viewed website always appears one place *below* the top entry.
3. Navigating to a website that is farther down the list *removes* that entry from the list and then *adds* it to the *top* of the list.

## Design Approach

Start with an empty list. Given the following functionality, it sounds like a Linked List or Queue could be a good solution.

When an address is entered a GO is clicked, add the address to the front of the list. This could be a Linked List or Stack operation.

When the Back button is pressed, return the address of the previous item in the list and maintain that spot in the list. Queue or Linked List would handle this operation efficiently.

When the Forward button is pressed, only return the next item in the list if it is not null. Linked List and Stack have Head and Top references that correlate relatively well, although a doubly-linked list would literally have a previous == null situation and a Stack does not.

## Algorithm

The algorithm I designed during the 40-minute challenge is as follows:

Create a new class Navigator.
1. Store a doubly-linked list.
2. Store a current reference.
3. Define a Go method.
4. Define a Forward method.
5. Define a Back method.

Go method:
1. Create a new Node using the input string.
2. If current is null, init a new linked list and add newNode to it.
3. Otherwise, insert newNode (at current location).

Forward method:
1. If current next() ref is not null:
2. Reassign current to current next() and then return current value.
3. Otherwise, return an empty string.

Back method:
1. If current previous() ref is not null:
2. Reassign current to current previous() ref and then return current value.
3. Otherwise, return an empty string.

## Pseudocode

During the 40-minute challenge I did not write any pseudocode, so the following was written with what I have learned since completing the challenge, without the time-bound stress.

```text
DEFINE: Class BrowserNavHistory
DECLARE: Private LinkedList field History
DECLARE: Private Integer CurrentIndex
DECLARE: Constructor that takes no arguments and instantiates History and initializes CurrentItem as -1

DEFINE: Class Method Go
INPUT: String Address
OUTPUT: Nothing
IF: Address is empty
    RETURN: Void and exit method
IF: CurrentIndex is greater than -1
    INSERT: Insert Address to History before CurrentIndex
ELSE:
    ADD: History <- Address
    INCREMENT: CurrentIndex
RETURN: Void and exit method

DEFINE Class Method Forward
INPUT: Nothing
OUTPUT: String Address
IF: CurrentIndex is greater than -1
    INCREMENT: CurrentIndex
    RETURN: Address <- History at CurrentIndex
RETURN: Empty String and exit method

DEFINE Class Method Back
INPUT: Nothing
OUTPUT: String Address
IF: CurrentIndex is greater than 0
    DECREMENT: CurrentIndex
    RETURN: Address <- History at CurrentIndex
RETURN: Empty String and exit method
```
## Implementation

See JAVA Class [Browser Nav history](../lib/src/main/java/myJava/code/challenges/BrowserNavHistory.java)

## BigO Analysis

Since this approach relies on a doubly-linked list, and there are no iterators in the algorithm, the analysis will reflect worst-case scenarios for a Linked List.

Time:

- Indexing directly to a Node in a Linked List is a O(1) operation.
- Traversing a single Node forward or back is an O(1) operation.
- Adding a Node to the Linked List is an O(1) operation using a reference to the "current" node (or index as the case may be).
- Overall the time efficiency in worst-case scenario is O(1).

Space:

- Linked Lists are very space efficient in that they only add or remove space when Nodes are added or removed.
- This implementation only adds Nodes, otherwise traverses others, so the space efficiency in worst-case scenario is O(1).

## Test Approach and Test Cases

Since this solution is being developed in Java, JUnit Jupiter will be leveraged for unit testing.

Assertions will be made to verify functionality:

- Class can be instantiated.
- Go(address) function adds a Node.
- Go(address) could throw an IndexOutOfBounds Exception.
- Forward() moves the current pointer to the Node.Next() location and returns that nodes Value.
- Back() moves the current pointer to the Node.Previous() location and returns that nodes Value.
- In cases where Forward() is used but Node.Next() is NULL, an empty String address is returned.
- In cases where Back() is used but Node is Head, an empty String address is returned.
- Happy Path cases will be tested.

## Retrospective

### What Went Well

- Was able to devise a workable solution, with only minor tweaking.
- BigO Analysis was super-succinct! `Space: LL Init is O(1); LL Add Node is O(1); Overall worst-case performance: O(1)`
- Test approach was well built-out and captured the Happy Path as well as several other common cases.

### How I Could Have Done Better

1. Ask the interviewer how they see website history operating.
2. If there is not enough detail around when a web address is "moved to the top", drill-down into that question as part of exploring Go, Forward, and Back button behavior.
3. Review Back and Forward operations to determine if the History list is flat, or if it should be dynamically updated in some way.
4. Focus on solving the problem. Plan to high-level overview how the abstracted data structure functions and only go into detail if asked.
5. Get to writing Pseudocode and Code sooner than later. If you have to, skip Algorithm or Pseudocode, and maybe come back to it later.
6. Consider Negative Test Cases.
7. Remember to at least mention that tests for expected Exceptions will be created, for example: Null Pointer and Index Out Of Bounds are common Exception types in Collections and other Data Structures.

## Footer

Return to [Root README](../README.md)
