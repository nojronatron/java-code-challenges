package myJava.code.challenges;

import myJava.code.models.GenericBinaryTree.MyBinaryNode;
import myJava.code.models.GenericBinaryTree.MyBinaryTree;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Random;
import java.util.TreeSet;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestBinaryTreeFindMax {
    @Test
    public void test_firstSampleInputReturnCorrectMaxNumber() {
        int[] inputs = {1, 3, 5, 2, 4, 6, 0};
        int expectedResult = 6;
        MyBinaryTree<Integer> sutTree = new MyBinaryTree<>(1);
        for (int idx = 1; idx < inputs.length; idx++) {
            sutTree.addNode(inputs[idx]);
        }
        MyBinaryNode<Integer> sut = sutTree.getRoot();
        int actualResult = BinaryTreeFindMax.findMax(sut);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void test_secondSampleInputReturnCorrectMaxNumber() {
        int[] inputs = {-10, -3, 3, -1, 0, 4, -2};
        int expectedResult = 4;
        MyBinaryTree<Integer> sutTree = new MyBinaryTree<>(-10);
        for (int idx = 1; idx < inputs.length; idx++) {
            sutTree.addNode(inputs[idx]);
        }
        MyBinaryNode<Integer> sut = sutTree.getRoot();
        int actualResult = BinaryTreeFindMax.findMax(sut);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void test_allNegativeNumbersReturnsValueClosestToZero() {
        ArrayList<Integer> randNumbers = new ArrayList<>();
        var rand = new Random();

        for (int idx = 0; idx < 1_000; idx++) {
            int randNum = rand.nextInt();
            if (randNum > 0) {
                randNum *= -1;
            }
            randNumbers.add(randNum);
//            System.out.printf("Generated randNumber: %s.%n", randNum);
        }

        TreeSet<Integer> treeSet = new TreeSet<>(randNumbers);
        var expectedResult = treeSet.last();
        System.out.printf("TreeSet says highest number is %s.%n", expectedResult);
        MyBinaryTree<Integer> sutTree = new MyBinaryTree<>(randNumbers.get(0));

        for (int number : randNumbers) {
            sutTree.addNode(number);
        }

        MyBinaryNode<Integer> sut = sutTree.getRoot();
        int actualResult = BinaryTreeFindMax.findMax(sut);
        System.out.printf("findMax says max value is %s.%n", actualResult);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void test_randomizedSignedNumbersReturnsValueClosestToZero() {
        ArrayList<Integer> randNumbers = new ArrayList<>();
        var rand = new Random();

        for (int idx = 0; idx < 1_000; idx++) {
            int randNum = rand.nextInt();
            randNumbers.add(randNum);
//            System.out.printf("Generated randNumber: %s.%n", randNum);
        }

        TreeSet<Integer> treeSet = new TreeSet<>(randNumbers);
        var expectedResult = treeSet.last();
        System.out.printf("TreeSet says highest number is %s.%n", expectedResult);
        MyBinaryTree<Integer> sutTree = new MyBinaryTree<>(randNumbers.get(0));

        for (int number : randNumbers) {
            sutTree.addNode(number);
        }

        MyBinaryNode<Integer> sut = sutTree.getRoot();
        int actualResult = BinaryTreeFindMax.findMax(sut);
        System.out.printf("findMax says max value is %s.%n", actualResult);

        assertEquals(expectedResult, actualResult);
    }
}
