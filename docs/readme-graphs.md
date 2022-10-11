# Graphs

Graphs can be thought of as extensions to Linked Lists and Trees. This readme will discuss details of Graphs, how to build and use them, and performance analysis.

## Terminology

Vertex: Aka 'Node'. Data object that can have zero to many adjacent vertices.

Edge: The connection between 2 Vertices/Nodes. An edge can be defined as coordinates, e.g. `(node1, node2)`.

Neighbor: An adjacent Vertex/Node, connected by an Edge, to the current Vertex/Node.

Degree: The number of Edges connected to the current Vertex/Node.

### Types of Graphs

Undirected

- Each edge is bidirectional.
- Connections are static - traversal between Neighbors via an Edge can happen in either direction.

Directed or "Digraph"

- Every edge is directed.
- Each traversal can only happen in one direction from a given Vertex.
- Directs which Vertex/Vertices *can* be traversed next from the current Vertex.

Complete

- All nodes are connected to *all other nodes* i.e. a matrix.

Connected

- All Vertices/Nodes have *at least* one edge.
- One or more Vertices/Nodes *could* have more than one edge.

Disconnected

- One or more Vertices/Nodes do not have any edges.
- Disconnected Graphs may have Vertices/Nodes with edges, however there will be at least one Vertex/Node with no Edges.
- Graphs that are disconnected from each other *do not share any Edge*.
- A standalone Vertex or Edge is known as an Island within a graph data structure.

Cycles In A Graph

- One or more loops in the traversal of Edges between Vertices.
- Repetitive visits to the same Vertex / item are possible in a 'cycle'.
- While traversing a Graph, if the same Vertex is seen twice, the graph is considered 'Cyclic'.

Acyclic Graph

- Graphs that do not have cycles/loops.
- Think of an acyclic graph as a Tree.

Cyclic Graph

- Graph has cycles in it.
- Traversal could potentially see the same Vertex one or more times.

Sparse Graph

- Very few Edges.

Dense Graph

- Many Edges

Symmetric Graph

- Undirected graphs will always be symmetric.

Asymmetric Graph

- Directed graphs will always be asymmetric.

Adjacency Matrix

- A 2-dimensional array.
- Dimensions are determined by the number of Vertices, squared.
- A 4-vertices Graph will have a 4x4 Adjacency Matrix.
- At each intersection (cell or record) in the matrix, a truthy value is placed if there *is* an Edge between the X-Vertex and the Y-Vertex.
- Any intersection where an Edge does *not* exist between X-Vertex and Y-Vertex, a falsy (or no value) is placed.

Adjacency List

- Common way to represent graphs.
- A chained Hashtable with LinkedList Buckets (chained?).
- Whenever an Edge is added, find the existing Vertex in the Adjacency List and add the Neighbor to the bucket.

Weighted Graph

- Edges can have value.
- Call the Edge Value 'Weight'.
- The weight is abstract, and depends on the implementation.
- For example, the cost to travel an Edge between Vertices could be time, money, fuel, or some other resource.

Weighted Matrix

- An Adjacency Matrix that uses Edge Weights to identify relationships between Vertices.
- A '0' represents "no Edge between these Vertices".
- Any other value represents the "weight of the Edge between these vertices".

Weighted Adjacency List

- An Adjacency List that records the Vertex value, as well as the Edge Weight in each Bucket Node.
- For example, if Node "A" has 2 Edges, one each to "B (weight: 4)" and "C (weight: 5)" the Bucket would then look like: `[A] :[B,4] -> [C,5] -> null`

## Purpose

Graphs can be used to represent large amounts of data.

Connections between related data items can easily be represented using a Graph.

Any system where relationships between items needs to be understood and traversed are good candidates for a Graph data structure.

Graphs are used in GPS and mapping applications, Social networks, Airline traffic management, and many other purposes.

## Graph Properties (Fields)

Adjacency Matrix:

- A 2-dimensional Array of all Vertices on X- and Y- axes
- Edge data is stored in each intersection.

