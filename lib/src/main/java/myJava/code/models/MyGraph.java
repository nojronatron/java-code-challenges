package myJava.code.models;

import org.apache.commons.math3.exception.NullArgumentException;

import java.util.*;

public class MyGraph {
    private final List<MyGraphNode> visitedNodes;
    private final Hashtable<MyGraphNode, MyGraphNode> adjacencyList;

    public int getGraphSize() {
        return adjacencyList.size();
    }

    public MyGraph() {
        this.visitedNodes = new ArrayList<>();
        this.adjacencyList = new Hashtable<>();
    }

    /**
     * Adds a new Graph Node with the param value, effectively making it an "Island" Graph member.
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
     * Adds the param GraphNode to the Graph as a connected Graph member if it has an Edge to a Node in this Graph.
     * @param vertex MyGraphNode
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

    public MyGraphNode removeNode(MyGraphNode vertex) throws NullPointerException {
        return this.adjacencyList.remove(vertex);
    }

    public int[] getVisitedNodeValues() {
        int[] result = new int[this.visitedNodes.size()];
        int counter = 0;

        for(MyGraphNode node: this.visitedNodes) {
            result[counter] = node.getValue();
            counter++;
        }

        return result;
    }

    public MyGraphNode[] getVisitedNodes() {
        MyGraphNode[] result = this.visitedNodes.toArray(new MyGraphNode[0]);
        return result;
    }

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

        return this.visitedNodes;
    }

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

            for(MyGraphNode neighbor: neighbors) {
                if (!this.visitedNodes.contains(neighbor)) {
                    this.visitedNodes.add(neighbor);
                    depthStack.push(neighbor);
                }
            }
        }

        return this.visitedNodes;
    }


    /**
     * Returns a Node from the Adjacency List. Not guaranteed to be in a particular order.
     * @return MyGraphNode
     */
    public MyGraphNode getNodeFromGraph() throws NoSuchElementException {
        Iterator<MyGraphNode> item = this.adjacencyList.keys().asIterator();
        return item.next();
    }

    public boolean isEmpty() {
        return this.adjacencyList.isEmpty();
    }
}

class MyGraphNode {
    private int value;
    private List<MyGraphEdge> edges;

    public MyGraphNode(int value) {
        this.edges = new ArrayList<>(){};
        this.value = value;
    }

    public List<MyGraphEdge> getEdges() {
        return edges;
    }

    public ArrayList<MyGraphNode> getNeighbors() {
        ArrayList<MyGraphNode> result = new ArrayList<>();

        for(MyGraphEdge edge: edges) {
            result.add(edge.getNeighbor());
        }

        return result;
    }

    // use this to help get an appropriate hashcode
    public int[] getNeighborValues() {
        ArrayList<MyGraphNode> neighbors = this.getNeighbors();
        int[] results = new int[this.getNeighbors().size()];
        int count = 0;

        for (MyGraphNode node: neighbors) {
            results[count] = node.getValue();
            count++;
        }

        return results;
    }

    /**
     * Creates a new Edge with default weight 1 and neighbor param vertex and attaches it to this Node.
     * @param vertex MyGraphNode
     * @return boolean
     */
    public boolean addNeighbor(MyGraphNode vertex) {
        return this.addNeighbor(vertex, 0); // default weight
    }

    /**
     * Creates a new Edge with param weight and neighbor param vertex and attaches it to this Node.
     * @param vertex MyGraphNode
     * @param weight Integer
     * @return boolean
     */
    public boolean addNeighbor(MyGraphNode vertex, int weight) {
        boolean result = false;
        MyGraphEdge newEdge = new MyGraphEdge(vertex, weight);
        result = this.edges.add(newEdge);
        return result;
    }

    public boolean removeNeighbor(MyGraphNode neighborVertex) {
        for (MyGraphEdge edge: this.edges) {
            if (edge.getNeighbor().equals(neighborVertex)) {
                this.edges.remove(edge);
                return true;
            }
        }

        return false;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (!(other instanceof MyGraphNode)) return false;
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
