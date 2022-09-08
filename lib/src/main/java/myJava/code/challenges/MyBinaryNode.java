package myJava.code.challenges;

public class MyBinaryNode {
    private int value;
    private MyBinaryNode left;
    private MyBinaryNode right;

    public MyBinaryNode(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public MyBinaryNode getLeft() {
        return left;
    }

    public void setLeft(MyBinaryNode left) {
        this.left = left;
    }

    public MyBinaryNode getRight() {
        return right;
    }

    public void setRight(MyBinaryNode right) {
        this.right = right;
    }
}
