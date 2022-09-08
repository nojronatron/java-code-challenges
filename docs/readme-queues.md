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
- Peek: Retrieve the *value* of the Front node without dequeuing it. Throws an exception if Queue is empty.
- IsEmpty: Property returns true when no Nodes are in the Queue, otherwise returns false.

## Properties

### IsEmpty

Simply returns whether Front is null or not (boolean).

Pseudocode:

```text
Algorithm isEmpty()
return front == null
```

### Node Next

A reference to the next Node in line.

Front node has a next.

Rear node is the only Node that points to null unless there is only one node, then Front.next and Rear.next both point to null.

### Node Value

Hold the value assigned to the Node.

## Operations

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
