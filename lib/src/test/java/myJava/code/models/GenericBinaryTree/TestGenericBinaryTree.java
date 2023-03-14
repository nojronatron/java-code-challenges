package myJava.code.models.GenericBinaryTree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestGenericBinaryTree {
    @Test
    void testBinaryTree_CanInstantiateTree() {
        int rootValue = 11;
        MyBinaryTree<Integer> sut = new MyBinaryTree<>(rootValue);
        assertNotNull(sut);
    }

    @Test
    void testBinaryTree_AddNodesToTree() {
        int rootValue = 1;
        int bravo = 2;
        int charlie = 3;
        int delta = 4;
        int echo = 5;
        int foxtrot = 6;
        int golf = 7;

        MyBinaryTree<Integer> sut = new MyBinaryTree<>(rootValue);
        int expectedCount = rootValue;
        int actualCount = sut.getCount();
        assertEquals(expectedCount, actualCount);

        expectedCount++;
        boolean actualResult = sut.addNode(bravo);
        actualCount = sut.getCount();
        assertTrue(actualResult);
        assertEquals(expectedCount, actualCount);

        expectedCount++;
        actualResult = sut.addNode(charlie);
        actualCount = sut.getCount();
        assertTrue(actualResult);
        assertEquals(expectedCount, actualCount);

        expectedCount++;
        actualResult = sut.addNode(delta);
        actualCount = sut.getCount();
        assertTrue(actualResult);
        assertEquals(expectedCount, actualCount);

        expectedCount++;
        actualResult = sut.addNode(echo);
        actualCount = sut.getCount();
        assertTrue(actualResult);
        assertEquals(expectedCount, actualCount);

        expectedCount++;
        actualResult = sut.addNode(foxtrot);
        actualCount = sut.getCount();
        assertTrue(actualResult);
        assertEquals(expectedCount, actualCount);

        expectedCount++;
        actualResult = sut.addNode(golf);
        actualCount = sut.getCount();
        assertTrue(actualResult);
        assertEquals(expectedCount, actualCount);
    }

    @Test
    void testBinaryTree_contains() {
        int rootValue = 1;
        int bravo = 2;
        int charlie = 3;
        int delta = 4;
        int echo = 5;
        int foxtrot = 6;
        int golf = 7;

        MyBinaryTree<Integer> sut = new MyBinaryTree<>(rootValue);
        sut.addNode(bravo);
        sut.addNode(charlie);
        sut.addNode(delta);
        sut.addNode(echo);
        sut.addNode(foxtrot);
        sut.addNode(golf);

        // expected truthies
        boolean actualResult = sut.contains(bravo);
        assertTrue(actualResult);
        actualResult = sut.contains(echo);
        assertTrue(actualResult);
        actualResult = sut.contains(golf);
        assertTrue(actualResult);

        // expected falsies
        actualResult = sut.contains(8);
        assertFalse(actualResult);
        actualResult = sut.contains(-1);
        assertFalse(actualResult);
    }

    @Test
    void testBinaryTree_removeRootNodeDoesNotThrow() {
        // will throw exception until method is implemented
        int nodeValue = 4;
        MyBinaryTree<Integer> sut = new MyBinaryTree<>(nodeValue);
        int expectedCount = 1;
        int actualCount = sut.getCount();
        assertEquals(expectedCount, actualCount);

        int actualResult = assertDoesNotThrow(() -> sut.removeNode(nodeValue));
        assertEquals(nodeValue, actualResult);

        expectedCount = 0;
        actualCount = assertDoesNotThrow(sut::getCount);
        assertEquals(expectedCount, actualCount);
    }

    @Test
    void testBinaryTree_removeNode() {
        // will throw exception until method is implemented
        int nodeValue = 1;
        MyBinaryTree<Integer> sut = new MyBinaryTree<>(nodeValue);

        int startOfRange = 2;
        int endOfRange = 20;
        for(int idx = startOfRange; idx <= endOfRange; idx++) {
            sut.addNode(idx);
        }

        int actualCount = sut.getCount();
        assertEquals(endOfRange, actualCount);

        int expectedResult = 4;

        int actualResult = assertDoesNotThrow(() -> sut.removeNode(expectedResult));
        assertEquals(expectedResult, actualResult);

        int expectedCount = endOfRange - 1;
        actualCount = sut.getCount();
        assertEquals(expectedCount, actualCount);
    }

    @Test
    void testBinaryTree_removeRootRightChildDoesNotThrow() {
        // will throw exception until method is implemented
        int nodeValue = 1;
        MyBinaryTree<Integer> sut = new MyBinaryTree<>(nodeValue);

        int startOfRange = 2;
        int endOfRange = 3;
        for(int idx = startOfRange; idx <= endOfRange; idx++) {
            sut.addNode(idx);
        }

        int actualCount = sut.getCount();
        assertEquals(endOfRange, actualCount);

        int expectedResult = 3;

        int actualResult = assertDoesNotThrow(() -> sut.removeNode(expectedResult));
        assertEquals(expectedResult, actualResult);

        int expectedCount = endOfRange - 1;
        actualCount = sut.getCount();
        assertEquals(expectedCount, actualCount);
    }
    @Test
    void testBinaryTree_removeRootWithChildrenDoesNotThrow() {
        // will throw exception until method is implemented
        int nodeValue = 1;
        MyBinaryTree<Integer> sut = new MyBinaryTree<>(nodeValue);

        int startOfRange = 2;
        int endOfRange = 20;
        for(int idx = startOfRange; idx <= endOfRange; idx++) {
            sut.addNode(idx);
        }

        int actualCount = sut.getCount();
        assertEquals(endOfRange, actualCount);

        int expectedResult = 1;

        int actualResult = assertDoesNotThrow(() -> sut.removeNode(expectedResult));
        assertEquals(expectedResult, actualResult);

        int expectedCount = endOfRange - 1;
        actualCount = sut.getCount();
        assertEquals(expectedCount, actualCount);
    }

    @Test
    void testBinaryTree_IsEmpty() {
        // cannot test until tree.RemoveNode is implemented
    }

}
