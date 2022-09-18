package myJava.code.models;

import org.apache.commons.math3.util.Pair;

public class PairLinkedList {
    private PairNode head = null;
    private int count = 0;

    /***
     * Searches the Linked List Nodes and returns True if a node with matching value is found, otherwise returns false.
     * @param value Integer
     * @return boolean
     */
    public boolean includes(int value) {
        PairNode current = this.head;
        while (current != null) {
            if (current.getValue() == value) {
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    /***
     * Creates a new Node and adds it to the beginning of the linked list.
     * @param newPair String, Integer
     */
    public void add(Pair<String,Integer> newPair) {
        PairNode newNode = new PairNode(newPair.getKey(), newPair.getValue());
        newNode.setNext(this.head);
        this.head = newNode;
        this.count++;
    }

    /***
     * Inserts a new node in the position before the node with the second given parameters.
     * Returns True if successful, False if valueToAddBefore was not found.
     * @param newItem String,Integer
     * @param valueToAddBefore String,Integer
     * @return boolean
     */
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

    /***
     * Returns the Key-Value pair of the item in the list matching the given Key.
     * Returns Null if Key is not in this list.
     * @param key String
     * @return Pair String,Integer
     */
    public Pair<String,Integer> get(String key) {
        if (this.head == null) {
            return null;
        }
        PairNode current = this.head;
        while (current != null) {
            if (current.getKey().equals(key)) {
                //noinspection UnnecessaryLocalVariable
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
        private int value;
        private PairNode next = null;
        public PairNode(String key, int value) {
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
