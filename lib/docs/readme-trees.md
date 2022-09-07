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

### Recursion in Traversal

When using recursion, the code will rely on the call stack to navigate back up the tree when reaching the end of a path of branches.

#### Pre-order Traversal

Pseudocode:

```text
Algorithm preOrder(root)
Output: root.value
if root.left is not NULL:
preOrder(root.left)
if root.right is not NULL:
preOrder(root.right)
```

Root has to be processed first.

Processing usually entails reading the value of the node, and perhaps performing some operation on it.

Each time 'preOrder()' is called, it adds a Node to the call stack.

