# Queues Readme

Review of terminology and features of Queues.

## Terminology

Queues are First-in-first-out (FIFO) data structures.

Items added are removed in the exact same order.

Last-in-first-out (LIFO): Another way of saying FIFO, but from the other perspective.

- Enqueue: Add an item (node) to a Queue.
- Dequeue: Remove a node from a Queue. Throws an exception if Queue is empty.
- Front: The first node/next node to dequeue is here.
- Rear: The last node enqueued. Will also be the last node dequeued if no other nodes are enqueued.
- Peek: Retrieve the *value* of the Front node without de-queuing it. Throws an exception if Queue is empty.
- IsEmpty: Property returns true when no Nodes are in the Queue, otherwise returns false.

## Properties

### Front

Returns reference to the Front Node.

### Rear

Returns reference to the Rear Node.

### Node Next

A reference to the next Node in line.

Front node has a next.

Rear node is the only Node that points to null unless there is only one node, then Front.next and Rear.next both point to null.

### Node Value

Hold the value assigned to the Node.

## Operations

## IsEmpty

Simply returns whether Front is null or not (boolean).

Pseudocode:

```text
Algorithm isEmpty()
return front == null
```

### Enqueue

1. Assign rear.next to point to the new Node.
2. Reassign rear referent to new Node.

Pseudocode:

```text
Algorithm enqueue(value)
newNode = new Node(value)
rear.next <= newNode
rear <= newNode
Returns: void
```

### Dequeue

Simply remove the Front referenced Node without losing reference to the Front.next referenced Node.

1. Create a temporary Node that references Front.
2. Reassign Front reference to Front.next.
3. Reassign TempNode.next to null
4. Return the value of TempNode and exit the function.

Pseudocode:

```text
Algorithm dequeue()
Throws if Queue is empty
Node temp <= front
front <= front.next
temp.next <= null
return temp.value
```

### Peek

Simply check isEmpty and if false, inspect the Front node reference and return the result, otherwise throw and Exception.

Pseudocode:

```text
Algorithm peek()
Exception: isEmpty is true
return front.value
```

## Big-O Analysis of Operations

- Enqueue: O(1) in time => Does not matter how many items are in the queue.
- Dequeue: O(1) in time => Does not matter how many items are in the queue.
- Peek: O(1) in time => Does not matter how many items are in the queue.
- IsEmpty: O(1) in time => Does not matter how many items are in the queue.

## Generics

When making a class generic, remember these tips:

- Start with the Class-level properties. Which ones *need* to be generic? Which ones don't?
- Look at the constructors and make sure generic properties are initialized properly (if they need to be).
- Look at each private and public method and ensure input parameters are templated `<T>` when referencing the class itself (i.e. `addNext(MyNode<T> node)`) and properties that are generic.
- Review calling functions that rely on the generic methods and ensure they define the type in the template `<T>` when initializing or calling.
- Make the Class itself generic. This will allow the Class members to accept generic input parameters and its methods can return generic types.
- Avoid setting *any* types within the class itself, unless it is accepting or returning a type of itself.

Look at MyNode.java for an excellent example of a Class refactored to be Generic.

## Unit Tests

- [Test Queue Library](../lib/src/test/java/myJava/code/challenges/TestQueueLibrary.java)

## Code

- [My Node Class for use with My Queue class](../lib/src/main/java/myJava/code/challenges/MyNode.java)
- [My Queue Class definition](../lib/src/main/java/myJava/code/challenges/MyQueue.java)

## Advanced Enqueue and Dequeue

Situations will arise where additional logic is required to get predictable, consistent results from these operations.

The approach is to sort out how many nodes are already in the Queue before taking action:

- Is the Queue empty?
- Is there only one node in the Queue?
- Are there only two nodes in the Queue?
- Are there more than two nodes in the Queue?

The reason these questions matter are:

- Where there are no nodes in the Queue and you simply add a node to Rear, Front will not get updated properly.
- When removing a node from Front and there are only one node in the Queue, removing a reference to the Front or Rear node can remove the reference to Temp node *before getting the value from it*.

There are other situations, but the best advice I can give is as follows:

- Enqueue must check for 2 or more nodes first, then single node, then no nodes (a default action and return statement).
- Dequeue must check for a single node Queue first, then two nodes, then have a default action and return for more than 2 nodes.
- Situations where there are no nodes could be handled using `throws NullPointerException` at the method definition.

## Resources and Acknowledgements

Code Fellows common curriculum: Overall guidance and pseudocode.
