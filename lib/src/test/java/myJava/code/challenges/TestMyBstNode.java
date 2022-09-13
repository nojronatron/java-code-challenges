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
    public void test_bstNodeSetGetValues() {
        int expectedZeroValue = 0;
        int expectedFirstResult = 11;
        int expectedSecondResult = 12;
        int expectedThirdResult = 13;

        MyBstNode sut = new MyBstNode(expectedZeroValue);
        assertEquals(expectedZeroValue, sut.getValue());

        sut.setValue(expectedFirstResult);
        assertEquals(expectedFirstResult, sut.getValue());

        sut.setValue(expectedSecondResult);
        assertEquals(expectedSecondResult, sut.getValue());

        sut.setValue(expectedThirdResult);
        assertEquals(expectedThirdResult, sut.getValue());
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

    @Test public void test_bstNodeAddManyNodesLargerAndSmaller() {
        // Note: Add function does not perform rebalancing not does it try to fill all child nodes explicitly
        //       order of add() operations matters when it comes to final tree layout
        //       which will impact whether this test passes or fails based on getChild method calls.
        int expectedEightValue = 8;
        int expectedNineValue = 9;
        int expectedTenValue = 10;
        int expectedRootValue = 11;
        int expectedTwelveValue = 12;
        int expectedThirteenValue = 13;
        int expectedFourteenValue = 14;
        int expectedFifteenValue = 15;

        MyBstNode rootNode = new MyBstNode(expectedRootValue);
        rootNode.add(expectedTenValue);
        rootNode.add(expectedTwelveValue);

        rootNode.add(expectedEightValue);
        rootNode.add(expectedNineValue);

        rootNode.add(expectedFourteenValue);
        rootNode.add(expectedThirteenValue);
        rootNode.add(expectedFifteenValue);

        assertEquals(expectedEightValue, rootNode.getLeft().getLeft().getValue());
        assertEquals(expectedNineValue, rootNode.getLeft().getLeft().getRight().getValue());
        assertEquals(expectedTenValue, rootNode.getLeft().getValue());

        assertEquals(expectedRootValue, rootNode.getValue());

        assertEquals(expectedTwelveValue, rootNode.getRight().getValue());
        assertEquals(expectedThirteenValue, rootNode.getRight().getRight().getLeft().getValue());
        assertEquals(expectedFourteenValue, rootNode.getRight().getRight().getValue());
        assertEquals(expectedFifteenValue, rootNode.getRight().getRight().getRight().getValue());
    }

    @Test
    public void test_bstNodeSearchForSpecificValue() {
        int expectedRootValue = 11;
        int expectedLeftChildValue = 10;
        int expectedRightChildValue = 12;
        // MyBstNode expected20Result = null;
        // MyBstNode expected2Result = null;

        MyBstNode rootNode = new MyBstNode(expectedRootValue);
        rootNode.add(expectedLeftChildValue);
        rootNode.add(expectedRightChildValue);

        var actual12Result = rootNode.search(rootNode, expectedRightChildValue);
        assertEquals(expectedRightChildValue, actual12Result.getValue());

        var actual10Result = rootNode.search(rootNode, expectedLeftChildValue);
        assertEquals(expectedLeftChildValue, actual10Result.getValue());

        var actual11Result = rootNode.search(rootNode, expectedRootValue);
        assertEquals(expectedRootValue, actual11Result.getValue());

        var actual20Result = rootNode.search(rootNode, 20);
        assertNull(actual20Result);

        var actual2Result = rootNode.search(rootNode, 2);
        assertNull(actual2Result);
    }

    @Test
    public void test_bstNodeContainsSpecificValue() {
        int expectedRootValue = 11;
        int expectedLeftChildValue = 10;
        int expectedRightChildValue = 12;
        // MyBstNode expected20Result = null;
        // MyBstNode expected2Result = null;

        MyBstNode rootNode = new MyBstNode(expectedRootValue);
        rootNode.add(expectedLeftChildValue);
        rootNode.add(expectedRightChildValue);

        var actual12Result = rootNode.contains(rootNode, expectedRightChildValue);
        assertTrue(actual12Result);

        var actual10Result = rootNode.contains(rootNode, expectedLeftChildValue);
        assertTrue(actual10Result);

        var actual11Result = rootNode.contains(rootNode, expectedRootValue);
        assertTrue(actual11Result);

        var actual20Result = rootNode.contains(rootNode, 20);
        assertFalse(actual20Result);

        var actual2Result = rootNode.contains(rootNode, 2);
        assertFalse(actual2Result);
    }

    @Test
    public void test_bstNodeIsLeafTrueAndFalse() {
        MyBstNode sut = new MyBstNode(11);
        assertTrue(sut.isLeaf());
        sut.setLeft(new MyBstNode(10));
        assertFalse(sut.isLeaf());
        sut.setRight(new MyBstNode(12));
        assertFalse(sut.isLeaf());
        assertTrue(sut.getLeft().isLeaf());
        assertTrue(sut.getRight().isLeaf());
    }

    @Test
    public void test_bstNodeStringOutput() {
        MyBstNode sut = new MyBstNode(11);
        sut.setLeft(new MyBstNode(10));
        sut.setRight(new MyBstNode(12));
        System.out.println("sut.toString(): " + sut);
        assertEquals("11", sut.toString());
        System.out.println("sut.getLeft().toString(): " + sut.getLeft().toString());
        assertEquals("10", sut.getLeft().toString());
        System.out.println("sut.getRight().toString(): " + sut.getRight().toString());
        assertEquals("12", sut.getRight().toString());
    }

    @Test
    public void test_bstNodeListTreeStringOutput() {
        int expectedEightValue = 8;
        int expectedNineValue = 9;
        int expectedTenValue = 10;
        int expectedRootValue = 11;
        int expectedTwelveValue = 12;
        int expectedThirteenValue = 13;
        int expectedFourteenValue = 14;
        int expectedFifteenValue = 15;

        MyBstNode sut = new MyBstNode(expectedRootValue);
        sut.add(expectedTenValue);
        sut.add(expectedTwelveValue);
        sut.add(expectedEightValue);
        sut.add(expectedNineValue);
        sut.add(expectedFourteenValue);
        sut.add(expectedThirteenValue);
        sut.add(expectedFifteenValue);

        String actualResult = sut.listTree();
        System.out.println("List Tree String Output: " + actualResult);
        assertInstanceOf(String.class, actualResult);
    }
}
