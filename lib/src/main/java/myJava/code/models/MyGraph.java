package myJava.code.models;

import java.util.*;

public class MyGraph {
  private final HashSet<MyGraphNode> visitedNodes;
  private final Hashtable<MyGraphNode, MyGraphNode> adjacencyList;

  /**
   * Returns integer count of Vertices in the Adjacency List.
   * 
   * @return Integer
   */
  public int getGraphSize() {
    return adjacencyList.size();
  }

  /**
   * Custom constructor initialized internal Fields.
   */
  public MyGraph() {
    this.visitedNodes = new HashSet<>();
    this.adjacencyList = new Hashtable<>();
  }

  /**
   * Adds a new Graph Node with the param value, effectively making it an "Island"
   * Graph member.
   * 
   * @param value Integer
   * @return boolean
   * @throws NullPointerException if param is Null
   */
  public boolean addNode(int value) throws NullPointerException {
    MyGraphNode newNode = new MyGraphNode(value);

    if (this.adjacencyList.containsValue(newNode)) {
      return false;
    }

    this.adjacencyList.put(newNode, newNode);
    return true;
  }

  /**
   * Adds the param GraphNode to the Graph as a connected Graph member if it has
   * an Edge to a Node in this Graph.
   * 
   * @param vertex MyGraphNode to add
   * @return boolean
   * @throws NullPointerException if MyGraphNode is null
   */
  public boolean addNode(MyGraphNode vertex) throws NullPointerException {
    if (this.adjacencyList.containsValue(vertex)) {
      return false;
    }
    this.adjacencyList.put(vertex, vertex);
    return true;
  }

  /**
   * Attempts to remove a specific Node/Vertex. Returns removed Vertex value if
   * found, null if not.
   * Throws an exception if input is null or Vertex not in Adjacency List.
   * 
   * @param vertex MyGraphNode to find
   * @return int count of neighbors vertex had
   * @throws NullPointerException upon Null input or does not exist
   */
  public int removeNode(MyGraphNode vertex) throws NullPointerException {
    int result = 0;
    // iterate over the values (rather than enumerate the keys)
    var inodes = this.adjacencyList.contains(vertex) ? this.adjacencyList.values() : null;

    if (inodes != null) {
      for (MyGraphNode inode : inodes) {
        result += inode.removeNeighbor(vertex) ? 1 : 0;
      }
    }

    this.adjacencyList.remove(vertex).getValue();
    return result;
  }

  /**
   * Removes an Edge between a parent and neighbor vertex. Needs to be tested.
   * 
   * @param parentVertex
   * @param neighborVertex
   * @return boolean
   */
  public boolean removeEdge(MyGraphNode parentVertex, MyGraphNode neighborVertex) {
    if (this.adjacencyList.contains(parentVertex) && this.adjacencyList.contains(neighborVertex)) {
      boolean result = parentVertex.removeNeighbor(neighborVertex);
      if (result == true) {
        return true;
      }
    }

    return false;
  }

  /**
   * Returns a list of integer values of each Vertex in the Visited List array.
   * 
   * @return Integer Array
   */
  public int[] getVisitedNodeValues() {
    int[] result = new int[this.visitedNodes.size()];
    int counter = 0;

    for (MyGraphNode node : this.visitedNodes) {
      result[counter] = node.getValue();
      counter++;
    }

    return result;
  }

  /**
   * Returns an Integer Array of the Vertices visited in the last traversal run.
   * Returns empty Array if no traversals have returned anything.
   * 
   * @return MyGraphNode Array
   */
  public MyGraphNode[] getVisitedNodes() {
    if (this.visitedNodes.size() < 1) {
      return new MyGraphNode[] {};
    }

    return this.visitedNodes.toArray(new MyGraphNode[0]);
  }

  /**
   * Traverse this Graph's Vertices starting with param 'vertex' across neighbor
   * vertices from 'left-to-right'.
   * Returns a unique collection of traversed Vertices.
   * 
   * @param vertex Starting Node
   * @return Collection of unique MyGraphNode instances
   */
  public List<MyGraphNode> breadthFirstTraversal(MyGraphNode vertex) {
    if (vertex == null) {
      return null;
    }

    MyQueue<MyGraphNode> breadthQueue = new MyQueue<>();
    breadthQueue.enqueue(vertex);
    this.visitedNodes.clear();

    while (!breadthQueue.isEmpty()) {
      MyGraphNode front = breadthQueue.dequeue();

      if (!this.visitedNodes.contains(front)) {
        this.visitedNodes.add(front);

        ArrayList<MyGraphNode> neighbors = front.getNeighbors();

        for (MyGraphNode child : neighbors) {
          breadthQueue.enqueue(child);
        }
      }
    }

    List<MyGraphNode> result = this.visitedNodes.stream().toList();
    return result;
  }

