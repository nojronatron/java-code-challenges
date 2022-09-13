package myJava.code.challenges;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestMyBstNode {
    @Test
    public void test_bstNodeInstantiationNull() {
        MyBstNode sut = null;
        assertNull(sut);
    }

    @Test
    public void test_bstNodeInstantiationValue() {
        int expectedResult = 11;
        MyBstNode sut = new MyBstNode(expectedResult);
        assertNotNull(sut);
    }

    @Test
    public void test_bstNodeGetValueNullAndNonNull() {
        int expectedResult = 11;
        MyBstNode sut = new MyBstNode(expectedResult);
        assertEquals(expectedResult, sut.getValue());
    }

    @Test
    public void test_bstNodeSetAndGetLeftChildNullAndNonNull() {
        int expectedRootValue = 11;
        int expectedLeftChildValue = 10;

        MyBstNode rootNode = new MyBstNode(expectedRootValue);
        assertNull(rootNode.getLeft());
        rootNode.setLeft(new MyBstNode(expectedLeftChildValue));
        assertNotNull(rootNode.getLeft());
        assertEquals(expectedLeftChildValue, rootNode.getLeft().getValue());
    }

    @Test
    public void test_bstNodeSetAndGetRightChildNullAndNonNull() {
        int expectedRootValue = 11;
        int expectedRightChildValue = 12;

        MyBstNode rootNode = new MyBstNode(expectedRootValue);
        assertNull(rootNode.getRight());
        rootNode.setRight(new MyBstNode(expectedRightChildValue));
        assertNotNull(rootNode.getRight());
        assertEquals(expectedRightChildValue, rootNode.getRight().getValue());
    }

    @Test public void test_bstNodeAddNodesLargerAndSmaller() {
        int expectedRootValue = 11;
        int expectedLeftChildValue = 10;
        int expectedRightChildValue = 12;

        MyBstNode rootNode = new MyBstNode(expectedRootValue);
        assertNull(rootNode.getLeft());
        assertNull(rootNode.getRight());

        rootNode.add(expectedLeftChildValue);
        assertNotNull(rootNode.getLeft());
        assertEquals(expectedLeftChildValue, rootNode.getLeft().getValue());

        rootNode.add(expectedRightChildValue);
        assertNotNull(rootNode.getRight());
        assertEquals(expectedRightChildValue, rootNode.getRight().getValue());
    }

    @Test
    public void test_bstNodeSearchForSpecificValue() {
        int expectedRootValue = 11;
        int expectedLeftChildValue = 10;
        int expectedRightChildValue = 12;
        MyBstNode expected20Result = null;
        MyBstNode expected2Result = null;

        MyBstNode rootNode = new MyBstNode(expectedRootValue);
        rootNode.add(expectedLeftChildValue);
        rootNode.add(expectedRightChildValue);

        var actual12Result = rootNode.search(rootNode, 12);
        var actual10Result = rootNode.search(rootNode, 10);
        var actual11Result = rootNode.search(rootNode, 11);
        var actual20Result = rootNode.search(rootNode, 20);
        var actual2Result = rootNode.search(rootNode, 2);

        assertEquals(expectedRightChildValue, actual12Result.getValue());
        assertEquals(expectedLeftChildValue, actual10Result.getValue());
        assertEquals(expectedRootValue, actual11Result.getValue());
        assertNull(actual20Result);
        assertNull(actual2Result);
    }

    @Test
    public void test_bstNodeContainsSpecificValue() {
        int expectedRootValue = 11;
        int expectedLeftChildValue = 10;
        int expectedRightChildValue = 12;

        MyBstNode rootNode = new MyBstNode(expectedRootValue);
        assertNull(rootNode.getLeft());
        assertNull(rootNode.getRight());

        rootNode.add(expectedLeftChildValue);
        assertNotNull(rootNode.getLeft());
        assertEquals(expectedLeftChildValue, rootNode.getLeft().getValue());

        rootNode.add(expectedRightChildValue);
        assertNotNull(rootNode.getRight());
        assertEquals(expectedRightChildValue, rootNode.getRight().getValue());

    }

    @Test
    public void test_bstNodeIsLeafTrueAndFalse() {
        MyBstNode sut = new MyBstNode(11);
        assertTrue(sut.isLeaf());
        sut.setLeft(new MyBstNode(10));
        assertFalse(sut.isLeaf());
        sut.setRight(new MyBstNode(12));
        assertFalse(sut.isLeaf());
    }

    @Test
    public void test_bstNodeStringOutput() {
        MyBstNode sut = new MyBstNode(11);
        sut.setLeft(new MyBstNode(10));
        sut.setRight(new MyBstNode(12));
    }
}
