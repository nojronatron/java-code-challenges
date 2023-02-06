package myJava.code.challenges;

import java.util.ArrayList;

public class LargestPossibleProductStack {
    public int LargestProduct(ArrayList<Integer> collection) {
        if (collection.size() < 1) {
            return 0;
        }
        LPStack<Integer> myStack = new LPStack<>();
        for (int currentItem : collection) {
            if (currentItem == 0) {
                continue;
            }
            if (myStack.isEmpty()) {
                myStack.push(currentItem);
                continue;
            }
            int tempNumber = myStack.peek();
            if (currentItem > tempNumber) {
                myStack.push(currentItem);
            } else {
                myStack.pop();
                myStack.push(currentItem);
                myStack.push(tempNumber);
            }
        }
        if (myStack.isEmpty()) {
            return 0;
        }
        int idxMax = Math.min(collection.size(), 3);
        int accumulator = 1;
        for (int idx = 0; idx < idxMax; idx++) {
            if (!myStack.isEmpty()) {
                accumulator *= myStack.pop();
            }
        }
        return accumulator;
    }

    private static class LPStack<T> {
        private StackNode<T> top;
        private StackNode<T> bottom;

        public LPStack() {
            this.top = null;
            this.bottom = null;
        }

        public void push(T data) {
            StackNode<T> newNode = new StackNode<>(data);
            if (this.bottom != this.top) {
                newNode.next = this.top;
                this.top = newNode;
            }
            if (this.bottom == this.top && !this.isEmpty()) {
                this.top = newNode;
                this.top.next = this.bottom;
            }
            if (this.isEmpty()) {
                this.top = newNode;
                this.bottom = newNode;
            }
        }

        public T pop() throws NullPointerException {
            StackNode<T> tempNode = this.top;
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

        public T peek() throws NullPointerException {
            return this.top.value;
        }

        public boolean isEmpty() {
            return this.top == this.bottom && this.top == null;
        }

        private static class StackNode<T> {
            private T value;
            private StackNode<T> next;

            StackNode(T data) {
                this.value = data;
            }

            public T getValue() {
                return this.value;
            }

            public void setValue(T value) {
                this.value = value;
            }

            public StackNode<T> getNext() {
                return next;
            }

            public void setNext(StackNode<T> next) {
                this.next = next;
            }
        }
    }
}
