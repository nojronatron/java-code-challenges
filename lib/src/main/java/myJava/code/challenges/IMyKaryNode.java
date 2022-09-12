package myJava.code.challenges;

import java.util.ArrayList;

public interface IMyKaryNode<T> {
    ArrayList<MyKaryNode<T>> getChildren();

    void setChildren(ArrayList<MyKaryNode<T>> children);

    T getValue();
}
