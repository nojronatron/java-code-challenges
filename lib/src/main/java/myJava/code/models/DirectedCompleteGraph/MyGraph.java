package myJava.code.models.DirectedCompleteGraph;

import myJava.code.models.MyQueue;

import java.util.*;

public class MyGraph<T> {
    private Hashtable<T, MyGraphNode<T>> adjacencyTable;
    private Set<MyGraphNode<T>> visitedNodes;
    private int count;

    public MyGraph(MyGraphNode<T> vertex) {
        this.adjacencyTable = new Hashtable<>();
        this.adjacencyTable.put(vertex.getValue(), vertex);
        this.visitedNodes = new HashSet<>();
        this.count = 1;
    }

    public MyGraph(Map<T, MyGraphNode<T>> verticesCollection) {
        this.adjacencyTable = new Hashtable<>();
        this.adjacencyTable.putAll(verticesCollection);
        this.visitedNodes = new HashSet<>();
        this.count = verticesCollection.size();
    }

    public void addVertex(MyGraphNode<T> vertex) throws NullPointerException {
        this.adjacencyTable.put(vertex.getValue(), vertex);
        this.count++;
    }

    public void addVertex(T data, int weight, MyGraphNode<T> neighborOfVertex) throws NullPointerException {
//        var newNode = new MyGraphNode<T>(data);
//        var newEdge = new MyGraphEdge<T>(newNode, weight);
//        neighborOfVertex.setEdge(newNode, weight);
//        this.adjacencyTable.put(newNode.getValue(), newNode);
//        this.count++;
    }

    public void removeVertex(MyGraphNode<T> vertexToRemove) throws NullPointerException {
        this.adjacencyTable.remove(vertexToRemove.getValue(), vertexToRemove);
    }

    // todo: function to add Edge between two existing Vertices

    public T findVertexValueByValueBF(T valueToFind) throws NullPointerException {
//        MyGraphNode<T> vertex = findVertexBreadthFirst(valueToFind);
//        return vertex.getValue();
        return null;
    }

    public MyGraphNode<T> findVertexBreadthFirst(MyGraphNode<T> starterVertex, T valueToFind) throws NullPointerException {
        // todo: test this
        if (this.adjacencyTable.isEmpty()) {
            throw new NullPointerException("No nodes in this Graph");
        }
        if (starterVertex == null) {
            throw new NullPointerException("Invalid starter vertex.");
        }
        var vertexQ = new MyQueue<MyGraphNode<T>>();
        this.visitedNodes = new HashSet<>();
        vertexQ.enqueue(starterVertex);
        while (!vertexQ.isEmpty()) {
            MyGraphNode<T> tempVertex = vertexQ.dequeue();
            if (tempVertex.getValue().equals(valueToFind)) {
                return tempVertex;
            }
            for (MyGraphEdge<T> edge : tempVertex.getEdges()) {
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
        for (MyGraphNode<T> node : this.visitedNodes) {
            resultArr.add(node.getValue());
        }
        return resultArr;
    }

    public int getCount() {
        return this.count;
    }

    @Override
    public String toString() {
        var result = new StringBuilder("[ ");
        Collection<MyGraphNode<T>> graphNodes = this.adjacencyTable.values();

        for(MyGraphNode<T> node: graphNodes) {
            String item = String.format(" ( %s:%s ), ", node.getValue(), node.edgeCount());
            result.append(item);
        }

        result.delete(result.length() - 2, result.length());
        result.append(" ]");
        return result.toString();
    }
}
