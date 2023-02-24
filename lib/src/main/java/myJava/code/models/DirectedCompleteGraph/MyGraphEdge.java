package myJava.code.models.DirectedCompleteGraph;

public class MyGraphEdge<T> {
    private int weight;
    private MyGraphNode<T> neighbor;

    public MyGraphEdge(MyGraphNode<T> neighbor, int weight) {
        this.weight = weight;
        this.neighbor = neighbor;
    }

    public int getWeight() {
        return this.weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public MyGraphNode<T> getNeighbor() {
        return this.neighbor;
    }

    public void setNeighbor(MyGraphNode<T> neighbor) {
        this.neighbor = neighbor;
    }
}
