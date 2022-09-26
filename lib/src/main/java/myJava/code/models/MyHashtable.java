package myJava.code.models;

import org.apache.commons.math3.util.Pair;
import java.util.ArrayList;
import java.util.List;

public class MyHashtable {
    private final List<PairLinkedList> BACKING_ARRAY;
    private final List<String> KEYS_COLLECTION;
    private final int BACKING_ARRAY_SIZE = 1024;
    private int keyIndexCount;
    private int objectCount;

    public MyHashtable() {
        this.BACKING_ARRAY = new ArrayList<>(this.BACKING_ARRAY_SIZE);
        this.initializeBuckets();
        this.KEYS_COLLECTION = new ArrayList<>();
    }

    private void initializeBuckets() {
        for(int idx = 0; idx< BACKING_ARRAY_SIZE; idx++) {
            this.BACKING_ARRAY.add(new PairLinkedList());
        }

        this.objectCount = 0;
        this.keyIndexCount = 0;
    }

    /***
     * Accepts a Key Value Pair and adds then to the hashtable.
     * @param key String
     * @param value Integer
     */
    public void set(String key, int value) {
        int hashedIndex = this.hash(key);
        PairLinkedList bucket = this.BACKING_ARRAY.get(hashedIndex);
        Pair<String,Integer> entry = new Pair<>(key, value);
        bucket.add(entry);
        this.objectCount++; //  actual kpv count stored in this hashtable

        if (!this.KEYS_COLLECTION.contains(key)) {
            this.KEYS_COLLECTION.add(key);    //  only add unique keys to the key collection
            this.keyIndexCount++;
        }
    }

    /***
     * Accepts a Key, finds the hashed index, and returns the correct value.
     * @param key String
     * @return Integer
     * @throws NullPointerException If value is not found in this hashtable.
     */
    public Integer get(String key) throws NullPointerException {
        int hashedIndex = this.hash(key);
        PairLinkedList bucket = this.BACKING_ARRAY.get(hashedIndex);
        Pair<String,Integer> result = bucket.get(key);
        return result.getValue();
    }

    /***
     * Accepts a Key and returns true if key exists in this hashtable, otherwise returns false.
     * @param key String
     * @return boolean
     */
    public boolean has(String key) {
        try {
            return this.get(key) != null;
        } catch (NullPointerException nullPointerException) {
//            System.out.println("info: hashtable: " + nullPointerException.getMessage());
            return false;
        }
    }

    /***
     * Accepts a Key and returns the hashed Key as an Integer.
     * @param key String
     * @return int
     */
    public int hash(String key) {
        int hashedIndex = key.hashCode();
        hashedIndex *= 599;
        hashedIndex %= this.BACKING_ARRAY_SIZE;
        return Math.abs(hashedIndex);
    }

    /***
     * Returns true if there are not objects in this hashtable.
     * @return boolean
     */
    public boolean isEmpty() {
        return this.objectCount == 0;
    }

    /***
     * Returns the size of the array for debugging purposes.
     * @return int
     */
    public int getArraySize() {
        return this.BACKING_ARRAY.size();
    }

    /***
     * Returns the count of objects stored in this hashtable.
     * @return int
     */
    public int getStoredItemsCount() {
        return this.objectCount;
    }

    /***
     * Shortcut property returns the number of keys that keys() would return.
     * @return int
     */
    public int getKeysCount() {
        return this.keyIndexCount;
    }

    /***
     * Returns the list of Keys stored in this hashtable.
     * @return List of type String
     */
    public List<String> keys() {
        return this.KEYS_COLLECTION;
    }
}
