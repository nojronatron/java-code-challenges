# Connect Binary Trees

I bumped into a code challenge where the goal was to take two binary trees and basically merge them.

If this were a Binary Search Tree, there would be a lot of work involved:

- BSTs are sorted.
- Inserting a Node implies altering the placement of the children and grand-children of the replaced Node.
- Altering Node placement is a sub-process of swapping descendants until the node-to-insert can be inserted while maintaining the sort order.
- Depending on the actual challenge requirement, balancing the BST might also be necessary.

A Binary Tree does not have stringent rules like these, so this is where I am starting.

## Initial Design

Rules:

- Ordering not required.
- Uniqueness not required.
- Interleaving nodes is acceptable.

Function Overview:

- Accepts a 'left' Tree and a 'right' Tree as input.
- Returns an updated 'right' Tree.
- Will fail-fast and return null if inputs are null.
- Will fail-fast and return the other tree if one is null.
- Utilizes breadth-first search (BFS) to find opening to 'join' the trees.

Tree Properties:

- A Tree is really a Binary Node (root) that might have children.
- While a proper Tree wouldn't be null, a TreeNode *could* be null.
- TreeNode has getter-setters for Value, LeftChild, and RightChild.
- TreeNode has boolean IsLeaf helper method.
- TreeNode has boolean HasLeftChild and HasRightChild helper methods.

Notes:

- Tree design is not the focus.
- Tree Node will be written in actual Java code, and then testing using JUnit Jupiter.

## Pseudocode

```text
DECLARE: Function AddTree
INPUT: LeftTree, RightTree
THROWS: n/a
TEST: LeftTree is Null and RightTree is Null
    RETURN: Null
TEST: LeftTree is Null and RightTree is NOT Null
    RETURN: RightTree
TEST: LeftTree is NOT Null and RightTree is Null
    RETURN: LeftTree
INSTANTIATE: BreadthQueue <- New Queue
EXECUTE: BreadthQueue <- Enqueue RightTree
ITERATE: While BreadthQueue is NOT Empty:
    INITIALIZE: CurrentNode <- BreadthQueue <- Dequeue
    TEST: CurrentNode IsLeaf
        EXECUTE: CurrentNode SetLeftChild <- LeftTree
        RETURN: RightTree
    TEST: CurrentNode HasLeftChild and CurrentNode NOT HasRightChild
        EXECUTE: CurrentNode SetRightChild <- LeftTree
        RETURN: RightTree
    TEST: CurrentNode HasRightChild and CurrentNode NOT HasLeftChild
        EXECUTE: CurrentNode SetLeftChild <- Left Tree
        RETURN: RightTree
    TEST: CurrentNode HasLeftChild
        EXECUTE: BreadthQueue <- Enqueue <- CurrentNode GetLeftChild
    TEST: CurrentNode HasRightChild
        EXECUTE: BreadthQueue <- Enqueue <- CurrentNode GetRightChild
RETURN: RightTree
```

### Code Review

Some portions of code could be consolidated by using the common RightTree return at the end.

To get around the WHILE statement the Queue would need to be emptied, which would clear memory storage, and drop code execution down to the single Return statement at the bottom.

### BigO Analysis

Time:

- BFS traversal is O(n), and there are no other iteration blocks.
- Actual performance will be better than this due to quick returning if-then statements within the iteration.
- Due to short-circuit if-then statements, in a worst-case a total of 2 times the height of RightTree nodes would be traversed before finding a Leaf Node or a node with a Null child reference.
- Overall: O(2H(RightTree) + 1) or better.

Space:

- BFS traversal with an exit condition requires enqueuing nodes until the processing condition is met which could be as bad as Height+1, or as good as O(1) if RightTree is a single Node.
- Updating an input saves from expanding memory resources for temporary or long-term storage.
- Due to quick-exit strategies where execution would not continue past the first Node with a Null Child reference field, storage is limited.
- Therefore, actual storage utilization would be O(2 * Height(RightTree) + 1).

## Test Approach and Test Cases

Framework: JUnit Jupiter

Golden Paths:

- Left and Right Trees each have a single Node and Left Tree is attached to Right Tree Root Node's Left Child.
- Left Tree is null, Right Tree has Nodes, only Right Tree is returned unmodified.
- Right Tree is null, Left Tree has NOdes, only Left Tree is returned unmodified.
- Left and Right Trees each have 6 nodes and 2nd level right-most Node has no Right Child reference. Right Tree is returned with Left Tree added to the Right Tree Null Right Child ref in 2nd level right-most Node.
- Left and Right Trees each have 6 nodes and 2nd level right-most Node has no Left Child reference. Right Tree is returned with Left Tree add to the Right Tree Null Left Child ref in 2nd level right-most Node.
- Left Tree has 1 Node, Right Tree has 7 Nodes (a perfect Tree - bottom row made up of Leaf Nodes). Right Tree is returned with Left Node add to Right Tree's 3rd level, left-hand Node's Left Child reference.

ToDo: Draw up some depictions of these test cases.

There are an infinite number of Binary Tree arrangements, but these 6 tests cover all those cases where code will exit (Leaf, or Empty LeftChild, or Empty RightChild references).

## Actual Code

## Actual Tests

## Footer

Return to [Root README](../README.html)
