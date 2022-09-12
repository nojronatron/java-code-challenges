package myJava.code.challenges;

import java.util.ArrayList;

public class MyKaryNode<T> {
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

    public ArrayList<MyKaryNode<T>> getChildren() {
        return this.children;
    }

    public void setChildren(ArrayList<MyKaryNode<T>> children) {
        this.children = children;
    }
}
