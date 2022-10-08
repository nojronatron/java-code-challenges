# Graphs

Graphs can be thought of as extensions to Linked Lists and Trees. This readme will discuss details of Graphs, how to build and use them, and performance analysis.

## Terminology

Vertex: Aka 'Node'. Data object that can have zero to many adjacent vertices.

Edge: The connection between 2 Vertices/Nodes. An edge can be defined as coordinates, e.g. `(node1, node2)`.

Neighbor: An adjacent Vertex/Node, connected by an Edge, to the current Vertex/Node.

Degree: The number of Edges connected to the current Vertex/Node.

### Types of Graphs

Undirected

- Each edge is bi-directional.
- Static, in than there is not directed traversal between Neighbors via an Edge.

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
- A standalone Vertex or Edge is known as an Island within a graph data structure.

Cycles In A Graph

- One or more loops in the traversal of Vertices Edges.
- Repetitive visits to the same state or item are possible in a 'cycle'.
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
- Dimensions are determined by the number of Vertices squared.
- A 4-vertices Graph will have a 4x4 Adjacency Matrix.
- At each intersection (cell or record) in the matrix, a '1' is placed if there *is* an Edge between the X-Vertex and the Y-Vertex.
- Any intersection where an Edge does *not* exist between X-Vertex and Y-Vertex, a '0' is placed.

Adjacency List

- Common way to represent graphs.
- A chained Hashtable with LinkedList Buckets (chained?).
- Whenever an Edge is added, find the existing Vertex in the Adjacency List and add the Neighbor to the bucket.

Weighted Graph

- Edges can have value.
- Call the Edge Value 'Weight'.
- The weight is abstract, and depends on the implementation. For example, the cost to travel an Edge between Vertices could be time, money, or fuel.

Weighted Matrix

- An Adjacency Matrix that uses Edge Weights to identify relationships between Vertices.
- A '0' represents "no Edge between these Vertices".

Weighted Adjacency List

- An Adjacency List that records the Vertex value, as well as the Edge Weight in each Bucket Node.
- For example, if Node "A" has 2 Edges, one each to "B" and "C". The Bucket would then look like: `[A] :[B,4] -> [C,5] -> null`

## Purpose

Graphs can be used to represent large amounts of data.

Connections between related data items can easily be represented using a Graph.

Any system where relationships between items needs to be understood and traversed are good candidates for a Graph data structure.

Mapping software can use a Graph to help determine how to traverse roads from point A to point B, via other points or direct.

## Graph Properties (Fields)

Adjacency Matrix: A 2-dimensional Array of all Vertices on X- and Y- axes, with Edge data stored in each intersection.

Adjacency List: Could be a Hashtable that stores an Array of unique Vertices (Keys), with Buckets (Linked List) containing Edge/Adjacency information (Values).

Visited Collection: An internal List that traversals can use to determine if a Vertex has been accessed before.

## Traversals

Similar to Trees, Graphs can be traversed using Breadth-first or Depth-first methods.

A key difference is dealing with Cyclic vs. Acyclic graphs.

Trees are Acyclic, so the traversal methods do not have to be concerned with visiting the same node twice.

Graphs *can be* Cyclic, so additional consideration must be made to avoid traversing the same Vertices again and again.

### Breadth First Traversal

1. Enqueue the declared 'start' Node (Vertex).
2. Iterate through additional code while the Queue is not empty.
3. Dequeue the first Node.
4. If the Node is not in the 'Visited' array, add it. 
5. If the Node has Edges, Enqueue the Neighbor Vertices into the Queue.

Notes:

1. Island Vertices will not be visited.
2. Only Neighbors with a path to the selected 'root' Node will be visited.

Pseudocode:

```text
DECLARE: Method BreadthFirst(vertex)
INPUT: Node Vertex
OUTPUT: Collection of Nodes
INSTANTIATE: Nodes <- new List
INSTANTIATE: BreadthQueue <- new Queue
INSTANTIATE: Visited <- new Set
EXECUTE: BreadthQueue <- enqueue Vertex
EXECUTE: Visited <- add Vertex
ITERATE: While BreadthQueue is not empty
    INSTANTIATE: Front <- dequeue BreadthQueue
    EXECUTE: Nodes <- add Front
    ITERATE: For each Child in Front Children (Neighbors)
        IF: Child not is Visited
            EXECUTE: Visited <- add Child
            EXECUTE: BreadthQueue <- enqueue Child
RETURN: Nodes
```

### Depth First

## Big-O Analysis

## Code

## Tests

## Resources and Acknowledgements

- Code Fellows Common Curriculum.

## Footer

Return to [root readme](../README.md)
