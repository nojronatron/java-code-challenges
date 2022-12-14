package myJava.code.models;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TestBinaryTreeLibrary {

    @Test void testBinaryNode_CanInstantiate() {
        int expectedValue = 11;
        MyBinaryNode sut = new MyBinaryNode(expectedValue);
        assertNotNull(sut);
        assertEquals(expectedValue, sut.getValue());
    }

    @Test void testBinaryNode_GetterSetters() {
        MyBinaryNode sut = new MyBinaryNode(11);
        MyBinaryNode leftSut = new MyBinaryNode(10);
        sut.setLeft(leftSut);
        assertEquals(leftSut, sut.getLeft());
        assertEquals(sut.getLeft().getValue(), leftSut.getValue());
        MyBinaryNode rightSut = new MyBinaryNode(12);
        sut.setRight(rightSut);
        assertEquals(rightSut, sut.getRight());
        assertEquals(sut.getRight().getValue(), rightSut.getValue());
    }

    @Test void testBinaryTree_CanInstantiateEmpty() {
        MyBinaryTree sut = new MyBinaryTree();
        assertNotNull(sut);
        assertNull(sut.getRoot());
    }

    @Test void testBinaryTree_CanInstantiateWithValue() {
        MyBinaryNode node = new MyBinaryNode(11);
        MyBinaryTree sut = new MyBinaryTree(node);
        assertNotNull(sut);
        assertEquals(node, sut.getRoot());
    }

    @Test void testBST_CanInstantiateEmpty() {
        MyBinaryNode node = null;
        assertNull(node);
    }

    @Test void testBinaryTree_PreOrderExpectedResults() {
        MyBinaryNode firstRoot = new MyBinaryNode(1);
        MyBinaryNode secondLeft = new MyBinaryNode(2);
        MyBinaryNode secondRight = new MyBinaryNode(3);
        MyBinaryNode thirdLeftLeft = new MyBinaryNode(4);
        MyBinaryNode thirdLeftRight = new MyBinaryNode(5);
        MyBinaryNode thirdRightLeft = new MyBinaryNode(6);
        MyBinaryNode thirdRightRight = new MyBinaryNode(7);

        MyBinaryTree sut = new MyBinaryTree(firstRoot);
        var actualRoot = sut.getRoot();
        assertEquals(firstRoot, actualRoot);

        assertTrue(sut.resetStorageArray());
        sut.preOrder(firstRoot);
        assertEquals("[ 1 ]", sut.getStorageArray());

        String expectedPreOrderArray = "[ 1, 2, 4, 5, 3, 6, 7 ]";

        firstRoot.setLeft(secondLeft);
        firstRoot.setRight(secondRight);
        secondLeft.setLeft(thirdLeftLeft);
        secondLeft.setRight(thirdLeftRight);
        secondRight.setLeft(thirdRightLeft);
        secondRight.setRight(thirdRightRight);

        assertTrue(sut.resetStorageArray());
        sut.preOrder(sut.getRoot());
        assertEquals(expectedPreOrderArray, sut.getStorageArray());
    }
    @Test void testBinaryTree_InOrderExpectedResults() {
        MyBinaryNode firstRoot = new MyBinaryNode(1);
        MyBinaryNode secondLeft = new MyBinaryNode(2);
        MyBinaryNode secondRight = new MyBinaryNode(3);
        MyBinaryNode thirdLeftLeft = new MyBinaryNode(4);
        MyBinaryNode thirdLeftRight = new MyBinaryNode(5);
        MyBinaryNode thirdRightLeft = new MyBinaryNode(6);
        MyBinaryNode thirdRightRight = new MyBinaryNode(7);

        MyBinaryTree sut = new MyBinaryTree(firstRoot);
        var actualRoot = sut.getRoot();
        assertEquals(firstRoot, actualRoot);

        assertTrue(sut.resetStorageArray());
        sut.inOrder(firstRoot);
        assertEquals("[ 1 ]", sut.getStorageArray());

        String expectedPreOrderArray = "[ 4, 2, 5, 1, 6, 3, 7 ]";

        firstRoot.setLeft(secondLeft);
        firstRoot.setRight(secondRight);
        secondLeft.setLeft(thirdLeftLeft);
        secondLeft.setRight(thirdLeftRight);
        secondRight.setLeft(thirdRightLeft);
        secondRight.setRight(thirdRightRight);

        assertTrue(sut.resetStorageArray());
        sut.inOrder(sut.getRoot());
        assertEquals(expectedPreOrderArray, sut.getStorageArray());
    }

    @Test void testBinaryTree_PostOrderExpectedResults() {
        MyBinaryNode firstRoot = new MyBinaryNode(1);
        MyBinaryNode secondLeft = new MyBinaryNode(2);
        MyBinaryNode secondRight = new MyBinaryNode(3);
        MyBinaryNode thirdLeftLeft = new MyBinaryNode(4);
        MyBinaryNode thirdLeftRight = new MyBinaryNode(5);
        MyBinaryNode thirdRightLeft = new MyBinaryNode(6);
        MyBinaryNode thirdRightRight = new MyBinaryNode(7);

        MyBinaryTree sut = new MyBinaryTree(firstRoot);
        var actualRoot = sut.getRoot();
        assertEquals(firstRoot, actualRoot);

        assertTrue(sut.resetStorageArray());
        sut.postOrder(firstRoot);
        assertEquals("[ 1 ]", sut.getStorageArray());

        String expectedPreOrderArray = "[ 4, 5, 2, 6, 7, 3, 1 ]";

        firstRoot.setLeft(secondLeft);
        firstRoot.setRight(secondRight);
        secondLeft.setLeft(thirdLeftLeft);
        secondLeft.setRight(thirdLeftRight);
        secondRight.setLeft(thirdRightLeft);
        secondRight.setRight(thirdRightRight);

        assertTrue(sut.resetStorageArray());
        sut.postOrder(sut.getRoot());
        assertEquals(expectedPreOrderArray, sut.getStorageArray());
    }

    @Test void testBinaryTree_BreadthFirstTraversalExpectedResults() {
        MyBinaryNode firstRoot = new MyBinaryNode(1);
        MyBinaryNode secondLeft = new MyBinaryNode(2);
        MyBinaryNode secondRight = new MyBinaryNode(3);
        MyBinaryNode thirdLeftLeft = new MyBinaryNode(4);
        MyBinaryNode thirdLeftRight = new MyBinaryNode(5);
        MyBinaryNode thirdRightLeft = new MyBinaryNode(6);
        MyBinaryNode thirdRightRight = new MyBinaryNode(7);

        MyBinaryTree sut = new MyBinaryTree(firstRoot);
        var actualRoot = sut.getRoot();
        assertEquals(firstRoot, actualRoot);

        assertTrue(sut.resetStorageArray());
        sut.breadthFirst(firstRoot);
        assertEquals("[ 1 ]", sut.getStorageArray());

        String expectedPreOrderArray = "[ 1, 2, 3, 4, 5, 6, 7 ]";

        firstRoot.setLeft(secondLeft);
        firstRoot.setRight(secondRight);
        secondLeft.setLeft(thirdLeftLeft);
        secondLeft.setRight(thirdLeftRight);
        secondRight.setLeft(thirdRightLeft);
        secondRight.setRight(thirdRightRight);

        assertTrue(sut.resetStorageArray());
        sut.breadthFirst(sut.getRoot());
        assertEquals(expectedPreOrderArray, sut.getStorageArray());
    }

    @Test void testBinaryTree_GetStringOfArray() {
        MyBinaryTree sut = new MyBinaryTree();
        assertEquals("[]", sut.getStorageArray());

        int expectedValue = 11;
        String expectedResult = String.format("[ %1$s ]", expectedValue);

        assertTrue(sut.resetStorageArray());
        sut.addItemToStorageArray(expectedValue);
        assertEquals(expectedResult, sut.getStorageArray());
    }


}
