package myJava.code.challenges;

public class MyBstNode {
    // Todo: consider adding a rebalancing method
    private int value;
    private MyBstNode left;
    private MyBstNode right;

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
        // Todo: consider improving the logic to be smarter about adding nodes
        MyBstNode tempNode = new MyBstNode(data);
        MyBstNode currentNode = this;

        while (tempNode.getValue() != currentNode.getValue()) {
            if (tempNode.getValue() < currentNode.getValue()) {
                if (currentNode.getLeft() == null) {
                    currentNode.setLeft(tempNode);
                    return;
                }
                currentNode = currentNode.getLeft();
                continue;
            }
            if (tempNode.getValue() > currentNode.getValue()) {
                if (currentNode.getRight() == null) {
                    currentNode.setRight(tempNode);
                    return;
                }
                currentNode = currentNode.getRight();
            }
        }

    }

    public boolean contains(MyBstNode rootNode, int data) {
        try {
            MyBstNode tempNode = this.search(rootNode, data);
            return tempNode.getValue() == data;
        } catch (NullPointerException npex) {
            System.out.println("contains() method received null from search() method. Returning \"false\". " + npex.getMessage());
            return false;
        }
    }

    public MyBstNode search(MyBstNode rootNode, int data) {
        MyBstNode tempNode = rootNode;

        while (tempNode.getValue() != data) {
            if (tempNode.getValue() > data) {
                if (tempNode.getLeft() == null) {
                    tempNode = null;
                    break;
                }
                tempNode = tempNode.getLeft();
                continue;
            }
            if (tempNode.getValue() < data) {
                if (tempNode.getRight() == null) {
                    tempNode = null;
                    break;
                }
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

        return root.getValue() + ", " + nodeValue;
    }

    public boolean isLeaf() {
        return this.getLeft() == null && this.getRight() == null;
    }

    public String listTree() {
        MyBstNode tempNode = this;
        String nodeList = this.inOrderTraversal(tempNode);
        StringBuilder sb = new StringBuilder();
        sb.append("[ ").append(nodeList).append(" ]");
        return sb.toString();
    }

    public String toString() {
        return String.valueOf(this.getValue());
    }
}
