package myJava.code.challenges;

import java.util.ArrayList;

public class MyBinaryTree {
    private MyBinaryNode root = null;
    private ArrayList<Integer> storageArray = new ArrayList<>();

    public MyBinaryTree() {
        this.root = null;
    }

    public MyBinaryTree(MyBinaryNode root) {
        this.root = root;
    }

    public MyBinaryNode getRoot() {
        return root;
    }

    public void setRoot(MyBinaryNode root) {
        this.root = root;
    }

    public void preOrder(MyBinaryNode root) {
        // process root node here
        storageArray.add(root.getValue());

        if (root.getLeft() != null) {
            preOrder(root.getLeft());
        }
        if (root.getRight() != null) {
            preOrder(root.getRight());
        }
    }

    public void inOrder(MyBinaryNode root) {
        if (root.getLeft() != null) {
            inOrder(root.getLeft());
        }
        // process root node here
        storageArray.add(root.getValue());

        if (root.getRight() != null) {
            inOrder(root.getRight());
        }
    }

    public void postOrder(MyBinaryNode root) {
        if (root.getLeft() != null) {
            postOrder(root.getLeft());
        }
        if (root.getRight() != null) {
            postOrder(root.getRight());
        }
        // process root node here
        storageArray.add(root.getValue());
    }

    public void breadthFirst(MyBinaryNode root) {
        MyQueue<MyBinaryNode> breadth = new MyQueue<>();
        breadth.enqueue(root);
        while (!breadth.isEmpty()) {
            MyBinaryNode temp = breadth.dequeue();
            // process temp node value here
            if (temp.getLeft() != null) {
                breadth.enqueue(root.getLeft());
            }
            if (temp.getRight() != null) {
                breadth.enqueue(root.getRight());
            }
        }
    }

    public void addItemToStorageArray(int item) {
        this.storageArray.add(item);
    }

    public boolean resetStorageArray() {
        this.storageArray.clear();
        this.storageArray = new ArrayList<>();
        return true;
    }

    /***
     * Returns a stringified representation of the internal storage array to the caller.
     * If the internal storage array is empty it returns '[]'.
     * @return String
     */
    public String getStorageArray() {
        if (this.storageArray.size() < 1) {
            return "[]";
        }

        StringBuilder result = new StringBuilder();
        result.append("[ ");

        for(int item: this.storageArray) {
            result.append(item).append(", ");
        }

        int resultLen = result.length();
        result.delete(resultLen - 2, resultLen - 1);
        result.append("]");

        return result.toString();
    }
}
