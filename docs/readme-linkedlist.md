# Linked List

A list of Nodes carrying data, with references linking the Nodes to each other.

There are two common types of Linked Lists:

- Singly: Each Node has a reference only to the Node *following* it.
- Doubly: Each Node has references to the Node *ahead* and following it.

## Lingo

Linked List: Data structure contains Nodes that link (point) to next node in the list. Nodes could also contain data.

Singly: A single reference to another Node, Null, or itself.

Doubly: Two references to one or two other Nodes, Null, or itself.

Node: Abstractions that have a Reference to another Node and a Data property that will store value(s) assigned to them.

Next: Property that contains a reference to Null, self, or another Node.

Head: Property that contains a reference to a Node that is considered "first" in the Linked List.

Current: Property that contains a reference to a Node representing an imaginary pointer.

## Traversal

Unable to use a ForEach or For iterators.

Use the Next reference property to move between Nodes.

Data extraction can happen while the Current pointer is set to a specific Node.

Use a `while` looping structure to traverse a Linked List.

Inside the while loop, check that the Current reference is not Null before continuing the next iteration.

*Note*: Attempting to traverse a Null Node will cause a NullReferenceException that must be handled; better to just avoid it.

## Properties

### Head

A reference pointing to the *first* Node in the Linked List.

Reference the Linked List's Head reference to acquire the first Node and either get the data from it or begin a traversal using the Node's Next property.

## Functions

### Includes

Includes will take a value and search the Linked List Nodes, returning True if a Node with a matching value is found, otherwise returns False.

Algorithm:

```text
ALGORITHM Includes (value)
INPUT: Integer value
OUTPUT: Boolean
ASSIGN: Current <- Head
ITERATE: While Current is not NULL
    IF: Current.Nalue is equal to value return TRUE
    ELSE: Current <- Current.Next
END ITERATE
RETURN: FALSE
```

### Add

Accepts a new value, create a new Node, update new Node's reference to be that of the Head reference, and reassign Head to the new Node.

Algorithm:

```text
ALGORITHM Add(newValue)
INPUT: Value
OUTPUT: Void
INITIALIZE: newNode <- NEW Node
ASSIGN: newNode.Value <- newValue
ASSIGN: newNode.Next <- Head
ASSIGN: Head <- newNode
```

### AddBefore

Insert a new Node before a Node with a specific value.

The algorithm must traverse the Linked List to find the Node with the specified value, then update reference links to insert the input Node before it.

Algorithm:

```text
ALGORITHM AddBefore(newValue, valueToAddBefore)
INPUT: newValue, valueToAddBefore
OUTPUT: Boolean
INITIALIZE: Node Current <- Head
IF: Current is equal to NULL RETURN FALSE
END IF
WHILE: Current.Next is not equal to NULL
    IF: Current.Next.Value is equal to valueToAddBefore
        INSTANTIATE: newNode
        ASSIGN: newNode.Value <- newValue
        ASSIGN: newNode.Next <- Current.Next
        ASSIGN: Current.Next <- newNode
        RETURN: TRUE
    END IF
    ASSIGN: Current <- Current.Next
RETURN: FALSE
```

### Print

Print out all nodes in the Linked List.

Algorithm:

```text
ALGORITHM: Print()
INPUT: None
OUTPUT: String
INITIALIZE: Current <- Head
WHILE: Current is not equal to NULL
    OUTPUT: "[Current.Value]->"
    ASSIGN: Current <- Current.Next
OUTPUT: "NULL"
```

## Big-O Analysis

### Add(value)

Because adding a new Node simply replaces Head and reassigns the Head reference to the new Node, it is a O(1) operation.

No traversing is necessary, and the operation is not affected by input or how many Nodes are in the Linked List.

### Includes(someValue)

This function must traverse the Linked List, potentially every Node, and possibly to the end NULL before it returns, making it an O(n) operation.

### AddBefore(newValue, existingValue)

A traversal must be done to find existingValue before the newValue Node can be inserted.

- Traversals are an O(n) operation.
- Add is an O(1) operation.

- The worst of these two major operations is O(n).

### Print()

Uses a while iterator to check if the end of the Linked List has been reached and if not, the current Node value is processed and then a traversal to the next Node is done.

Due to the iterating structure, the operation will walk all Nodes in the list in a worst-case scenario, making it a O(n) operation.

## Code

[My Linked List Class](../lib/src/main/java/myJava/code/challenges/MyLinkedList.java)
[My Linked List Node Class](../lib/src/main/java/myJava/code/challenges/MyLinkedListNode.java)

## Tests

My Linked List and My Linked List Node [Unit Tests](../lib/src/test/java/myJava/code/challenges/TestMyLinkedList.java)

## Resources and Acknowledgements

- Code Fellows Common Curriculum
