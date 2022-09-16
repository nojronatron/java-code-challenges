package myJava.code.challenges;

public class MyLinkedListNode {
    private int value;
    private MyLinkedListNode next;
    public MyLinkedListNode(int data) {
        this.value = data;
    }

    public int getValue() {
        return this.value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public MyLinkedListNode getNext() {
        return this.next;
    }

    public void setNext(MyLinkedListNode next) {
        this.next = next;
    }
}
