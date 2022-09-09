package myJava.code.challenges;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestLeafCounter {

    @Test
    void testBinaryTree_SameLeafCountReturnsTrue() {
        // create a method that takes in two directory structures (trees)
        // method should compare both structures
        // method returns whether or not they have the same number of individual files (leaves)
        MyBinaryNode alphaFirstRoot = new MyBinaryNode(1);
        MyBinaryNode alphaSecondLeft = new MyBinaryNode(2);
        MyBinaryNode alphaSecondRight = new MyBinaryNode(3);
        MyBinaryNode alphaThirdLeftLeft = new MyBinaryNode(4);
        MyBinaryNode alphaThirdLeftRight = new MyBinaryNode(5);

        alphaFirstRoot.setLeft(alphaSecondLeft);
        alphaFirstRoot.setRight(alphaSecondRight);
        alphaSecondLeft.setLeft(alphaThirdLeftLeft);
        alphaSecondLeft.setRight(alphaThirdLeftRight);

        MyBinaryNode bravoFirstRoot = new MyBinaryNode(6);
        MyBinaryNode bravoSecondLeft = new MyBinaryNode(7);
        MyBinaryNode bravoSecondRight = new MyBinaryNode(8);
        MyBinaryNode bravoThirdLeftLeft = new MyBinaryNode(9);
        MyBinaryNode bravoThirdLeftRight = new MyBinaryNode(10);

        bravoFirstRoot.setLeft(bravoSecondLeft);
        bravoFirstRoot.setRight(bravoSecondRight);
        bravoSecondLeft.setLeft(bravoThirdLeftLeft);
        bravoSecondLeft.setRight(bravoThirdLeftRight);

        MyBinaryTree leftTree = new MyBinaryTree(alphaFirstRoot);
        MyBinaryTree rightTree = new MyBinaryTree(bravoFirstRoot);

        LeafCounter sut = new LeafCounter();
        boolean actualResult = sut.fileCountSame(leftTree, rightTree);

        assertTrue(actualResult);
    }
}
