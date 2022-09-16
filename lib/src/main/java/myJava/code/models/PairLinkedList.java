package myJava.code.models;

import org.apache.commons.math3.util.Pair;

public class PairLinkedList {
    private PairNode head = null;

    public boolean includes(Integer value) {
        var current = this.head;
        while (current != null) {
            if (current.getValue() == value) {
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    public void add(Pair<String,Integer> value) {
        PairNode newNode = new PairNode();
        newNode.setValue(value);
        newNode.setNext(this.head);
        this.head = newNode;
    }

    public boolean addBefore(String key, Pair<String,Integer> newItem) {
        PairNode current = this.head;
        if (current == null) {
            return false;
        }
        while (current != null) {

        }
        return false;
    }
    class PairNode {
        private Pair<String,Integer> value;
        private PairNode next = null;
        public int getValue() {
            return this.value.getValue();
        }
        public void setValue(Pair<String,Integer> item) {
            this.value = item;
        }
        public PairNode getNext() {
            return this.next;
        }
        public boolean setNext(PairNode node) {
            if (node != null) {
                this.next = node;
                return true;
            }
            return false;
        }
    }
}
