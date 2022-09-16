package myJava.code.models;

import myJava.code.models.MyLinkedListNode;

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
        this.count++;
    }

    public int getCount() {
        return this.count;
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
        this.count++;
    }

    public boolean addBefore(int newValue, int valueToAddBefore) {
        if (this.head == null) {
            return false;
        }
        MyLinkedListNode newNode = new MyLinkedListNode(newValue);
        if (head.getValue() == valueToAddBefore) {
            newNode.setNext(this.head);
            head = newNode;
            this.count++;
            return true;
        }
        MyLinkedListNode current = this.head;
        while (current != null) {
            if (current.getNext().getValue() == valueToAddBefore) {
                newNode.setNext(current.getNext());
                current.setNext(newNode);
                this.count++;
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
