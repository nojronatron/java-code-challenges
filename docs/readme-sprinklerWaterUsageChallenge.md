# Sprinkler Water Usage Challenge

In this challenge, the problem is to determine water usage of a multi-head sprinkler system.

Within 40 minutes, design as much of a solution as possible, including a problem diagram, step-through, code, Big-O analysis, and a test plan.

## Feature Requirements

Avoid using built-in methods available in Java.

Calculate the water usage for a sprinkler system.

Sprinkler heads may be attached to up to 2 other sprinklers.

The system is open, meaning no connected loops.

Sprinkler heads dissipate a known amount of water in milliliters per minute.

An analysis of the system must be possible *starting from any sprinkler head in the system* (note).

## My Timed Attempt

I figured out the inputs and outputs within a few minutes.

Because the sprinklers needed connectivity from 0 to 2 other sprinklers, I went for a Tree structure.

Traversal method selected was Breadth First because I am more comfortable with it than depth traversal.

For a brief period I thought about implementing a graph, but I interpreted the problem statement to be asking for values held in the nodes, and *failed to observe the requirement to start anywhere in the system* and still get the correct answer.

After considering a graph I sorted out requirements to implement a Tree, and landed on K-ary Tree because I thought that each sprinkler needed to be connected to up to a total of 3 other things.

### Attempted Problem Domain Definition

I failed to ask lots of simple questions like:

- Is there any need to check for 0 or less-than-zero values in the input?
- Should the function check for null input?
- Are the numbers all whole numbers, or will there be fractional/decimal/floating point numbers involved?
- What is the largest number the function might have to manage?
- If there is not a valid input, what should the function return? Null? -1?

### Attempted Pseudocode

The following pseudocode is directly from the whiteboard:

```text
DEFINE: Method WaterUsage
INPUT: KaryTree RootNode
OUTPUT: Integer
INSTANTIATE: BreadthQ <- New Queue()
EXECUTE: BreadthQ Enqueue <- RootNode
INITIALIZE: SumValue <- 0
ITERATE: While BreadthQ is not Empty:
    INSTANTIATE: TempNode <- BreadthQ Dequeue
    ASSIGN: SumValue <- SumValue + TempNode Value
    IF: TempNode Children Count is greater than 0
        ITERATE: For Each Child in TempNode Children
            EXECUTE: BreadthQ <- Enqueue Child
    ELSE: CONTINUE
RETURN: SumValue
```

### Attempted Step Through

The step through had:

1. Initial start-up steps like initializing a Queue and a value-summing variable.
2. The middle steps were within a while iterator that continued so long as the breadth queue was not empty.
3. The final step is a return statement, returning the value-summing variable value.

### Attempted Algorithm

No algorithm was written-out specifically, although I was able to talk-through the algorithm verbally while building the step-through diagram.

### Incomplete Java Code

I barely wrote any Java code before the timer expired. Seven lines.

For this exercise, I will write appropriate Java code using the pseudocode as a guide.

### Missing Test Approach

No test approach nor test cases were documented.

### Missing BigO Analysis

I failed to discuss the Time and Space performance implications of my algorithm and pseudocode, much less write it out.

## Exercise Design

### Pseudocode

For this round, using a Kary Tree, the Java code will follow the Pseudocode documented [at subsection attempted pseudocode](#attempted-pseudocode) in this readme.

### Java Code

Create a new Class to contain one or more functions that will solve this challenge.

[Sprinkler Water Usage Java Class](../lib/src/main/java/myJava/code/challenges/SprinklerWaterUsage.java)

### Test Cases

Design test cases that will cover for these situations:

- Null input (an empty tree) -> Returns null.
- Single-node tree -> Return value of Root node.
- Negative values in tree -> Ignore them.
- Tree with at least 6 nodes with values 35, 41, 59, 33, 52, 30, 44 -> 249 is returned.

[Sprinkler Water Usage Unit Tests](../lib/src/test/java/myJava/code/challenges/TestSprinklerWaterUsage.java)

### Big-O Analysis

Kary Tree:

Time: O(n) -> Each node must be checked for a value, and each child node traversed throughout entire tree.

Space: O(w) -> However wide the Kary Tree is determines the maximum amount of space needed for storage at any time during traversal.

## Retrospective

### What Went Well

- Confident that I had a viable solution and could code and analyze it (given enough time).

### What Needs Work

- Ask more questions about the problem domain!
- Pay attention to details like "calculate the answer from anywhere in the system". This statement actually makes this Tree-ish problem a Graph problem instead!
- When I start to feel like time is getting short, I need to very rapidly go over BigO Time and Space. I can always go back and refine/expand on it later if there is more time.
- When I feel like time is short, I need to write out at least 4 statements about my testing approach: JUnit Jupiter, Happy Path, Null In/Out, and 1 or 2 edge case inputs with expected outputs.
- When looking at a tree-ish problem, pay attention to the number of nodes. *Don't build a K-ary Tree* if only a Binary Tree is necessary. Similarly, *only* build a Binary Search Tree if ordering of information is important!
- If a Binary Tree is to be used instead of a Kary Tree, then remember to create a Class with a storage array, and then use *depth first traversal* via a *recursive function* for best performance.

## Resources and Acknowledgements

Code Fellows common curriculum: Overall guidance and pseudocode.

## Footer

Return to root [README](../README.md)
