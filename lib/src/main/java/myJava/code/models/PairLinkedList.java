package myJava.code.models;

import org.apache.commons.math3.util.Pair;

public class PairLinkedList {
    private PairNode head = null;
    private int count = 0;

    public boolean includes(Integer value) {
        PairNode current = this.head;
        while (current != null) {
            if (current.getValue() == value) {
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    public void add(Pair<String,Integer> newPair) {
        PairNode newNode = new PairNode(newPair.getKey(), newPair.getValue());
        newNode.setNext(this.head);
        this.head = newNode;
        this.count++;
    }

    public boolean addBefore(Pair<String,Integer> newItem, Pair<String,Integer> valueToAddBefore) {
        if (this.head == null) {
            return false;
        }
        PairNode newNode = new PairNode(newItem.getKey(), newItem.getValue());
        if (this.head.getKey().equals(valueToAddBefore.getKey()) &&
                this.head.getValue() == valueToAddBefore.getValue()) {
            newNode.setNext(this.head);
            this.head = newNode;
            this.count ++;
            return true;
        }
        PairNode current = this.head;
        while (current != null) {
            if (current.next.getKey().equals(valueToAddBefore.getKey()) &&
                    current.next.getValue() == valueToAddBefore.getValue()) {
                newNode.setNext(current.getNext());
                current.setNext(newNode);
                this.count++;
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    public Pair<String,Integer> get(String key) {
        if (this.head == null) {
            return null;
        }
        PairNode current = this.head;
        while (current != null) {
            if (current.getKey().equals(key)) {
                Pair<String,Integer> result = new Pair<>(current.getKey(), current.getValue());
                return result;
            }
            current = current.getNext();
        }
        return null;
    }

    public int getCount() {
        return this.count;
    }

    static class PairNode {
        private String key;
        private Integer value;
        private PairNode next = null;
        public PairNode(String key, Integer value) {
            this.key = key;
            this.value = value;
        }
        public String getKey() {
            return this.key;
        }
        public void setKey(String newKey) {
            this.key = newKey;
        }
        public int getValue() {
            return this.value;
        }
        public void setValue(int newValue) {
            this.value = newValue;
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
        public String print() {
            //noinspection StringBufferReplaceableByString
            StringBuilder result = new StringBuilder();
            result.append("[ ").append("Key: ").append(this.key);
            result.append(" Value: ").append(this.value).append(" ]");
            return result.toString();
        }
    }
}
