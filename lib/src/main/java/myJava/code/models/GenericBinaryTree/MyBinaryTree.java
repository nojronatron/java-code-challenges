package myJava.code.models.GenericBinaryTree;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingQueue;

public class MyBinaryTree<T> {
    private final BinaryNode<T> root;
    private int count;

    public MyBinaryTree(T value) {
        root = new BinaryNode<>(value);
        count = 1;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public boolean contains(T searchValue) {
        // does a depth-first search for value in this binary tree
        // time complexity is O(n) aka O(this.count)
        // space complexity is N for each Set and Stack or O(2n) -> O(n)
        Set<BinaryNode<T>> visitedSet = new HashSet<>();
        Stack<BinaryNode<T>> treeStack = new Stack<>();
        treeStack.push(this.root);
        while (!treeStack.isEmpty()) {
            if (treeStack.peek().value == searchValue) {
                return true;
            }
            BinaryNode<T> tempNode = treeStack.peek();
            if (tempNode.hasLeftChild() && !visitedSet.contains(tempNode.getLeftChild())) {
                visitedSet.add(tempNode.getLeftChild());
                treeStack.push(tempNode.getLeftChild());
                continue;
            }
            if (tempNode.hasRightChild() && !visitedSet.contains(tempNode.getRightChild())) {
                visitedSet.add(tempNode.getRightChild());
                treeStack.push(tempNode.getRightChild());
                continue;
            }
            treeStack.pop(); // remove from the stack to stop processing top element
        }

        return false;
    }

    public boolean addNode(T nodeValue) {
        // does a breadth-first traversal to find next-best place to add new node
        // LinkedBlockingQueue implements FIFO and has head, tail, count, and peek
        // time complexity O(n), although the pseudo-sorting allows for O(height)
        // space complexity O(width) due to use of a Queue
        BinaryNode<T> newNode = new BinaryNode<>(nodeValue);
        LinkedBlockingQueue<BinaryNode<T>> treeQueue = new LinkedBlockingQueue<>();
        treeQueue.add(root);
        while (!treeQueue.isEmpty()) {
            BinaryNode<T> tempNode = treeQueue.poll();
            // try to set a child and exit
            if (tempNode.isLeaf()) {
                tempNode.setLeftChild(newNode);
                this.count++;
                return true;
            }
            if (!tempNode.hasRightChild()) {
                tempNode.setRightChild(newNode);
                this.count++;
                return true;
            }
            // if we are here then we need to see which leaf child to enqueue next
            if (tempNode.hasLeftChild() && tempNode.getLeftChild().isLeaf()) {
                treeQueue.add(tempNode.getLeftChild());
                continue;
            }
            if (tempNode.hasRightChild() && tempNode.getRightChild().isLeaf()) {
                treeQueue.add(tempNode.getRightChild());
                continue;
            }
            // neither child is a leaf node so pick one to enqueue
            int newNodeSeed = newNode.hashCode();
            if (chooseLeft(newNodeSeed)) {
                treeQueue.add(tempNode.getLeftChild());
            } else {
                treeQueue.add(tempNode.getRightChild());
            }
        }
        return false;
    }

    public T removeNode(T nodeValue) throws NoSuchMethodException {
        throw new NoSuchMethodException("Method not implemented.");
    }

    private boolean chooseLeft(long binaryNodeHashCode) {
        // use pseudorandom generator to select left or right child node
        var rand = new Random(binaryNodeHashCode);
        var randInt = rand.nextInt();
        return randInt < 0;
    }

    public int getCount() {
        return this.count;
    }

    static class BinaryNode<T> {
        // implement comparable<T>
        private final T value;
        private BinaryNode<T> leftChild;
        private BinaryNode<T> rightChild;

        private BinaryNode(T value) {
            this.value = value;
        }

        private boolean hasLeftChild() {
            return this.leftChild != null;
        }

        private boolean hasRightChild() {
            return this.rightChild != null;
        }

        private BinaryNode<T> getLeftChild() {
            return leftChild;
        }

        private void setLeftChild(BinaryNode<T> leftChild) {
            this.leftChild = leftChild;
        }

        private BinaryNode<T> getRightChild() {
            return rightChild;
        }

        private void setRightChild(BinaryNode<T> rightChild) {
            this.rightChild = rightChild;
        }

        private boolean isLeaf() {
            return this.leftChild == null && this.rightChild == null;
        }

    }
}
