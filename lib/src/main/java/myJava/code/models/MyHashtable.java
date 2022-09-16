package myJava.code.models;

import org.apache.commons.math3.util.Pair;

import java.util.ArrayList;
import java.util.LinkedList;

public class MyHashtable {
    private ArrayList<LinkedList<Pair<String,Integer>>> backingArray;
    private boolean isEmpty; // might not be necessary
    private final int backingArrayCapacity = 1024;
    public MyHashtable() {
        this.backingArray = new ArrayList<>(this.backingArrayCapacity);
        this.initializeBuckets();
    }

    private void initializeBuckets() {
        for(int idx = 0; idx< backingArrayCapacity; idx++) {
            this.backingArray.set(idx, new LinkedList<>());
        }
    }

    public void set(String key, int value) {
        var hashedIndex = this.hash(key);
        Pair<String,Integer> entry = new Pair<>(key, value);
        this.backingArray.set(hashedIndex, entry);
    }

    public Integer get(String key) {
        int hashedIndex = this.hash(key);
        LinkedList<Pair<String,Integer>> result = this.backingArray.get(hashedIndex);
        result.
        var head = result.getFirst(); // aka linkedlist.head
        while (head != null) {
            if (head.getKey().equals(key)) {
                return head.getValue();
            }
            head = head.getFirst();
        }
    }
}
