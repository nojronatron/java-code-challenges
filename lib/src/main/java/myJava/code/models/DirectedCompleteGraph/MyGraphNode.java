package myJava.code.models.DirectedCompleteGraph;

import java.util.HashSet;
import java.util.Set;

public class MyGraphNode<T> {
    private T value;
    private Set<MyGraphEdge<T>> edges;

    public MyGraphNode(T value) {
        this.value = value;
        this.edges = new HashSet<>();
    }

    public T getValue() {
        return this.value;
    }

    public Set<MyGraphEdge<T>> getEdges() {
        return this.edges;
    }

    public void setValue(T value) throws NullPointerException {
        this.value = value;
    }

    public void setEdge(MyGraphEdge<T> newEdge) throws NullPointerException {
        this.edges.add(newEdge);
    }

    public void setEdge(MyGraphNode<T> neighbor, int weight) throws NullPointerException {
        var newEdge = new MyGraphEdge<>(neighbor, weight);
        this.edges.add(newEdge);
    }

    public int edgeCount() {
        return this.edges.size();
    }

    @Override
    public String toString() {
        return String.format(" [ %s {%s} ] ", this.getValue(), this.edgeCount());
    }
}
