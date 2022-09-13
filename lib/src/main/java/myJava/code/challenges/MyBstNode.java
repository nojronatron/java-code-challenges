package myJava.code.challenges;

import org.checkerframework.checker.units.qual.A;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class MyBstNode {
    private int value;
    private MyBstNode left;
    private MyBstNode right;
    private List<Integer> storage = new ArrayList<>();

    public MyBstNode(int data) {
        this.value = data;
    }

    public int getValue() {
        return this.value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public MyBstNode getLeft() {
        return this.left;
    }

    public void setLeft(MyBstNode left) {
        this.left = left;
    }

    public MyBstNode getRight() {
        return this.right;
    }

    public void setRight(MyBstNode right) {
        this.right = right;
    }

    public void add(int data) {
        var tempNode = new MyBstNode(data);
        MyBstNode currentNode = this;

        while (tempNode.getValue() != currentNode.getValue()) {
            if (tempNode.getValue() < this.getValue()) {
                currentNode = currentNode.getLeft();
                continue;
            }
            if (tempNode.getValue() > this.getValue()) {
                currentNode = currentNode.getRight();
            }
        }

    }

    public boolean contains(MyBstNode rootNode, int data) {
        var tempNode = this.search(rootNode, data);
        return tempNode.getValue() == data;
    }

    public MyBstNode search(MyBstNode rootNode, int data) {
        var tempNode = rootNode;

        while (tempNode.getValue() != data) {
            if (tempNode.getLeft().getValue() > data) {
                tempNode = tempNode.getLeft();
                continue;
            }
            if (tempNode.getRight().getValue() < data) {
                tempNode = tempNode.getRight();
            }
        }

        return tempNode;
    }

    private String inOrderTraversal(MyBstNode root) {
        if (root.getLeft() != null) {
            inOrderTraversal(root.getLeft());
        }

        // process root node here
        String nodeValue = String.valueOf(root.getValue());

        if (root.getRight() != null) {
            inOrderTraversal(root.getRight());
        }

        return String.valueOf(root.getValue()) + ", " + nodeValue;
    }

    public boolean isLeaf() {
        return this.getLeft() == null && this.getRight() == null;
    }

    public String toString() {
        MyBstNode tempNode = this;
        String nodeList = this.inOrderTraversal(tempNode);
        StringBuilder sb = new StringBuilder();
        sb.append("[ ").append(nodeList).append(" ]");
        return sb.toString();
    }
}
