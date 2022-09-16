package myJava.code.challenges;

import java.util.ArrayList;
import java.util.LinkedList;

public class MyHashtable<T>{
    private ArrayList<LinkedList<T>> backingArray;
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
}
