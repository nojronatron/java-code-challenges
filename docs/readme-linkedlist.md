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
