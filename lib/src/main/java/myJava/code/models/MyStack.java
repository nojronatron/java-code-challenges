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
        if (this.isEmpty()) {
            this.top = newNode;
            this.bottom = newNode;
        } else {
            if (this.bottom == this.top) {
                this.top = newNode;
                this.top.next = bottom;
            }
        }
    }

    public Object pop() {
        if (this.isEmpty()) {
            return new NullPointerException("There are no items in this Stack.");
        } else {
            StackNode tempNode = this.top;
            this.top = top.getNext();
            tempNode.setNext(null);
            return tempNode.getValue();
        }
    }

    public Object peek() {
        if (this.isEmpty()) {
            throw new NullPointerException("There are no items in this Stack.");
        } else {
            return this.top.getValue();
        }
    }

    public boolean isEmpty() {
        if (this.top == this.bottom) {
            if (this.top == null) {
                return true;
            }
        }
        return false;
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
