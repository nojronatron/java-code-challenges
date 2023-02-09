package myJava.code.challenges;

import java.util.ArrayList;

public class LargestPossibleProductQueue {
    public int largestProduct(ArrayList<Integer> collection) {
        LPQueue<Integer> queue = new LPQueue<>();
        for (int idx = 0; idx < collection.size(); idx++) {
            int currentValue = collection.get(idx);
            if (currentValue != 0) {
                if (queue.isEmpty()) {
                    queue.enqueue(currentValue);
                } else {
                    if (queue.getSize() >= 3) {
                        for (int jdx = 0; jdx < 3; jdx++) {
                            int dequeuedValue = queue.dequeue();
                            if (currentValue > dequeuedValue) {
                                queue.enqueue(currentValue);
                                currentValue = dequeuedValue;
                            } else {
                                queue.enqueue(dequeuedValue);
                            }
                        }
                    } else {
                        queue.enqueue(currentValue);
                    }
                }
            }
        }
        if (queue.isEmpty()) {
            return 0;
        } else {
            int result = queue.dequeue();
            while (!queue.isEmpty()) {
                result *= queue.dequeue();
            }
            return result;
        }
    }

    private static class LPQueue<T> {
        private QueueNode<T> front;
        private QueueNode<T> rear;
        private int count;

        LPQueue() {
            this.front = null;
            this.rear = null;
            this.count = 0;
        }

        private boolean isEmpty() {
            return this.front == this.rear && this.front == null;
        }

        private void enqueue(T value) throws NullPointerException {
            QueueNode<T> newNode = new QueueNode<>(value);
            if (this.isEmpty()) {
                this.front = newNode;
                this.rear = this.front;
                this.count++;
                return;
            }
            if (this.front == this.rear) {
                this.front.next = newNode;
                this.rear = newNode;
                this.count++;
                return;
            }
            this.rear.next = newNode;
            this.rear = newNode;
            this.count++;
        }

        // note: could this still throw NullPointerException?
        private T dequeue() {
            T tempValue;
            if (this.front == this.rear) {
                tempValue = this.front.value;
                this.front = null;
                this.rear = null;
                this.count = 0;
            } else {
                QueueNode<T> tempNode = this.front;
                this.front = tempNode.next;
                tempNode.next = null;
                tempValue = tempNode.value;
                tempNode.value = null;
                this.count--;
            }
            return tempValue;
        }

        private T peek() {
            if (this.count > 0) {
                return this.front.value;
            } else {
                return null;
            }
        }

        private int getSize() {
            return this.count;
        }

        private static class QueueNode<T> {
            private T value;
            private QueueNode<T> next;

            QueueNode(T data) {
                this.value = data;
                this.next = null;
            }
//            private void addNext(QueueNode<T> next) {
//                this.next = next;
//            }
//            private T getData() throws NullPointerException {
//                return this.value;
//            }
//            private void setData(T data) {
//                this.value = data;
//            }
        }
    }
}
