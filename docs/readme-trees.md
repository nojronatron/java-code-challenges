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

Three types of traversals:

- Pre-order: Root => Left => Right
- In-order: Left => Root => Right
- Post-order: Left => Right => Root

### Depth First Traversal

Use recursion to execute Depth First traversals.

When using recursion, the code will rely on the call stack to navigate back up the tree when reaching the end of a path of branches.

#### Depth-First Pre-order Traversal

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

In the pseudocode example above, root's left property is checked and if it is *not* null preOrder() is called with root.left child node as the argument.

When a function call on the call stack is completed, it is "popped off" the stack, and the function call will continue its execution from where it left off.

In the pseudocode example above, root's right property is checked and if it is *not* null, preOrder() is called again with root.right child node as the argument.

When both root.left and root.right are null, the code exits and the function pops-off the call stack.

When the last function pops-off the call stack, all work is completed.

#### Depth-First In-Order Traversal

Pseudocode:

```text
Algorithm inOrder(root)
if root.left is not NULL:
    inOrder(root.left)
Process: root.value
if root.right is not NULL:
    inOrder(root.right)
```

Like preOrder, inOrder works the same except the "processing" portion of the code is in-between calls to root.left and root.right.

#### Depth-First Post-Order Traversal

Pseudocode:

```text
Algorithm postOrder(root)
if root.left is not NULL
    postOrder(root.left)
if root.right is not NULL
    postOrder(root.right)
Process: root.value
```

Like preOrder and inOrder, postOrder works the same except the "processing" portion of the code is *after* the calls to root.left and root.right are completed.

### Breadth First Traversal

This is a non-recursive method to traverse a Tree.

It walks through each *level* of the tree, node-by-node.

Pre-, In-, and Post-Order Traversal processing can be applied to Breadth-First Traversals.

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
        breadth.enqueue(temp.left)
    if temp.right is not NULL
        breadth.enqueue(temp.right)
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
2. Check for the presence of child nodes, from the first to the last in the list of K children.
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

A binary tree is a special case of a K-ary Tree, so there is a lot of overlapping logic in this traversal method.

K-ary Breadth-First Traversal is an O(n) operation as every Node is accessed within the while iteration block.

### Adding a Node

According to Code Fellows curriculum there are no placement rules in a Binary Tree, nor a K-ary Tree.

In this case, just place a new node in any empty child spot, from the top down, and from index 0 to the last index of node's K children.

Use breadth-first traversal to find the next-best placement spot in the tree, and an iterator to index to the 1st null child.

To place a node in a specific location:

1. Reference both the new node to create *and* the parent node the new node should be attached to.
2. Check the child 'slots' for the 1st empty one.
3. Fill the first empty child 'slot' found, and then exit.

*Note*: Depending on whether the targeted parent node is 'full' with children or not, this could be successful or cause an exception that should be handled gracefully.

### Big-O of Trees

Time Complexity:

- Node insertion: O(n)
- Search for specific node: O(n)
- Any Traversal: O(n) => If the tree has N nodes, traversing the tree would require visiting N nodes in the worst case scenario.

Space Complexity:

- Node insertion using Breadth Traversal: O(w) where w is *width* of the tree at its widest level.

## Binary Search Trees

Similar to a binary tree, but *does have structure*.

- Referred to as 'BST'.
- Nodes are organized by value: The farthest left to the furthest down and right.

Specifically:

- Nodes with value LESSER than the root are placed to the LEFT.
- Nodes with value GREATER than the root are placed to the RIGHT.
- The above rules apply to whatever "current" node is selected.

### Searching a BST

Faster than searching a binary tree because only certain nodes are visited to find the target node value.

Basically, the problem of finding the node is cut in half at every Node that is visited.

1. Take the input value you are searching for.
2. Compare it to the current Node (starting with Root):
3. Child Node value less than Root/Current value? Traverse to Current Left child.
4. Child Node value greater than root/Current value? Traverse to Current Right child.

Searching a tree with 10 nodes might require:

