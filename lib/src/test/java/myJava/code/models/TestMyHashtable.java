package myJava.code.models;

import org.junit.jupiter.api.Test;

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
        String secondKey = "slkjsadflkjasdflkjsadflkjsadflkjsadflkjasdflkjsadflkjsadflkjsadflkjsadflkjsdf";
        int secondValue = 22;

        assertTrue(sut.isEmpty());
        System.out.println("Size of backing array: " + sut.getArraySize());
        System.out.println("Count of buckets with data in them: " + sut.getKeyIndexCount());
        System.out.println("Count of items stored in hashtable: " + sut.getItemCount());
        assertEquals(1024, sut.getArraySize());
        assertEquals(0, sut.getKeyIndexCount());
        assertEquals(0, sut.getItemCount());

        sut.set(firstKey, firstValue);
        System.out.println("Added key: " + firstKey + "; value: " + firstValue);
        assertFalse(sut.isEmpty());
        System.out.println("Size of backing array: " + sut.getArraySize());
        System.out.println("Count of buckets with data in them: " + sut.getKeyIndexCount());
        System.out.println("Count of items stored in hashtable: " + sut.getItemCount());
        assertEquals(1024, sut.getArraySize());
        assertEquals(1, sut.getKeyIndexCount());
        assertEquals(1, sut.getItemCount());

        sut.set(secondKey, secondValue);
        System.out.println("Added key: " + secondKey + "; value: " + secondValue);
        assertFalse(sut.isEmpty());
        System.out.println("Size of backing array: " + sut.getArraySize());
        System.out.println("Count of buckets with data in them: " + sut.getKeyIndexCount());
        System.out.println("Count of items stored in hashtable: " + sut.getItemCount());
        assertEquals(1024, sut.getArraySize());
        assertEquals(2, sut.getKeyIndexCount());
        assertEquals(2, sut.getItemCount());

        sut.set(secondKey, firstValue);
        System.out.println("Added key: " + secondKey + "; value: " + firstValue);
        assertFalse(sut.isEmpty());
        System.out.println("Size of backing array: " + sut.getArraySize());
        System.out.println("Count of buckets with data in them: " + sut.getKeyIndexCount());
        System.out.println("Count of items stored in hashtable: " + sut.getItemCount());
        assertEquals(1024, sut.getArraySize());
        assertEquals(2, sut.getKeyIndexCount());
        assertEquals(3, sut.getItemCount());
    }

    @Test
    void test_SetFunctionWithUniqueKeyValuePairIncreasesBackingArraySize() {

    }

    @Test
    void test_BucketsHoldKeyAndValueAsTheirData() {

    }

    @Test
    void test_GetFindsExistingKeyValuePair() {

    }

    @Test
    void test_GetReturnsNullIfKeyNotStoredInHashtable() {

    }

    @Test
    void test_HasMethodReturnsBooleanTrueIfExistsFalseIfNotInHashtable() {

    }

    @Test
    void test_GetKeysReturnsAllUniqueKeysOrNullIfNone() {

    }
}
