/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package myJava.code.challenges;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TestTreeLibrary {

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
        MyBinaryNode node = new MyBinaryNode(11);
        MyBST sut = new MyBST(node);
        assertNotNull(sut);
        assertEquals(node, sut.getRoot());
    }
}