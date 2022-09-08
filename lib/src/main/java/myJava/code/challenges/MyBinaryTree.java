package myJava.code.challenges;

public class MyBinaryTree {
    private MyBinaryNode root = null;

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
        // process root.getValue()
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
        // process root.getValue();
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
        // process root.getValue();
    }

    public void breadthFirst(MyBinaryNode root) {
        // TODO: Implement MyQueue before implementing
    }
}
