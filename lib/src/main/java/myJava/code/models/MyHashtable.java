package myJava.code.models;

import org.apache.commons.math3.util.Pair;

import java.util.ArrayList;
import java.util.LinkedList;

public class MyHashtable {
    private ArrayList<PairLinkedList> backingArray;
    private boolean isEmpty; // might not be necessary
    private final int backingArrayCapacity = 1024;
    public MyHashtable() {
        this.backingArray = new ArrayList<>(this.backingArrayCapacity);
        this.initializeBuckets();
    }

    private void initializeBuckets() {
        for(int idx=0; idx<backingArrayCapacity; idx++) {
            this.backingArray.set(idx, new PairLinkedList());
        }
    }

    public void set(String key, int value) {
        var hashedIndex = this.hash(key);
        PairLinkedList bucket = this.backingArray.get(hashedIndex);
        Pair<String,Integer> entry = new Pair<>(key, value);
        bucket.add(entry);
    }

    public Integer get(String key) {
        int hashedIndex = this.hash(key);
        PairLinkedList bucket = this.backingArray.get(hashedIndex);
        Pair<String,Integer> result = bucket.get(key);
        return result.getValue();
    }
}
