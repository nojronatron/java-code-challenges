package myJava.code.challenges;

import java.util.concurrent.LinkedTransferQueue;

public class ConnectBinaryTrees<T> {
    private final T value;
    private ConnectBinaryTrees<T> leftChild;
    private ConnectBinaryTrees<T> rightChild;

    public ConnectBinaryTrees(T data) {
        this.value = data;
    }

    public T getValue() {
        return this.value;
    }

    public ConnectBinaryTrees<T> getLeftChild() {
        return this.leftChild;
    }

    public ConnectBinaryTrees<T> getRightChild() {
        return this.rightChild;
    }

    public void setLeftChild(ConnectBinaryTrees<T> node) {
        this.leftChild = node;
    }

    public void setRightChild(ConnectBinaryTrees<T> node) {
        this.rightChild = node;
    }

    public boolean isLeaf() {
        return this.leftChild == null && this.rightChild == null;
    }

    public boolean hasLeftChild() {
        return this.leftChild != null;
    }

    public boolean hasRightChild() {
        return this.rightChild != null;
    }

    public boolean hasOnlyLeft() {
        return this.leftChild != null && this.rightChild == null;
    }

    public boolean hasOnlyRight() {
        return this.leftChild == null && this.rightChild != null;
    }

    @Override
    public String toString() {
        // this is for ease of debugging this Node instance
        StringBuilder sb = new StringBuilder("[");
        sb.append(this.value.toString()).append(":");
        var leftItem = this.getLeftChild() != null ? this.getLeftChild().getValue() : " ";
        var rightItem = this.getRightChild() != null ? this.getRightChild().getValue() : " ";
        sb.append(leftItem.toString()).append(",").append(rightItem.toString());
        sb.append("]");
        return sb.toString();
    }

    public String displayTree() {
        // this is for ease of debugging to display list of nodes in this tree instance
        LinkedTransferQueue<ConnectBinaryTrees<T>> breadthQueue = new LinkedTransferQueue<>();
        StringBuilder visited = new StringBuilder();
        visited.append("<");
        breadthQueue.add(this); // enqueue
        while (!breadthQueue.isEmpty()) {
            ConnectBinaryTrees<T> temp = breadthQueue.remove(); // dequeue
            visited.append(temp.toString()).append(",");
            if (temp.getLeftChild() != null) {
                breadthQueue.add(temp.getLeftChild());
            }
            if (temp.getRightChild() != null) {
                breadthQueue.add(temp.getRightChild());
            }
        }
        visited.delete(visited.length() - 2, visited.length());
        visited.append("]>");
        return visited.toString();
    }

    public static <T> ConnectBinaryTrees<T> addTree(ConnectBinaryTrees<T> leftTree, ConnectBinaryTrees<T> rightTree) {
        if (leftTree == null && rightTree == null) {
            return null;
        }
        if (leftTree == null) {
            return rightTree;
        }
        if (rightTree == null) {
            return leftTree;
        }
        LinkedTransferQueue<ConnectBinaryTrees<T>> breadthQueue = new LinkedTransferQueue<>();
        breadthQueue.add(rightTree); // enqueue
        while (!breadthQueue.isEmpty()) {
            ConnectBinaryTrees<T> currentNode = breadthQueue.remove(); // dequeue
            if (currentNode.isLeaf()) {
                currentNode.setLeftChild(leftTree);
                return rightTree;
            }
            if (currentNode.hasOnlyLeft()) {
                currentNode.setRightChild(leftTree);
                return rightTree;
            }
            if (currentNode.hasOnlyRight()) {
                currentNode.setLeftChild(leftTree);
                return rightTree;
            }
            if (currentNode.hasLeftChild()) {
                breadthQueue.add(currentNode.getLeftChild());
            }
            if (currentNode.hasRightChild()) {
                breadthQueue.add(currentNode.getRightChild());
            }
        }
        return rightTree;
    }
}
