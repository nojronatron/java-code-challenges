package myJava.code.models.DirectedCompleteGraph;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class MyGraphNode<T> {
    private T value;
    private final Set<MyGraphEdge<T>> edges;

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

    /***
     * Remove Edge(s) containing edge Neighbor from this Vertex that point to a specific Vertex.
     * @param edgeNeighbor The Neighbor Vertex to disconnect from.
     */
    public void removeEdge(MyGraphNode<T> edgeNeighbor) {
        Iterator<MyGraphEdge<T>> itEdges = this.edges.iterator();

        while (itEdges.hasNext()) {
            var nextEdge = itEdges.next();
            if (nextEdge.getNeighbor().equals(edgeNeighbor)) {
                 itEdges.remove();
            }
        }
    }

    /***
     * Remove all Edges from this Vertex. Vertex will no longer points to any other Vertex.
     */
    public void removeEdges() {
        this.edges.clear();
    }

    public int edgeCount() {
        return this.edges.size();
    }

    @Override
    public String toString() {
        return String.format(" [ %s {%s} ] ", this.getValue(), this.edgeCount());
    }
}
