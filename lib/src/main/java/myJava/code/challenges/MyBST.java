package myJava.code.challenges;

public class MyBST {
    private MyBinaryNode root = null;

    public MyBST(MyBinaryNode root) {
        this.root = root;
    }

    public boolean contains(int value) {
        if (this.root.getValue() == value) {
            return true;
        }

        var tempNode = root;

        while (tempNode.getValue() != value) {
            if (tempNode.getLeft().getValue() > value) {
                tempNode = tempNode.getLeft();
                continue;
            }
            if (tempNode.getRight().getValue() < value) {
                tempNode = tempNode.getRight();
            }
        }

        return tempNode.getValue() == value;
    }
}
