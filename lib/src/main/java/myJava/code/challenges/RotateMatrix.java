package myJava.code.challenges;

import myJava.code.models.MyQueue;

public class RotateMatrix {
    public int[][] rotate(int[][] inputArr) {
        if (inputArr.length < 3) {
            return new int[][]{{}};
        }

        int[][] result = new int[inputArr.length][inputArr.length]; // todo: properly account for 2nd dimension size
        MyQueue<Integer> queue = new MyQueue<>();

        for (int outerIdx=0; outerIdx<3; outerIdx++) {
            for (int innerIdx=0; innerIdx<3; innerIdx++) {
                queue.enqueue(inputArr[outerIdx][innerIdx]);
            }
        }

        for (int col=2; col>=0; col--) {
            for (int row=0; row<3; row++) {
                result[row][col] = queue.dequeue();
            }
        }

        return result;
    }
}
