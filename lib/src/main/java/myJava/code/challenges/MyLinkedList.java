package myJava.code.challenges;

public class MyLinkedList {
    private MyLinkedListNode head;
    private int count;
    public MyLinkedList() {
        this.count = 0;
    }

    public MyLinkedListNode getHead() {
        return this.head;
    }

    public void setHead(MyLinkedListNode head) {
        this.head = head;
    }

    public boolean includes(int value) {
        MyLinkedListNode current = this.head;
        while(current != null) {
            if (current.getValue() == value) {
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    public void add(int value) {
        MyLinkedListNode newNode = new MyLinkedListNode(value);
        newNode.setValue(value);
        newNode.setNext(this.head);
        this.head = newNode;
    }

    public boolean addBefore(int newValue, int valueToAddBefore) {
        if (this.head == null) {
            return false;
        }
        MyLinkedListNode current = this.head;
        while (current != null) {
            if (current.getNext().getValue() == valueToAddBefore) {
                MyLinkedListNode newNode = new MyLinkedListNode(newValue);
                newNode.setNext(current.getNext());
                current.setNext(newNode);
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    public String print() {
        MyLinkedListNode current = this.head;
        StringBuilder result = new StringBuilder();
        while (current != null) {
            result.append("[").append(current.getValue()).append("]->");
            current = current.getNext();
        }
        result.append("NULL");
        return result.toString();
    }
}
