package myJava.code.challenges;

import myJava.code.models.MyKaryNode;
import myJava.code.models.MyQueue;

public class SprinklerWaterUsage {
    public int waterUsage(MyKaryNode<Integer> tree) {
        MyQueue<MyKaryNode<Integer>> breadthQueue = new MyQueue<>();
        breadthQueue.enqueue(tree); // failed to test for null so exception is possible
        int sumValue = 0;
        while (!breadthQueue.isEmpty()) {
            MyKaryNode<Integer> tempNode = breadthQueue.dequeue();
            sumValue += tempNode.getValue();
            if (tempNode.hasChildren()) {
                for(MyKaryNode<Integer> child: tempNode.getChildren()) {
                    breadthQueue.enqueue(child); // failed to test for null child so exception is possible
                }
            }
        }
        return sumValue;
    }
}
