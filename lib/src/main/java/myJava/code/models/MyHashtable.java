package myJava.code.models;

import org.apache.commons.math3.util.Pair;
import java.util.ArrayList;
import java.util.List;

public class MyHashtable {
    private List<PairLinkedList> backingArray;
    private int objectCount;
    private int bucketsWithDataCount;
    private final int backingArrayCapacity = 1024;
    private List<String> keyCollection;

    public MyHashtable() {
        this.backingArray = new ArrayList<>(this.backingArrayCapacity);
        this.initializeBuckets();
        this.keyCollection = new ArrayList<>();
    }

    private void initializeBuckets() {
        for(int idx=0; idx<backingArrayCapacity; idx++) {
            this.backingArray.add(new PairLinkedList());
        }
        this.objectCount = 0;
        this.bucketsWithDataCount = 0;
    }

    private void calculateBucketsWithDataCount(int hashedIndex, int value) {
        var bucket = this.backingArray.get(hashedIndex);
        if (bucket.getCount() == 1) {
            this.bucketsWithDataCount++;
        }
        // TODO: If a delete or remove method is added, this function needs to be updated
    }

    public void set(String key, int value) {
        var hashedIndex = this.hash(key);
        PairLinkedList bucket = this.backingArray.get(hashedIndex);
        Pair<String,Integer> entry = new Pair<>(key, value);
        bucket.add(entry);
        this.keyCollection.add(key);
        this.objectCount++;
        this.calculateBucketsWithDataCount(hashedIndex, value);
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
        return Math.abs(hashedIndex);
    }

    public boolean isEmpty() {
        return this.objectCount == 0;
    }

    public int getArraySize() {
        return this.backingArray.size();
    }

    public int getItemCount() {
        return this.keyCollection.size();
    }

    public int getKeyIndexCount() {
        return this.bucketsWithDataCount;
    }

    public List<String> keys() {
        return this.keyCollection;
    }
}
