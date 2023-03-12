package myJava.code.models.DirectedCompleteGraph;

import myJava.code.models.MyQueue;

import java.sql.Ref;
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

        Stack<MyGraphEdge<T>> edgeCrumbs = new Stack<>();
        MyGraphNode<T> destination = target;
        int sumWeight = 0;

        while (!destination.equals(root)) {
            // find vertex that has target vertex as a neighbor
            var vertexWithTargetNeighbor = findVertexWithTargetNeighbor(destination, edgeCrumbs);

            // change destination Vertex to be the one just found
            if (vertexWithTargetNeighbor == null) {
                return 0;
            } else {
                destination = vertexWithTargetNeighbor;
            }
        }

        while (!edgeCrumbs.isEmpty()) {
            sumWeight += edgeCrumbs.pop().getWeight();
        }

        return sumWeight;
    }


    private MyGraphNode<T> findVertexWithTargetNeighbor(MyGraphNode<T> targetNode, Stack<MyGraphEdge<T>> trackingStack) {
        // find vertex with target vertex as a neighbor and return the edge between them else null
        if (this.adjacencyTable.containsKey(targetNode.getValue())){
            var keys = this.adjacencyTable.keySet();
            for(T item: keys) {
                MyGraphNode<T> currentNode = this.adjacencyTable.get(item);
                if (currentNode.equals(targetNode)) {
                    continue;
                }
                var breadcrumb = findBreadcrumbPortion(currentNode, targetNode);
                if (breadcrumb != null) {
                    trackingStack.push(breadcrumb);
                    return currentNode;
                }
            }
        }
        return null;
    }

    private MyGraphEdge<T> findBreadcrumbPortion(MyGraphNode<T> starterVertex, MyGraphNode<T> targetVertex) {
        for(MyGraphEdge<T> edge: starterVertex.getEdges()) {
            if (edge != null && edge.getNeighbor().equals(targetVertex)) {
                return edge;
            }
        }
        return null;
    }

    private MyGraphEdge<T> getWeightToTargetVertex(MyGraphNode<T> sourceVertex, MyGraphNode<T> destinationVertex) {
        for (var edge: sourceVertex.getEdges()) {
            if (edge.getNeighbor().equals(destinationVertex)) {
                return edge;
            }
        }
        return null;
    }

    private Stack<MyGraphEdge<T>> getListOfEdges (MyGraphNode<T> vertex) {
        Stack<MyGraphEdge<T>> result = new Stack<>();
        for (MyGraphEdge<T> edge: vertex.getEdges()) {
            result.push(edge);
        }
        return result;
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
