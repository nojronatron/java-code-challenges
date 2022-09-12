package myJava.code.challenges;

import java.util.ArrayList;
import java.util.List;

public class MyKaryTree<T> {
    private IMyKaryNode<T> root = null;
    private List<T> valueStore = new ArrayList<>();

    public IMyKaryNode<T> getRoot() {
        return this.root;
    }

    public void setRoot(T data) {
        this.root = new MyKaryNode<T>(data);
    }

    public ArrayList<T> getValueStore() {
        return new ArrayList<>(this.valueStore);
    }

    public void setValueStore(ArrayList<T> valueStore) {
        this.valueStore = valueStore;
    }

    private void resetStorageArray() {
        this.valueStore.clear();
    }

    public void breadthFirst(IMyKaryNode<T> root) {
        this.resetStorageArray();
        MyQueue<IMyKaryNode<T>> breadth = new MyQueue<>();
        breadth.enqueue(root);

        while (!breadth.isEmpty()) {
            IMyKaryNode<T> temp = breadth.dequeue();

            // process the node...in this case we will just push the node value into a local arraylist
            T tempValue = temp.getValue();
            this.valueStore.add(tempValue);

            for (var node : temp.getChildren()) {
                breadth.enqueue(node);
            }
        }
    }
}
