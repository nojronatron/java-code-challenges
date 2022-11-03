package myJava.code.challenges;

import myJava.code.models.MyQueue;

public class RotateMatrix {
    public int[][] rotate(int[][] inputArr) {
        if (inputArr.length < 3) {
            return new int[][]{{}};
        }

        int[][] result = new int[inputArr[0].length][inputArr.length];
        MyQueue<Integer> queue = new MyQueue<>();

        int outerLength = inputArr.length;
        int innerLength = inputArr[0].length;

        for (int outerIdx=0; outerIdx < outerLength; outerIdx++) {
            for (int innerIdx=0; innerIdx < innerLength; innerIdx++) {
                queue.enqueue(inputArr[outerIdx][innerIdx]);
            }
        }

        outerLength = result[0].length;

        for (int col=outerLength-1; col >= 0; col--) {
            for (int row=0; row < innerLength; row++) {
                result[row][col] = queue.dequeue();
            }
        }

        return result;
    }
}
