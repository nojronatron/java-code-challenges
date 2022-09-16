package myJava.code.challenges;

public class MyBinaryNode implements IMyBinaryNode {
    private int value;
    private MyBinaryNode left;
    private MyBinaryNode right;

    public MyBinaryNode(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public MyBinaryNode getLeft() {
        return this.left;
    }

    @Override
    public void setLeft(MyBinaryNode left) {
        this.left = left;
    }

    @Override
    public MyBinaryNode getRight() {
        return this.right;
    }

    @Override
    public void setRight(MyBinaryNode right) {
        this.right = right;
    }
}
