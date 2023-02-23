package myJava.code.models;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class DirectedCompleteGraph<T> {
    private Set<GraphNode<T>> adjacencySet;
    private Set<GraphNode<T>> visitedNodes;

    public DirectedCompleteGraph(T value) {
        var newNode = new GraphNode<T>(value);
        this.adjacencySet = new HashSet<>();
        this.adjacencySet.add(newNode);
        this.visitedNodes = new HashSet<>();
    }

    public void addVertex(T data, int weight, GraphNode<T> neighborOfVertex) throws NullPointerException {
        var newNode = new GraphNode<T>(data);
        var newEdge = new GraphEdge<T>(weight, newNode);
        neighborOfVertex.setNeighbor(newEdge);
        this.adjacencySet.add(neighborOfVertex);
    }

    public void addVertex(T data, int weight, T neighborOfValue) {
        // todo: test this
        var nodeToConnectTo = findVertexBreadthFirst(neighborOfValue);
        this.addVertex(data, weight, nodeToConnectTo);
    }

    public T findVertexByValueBF(T valueToFind) throws NullPointerException {
        GraphNode<T> vertex = findVertexBreadthFirst(valueToFind);
        return vertex.getValue();
    }

    public GraphNode<T> findVertexBreadthFirst(T valueToFind) throws NullPointerException {
        // todo: test this
        if (this.adjacencySet.isEmpty()) {
            throw new NullPointerException("No nodes in this Graph");
        }
        var vertexQ = new MyQueue<GraphNode<T>>();
        this.visitedNodes = new HashSet<>();
        GraphNode<T> starterVertex = adjacencySet.iterator().next();
        vertexQ.enqueue(starterVertex);
        while (!vertexQ.isEmpty()) {
            var tempVertex = vertexQ.dequeue();
            if (tempVertex.getValue().equals(valueToFind)) {
                return tempVertex;
            }
            for (GraphEdge<T> edge : tempVertex.getNeighbors()) {
                tempVertex = edge.getNeighbor();
                if (!this.visitedNodes.contains(tempVertex)) {
                    vertexQ.enqueue(tempVertex);
                }
            }
        }
        return null;
    }

    public Set<GraphNode<T>> getAdjacencySet() {
        return adjacencySet;
    }

    public ArrayList<T> getVisitedNodes() {
        var resultArr = new ArrayList<T>();
        for (GraphNode<T> node : this.visitedNodes) {
            resultArr.add(node.getValue());
        }
        return resultArr;
    }


    private static class GraphNode<T> {
        private T value;
        private Set<GraphEdge<T>> neighbors;

        public GraphNode(T value) {
            this.value = value;
            this.neighbors = new HashSet<>();
        }

        private T getValue() {
            return this.value;
        }

        private Set<GraphEdge<T>> getNeighbors() {
            return this.neighbors;
        }

        private void setValue(T value) throws NullPointerException {
            this.value = value;
        }

        private void setNeighbor(GraphEdge<T> neighbor) throws NullPointerException {
            this.neighbors.add(neighbor);
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
