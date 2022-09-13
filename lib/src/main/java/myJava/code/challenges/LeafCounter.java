package myJava.code.challenges;

public class LeafCounter extends MyBinaryTree {
    public boolean fileCountSame(MyBinaryTree treeLeft, MyBinaryTree treeRight) {
        int fileSum = 0;
        if (treeLeft.getRoot() == null && treeRight.getRoot() == null) {
            return true; // null == null so same count of leaves
        }

        int fileSumLeft = processFunction(treeLeft);
        int fileSumRight = processFunction(treeRight);
        return fileSumLeft == fileSumRight;
    }

    private int processFunction(MyBinaryTree tree) {
        MyQueue<MyBinaryNode> breadthQueue = new MyQueue<>();
        breadthQueue.enqueue(tree.getRoot());
        int fileSum = 0;

        while (!breadthQueue.isEmpty()) {
            var tempNode = breadthQueue.dequeue();

            // if node is a leaf node then increment sum
            if (tempNode.getLeft() == null && tempNode.getRight() == null) {
                fileSum++;
            }

            if (tempNode.getLeft() != null) {
                breadthQueue.enqueue(tempNode.getLeft());
            }

            if (tempNode.getRight() != null) {
                breadthQueue.enqueue(tempNode.getRight());
            }
        }

        return fileSum;
    }
}