Adjacency List:

- Could be a Hashtable
- Stores an Array of unique Vertices (Keys).
- Could use Buckets (Linked Lists) containing Edge/Adjacency information (Values).

Visited Collection:

- An internal List.
- Traversal methods can use it to determine if a Vertex has been accessed before.

## Traversals

Graphs can be traversed using Breadth-first or Depth-first methods, similar to Trees.

A key difference is dealing with Cyclic vs. Acyclic graphs.

Trees are Acyclic, so the traversal methods do not have to be concerned with visiting the same node twice.

Graphs *can be* Cyclic, so additional consideration must be made to avoid traversing the same Vertices again and again.

### Breadth First Traversal

Overview:

1. Enqueue the declared 'start' Node (Vertex).
2. Iterate through the next steps while the Queue is not empty.
3. Dequeue the first Node.
4. If the Node is not in the 'Visited' array, add it. 
5. If the Node has Edges, Enqueue the Neighbor Vertices into the Queue.

Notes:

1. Island Vertices will not be visited.
2. Only Neighbors with an Edge to the selected 'root' Node will be visited.

Pseudocode:

```text
DECLARE: Method BreadthFirst(vertex)
INPUT: Node Vertex
OUTPUT: Collection of Nodes
INSTANTIATE: BreadthQueue <- new Queue
EXECUTE: BreadthQueue <- enqueue Vertex
INSTANTIATE: Visited <- new Set
ITERATE: While BreadthQueue is not empty
    INSTANTIATE: Front <- dequeue BreadthQueue
    IF: Front is not in Visited
        EXECUTE: Visited <- Add Front
    ITERATE: For each Child in Front Children (Neighbors)
        EXECUTE: BreadthQueue <- enqueue Child
RETURN: Visited
```

### Depth First

Overview:

1. Push the root node into a Stack.
2. Mark the root node as Visited.
3. Enter an iterator and do the following while the Stack is not empty.
4. Pop the top Node off the Stack.
5. If the node's Neighbor has not been visited, push it onto the Stack and mark it as visited.
6. Repeat until the Stack is empty.

Pseudocode:

```text
DECLARE: Method DepthFirst(vertex)
INPUT: Node Vertex
OUTPUT: Collection of Nodes
INSTANTIATE: Nodes <- new Set
EXECUTE: Visited <- add Temp
INSTANTIATE: DepthStack <- new Stack
EXECUTE: DepthStack <- push Vertex
ITERATE: While Stack is not empty
    EXECUTE: Node Temp <- pop Stack
    ITERATE: For each Neighbor to Temp
        IF: Neighbor not in Visited
            EXECUTE: Visited <- add Neighbor
            EXECUTE: Stack <- push Neighbor
RETURN: Visited
```

## Big-O Analysis

Pushing a Node onto a Stack: O(1).

Popping a Node from a Stack: O(1).

Pushing a Node into a Queue: O(1).

Popping a Node from a Queue: O(1).

Checking if Set HAS Node in it: O(1).

Adding a Node to a Set: O(1).

Iterating through collection of Edges (i.e. Adjacency List or Visited Array): O(Edges).

Iterating through all Vertices one single time each in a connected Graph: O(Nodes + Edges) -> roughly O(n^2), arguably O(n+m). *[University of Washington, see Resources section of this document]*

Time:

The worst-case scenario for traversing a Graph either by Depth First or Breadth First is O(n+m).

Space:

Additional space is needed for storing visited nodes, and the Stack and Queue storage, which could add up to O(stackMax+queueMax+visitedList) in wost-case scenario, probably up to O(n^3).

## Code

The following is a draft of how the Java code could look when completed. These draft code examples will be replaced with links to actual code at a later time.

