package myJava.code.models;

public class MyStack {
    private StackNode top;
    private StackNode bottom;
    public MyStack() {
        this.top = null;
        this.bottom = null;
    }

    public void push(Object data) {
        StackNode newNode = new StackNode(data);

        // more than one item in this Stack
        if (this.bottom != this.top) {
            newNode.next = this.top;
            this.top = newNode;
        }

        // one item in this Stack
        if (this.bottom == this.top && !this.isEmpty()) {
            this.top = newNode;
            this.top.next = this.bottom;
        }

        // this Stack is empty
        if (this.isEmpty()) {
            this.top = newNode;
            this.bottom = newNode;
        }
    }

    public Object pop() throws NullPointerException {
        StackNode tempNode = this.top;
        if (this.top == this.bottom) {
            this.bottom = null;
            this.top = null;
        } else if (this.top.next == this.bottom) {
            this.top.next = null;
            this.top = bottom;
        } else {
            this.top = top.next;
        }
        return tempNode.value;
    }

    public Object peek() throws NullPointerException {
        return this.top.value;
    }

    public boolean isEmpty() {
        return this.top == this.bottom && this.top == null;
    }

    class StackNode {
        // todo: convert to generic to avoid boxing, unboxing operations
        private Object value;
        private StackNode next;
        public StackNode(Object data) {
            this.value = data;
        }

        public Object getValue() {
            return value;
        }

        public void setValue(Object value) {
            this.value = value;
        }

        public StackNode getNext() {
            return next;
        }

        public void setNext(StackNode next) {
            this.next = next;
        }
    }
}
