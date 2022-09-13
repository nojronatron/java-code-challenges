package myJava.code.challenges;

import java.util.ArrayList;
import java.util.List;

public class MyKaryNode<T> implements IMyKaryNode<T> {
    private T value;

    private ArrayList<MyKaryNode<T>> children = new ArrayList<>();

    public MyKaryNode(T data) {
        this.value = data;
    }

    public T getValue() {
        return this.value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public MyKaryNode<T> getChild(int index) {
        if (index > this.children.size() - 1) {
            return null;
        }

        if (index < 1) {
            return null;
        }

        MyKaryNode<T> temp = this.children.get(index);

        if (temp == null || temp.value == null) {
            return temp;
        }

        return null;
    }

    public void setChild(MyKaryNode<T> childNode) {
        this.children.add(childNode);
    }

    public boolean hasChildren() {
        if (this.children.size() < 1) {
            return false;
        }

        int nonNullCount = 0;
        for(var child: this.children) {
            if (child != null) {
                nonNullCount++;
            }
        }

        return nonNullCount > 0;
    }

    public boolean isLeaf(){
        return !this.hasChildren();
    }

    @Override
    public ArrayList<MyKaryNode<T>> getChildren() {
        return this.children;
    }

    @Override
    public void setChildren(List<MyKaryNode<T>> children) {
        this.children = new ArrayList<>(children);
    }

    public List<MyKaryNode<T>> breadthFirst (MyKaryNode<T> rootNode) {
        List<MyKaryNode<T>> result = new ArrayList<>();
        MyQueue<MyKaryNode<T>> breadth = new MyQueue<>();
        breadth.enqueue(rootNode);

        while (!breadth.isEmpty()) {
            var front = breadth.dequeue();
            result.add(front); // for later processing
            for (var child : front.getChildren()) {
                breadth.enqueue(child);
            }
        }

        return result;
    }

    public String toString() {
        return String.format("%1$s", this.value);
    }
}
