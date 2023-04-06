package myJava.code.challenges;

import java.util.ArrayList;

public class LargestPossibleProductQueue {
  public int largestProduct(ArrayList<Integer> collection) {
    LPQueue<Integer> queue = new LPQueue<>();
    for (int currentValue : collection) {
      if (currentValue == 0) {
        continue;
      }
      if (queue.getSize() < 3) {
        queue.enqueue(currentValue);
      } else {
        for (int jdx = 0; jdx < 3; jdx++) {
          if (queue.peek() != null) {
            int dequeuedValue = queue.dequeue();
            if (currentValue > dequeuedValue) {
              queue.enqueue(currentValue);
              currentValue = dequeuedValue;
            } else {
              queue.enqueue(dequeuedValue);
            }
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
    }
  }
}
