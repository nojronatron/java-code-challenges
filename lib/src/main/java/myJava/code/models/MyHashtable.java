package myJava.code.models;

import org.apache.commons.math3.util.Pair;
import java.util.ArrayList;
import java.util.List;

public class MyHashtable {
    private List<PairLinkedList> backingArray;
    private int bucketCount;
    private final int backingArrayCapacity = 1024;
    private List<String> keyCollection;

    public MyHashtable() {
        this.backingArray = new ArrayList<>(this.backingArrayCapacity);
        this.initializeBuckets();
        this.keyCollection = new ArrayList<>();
    }

    private void initializeBuckets() {
        for(int idx=0; idx<backingArrayCapacity; idx++) {
            //this.backingArray.set(idx, new PairLinkedList());
            this.backingArray.add(new PairLinkedList());
        }
        this.bucketCount = 0;
    }

    public void set(String key, int value) {
        var hashedIndex = this.hash(key);
        PairLinkedList bucket = this.backingArray.get(hashedIndex);
        Pair<String,Integer> entry = new Pair<>(key, value);
        bucket.add(entry);
        this.keyCollection.add(key);
        this.bucketCount++;
    }

    public Integer get(String key) {
        int hashedIndex = this.hash(key);
        PairLinkedList bucket = this.backingArray.get(hashedIndex);
        Pair<String,Integer> result = bucket.get(key);
        return result.getValue();
    }

    public boolean has(String key) {
        int hashedIndex = this.hash(key);
        if (this.backingArray.get(hashedIndex) != null) {
            return true;
        }
        return false;
    }

    public int hash(String key) {
        int hashedIndex = key.hashCode();
        hashedIndex *= 599;
        hashedIndex %= this.backingArrayCapacity;
        return hashedIndex;
    }

    public boolean isEmpty() {
        return this.bucketCount == 0;
    }

    public List<String> keys() {
        return this.keyCollection;
    }
}