  /**
   * Traverse this Graph's Vertices starting with param 'vertex' in hierarchical
   * order down neighboring vertices from 'top-to-bottom'.
   * Returns a unique collection of traversed Vertices.
   * 
   * @param vertex Starting Node
   * @return Collection of unique MyGraphNode instances
   */
  public List<MyGraphNode> depthFirstTraversal(MyGraphNode vertex) {
    if (vertex == null) {
      return null;
    }

    Stack<MyGraphNode> depthStack = new Stack<>();
    depthStack.push(vertex);
    this.visitedNodes.clear();
    this.visitedNodes.add(vertex);

    while (!depthStack.isEmpty()) {
      MyGraphNode top = depthStack.pop();
      ArrayList<MyGraphNode> neighbors = top.getNeighbors();

      for (MyGraphNode neighbor : neighbors) {
        if (!this.visitedNodes.contains(neighbor)) {
          this.visitedNodes.add(neighbor);
          depthStack.push(neighbor);
        }
      }
    }

    List<MyGraphNode> result = this.visitedNodes.stream().toList();
    return result;
  }

  /**
   * Returns the first Vertex from the Adjacency List using as Iterator.
   * 
   * @return MyGraphNode
   */
  public MyGraphNode getNodeFromGraph() throws NoSuchElementException {
    Iterator<MyGraphNode> item = this.adjacencyList.keys().asIterator();
    var result = item.next();
    return result;
  }

  /**
   * Returns true if the AdjacencyList is empty, otherwise false.
   * 
   * @return boolean
   */
  public boolean isEmpty() {
    return this.adjacencyList.isEmpty();
  }
}

class MyGraphNode {
  private int value;
  final private List<MyGraphEdge> edges;

  public MyGraphNode(int value) {
    this.edges = new ArrayList<>() {
    };
    this.value = value;
  }

  public List<MyGraphEdge> getEdges() {
    return edges;
  }

  public ArrayList<MyGraphNode> getNeighbors() {
    ArrayList<MyGraphNode> result = new ArrayList<>();

    for (MyGraphEdge edge : edges) {
      result.add(edge.getNeighbor());
    }

    return result;
  }

  // use this to help get an appropriate hashcode
  public int[] getNeighborValues() {
    ArrayList<MyGraphNode> neighbors = this.getNeighbors();
    int[] results = new int[this.getNeighbors().size()];
    int count = 0;

    for (MyGraphNode node : neighbors) {
      results[count] = node.getValue();
      count++;
    }

    return results;
  }

  /**
   * Creates a new Edge with default weight 1 and neighbor param vertex and
   * attaches it to this Node.
   * 
   * @param vertex MyGraphNode
   * @return boolean
   */
  public boolean addNeighbor(MyGraphNode vertex) {
    return this.addNeighbor(vertex, 0); // default weight
  }

  /**
   * Creates a new Edge with param weight and neighbor param vertex and attaches
   * it to this Node.
   * 
   * @param vertex MyGraphNode
   * @param weight Integer
   * @return boolean
   */
  public boolean addNeighbor(MyGraphNode vertex, int weight) {
    MyGraphEdge newEdge = new MyGraphEdge(vertex, weight);
    return this.edges.add(newEdge);
  }

  /**
   * Locates a neighbor vertex and removes it and its edge connection from this
   * Vertex.
   * Does NOT remove Vertex from a Graph Adjacency List.
   * 
   * @param neighborVertex MyGraphNode
   * @return boolean true if succeeds, false if fails
   */
  public boolean removeNeighbor(MyGraphNode neighborVertex) {
    boolean result = false;
    for (MyGraphEdge edge : this.edges) {
      if (edge.getNeighbor().equals(neighborVertex)) {
        this.edges.remove(edge);
        result = true;
      }
    }
    return result;
  }

  public int getValue() {
    return value;
  }

  public void setValue(int value) {
    this.value = value;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other)
      return true;
    if (!(other instanceof MyGraphNode))
      return false;
    MyGraphNode that = (MyGraphNode) other;
    return this.getValue() == that.getValue() && Arrays.equals(this.getNeighborValues(), that.getNeighborValues());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getValue(), Arrays.hashCode(getNeighborValues()));
  }
}

class MyGraphEdge {
  private MyGraphNode neighbor;
  private int weight;

  public MyGraphEdge(MyGraphNode neighbor) {
    this.neighbor = neighbor;
    this.weight = 0;
  }

  public MyGraphEdge(MyGraphNode neighbor, int weight) {
    this.neighbor = neighbor;
    this.weight = weight;
  }

  public MyGraphNode getNeighbor() {
    return neighbor;
  }

  public void setNeighbor(MyGraphNode neighbor) {
    this.neighbor = neighbor;
  }

  public int getWeight() {
    return weight;
  }

  public void setWeight(int weight) {
    this.weight = weight;
  }
}
