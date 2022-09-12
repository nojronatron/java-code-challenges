package myJava.code.challenges;

import java.util.ArrayList;
import java.util.List;

public class MyKaryTree<T> {
    private MyKaryNode<T> root = null;
    private List<T> storageArray = new ArrayList<>();

    public MyKaryTree(MyKaryNode<T> root) {
        this.root = root;
    }

    public MyKaryNode<T> getRoot() {
        return this.root;
    }

    public void setRoot(MyKaryNode<T> root) {
        this.root = root;
    }

    public ArrayList<T> getStorageArray() {
        return new ArrayList<>(this.storageArray);
    }

    public void setStorageArray(ArrayList<T> storageArray) {
        this.storageArray = storageArray;
    }

    public void breadthFirst(MyKaryNode<T> root) {
        MyQueue<MyKaryNode<T>> breadth = new MyQueue<>();
        breadth.enqueue(root);

        while (!breadth.isEmpty()) {
            MyKaryNode<T> temp = breadth.dequeue();

            // process the node...in this case we will just push the node value into a local arraylist
            T tempValue = temp.getValue();
            this.storageArray.add(tempValue);

            for (var node : temp.getChildren()) {
                breadth.enqueue(node);
            }
        }
    }
}
