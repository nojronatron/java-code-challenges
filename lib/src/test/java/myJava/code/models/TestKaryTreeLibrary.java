package myJava.code.challenges;

import myJava.code.models.MyKaryNode;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class TestKaryTreeLibrary {
    @Test
    void test_MyKaryNodeInstantiationNull() {
        int expectedValue = 11;
        int expectedChildren = 0;
        MyKaryNode<Integer> sut = new MyKaryNode<>(expectedValue);
        int actualValue = sut.getValue();
        assertEquals(expectedValue, actualValue);
        System.out.println(sut.getChildren().size());
        int actualChildren = sut.getChildren().size();
        assertEquals(expectedChildren, actualChildren);
    }

    @Test
    void test_MyKaryNodesHaveManyValueTypes() {
        int expectedInt = 11;
        String expectedString = "Eleven";
        boolean expectedBoolean = true;

        MyKaryNode<Integer> sutInt = new MyKaryNode<>(expectedInt);
        MyKaryNode<String> sutString = new MyKaryNode<>(expectedString);
        MyKaryNode<Boolean> sutBoolean = new MyKaryNode<>(expectedBoolean);

        assertNotNull(sutInt);
        assertNotNull(sutString);
        assertNotNull(sutBoolean);

        assertEquals(expectedInt, sutInt.getValue());
        assertEquals(expectedString, sutString.getValue());
        assertEquals(expectedBoolean, sutBoolean.getValue());
    }

    @Test
    void test_MyKaryNodesCanToStringVariousValueTypes() {
        int expectedInt = 11;
        String expectedString = "Eleven";
        boolean expectedBoolean = true;

        MyKaryNode<Integer> sutInt = new MyKaryNode<>(expectedInt);
        MyKaryNode<String> sutString = new MyKaryNode<>(expectedString);
        MyKaryNode<Boolean> sutBoolean = new MyKaryNode<>(expectedBoolean);

        assertEquals(expectedInt, sutInt.getValue());
        assertEquals(String.valueOf(expectedInt), sutInt.toString());

        assertEquals(expectedString, sutString.getValue());
        assertEquals(expectedString, sutString.toString());

        assertEquals(expectedBoolean, sutBoolean.getValue());
        assertEquals("true", sutBoolean.toString());
    }

    @Test
    void test_MyKaryNodeSetValue() {
        int expectedValue = 11;
        MyKaryNode<Integer> sut = new MyKaryNode<>(expectedValue);
        assertEquals(expectedValue, sut.getValue());

        int expectedNewValue = 22;
        sut.setValue(expectedNewValue);
        assertEquals(expectedNewValue, sut.getValue());
    }

    @Test
    void test_MyKaryNodeSetAndGetSingleChild() {
        int expectedRootValue = 11;
        MyKaryNode<Integer> sut = new MyKaryNode<>(expectedRootValue);
        int expectedChildValue = 12;
        MyKaryNode<Integer> child = new MyKaryNode<>(expectedChildValue);
        int expectedSecondChildValue = 13;
        MyKaryNode<Integer> secondChild = new MyKaryNode<>(expectedSecondChildValue);

        sut.setChild(child);
        MyKaryNode<Integer> actualChildNode = sut.getChild(0);
        assertEquals(expectedChildValue, actualChildNode.getValue());
        sut.setChild(secondChild);
        MyKaryNode<Integer> actualSecondChildNode = sut.getChild(1);
        assertEquals(expectedSecondChildValue, actualSecondChildNode.getValue());
    }

    @Test
    void test_MyKaryNodeGetAndSetListOfChildren() {
        int expectedRootValue = 11;
        MyKaryNode<Integer> sut = new MyKaryNode<>(expectedRootValue);
        int expectedChildValue = 12;
        MyKaryNode<Integer> child = new MyKaryNode<>(expectedChildValue);
        int expectedSecondChildValue = 13;
        MyKaryNode<Integer> secondChild = new MyKaryNode<>(expectedSecondChildValue);

        assertEquals(new ArrayList<MyKaryNode<Integer>>(), sut.getChildren());
        assertFalse(sut.hasChildren());
        assertTrue(sut.isLeaf());

        var childList = new ArrayList<MyKaryNode<Integer>>();
        childList.add(child);
        childList.add(secondChild);

        sut.setChildren(childList);

        assertTrue(sut.hasChildren());
        assertFalse(sut.isLeaf());
        assertNotNull(sut.getChildren());
    }

    @Test
    void test_MyKaryNodeHasChildren() {
        int expectedRootValue = 11;
        MyKaryNode<Integer> sut = new MyKaryNode<>(expectedRootValue);
        int expectedChildValue = 12;
        MyKaryNode<Integer> child = new MyKaryNode<>(expectedChildValue);
        int expectedSecondChildValue = 13;
        MyKaryNode<Integer> secondChild = new MyKaryNode<>(expectedSecondChildValue);

        assertEquals(new ArrayList<MyKaryNode<Integer>>(), sut.getChildren());
        assertFalse(sut.hasChildren());

        var childList = new ArrayList<MyKaryNode<Integer>>();
        childList.add(child);
        childList.add(secondChild);

        sut.setChildren(childList);

        assertTrue(sut.hasChildren());
        assertNotNull(sut.getChildren());
    }

    @Test
    void test_MyKaryNodeIsLeaf() {
        int expectedRootValue = 11;
        MyKaryNode<Integer> sut = new MyKaryNode<>(expectedRootValue);
        int expectedChildValue = 12;
        MyKaryNode<Integer> child = new MyKaryNode<>(expectedChildValue);
        int expectedSecondChildValue = 13;
        MyKaryNode<Integer> secondChild = new MyKaryNode<>(expectedSecondChildValue);

        assertEquals(new ArrayList<MyKaryNode<Integer>>(), sut.getChildren());
        assertTrue(sut.isLeaf());

        var childList = new ArrayList<MyKaryNode<Integer>>();
        childList.add(child);
        childList.add(secondChild);

        sut.setChildren(childList);

        assertFalse(sut.isLeaf());
        assertNotNull(sut.getChildren());
    }

    @Test
    void test_KaryNodeBreadthFirstFunctions() {
        int expectedRootValue = 11;
        MyKaryNode<Integer> sut = new MyKaryNode<>(expectedRootValue);
        int expectedAlphaChildValue = 12;
        MyKaryNode<Integer> alphaChild = new MyKaryNode<>(expectedAlphaChildValue);
        int expectedBravoChildValue = 13;
        MyKaryNode<Integer> bravoChild = new MyKaryNode<>(expectedBravoChildValue);
        int expectedCharlieChildValue = 14;
        MyKaryNode<Integer> charlieChild = new MyKaryNode<>(expectedCharlieChildValue);
        int expectedDeltaChildValue = 15;
        MyKaryNode<Integer> deltaChild = new MyKaryNode<>(expectedDeltaChildValue);

        sut.setChild(alphaChild);
        MyKaryNode<Integer> actualSutAlphaChildNode = sut.getChild(0);
        assertEquals(expectedAlphaChildValue, actualSutAlphaChildNode.getValue());

        sut.setChild(bravoChild);
        MyKaryNode<Integer> actualSutBravoChildNode = sut.getChild(1);
        assertEquals(expectedBravoChildValue, actualSutBravoChildNode.getValue());

        alphaChild.setChild(charlieChild);
        MyKaryNode<Integer> actualAlphaCharlieChildNode = alphaChild.getChild(0);
        assertEquals(expectedCharlieChildValue, actualAlphaCharlieChildNode.getValue());

        alphaChild.setChild(deltaChild);
        MyKaryNode<Integer> actualAlphaDeltaChildNode = alphaChild.getChild(1);
        assertEquals(expectedDeltaChildValue, actualAlphaDeltaChildNode.getValue());

        ArrayList<Integer> expectedResultValues = new ArrayList<>();
        for(int item=11; item < 16; item++) {
            expectedResultValues.add(item);
            System.out.println("Expected Node Value: " + item);
        }

        var breadthFirstResult = sut.breadthFirst(sut);
        ArrayList<Integer> actualResultValues = new ArrayList<>();
        for(MyKaryNode<Integer> node: breadthFirstResult) {
            actualResultValues.add(node.getValue());
            System.out.println("Actual Node Value: " + node.getValue());
        }

        assertEquals(expectedResultValues, actualResultValues);
    }
}
