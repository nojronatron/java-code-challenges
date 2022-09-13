package myJava.code.challenges;

import java.util.ArrayList;
import java.util.List;

public class MyKaryTree<T> {
    private T root = null;
    private List<T> storage = new ArrayList<>();

    public T getRoot() {
        return this.root;
    }

    public void setRoot(T node) {
        this.root = node;
    }

    public ArrayList<T> getStorage() {
        return new ArrayList<>(this.storage);
    }

    public void setStorage(ArrayList<T> storage) {
        this.storage = storage;
    }

    private void resetStorageArray() {
        this.storage = new ArrayList<>();
    }

//    public void breadthFirst(T root) {
//        this.resetStorageArray();
//        MyQueue<T> breadth = new MyQueue<>();
//        breadth.enqueue(root);
//
//        while (!breadth.isEmpty()) {
//            T tempNode = breadth.dequeue();
//
//            // process the node...in this case we will just push the node into a local arraylist
//            this.storage.add(tempNode);
//
//            // iterate through children and enqueue non-nulls
//            int idx = 0;
//            while (true) {
//                T tempChildNode = (MyKaryNode<T>)
//                idx++;
//            }
//        }
//    }
}
