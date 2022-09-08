# Tree Readme

Review of terminology and types of trees, as well as how to code them.

## Terminology

Memorize this terminology for use during interviewing.

Node: Component contains its own values and references to other nodes.

Root: The node at the top of the Tree.

K: The maximum number of children any given node can have.

Left: Handy name for a binary tree child node.

Right: Handy name for a binary tree child node.

Edge: The link between a parent and child node.

Leaf: A node that does not have any child nodes.

Height: The number of edges from root to the furthest leaf.

## Traversal

Traversal means to move through the data structure.

Two categories:

- Depth First
- Breadth First

### Depth First Traversal

Three types of traversals:

- Pre-order: Root => Left => Right
- In-order: Left => Root => Right
- Post-order: Left => Right => Root

Use recursion to execute Depth First traversals.

When using recursion, the code will rely on the call stack to navigate back up the tree when reaching the end of a path of branches.

#### Pre-order Traversal

Pseudocode:

```text
Algorithm preOrder(root)
Process: root.value
if root.left is not NULL:
    preOrder(root.left)
if root.right is not NULL:
    preOrder(root.right)
```

Root has to be processed first.

Processing usually entails reading the value of the node, and perhaps performing some operation on it.

Each time 'preOrder()' is called, it adds the Node to the call stack.

In the pseudocode example above, root's left property is checked if it is not null and if true, preOrder() is called with root.left child node as the argument.

When a function call on the call stack is completed, it is "popped off" the stack, and the function call will continue its execution where it left off.

In the pseudocode example above, root's right property is checked if it is not null and if true, preOrder() is called again in the next line of code, and the root.right child node is supplied as the argument.

When both root.left and root.right are null, the code exits and the function pops-off the call stack.

#### In-Order Traversal

Pseudocode:

```text
Algorithm inOrder(root)
if root.left is not NULL:
    inOrder(root.left)
Process: root.value
if root.right is not NULL:
    inOrder(root.right)
```

#### Post-Order Traversal

Pseudocode:

```text
Algorithm postOrder(root)
if root.left is not NULL
    postOrder(root.left)
if root.right is not NULL
    postOrder(root.right)
Process: root.value
```

### Breadth First Traversal

This is a non-recursive method to traverse a Tree.

It walks through each *level* of the tree, node-by-node.

Implement a Queue to assist with breadth-first traversal.

1. Put the root node into the queue.
2. Enter an iterator that continues to iterate until the queue is empty.
3. In each iteration, dequeue a single node and store it in a temporary variable.
4. Process the node that was just dequeued.
5. Enqueue the left child if it is not null.
6. Enqueue the right child if it is not null.

Pseudocode:

```text
Queue breadth <= new Queue()
breadth.enqueue(root)
while !breadth.is_empty()
    node temp = breadth.dequeue()
    Process: temp.value
    if temp.left is not NULL
        breadth.enqueue(front.left)
    if temp.right is not NULL
        breadth.enqueue(front.right)
```

## Types of Trees

Nodes in any type of tree are going to have child nodes, it is just a matter of how many: 0, few, or many.

### Binary Tree

Nodes are limited to 2 children: left and right.

Ordering is unspecified, and when Nodes are added, they are inserted wherever space allows.

### K-ary Tree

Nodes are not limited to 2 children, and have K children instead, representing the maximum number of children that node can have.

#### Traversing K-ary Trees

Use breadth first traversal:

1. Push nodes into a queue.
2. Check for the presence of nodes, from the first to the last in the list of K children.
3. Repeat for all nodes until the queue is empty.

Pseudocode:

```text
Algorithm breadthFirst(root)
Queue breadth <= new Queue()
breadth.enqueue(root)
while !breadth.is_empty()
    node temp = breadth.dequeue()
    Process: temp.value
    for child in temp.children:
        breadth.enqueue(child)
```

A binary tree is a special case of a K-ary Tree.

### Adding a Node

According to Code Fellows curriculum there are no placement rules in a Binary Tree.

In this case, just place a new node in any empty child spot, from the top down.

This implies using breadth-first traversal to find the next-best placement spot.

To place a node in a specific location, reference both the new node to create *and* the parent node the new node should be attached to. Fill the empty child 'slots' from left-to-right. Depending on whether or not the targeted parent node is 'full' with children, this could be successful or cause an exception that should be handled gracefully.

### Big-O of Trees

Time Complexity:

- Node insertion: O(n)
- Search for specific node: O(n)
- Traversal: O(n) => If the tree has N nodes, traversing the tree requires visiting N nodes.

Space Complexity:

- Node insertion: O(w) where w is largest *width* of the tree.

## Binary Search Trees

