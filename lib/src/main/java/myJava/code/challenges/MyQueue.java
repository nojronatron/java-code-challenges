package myJava.code.challenges;

public class MyQueue<T> {
    private MyNode<T> front = null;
    private MyNode<T> rear = null;

    public boolean isEmpty() {
        return this.front == null;
    }

    public void enqueue(T value) {
        MyNode<T> newNode = new MyNode<>(value);
        // queue has 2 or more nodes
        if (this.rear != null && this.rear != this.front) {
            this.rear.setNext(newNode);
            this.rear = newNode;
        }
        // queue has 1 node
        if (this.rear != null && this.rear == this.front) {
            this.rear = newNode;
            this.front.setNext(this.rear);
        }
        // queue is empty so rear is null
        if (this.rear == null) {
            this.front = newNode;
            this.rear = this.front;
        }
    }

    public T dequeue() throws NullPointerException {
        var temp = this.front;
        this.front = front.getNext();
        temp.setNext(null);
        return temp.getValue();
    }

    public T peek() throws NullPointerException {
        return this.front.getValue();
    }
}
