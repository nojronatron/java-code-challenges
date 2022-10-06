package myJava.code.challenges;

import myJava.code.models.MyKaryNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestSprinklerWaterUsage {
    @Test
    void test_canInstantiateClass() {
        var sut = new SprinklerWaterUsage();
        assertNotNull(sut);
    }
    @Test
    void test_singleNodeTreeReturnsRootNodeValue() {
        int expectedResult = 11;
        var sut = new SprinklerWaterUsage();
        MyKaryNode<Integer> rootNode = new MyKaryNode<>(expectedResult);
        assertEquals(expectedResult, sut.waterUsage(rootNode));
    }
    @Test
    void test_negativeValuesInTreeIgnored() {
        int expectedResult = 0;
        int startingValue = -11;
        var sut = new SprinklerWaterUsage();
        MyKaryNode<Integer> rootNode = new MyKaryNode<>(startingValue);
        assertEquals(expectedResult, sut.waterUsage(rootNode));
    }
    @Test
    void test_exampleInputsReturns249() {
        int expectedResult = 294;
        var sut = new SprinklerWaterUsage();
        MyKaryNode<Integer> rootNode = new MyKaryNode<>(35);
        MyKaryNode<Integer> rootLeftChild = new MyKaryNode<>(41);
        MyKaryNode<Integer> rootRightChild = new MyKaryNode<>(59);

        MyKaryNode<Integer> thirdLevelAlpha = new MyKaryNode<>(33);
        MyKaryNode<Integer> thirdLevelBravo = new MyKaryNode<>(52);
        MyKaryNode<Integer> thirdLevelCharlie = new MyKaryNode<>(30);
        MyKaryNode<Integer> thirdLevelDelta = new MyKaryNode<>(44);

        rootLeftChild.setChild(thirdLevelAlpha);
        rootLeftChild.setChild(thirdLevelBravo);

        rootRightChild.setChild(thirdLevelCharlie);
        rootRightChild.setChild(thirdLevelDelta);

        rootNode.setChild(rootLeftChild);
        rootNode.setChild(rootRightChild);

        assertEquals(expectedResult, sut.waterUsage(rootNode));
    }
}
