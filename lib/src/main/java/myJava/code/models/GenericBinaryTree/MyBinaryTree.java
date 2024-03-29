package myJava.code.models.GenericBinaryTree;

import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;

public class MyBinaryTree<T> {
    private MyBinaryNode<T> root;
    private int count;

    public MyBinaryTree(T value) {
        this.root = new MyBinaryNode<>(value);
        this.count = 1;
    }

    public MyBinaryNode<T> getRoot() {
        return this.root;
    }

    private void setRoot(MyBinaryNode<T> root) {
        this.root = root;
    }

    public boolean isEmpty() {
        return getCount() == 0;
    }

    public boolean contains(T searchValue) {
        return get(searchValue) != null;
    }

    public boolean addNode(T nodeValue) {
        // does a breadth-first traversal to find next-best place to add new node
        // LinkedBlockingQueue implements FIFO and has head, tail, count, and peek
        // time complexity O(n), although the pseudo-sorting allows for O(height)
        // space complexity O(width) due to use of a Queue
        MyBinaryNode<T> newNode = new MyBinaryNode<>(nodeValue);
        return addNode(newNode);
    }

    public boolean addNode(MyBinaryNode<T> parentNode) {
        if (this.contains(parentNode.getValue())) {
            return true;
        }

        LinkedBlockingQueue<MyBinaryNode<T>> treeQueue = new LinkedBlockingQueue<>();
        treeQueue.add(getRoot());
        while (!treeQueue.isEmpty()) {
            MyBinaryNode<T> tempNode = treeQueue.poll();
            // try to set a child and exit
            if (tempNode.isLeaf()) {
                tempNode.setLeftChild(parentNode);
                this.count++;
                return true;
            }
            if (!tempNode.hasRightChild()) {
                tempNode.setRightChild(parentNode);
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
            int newNodeSeed = parentNode.hashCode();
            // well we already know it is not a Leaf Node
            if (parentNode.hasLeftChild() && parentNode.hasRightChild()) {
                // it is a Full lNode
                if (chooseLeft(newNodeSeed)) {
                    treeQueue.add(tempNode.getLeftChild());
                } else {
                    treeQueue.add(tempNode.getRightChild());
                }
            } else {
                // it has one child but which one?
                if (parentNode.hasLeftChild()) {
                    treeQueue.add(tempNode.getLeftChild());
                } else {
                    treeQueue.add(tempNode.getRightChild());
                }
            }
        }
        return false;
    }

    public T removeNode(T targetNodeValue) throws NullPointerException {
        // 1. Node value is same as this.root
        if (getRoot().getValue() == targetNodeValue) {
            int startCount = this.count;
            MyBinaryNode<T> rightChild = getRoot().getRightChild();
            getRoot().setRightChild(null);
            this.count--;
            setRoot(getRoot().getLeftChild());
            // root node MIGHT be ONLY node
            if (rightChild != null) {
                addNode(rightChild);
            }
            if (startCount > 1) {
                resetCount();
            }
            return targetNodeValue;
        }

        // 2. Find targetNodeParent
        MyBinaryNode<T> targetNode = getFromNodeValue(targetNodeValue, getRoot());
        if (targetNode == null) {
            throw new NullPointerException("Much to my surprise, Target Node is null!");
        }
        MyBinaryNode<T> parentNode = findParentNode(targetNode, getRoot());
        if (parentNode == null) {
            throw new NullPointerException("Much to my surprise, Target Node's Parent returned null!");
        }

        // 3. Target is a Leaf
        if (targetNode.isLeaf()) {
            if (clearChildRef(parentNode, targetNode)) {
                this.count--;
                return targetNodeValue;
            }
        }

        // 4. Target has BOTH Children
        MyBinaryNode<T> targetLeftChild = targetNode.getLeftChild();
        MyBinaryNode<T> targetRightChild = targetNode.getRightChild();
        if (clearChildRef(parentNode, targetNode)) {
            targetNode.setLeftChild(null);
            targetNode.setRightChild(null);
            addNode(targetLeftChild);
            addNode(targetRightChild);
            resetCount();
            return targetNodeValue;
        }

        // 5. Target has LEFT Child OR RIGHT Child only
        boolean collapseGrandChildToParent = setChildRef(parentNode, targetNode);
        if (collapseGrandChildToParent) {
            resetCount();
        }

        return targetNodeValue;
    }

    private boolean setChildRef(MyBinaryNode<T> parentNode, MyBinaryNode<T> targetNode) {
        if (targetNode.isLeaf() || (targetNode.hasLeftChild() && targetNode.hasRightChild())) {
            return false;
        }
        // now that we know we are working with Parent with single-child
        if (targetNode.hasLeftChild() && parentNode.hasLeftChild()) {
            if (parentNode.getLeftChild().equals(targetNode)) {
                parentNode.setLeftChild(targetNode.getLeftChild());
                targetNode.setLeftChild(null);
                return true;
            }
        }
        if (targetNode.hasLeftChild() && parentNode.hasRightChild()) {
            if (parentNode.getRightChild().equals(targetNode)) {
                parentNode.setRightChild(targetNode.getLeftChild());
                targetNode.setLeftChild(null);
                return true;
            }
        }
        if (targetNode.hasRightChild() && parentNode.hasLeftChild()) {
            if (parentNode.getLeftChild().equals(targetNode)) {
                parentNode.setLeftChild(targetNode.getRightChild());
                targetNode.setRightChild(null);
                return true;
            }
        }
        if (targetNode.hasRightChild() && parentNode.hasRightChild()) {
            if (parentNode.getRightChild().equals(targetNode)) {
                parentNode.setRightChild(targetNode.getRightChild());
                targetNode.setRightChild(null);
                return true;
            }
        }
        return false;
    }

    private boolean clearChildRef(MyBinaryNode<T> parentNode, MyBinaryNode<T> targetNode) {
        // dereference from parent node whichever child that exists and has same value as targetNode
        if (parentNode.hasLeftChild() && parentNode.getLeftChild().equals(targetNode)) {
            parentNode.setLeftChild(null);
            return true;
        }
        if (parentNode.getRightChild().equals(targetNode)) {
            parentNode.setRightChild(null);
            return true;
        }
        return false;
    }

    public T findParentNode(T targetNodeValue, T startingNodeValue) {
        // MyBinaryNode<T> class compares based only on VALUE
        // not by REF nor by child node(s) nor count
        MyBinaryNode<T> targetNode = get(targetNodeValue);
        MyBinaryNode<T> startingNode = get(startingNodeValue);
        MyBinaryNode<T> result = findParentNode(targetNode, startingNode);
        if (result == null) {
            throw new NullPointerException("Unable to find parent node.");
        }
        return result.getValue();
    }

    private MyBinaryNode<T> findParentNode(MyBinaryNode<T> targetNode, MyBinaryNode<T> startingNode) {
        if (targetNode.equals(startingNode)) {
            return null;
        }
        Set<MyBinaryNode<T>> visitedSet = new HashSet<>();
        Stack<MyBinaryNode<T>> treeStack = new Stack<>();
        treeStack.push(startingNode);
        while (!treeStack.isEmpty()) {
            MyBinaryNode<T> currentNode = treeStack.peek();
            if (currentNode.hasLeftChild() && currentNode.getLeftChild().equals(targetNode)) { // might throw
                return currentNode;
            }
            if (currentNode.hasRightChild() && currentNode.getRightChild().equals(targetNode)) {
                return currentNode;
            }
            if (currentNode.hasLeftChild() && !visitedSet.contains(currentNode.getLeftChild())) {
                visitedSet.add(currentNode.getLeftChild());
                treeStack.push(currentNode.getLeftChild());
                continue;
            }
            if (currentNode.hasRightChild() && !visitedSet.contains(currentNode.getRightChild())) {
                visitedSet.add(currentNode.getRightChild());
                treeStack.push(currentNode.getRightChild());
                continue;
            }
            treeStack.pop();
        }

        return null;
    }

    private MyBinaryNode<T> get(T nodeValue) {
        return getFromNodeValue(nodeValue, getRoot());
    }

    private MyBinaryNode<T> getFromNodeValue(T nodeValue, MyBinaryNode<T> startingNode) {
        // find node with data nodeValue and return a reference to that node
        // does a depth-first search for value in binary tree startingNode
        // time complexity is O(n) aka O(this.count)
        // space complexity is N for each Set and Stack or O(2n) -> O(n)
        Set<MyBinaryNode<T>> visitedSet = new HashSet<>();
        Stack<MyBinaryNode<T>> treeStack = new Stack<>();
        treeStack.push(startingNode);
        while (!treeStack.isEmpty()) {
            if (treeStack.peek().getValue() == nodeValue) {
                return treeStack.pop();
            }
            MyBinaryNode<T> tempNode = treeStack.peek();
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

        return null;
    }

    private boolean chooseLeft(long binaryNodeHashCode) {
        // use pseudorandom generator to select left or right child node
        var rand = new Random(binaryNodeHashCode);
        var randInt = rand.nextInt();
        System.out.printf("chooseLeft generated randInt %s.%n", randInt);
        return randInt < 0;
    }

    private void resetCount() throws IllegalStateException {
        // call this method to update the count of nodes in the tree
        // for example after removing a node that had children.
        Set<MyBinaryNode<T>> visited = new HashSet<>();
        LinkedBlockingQueue<MyBinaryNode<T>> treeQueue = new LinkedBlockingQueue<>();
        treeQueue.add(getRoot());
        while (!treeQueue.isEmpty()) {
            MyBinaryNode<T> currentNode = treeQueue.poll();
            visited.add(currentNode);
            if (currentNode.hasLeftChild() && !visited.contains(currentNode.getLeftChild())) {
                treeQueue.add(currentNode.getLeftChild());
            }
            if (currentNode.hasRightChild() && !visited.contains(currentNode.getRightChild())) {
                treeQueue.add(currentNode.getRightChild());
            }
        }

        count = visited.size();
        System.out.printf("Reset count to %s.%n", count);
    }

    public int getCount() {
        return this.count;
    }
}
