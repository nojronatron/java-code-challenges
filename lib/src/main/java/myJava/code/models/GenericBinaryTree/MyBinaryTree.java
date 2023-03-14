package myJava.code.models.GenericBinaryTree;

import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;

public class MyBinaryTree<T> {
    private BinaryNode<T> root;
    private int count;

    public MyBinaryTree(T value) {
        root = new BinaryNode<>(value);
        count = 1;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public boolean contains(T searchValue) {
        return get(searchValue) != null;
    }

    public boolean addNode(T nodeValue) {
        // does a breadth-first traversal to find next-best place to add new node
        // LinkedBlockingQueue implements FIFO and has head, tail, count, and peek
        // time complexity O(n), although the pseudo-sorting allows for O(height)
        // space complexity O(width) due to use of a Queue
        BinaryNode<T> newNode = new BinaryNode<>(nodeValue);
        boolean result = addNode(newNode);
        return result;
    }

    public boolean addNode(BinaryNode<T> parentNode) {
        if (this.contains(parentNode.value)) {
            return true;
        }

        LinkedBlockingQueue<BinaryNode<T>> treeQueue = new LinkedBlockingQueue<>();
        treeQueue.add(root);
        while (!treeQueue.isEmpty()) {
            BinaryNode<T> tempNode = treeQueue.poll();
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
        // 1. Node value is same as root
        if (root.value == targetNodeValue) {
            BinaryNode<T> rightChild = root.getRightChild();
            root.setRightChild(null);
            this.root = root.getLeftChild();
            // root node could be ONLY node
            if (rightChild != null) {
                addNode(rightChild);
            }
            this.count--;
            return targetNodeValue;
        }

        // 2. Find targetNodeParent
        BinaryNode<T> targetNode = getFromNodeValue(targetNodeValue, root);
        if (targetNode == null) {
            throw new NullPointerException("Much to my surprise, Target Node is null!");
        }
        BinaryNode<T> parentNode = findParentNode(targetNode, root);
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
        BinaryNode<T> targetLeftChild = targetNode.getLeftChild();
        BinaryNode<T> targetRightChild = targetNode.getRightChild();
        if (clearChildRef(parentNode, targetNode)) {
            targetNode.setLeftChild(null);
            targetNode.setRightChild(null);
            this.addNode(targetLeftChild);
            this.addNode(targetRightChild);
            this.count--;
            return targetNodeValue;
        }

        // 5. Target has LEFT Child OR RIGHT Child only
//        BinaryNode<T> targetChild = targetNode.hasLeftChild() ? targetNode.getLeftChild() : targetNode.getRightChild();
        boolean collapseGrandChildToParent = setChildRef(parentNode, targetNode);
        if (collapseGrandChildToParent) {
            this.count--;
        }
        return targetNodeValue;
    }

    private boolean setChildRef(BinaryNode<T> parentNode, BinaryNode<T> targetNode) {
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
    private boolean clearChildRef(BinaryNode<T> parentNode, BinaryNode<T> targetNode) {
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

    private BinaryNode<T> findParentNode(BinaryNode<T> targetNode, BinaryNode<T> startingNode) {
        Set<BinaryNode<T>> visitedSet = new HashSet<>();
        Stack<BinaryNode<T>> treeStack = new Stack<>();
        treeStack.push(startingNode);
        while (!treeStack.isEmpty()) {
            BinaryNode<T> currentNode = treeStack.peek();
            if (currentNode.hasLeftChild() && currentNode.getLeftChild().value == targetNode.value) { // might throw
                return currentNode;
            }
            if (currentNode.hasRightChild() && currentNode.getRightChild().value == targetNode.value) {
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

    private BinaryNode<T> get(T nodeValue) {
        return getFromNodeValue(nodeValue, this.root);
    }

    private BinaryNode<T> getFromNodeValue(T nodeValue, BinaryNode<T> startingNode) {
        // find node with data nodeValue and return a reference to that node
        // does a depth-first search for value in binary tree startingNode
        // time complexity is O(n) aka O(this.count)
        // space complexity is N for each Set and Stack or O(2n) -> O(n)
        Set<BinaryNode<T>> visitedSet = new HashSet<>();
        Stack<BinaryNode<T>> treeStack = new Stack<>();
        treeStack.push(startingNode);
        while (!treeStack.isEmpty()) {
            if (treeStack.peek().value == nodeValue) {
                return treeStack.pop();
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
        return null;
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

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("[").append(this.value.toString()).append(":");
            if (this.leftChild != null) {
                sb.append(this.leftChild.value.toString());
            } else {
                sb.append(" ");
            }
            sb.append(",");
            if (this.rightChild != null) {
                sb.append(this.rightChild.value.toString());
            } else {
                sb.append(" ");
            }
            sb.append("]");
            return sb.toString();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof BinaryNode<?> that)) return false;
            return Objects.equals(value, that.value);
        }

        @Override
        public int hashCode() {
            return Objects.hash(value);
        }
    }
}
