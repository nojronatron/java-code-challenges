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
    void testBinaryTree_removeNode() {
        // will throw exception until method is implemented
        int rootValue = 1;
        int bravo = 2;
        int charlie = 3;
        int delta = 4;
        int echo = 5;
        int foxtrot = 6;
        int golf = 7;

        MyBinaryTree<Integer> sut = new MyBinaryTree<Integer>(rootValue);
        boolean expectedAddResult = true;
        boolean addResult = sut.addNode(bravo);

        int expectedResult = bravo;
//        int actualResult = sut.removeNode(bravo);
    }

    @Test
    void testBinaryTree_IsEmpty() {
        // cannot test until tree.RemoveNode is implemented
    }

}
