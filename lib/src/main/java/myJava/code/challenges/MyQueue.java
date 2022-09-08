package myJava.code.challenges;

public class MyQueue {
    private MyNode front;
    private MyNode rear;

    public MyQueue(){
        this.front = null;
        this.rear = null;
    }

    public MyQueue(MyNode node) {
        this.front = node;
        this.rear = node;
    }

    public boolean isEmpty() {
        return this.front == null;
    }

    public void enqueue(int value) {
        MyNode newNode = new MyNode(value);
        this.rear.setNext(newNode);
        this.rear = newNode;
    }

    public int dequeue() throws NullPointerException {
        MyNode temp = this.front;
        this.front = front.getNext();
        temp.setNext(null);
        return temp.getValue();
    }

    public int peek() throws NullPointerException {
        return this.front.getValue();
    }
}
