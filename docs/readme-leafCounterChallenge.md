# Leaf Counter Challenge

Design a method that compares to trees and returns true/false whether they have the same number of leaf nodes.

## Design Approach

Identifying the Inputs and Outputs were helpful:

- Visualizing the tree inputs helped identify node types.
- The output wasn't a sum of Leaf Nodes, rather a boolean whether the Trees had the same number of Leaf Nodes (true) or not (false).

Drawing out the problem was helpful to see the Tree components and properly identify Leaf Nodes, and to separate my thinking from "file system" to the Tree Data Structure.

There are two primary tree traversal methods:

- Breadth First: Uses a Queue and a While loop to traverse all Tree Nodes, horizontally.
- Depth First: Uses recursion to traverse all Tree Nodes.

Processing data was fairly straightforward:

1. Define a Leaf Node as any Tree Node that has no Child Nodes (null).
2. Track the counts of Leaf Nodes encountered while traversing the Trees, one sum for each.
3. Process the two counts and assert they are equal, returning that result.

Helpful questions were:

- How many files per folder? Response: At most 2.
- Are empty folders possible? Yes.
- How is a file different from a folder? File is last-child to any parent.
- Are child files *contents* of parent folders? No, they are child elements.

## Test Approach

JUnit Jupiter is the go-to framework for Java unit testing at Code Fellows, so I will stick with that.

Tests include:

- Happy Path: Two non-null Trees are input, both with 5 Leaf Nodes. The algorithm returns True.
- Good Path: Two non-null Trees are input, both with 10 Leaf Nodes. The algorithm returns True.
- Failure Cases like: Two non-null Trees are input, Left Tree has 1 Leaf Nodes, Right Tree has 2 Leaf Nodes. The algorithm returns False.
- Null Inputs: One Tree of the two is Null: The algorithms returns False (Null != non-Null).
- Null Inputs: Both Trees are Null: The algorithm returns Tree (Null == Null).

## Implementation

Create 2 functions:

1. fileCountSame(left, right) that accepts two binary trees and returns a single boolean value.
2. processFunction(tree) that accepts a single binary tree and returns the sum of "files" within the tree.

fileCountSame():

- Declare common variables including a means to store count of files in each tree.
- Test for null or exceptional conditions and return-fast.
- Call processFunction() once for each tree and store the return value.
- Compare the return values and return true if equal, otherwise return false.

processFunction():

- Declare a Queue for traversal purposes, and a summing variable to count "files".
- Iterate through the Queue while loading and unloading Nodes and their Children.
- Test if both Child references are Null if so increment the summing variable by 1.
- Test if either Child ref is NOT Null and if so enqueue each before the next iteration starts.
- Return the summing variable once the iteration runs out of cycles (queue is empty).

## Scoring

Without going into gorey detail:

- Section 1: 9/10
- Section 2: 9/12
- Section 3: 6/6
- Section 4: 10/12

Final: 34/40 (32/40 is passing).

## How Could Do Better Next Time?

Talk throughout the design, development, and coding.

Remember to talk about test cases not only on their own, but *as they come up while designing and coding*.

Remember to talk about Big-O Analysis while designing and coding, to ensure at least some points are scored there whether I get to writing Big-O out or now.

When writing code on the board, worry about getting the important parts of the algorithm written, solving the problem.

Only consider adding test-case catches in the code if there is time remaining after completing all other sections of work.

## Algorithm

```text
PSEUDOCODE: Class LeafCounter extends BinaryTree
MEMBER: fileCountSame(leftTree, rightTree)
INPUT: BinaryTree, BinaryTree
OUTPUT: boolean
INITIALIZE: fileSum <- 0
COMMENT: Test for null inputs and other fail-fast cases
INITIALIZE: fileSumLeft <- 0
INITIALIZE: fileSumRight <- 0
ASSIGN: fileSumLeft <- processFunction with argument leftTree
ASSIGN: fileSumLeft <- processFunction with argument rightTree
IF: fileSumLeft EQUALS fileSumRight
    RETURN: TRUE
ELSE:
    RETURN: FALSE
ENDIF

MEMBER: processFunction(tree)
INSTANTIATE: breadthQueue <- new Queue
ENQUEUE: breadthQueue <- tree
INITIALIZE: fileSum <- 0
WHILE: breadthQueue.empty is not True
    INSTANTIATE: tempNode <- breadthQueue.dequeue
    IF: tempNode.left is NULL AND tempNode.right is NULL
        ASSIGN: fileSum <- increment by 1
    IF: tempNode.left is not NULL
        ENQUEUE: breadthQueue <- tempNode.left
    IF: tempNode.right is not NULL
        ENQUEUE: breadthQueue <- tempNode.right
END WHILE
RETURN: fileSum
```

## Algorithm Analysis

Time: O(n). A WHILE iterator processes every single item in both inputs, and Breadth First traversal is an O(n) worst-case operation.

Space: O(1): The inputs are not duplicated and only single-instance variables are created to assist with processing.

## Final Comments

The actual working code is somewhat different from the Pseudocode algorithm listed above.

[Working Java code for this code challenge](../lib/src/main/java/myJava/code/challenges/LeafCounter.java)

[Unit tests proving the Java code based on this algorithm is functional](../lib/src/test/java/myJava/code/challenges/TestLeafCounter.java)

## Footer

Return to [root readme](../README.md)
