package myJava.code.models;

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
            return;
        }
        // queue has 1 node
        if (this.rear != null) {
            this.rear = newNode;
            this.front.setNext(this.rear);
            return;
        }
        // queue is empty so rear is null
            this.front = newNode;
            this.rear = this.front;
    }

    public T dequeue() throws NullPointerException {
        if (this.isEmpty()) {
            throw new NullPointerException("This Queue is empty.");
        }

        var temp = this.front;

        // there is one node in the queue
        if (this.rear != null && this.rear == this.front) {
            var returnVal = temp.getValue();
            this.rear = null;
            this.front = null;
            return returnVal;
        }

        // there are two nodes in the queue
        if (this.rear != null && this.rear == this.front.getNext()) {
            this.front = this.rear;
            temp.setNext(null);
            return temp.getValue();
        }

        // there are more than two nodes in the queue
            this.front = front.getNext();
            temp.setNext(null);
            return temp.getValue();
    }

    public T peek() throws NullPointerException {
        return this.front.getValue();
    }
}
