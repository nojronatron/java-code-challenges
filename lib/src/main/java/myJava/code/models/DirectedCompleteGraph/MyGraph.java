package myJava.code.models.DirectedCompleteGraph;

import myJava.code.models.MyQueue;
import myJava.code.models.MyStack;

import java.util.*;

public class MyGraph<T> {
    private final Hashtable<T, MyGraphNode<T>> adjacencyTable;
    private Set<MyGraphNode<T>> visitedNodes;
    //private MyStack trackerStack;
    private Stack<MyGraphEdge<T>> trackerStack;

    public MyGraph(MyGraphNode<T> vertex) {
        this.adjacencyTable = new Hashtable<>();
        this.adjacencyTable.put(vertex.getValue(), vertex);
        this.visitedNodes = new HashSet<>();
    }

    public MyGraph(Map<T, MyGraphNode<T>> verticesCollection) {
        this.adjacencyTable = new Hashtable<>();
        this.adjacencyTable.putAll(verticesCollection);
        this.visitedNodes = new HashSet<>();
    }

    public void addVertex(MyGraphNode<T> vertex) throws NullPointerException {
        this.adjacencyTable.put(vertex.getValue(), vertex);
    }

    public void addVertex(T data, int weight, MyGraphNode<T> neighborOfVertex) throws NullPointerException {
        throw new NullPointerException("TDD this implementation.");
    }

    public void removeVertex(MyGraphNode<T> vertexToRemove) throws NullPointerException {
        for(MyGraphNode<T> vertex: this.adjacencyTable.values()) {
            vertex.removeEdge(vertexToRemove);
        }

        vertexToRemove.removeEdges();
        this.adjacencyTable.remove(vertexToRemove.getValue(), vertexToRemove);
    }

    public T findVertexValueByValueBF(T startValue, T valueToFind) throws NullPointerException {
        var startValueExists =  this.adjacencyTable.containsKey(startValue);
        var valueToFindExists = this.adjacencyTable.containsKey(valueToFind);

        if (startValueExists && valueToFindExists) {
            var startVertex = this.adjacencyTable.get(startValue);
            MyGraphNode<T> vertex = findVertexBreadthFirst(startVertex, valueToFind);
            return vertex.getValue();
        } else {
            return null;
        }
    }

    public MyGraphNode<T> findVertexBreadthFirst(MyGraphNode<T> starterVertex, T valueToFind) throws NullPointerException {
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
            this.visitedNodes.add(tempVertex);
            for (MyGraphEdge<T> edge : tempVertex.getEdges()) {
                tempVertex = edge.getNeighbor();
                if (!this.visitedNodes.contains(tempVertex)) {
                    vertexQ.enqueue(tempVertex);
                }
            }
        }
        return null;
    }

    public int getWeightBetweenVertices(MyGraphNode<T> root, MyGraphNode<T> target) {
        if (root.equals(target)) {
            return 0;
        }
        this.trackerStack = new Stack<>();
        this.visitedNodes = new HashSet<>();
        this.visitedNodes.add(root);
        var pathCompleted = false;

        trackPathToTargetDF(root, target, pathCompleted);

        var weightSum = 0;
        while (!this.trackerStack.isEmpty()) {
            weightSum += this.trackerStack.pop().getWeight();
        }

        return weightSum;
    }

    private void trackPathToTargetDF(MyGraphNode<T> currentVertex, MyGraphNode<T> targetVertex, boolean pathCompleted) {
        if (!pathCompleted) {
            for(MyGraphEdge<T> edge: currentVertex.getEdges()) {
                this.trackerStack.push(edge);
                if (edge.getNeighbor().equals(targetVertex)) {
                    pathCompleted = true;
                    return;
                }
                if (!this.visitedNodes.contains(edge.getNeighbor())) {
                    this.visitedNodes.add(edge.getNeighbor());
                    trackPathToTargetDF(edge.getNeighbor(), targetVertex, pathCompleted);
                }
                this.trackerStack.pop();
            }
        }
    }

    public ArrayList<T> getVisitedNodes() {
        var resultArr = new ArrayList<T>();
        for (MyGraphNode<T> node : this.visitedNodes) {
            resultArr.add(node.getValue());
        }
        return resultArr;
    }

    public int getCount() {
        return this.adjacencyTable.size();
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