```java
import java.util.Hashtable;
import java.util.Set;

public class GraphTraverser {
    private final int[] adjacencyMatrix = new int[]{};
    private final Set<GraphNode> visitedNodes;
    private final Hashtable<T, U> adjacencyList;

    public GraphTraverser() {
        this.visitedNodes = new Set<GraphNode>();
        this.adjacencyList = new Hashtable<Integer, String>();
    }
    // here: public getters for adjacencyMatrix, visitedNodes, and adjacencyList

    public Set<T> breadthFirstTraversal(GraphNode<T> vertex) {
        Queue<GraphNode> breadthQueue = new Queue<>();
        breadthQueue.enqueue(vertex);
        this.visitedNodes = new Set<>();
        while (!breadthQueue.isEmpty()) {
            GraphNode front = breadthQueue.dequeue();
            if (!visitedNodes.add(front)) {
                visitedNodes.add(front);
            }
            for (MyGraphEdge neighbor : front.getNeighbors()) {
                breadthQueue.enqueue(neighbor);
            }
        }
        return visitedNodes;
    }

    public Set<T> depthFirstTraversal(GraphNode<T> vertex) {
        this.visitedNodes.add(vertex);
        Stack<GraphNode> depthStack = new Stack<>();
        depthStack.push(vertex);
        while(!depthStack.isEmpty()) {
            GraphNode temp = depthStack.pop();
            for(GraphNode neighbor: temp.getNeighbors()) {
                if(!visitedNodes.contains(neighbor)) {
                    this.visitedNodes.add(neighbor);
                    depthStack.push(neighbor);
                }
            }
        }
        return this.visited;
    }
}
```

Here is a draft of what the Java code for a Node class and an Edge class:

```java
class GraphNode {
    private int value;
    private List<MyGraphEdge> neighbors;

    public GraphNode(int value) {
        this.value = value;
    }
    // public setter setNeighbor(vertex, weight)
    // public setters and getters for value and neighbors
}
class NodeEdge {
    private GraphNode neighbor;
    private int weight;
    
    // If an Edge is needed, then a neighbor and weight are required (weight could be defaulted to 0)
    public NodeEdge(GraphNode neighbor, int weight) {
        this.neighbor = neighbor;
        this.weight = weight;
    }
    
    // public getters for neighbor and weight
}
```

### Questions to Explore

Could (and should) the Adjacency List be used as the Set of visited nodes that the pseudocode is referring to?

- The Adjacency List is a Collection of Keys.
- Examples show the Adjacency List Key as the *value* held in the Graph node.
- Buckets would store the NodeEdge objects, containing the Neighbor and Weight information.
- Uniqueness would be guaranteed.

## Tests and Approach

The following is a brainstorm list of tests to attempt to write. Some may be retained, others removed or minimized:

- Utilize JUnit Jupiter
- GraphTraverser can be property instantiated.
- GraphNode can be instantiated with a value.
- GraphEdge can be instantiated with a value and a weight.
- GraphNode can have a GraphEdge (with a neighbor) added to it.
- GraphNode Edge can point to same GraphNode.
- Adjacency List populates unique nodes and correct Edge relationships.
- Connected graph traversals travers all Nodes once each.
- Non-cyclical, connected, undirected graph, depth traversal returns unique items ordered properly.
- Non-cyclical, connected, undirected graph, breadth traversal returns unique items ordered properly.
- Non-cyclical, connected, directed graph, depth traversal returns unique items ordered properly.
- Non-cyclical, connected, directed graph, breadth traversal returns unique items ordered properly.
- Cyclical, connected, undirected graph, depth traversal...
- Cyclical, connected, undirected graph, breadth traversal...
- Cyclical, connected, directed graph, depth traversal...
- Cyclical, connected, directed graph, breadth traversal...
- Empty graph in, empty return.
- Disconnected graph segments or 'Islands' are NOT traversed unless an Island Node is input.
- Sparse graph traversal(s).
- Dense graph traversal(s).
- Weighted Graph traversal(s).

## Resources and Acknowledgements

Code Fellows Common Curriculum.

University of Washington computer science program presentation [algorithms and computational complexity](https://courses.cs.washington.edu/courses/cse417/12wi/notes/03graphs.pdf)

## Footer

Return to [root readme](../README.md)
