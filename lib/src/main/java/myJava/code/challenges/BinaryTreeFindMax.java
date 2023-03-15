package myJava.code.challenges;

import myJava.code.models.GenericBinaryTree.MyBinaryNode;

import java.util.concurrent.LinkedTransferQueue;

public class BinaryTreeFindMax {
    public static int findMax(MyBinaryNode<Integer> inputTree) {
        if (inputTree.isLeaf()) {
            return inputTree.getValue();
        }
        int maxNumber = Integer.MIN_VALUE;
        LinkedTransferQueue<MyBinaryNode<Integer>> breadthQueue = new LinkedTransferQueue<>();
        breadthQueue.add(inputTree);
        while(!breadthQueue.isEmpty()){
            MyBinaryNode<Integer> tempNode = breadthQueue.poll();
            if (tempNode.getValue() > maxNumber){
                maxNumber = tempNode.getValue();
            }
            if (tempNode.hasLeftChild()){
                breadthQueue.add(tempNode.getLeftChild());
            }
            if (tempNode.hasRightChild()){
                breadthQueue.add(tempNode.getRightChild());
            }
        }
        return maxNumber;
    }
}
