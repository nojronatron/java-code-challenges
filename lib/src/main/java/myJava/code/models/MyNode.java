package myJava.code.models;

public class MyNode<T> {
    private T value;
    private MyNode<T> next;

    public MyNode(T value) {
        this.value = value;
        this.next = null;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public MyNode<T> getNext() {
        return this.next;
    }

    public void setNext(MyNode<T> next) {
        this.next = next;
    }
}
