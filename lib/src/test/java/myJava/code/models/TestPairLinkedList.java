package myJava.code.models;

import org.apache.commons.math3.util.Pair;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestPairLinkedList {
    @Test
    void test_InstantiatePairLinkedList() {
        PairLinkedList sut = new PairLinkedList();
        assertNotNull(sut);
    }

    @Test
    void test_PairLinkedListIncludes() {
        int expectedItemToFind = 13;
        Pair<String,Integer> expectedAlpha = new Pair<>("alpha", 11);
        Pair<String,Integer> expectedBravo = new Pair<>("bravo", 12);
        Pair<String,Integer> expectedCharlie = new Pair<>("charlie", 13);
        Pair<String,Integer> expectedDelta = new Pair<>("delta", 14);
        Pair<String,Integer> expectedEcho = new Pair<>("echo", 15);

        PairLinkedList sut = new PairLinkedList();
        assertFalse(sut.includes(expectedItemToFind));

        sut.add(expectedAlpha);
        sut.add(expectedBravo);
        sut.add(expectedCharlie);
        sut.add(expectedDelta);
        sut.add(expectedEcho);

        assertTrue(sut.includes(expectedItemToFind));
    }

    @Test
    void test_PairLinkedListAdd() {
        int expectedCount = 0;
        Pair<String,Integer> expectedAlpha = new Pair<>("alpha", 11);
        Pair<String,Integer> expectedBravo = new Pair<>("bravo", 12);

        PairLinkedList sut = new PairLinkedList();
        assertEquals(expectedCount, sut.getCount());

        sut.add(expectedAlpha);
        expectedCount = 1;
        assertNotNull(sut);
        assertEquals(expectedCount, sut.getCount());

        sut.add(expectedBravo);
        expectedCount = 2;
        assertNotNull(sut);
        assertEquals(expectedCount, sut.getCount());
    }

    @Test
    void test_PairLinkedListAddBefore() {
        int expectedCount = 0;
        Pair<String,Integer> expectedAlpha = new Pair<>("alpha", 11);
        Pair<String,Integer> expectedBravo = new Pair<>("bravo", 12);
        Pair<String,Integer> expectedCharlie = new Pair<>("charlie", 13);
        Pair<String,Integer> expectedDelta = new Pair<>("delta", 14);
        Pair<String,Integer> expectedEcho = new Pair<>("echo", 15);

        PairLinkedList sut = new PairLinkedList();
        sut.add(expectedAlpha);                                     //  alpha -> Null
        sut.add(expectedBravo);                                     //  bravo -> alpha -> Null
        sut.add(expectedCharlie);                                   //  charlie -> bravo -> alpha -> Null
        assertTrue(sut.addBefore(expectedDelta, expectedBravo));    //  charlie -> delta -> bravo -> alpha -> Null
        assertTrue(sut.addBefore(expectedEcho, expectedAlpha));     //  charlie -> delta -> bravo -> echo -> echo -> Null

        assertNotNull(sut);
        expectedCount = 5;
        assertEquals(expectedCount, sut.getCount());
    }

    @Test
    void test_PairLinkedListGet() {
        String expectedKey = "bravo";
        int expectedValue = 12;
        Pair<String,Integer> expectedToFind = new Pair<>(expectedKey, expectedValue);

        Pair<String,Integer> expectedAlpha = new Pair<>("alpha", 11);
        Pair<String,Integer> expectedBravo = new Pair<>(expectedKey, expectedValue);
        Pair<String,Integer> expectedCharlie = new Pair<>("charlie", 13);
        Pair<String,Integer> expectedDelta = new Pair<>("delta", 14);
        Pair<String,Integer> expectedEcho = new Pair<>("echo", 15);

        PairLinkedList sut = new PairLinkedList();
        sut.add(expectedAlpha);
        sut.add(expectedBravo);
        sut.add(expectedCharlie);
        sut.add(expectedDelta);
        sut.add(expectedEcho);

        Pair<String,Integer> actualResult = sut.get(expectedKey);
        assertEquals(actualResult.getKey(), expectedKey);
        assertEquals(actualResult.getValue(), expectedValue);
        assertEquals(actualResult, expectedToFind);
    }
}
