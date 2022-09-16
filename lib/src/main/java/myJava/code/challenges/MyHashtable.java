package myJava.code.challenges;

import java.util.ArrayList;
import java.util.List;

public class MyHashtable {
    private List<MyLinkedList> backingArray;
    private boolean isEmpty; // might not be necessary
    private int initialCapacity = 1024;
    public MyHashtable() {
        this.backingArray = new ArrayList<MyLinkedList>(initialCapacity);
    }

    private void initializeBuckets() {
        for(int idx=0; idx<initialCapacity; idx++) {
            this.backingArray.set(idx, new MyLinkedList());

        }
    }
}