- Up to 10 operations to search a balanced binary tree.
- Up to h (height or edge) operations to search a BST.

Code Fellows Curriculum recommends using a 'while' loop to search a BST, which will end when it hits a node value that matches the search criteria (success), or when it hits a leaf node whose value does not match.

### BST Big-O Analysis

Time:

- Insertion and Search operations: O(h) aka O(height).
- Balanced (or perfect) tree search: O(log(n)).
- Unbalanced tree search (for example, a BST that looks like a Linked List): O(n).

Space:

- Search operation: O(1) because no additional space is allocated to complete the operation.

## Unit Tests

- March 2023: [Binary Tree Find Max Tests](../lib/src/test/java/myJava/code/challenges/TestBinaryTreeFindMax.java)
- March 2023: [Generic Binary Tree Tests](../lib/src/test/java/myJava/code/models/GenericBinaryTree/TestGenericBinaryTree.java)
- [Test Queue](../lib/src/test/java/myJava/code/models/TestQueueLibrary.java) (for breadth-first traversal)
- [Test Leaf Counter challenge](../lib/src/test/java/myJava/code/challenges/TestLeafCounter.java)
- [Test K ary Tree](../lib/src/test/java/myJava/code/models/TestKaryTreeLibrary.java)
- [Test Binary Search Tree Node](../lib/src/test/java/myJava/code/models/TestMyBstNode.java)

## Code

Code can be found in java-code-challenges library files:

- March 2023: [Binary Tree Find Max](../lib/src/main/java/myJava/code/challenges/BinaryTreeFindMax.java)
- March 2023: [Generic Binary Tree](../lib/src/main/java/myJava/code/models/GenericBinaryTree/MyBinaryTree.java)
- [My Queue](../lib/src/main/java/myJava/code/models/MyQueue.java) (for breadth-first traversal)
- [My Node (for My Queue)](../lib/src/main/java/myJava/code/models/MyNode.java) (for breadth-first traversal)
- [My Binary Node](../lib/src/main/java/myJava/code/models/MyBinaryNode.java)
- [Leaf Counter Challenge Class](../lib/src/main/java/myJava/code/challenges/LeafCounter.java)
- [My K-ary Tree Node](../lib/src/main/java/myJava/code/models/MyKaryNode.java)
- [Binary Search Tree Node](../lib/src/main/java/myJava/code/models/MyBstNode.java)

### Interfaces

Previously, I experimented with using interfaces to constrain generic classes.

While I was able to utilize the custom interfaces, in the end they did not help much.

- [Interface My Binary Node](../lib/src/main/java/myJava/code/models/IMyBinaryNode.java)
- [Interface My K-ary Node](../lib/src/main/java/myJava/code/models/IMyKaryNode.java)

Later on I did some more research on Java Generics, thanks to this experience.

## Additional Comments

Utilize `TreeSet<T>`, a [Java Collections class](https://docs.oracle.com/javase/8/docs/api/?java/util/Collections.html) as a handy sorting tool. 

When designing a dependency like BinaryNode, add plenty of getter-setters to do simple logic tricks like True if Node is a Leaf, and so-on. This will help make code more readable, and avoids some complexity in setting up if-then statements.

While it is interesting to embed a required class like Node into a structured class like Binary Tree, it enforces specialization rather than modularity. Also, testing the underlying child Class is also a bit more difficult. Avoid doing this unless there is a compelling reason or a requirement to do so specifically.

When processing data within a recursive function, it is okay to leverage a Class-level property such as a storage ArrayList of some type.

- Remember to initialize the storage array when the class is created!
- Consider adding a helper method (or public method) that will reset the array before running the recursive or while iterator code block.
- Utilize a helper method (or public method) to return the contents of the storage array, perhaps as a toString-like function.

Attempting to pass values around within a call-stack of recursive methods can be difficult. Think *outside the method* to solve the problem!

## Resources and Acknowledgements

Code Fellows common curriculum: Overall guidance and pseudocode.

## Footer

Return to [root readme](../README.md)
