package myJava.code.models;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Set;

public class DirectedCompleteGraph<T> {
    private Hashtable<T, GraphNode<T>> adjacencyTable;
    private Set<GraphNode<T>> visitedNodes;
    private GraphNode<T> firstNode;
    private int count;

    public DirectedCompleteGraph(T value) {
        var newNode = new GraphNode<T>(value);
        this.adjacencyTable = new Hashtable<>();
        this.adjacencyTable.put(newNode.getValue(), newNode);
        this.visitedNodes = new HashSet<>();
        this.firstNode = newNode;
        this.count = 1;
    }

    public void addVertex(GraphNode<T> vertex) throws NullPointerException {
        this.adjacencyTable.put(vertex.getValue(), vertex);
        this.count++;
    }
    public void addVertex(T data, int weight, GraphNode<T> neighborOfVertex) throws NullPointerException {
        var newNode = new GraphNode<T>(data);
        var newEdge = new GraphEdge<T>(weight, newNode);
        neighborOfVertex.setNeighbor(newEdge);
        this.adjacencyTable.put(newNode.getValue(), newNode);
        this.count++;
    }

    public void removeVertex(GraphNode<T> vertexToRemove) throws NullPointerException {
        this.adjacencyTable.remove(vertexToRemove.getValue(), vertexToRemove);
    }
    public void addVertex(T data, int weight, T neighborOfValue) {
        // todo: test this
        GraphNode<T> nodeToConnectTo = findVertexBreadthFirst(neighborOfValue);
        this.addVertex(data, weight, nodeToConnectTo);
    }

    // todo: function to add Edge between two existing Vertices

    public T findVertexValueByValueBF(T valueToFind) throws NullPointerException {
        GraphNode<T> vertex = findVertexBreadthFirst(valueToFind);
        return vertex.getValue();
    }

    public GraphNode<T> findVertexBreadthFirst(T valueToFind) throws NullPointerException {
        // todo: test this
        if (this.adjacencyTable.isEmpty()) {
            throw new NullPointerException("No nodes in this Graph");
        }
        var vertexQ = new MyQueue<GraphNode<T>>();
        this.visitedNodes = new HashSet<>();
        // todo: this will not work in all undirected fully connected graph scenarios
        GraphNode<T> starterVertex = this.firstNode;
        vertexQ.enqueue(starterVertex);
        while (!vertexQ.isEmpty()) {
            GraphNode<T> tempVertex = vertexQ.dequeue();
            if (tempVertex.getValue().equals(valueToFind)) {
                return tempVertex;
            }
            for (GraphEdge<T> edge : tempVertex.getEdges()) {
                tempVertex = edge.getNeighbor();
                if (!this.visitedNodes.contains(tempVertex)) {
                    vertexQ.enqueue(tempVertex);
                    this.visitedNodes.add(tempVertex);
                }
            }
        }
        return null;
    }

    public String getAdjacencyTable() {
        return this.adjacencyTable.toString();
    }

    public ArrayList<T> getVisitedNodes() {
        var resultArr = new ArrayList<T>();
        for (GraphNode<T> node : this.visitedNodes) {
            resultArr.add(node.getValue());
        }
        return resultArr;
    }

    public int getCount() {
        return this.count;
    }


    public static class GraphNode<T> {
        private T value;
        private Set<GraphEdge<T>> edges;

        public GraphNode(T value) {
            this.value = value;
            this.edges = new HashSet<>();
        }

        private T getValue() {
            return this.value;
        }

        private Set<GraphEdge<T>> getEdges() {
            return this.edges;
        }

        private void setValue(T value) throws NullPointerException {
            this.value = value;
        }

        private void setNeighbor(GraphEdge<T> neighbor) throws NullPointerException {
            this.edges.add(neighbor);
        }
    }

    private static class GraphEdge<T> {
        private int weight;
        private GraphNode<T> neighbor;

        public GraphEdge(int weight, GraphNode<T> neighbor) {
            this.weight = weight;
            this.neighbor = neighbor;
        }

        private int getWeight() {
            return this.weight;
        }

        private void setWeight(int weight) {
            this.weight = weight;
        }

        private GraphNode<T> getNeighbor() {
            return this.neighbor;
        }

        public void setNeighbor(GraphNode<T> neighbor) {
            this.neighbor = neighbor;
        }
    }
}
