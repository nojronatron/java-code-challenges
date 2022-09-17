package myJava.code.models;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TestMyHashtable {
    @Test
    void test_CanInstantiateMyHashtableEmpty() {
        MyHashtable sut = new MyHashtable();
        assertNotNull(sut);
    }

    @Test
    void test_PredictableHashingFunction() {
        MyHashtable sut = new MyHashtable();
        int firstHash = sut.hash("slkjsadflkjasdflkjsadflkjsadflkjsadflkjasdflkjsadflkjsadflkjsadflkjsadflkjsdf");
        int secondHash = sut.hash("slkjsadflkjasdflkjsadflkjsadflkjsadflkjasdflkjsadflkjsadflkjsadflkjsadflkjsdf");
        int thirdHash = sut.hash("S");
        int fourthHash = sut.hash("5");

        System.out.println("firstHash: " + firstHash);
        System.out.println("secondHash: " + secondHash);
        System.out.println("thirdHash: " + thirdHash);
        System.out.println("fourthHash: " + fourthHash);

        assertEquals(firstHash, secondHash);
        assertNotEquals(firstHash, thirdHash);
        assertNotEquals(firstHash, fourthHash);

        assertEquals(Math.abs(firstHash), firstHash);
        assertEquals(Math.abs(secondHash), secondHash);
        assertEquals(Math.abs(thirdHash), thirdHash);
        assertEquals(Math.abs(fourthHash), fourthHash);
    }

    @Test
    void test_CollisionCausesAddedValueToBeAddedToBucket() {
        MyHashtable sut = new MyHashtable();
        String firstKey = "slkjsadflkjasdflkjsadflkjsadflkjsadflkjasdflkjsadflkjsadflkjsadflkjsadflkjsdf";
        int firstValue = 11;
        String secondKey = "s";
        int secondValue = 22;

        assertTrue(sut.isEmpty());
        System.out.println("Size of backing array: " + sut.getArraySize());
        System.out.println("Count of keys (buckets with data in them): " + sut.getKeysCount());
        System.out.println("Count of items (total objects stored in hashtable): " + sut.getStoredItemsCount());
        assertEquals(1024, sut.getArraySize());
        assertEquals(0, sut.getKeysCount());
        assertEquals(0, sut.getStoredItemsCount());

        sut.set(firstKey, firstValue);
        System.out.println("Added key: " + firstKey + "; value: " + firstValue);
        assertFalse(sut.isEmpty());
        System.out.println("Size of backing array: " + sut.getArraySize());
        System.out.println("Count of keys (buckets with data in them): " + sut.getKeysCount());
        System.out.println("Count of items (total objects stored in hashtable): " + sut.getStoredItemsCount());
        assertEquals(1024, sut.getArraySize());
        assertEquals(1, sut.getKeysCount());
        assertEquals(1, sut.getStoredItemsCount());

        sut.set(secondKey, secondValue);
        System.out.println("Added key: " + secondKey + "; value: " + secondValue);
        assertFalse(sut.isEmpty());
        System.out.println("Size of backing array: " + sut.getArraySize());
        System.out.println("Count of keys (buckets with data in them): " + sut.getKeysCount());
        System.out.println("Count of items (total objects stored in hashtable): " + sut.getStoredItemsCount());
        assertEquals(1024, sut.getArraySize());
        assertEquals(2, sut.getKeysCount());
        assertEquals(2, sut.getStoredItemsCount());

        sut.set(firstKey, secondValue);
        System.out.println("Added key: " + firstKey + "; value: " + secondValue);
        assertFalse(sut.isEmpty());
        System.out.println("Size of backing array: " + sut.getArraySize());
        System.out.println("Count of keys (buckets with data in them): " + sut.getKeysCount());
        System.out.println("Count of items (total objects stored in hashtable): " + sut.getStoredItemsCount());

        assertEquals(1024, sut.getArraySize());
        assertEquals(2, sut.getKeysCount());
        assertEquals(3, sut.getStoredItemsCount());
    }

    @Test
    void test_GetNonexistentKeyThrowsNullPointerException() {
        MyHashtable sut = new MyHashtable();
        String firstKey = "slkjsadflkjasdflkjsadflkjsadflkjsadflkjasdflkjsadflkjsadflkjsadflkjsadflkjsdf";
        int firstValue = 11;
        String secondKey = "s";

        sut.set(firstKey, firstValue);
        assertThrows(NullPointerException.class, ()->{
            sut.get(secondKey);
        });
    }

    @Test
    void test_GetExistingKeyFindsExistingValue() {
        MyHashtable sut = new MyHashtable();
        String expectedKey = "slkjsadflkjasdflkjsadflkjsadflkjsadflkjasdflkjsadflkjsadflkjsadflkjsadflkjsdf";
        int expectedValue = 11;
        ArrayList<String> expectedKeys = new ArrayList<>();
        expectedKeys.add(expectedKey);
        int expectedKeyCount = expectedKeys.size();

        sut.set(expectedKey, expectedValue);
        ArrayList<String> actualKeysCollection = new ArrayList<>(sut.keys());
        int actualValueResult = sut.get(expectedKey);

        printKeys(expectedKeys, "expected keys in sut");
        printKeys(actualKeysCollection, "actual keys() output");

        assertEquals(expectedValue, actualValueResult);
        assertEquals(expectedKey, actualKeysCollection.get(0));
        assertEquals(expectedKeyCount, actualKeysCollection.size());
    }

    @Test
    void test_HasMethodReturnsBooleanTrueIfExistsFalseIfNotInHashtable() {
        MyHashtable sut = new MyHashtable();
        String firstKey = "slkjsadflkjasdflkjsadflkjsadflkjsadflkjasdflkjsadflkjsadflkjsadflkjsadflkjsdf";
        int firstValue = 11;
        String secondKey = "s";

        sut.set(firstKey, firstValue);
        assertTrue(sut.has(firstKey));
        assertFalse(sut.has(secondKey));
    }

    @Test
    void test_GetKeysReturnsAllUniqueKeys() {
        MyHashtable sut = new MyHashtable();
        String firstKey = "slkjsadflkjasdflkjsadflkjsadflkjsadflkjasdflkjsadflkjsadflkjsadflkjsadflkjsdf";
        int firstValue = 11;
        String secondKey = "s";
        int secondValue = 22;
        String thirdKey = "t";
        int thirdValue = 33;

        List<String> expectedKeys = new ArrayList<>();
        expectedKeys.add(firstKey);
        expectedKeys.add(secondKey);
        expectedKeys.add(thirdKey);

        sut.set(firstKey, firstValue);
        sut.set(secondKey, secondValue);
        sut.set(thirdKey, thirdValue);
        sut.set(firstKey, 0);
        sut.set(firstKey, 1);

        List<String> actualKeys = sut.keys();

        printKeys(expectedKeys, "expected unique keys");
        printKeys(actualKeys, "actual keys from sut.keys()");

        assertIterableEquals(expectedKeys, actualKeys);
    }

    @Test
    void test_GetKeysReturnsNullIfNone() {
        MyHashtable sut = new MyHashtable();
        List<String> expectedResult = new ArrayList<>();
        assertEquals(expectedResult, sut.keys());
    }

    static void printValues(List<Integer> collection, String comment) {
        System.out.println("v v v " + comment + " v v v");
        for(Integer item: collection) {
            System.out.println(item);
        }
        System.out.println("^ ^ ^ End Collection ^ ^ ^");
    }
    static void printKeys(List<String> collection, String comment) {
        System.out.println("v v v " + comment + " v v v");
        for(String item: collection) {
            System.out.println(item);
        }
        System.out.println("^ ^ ^ End Collection ^ ^ ^");
    }
}
