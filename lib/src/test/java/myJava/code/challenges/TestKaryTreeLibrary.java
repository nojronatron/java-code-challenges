package myJava.code.challenges;

import org.junit.jupiter.api.Test;
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
        assertEquals(String.format("Boolean result: %1$s", expectedBoolean),
                String.format("Boolean result: %1$s"), sutBoolean.toString());
    }

    @Test
    void test_MyKaryNodeSetValue() {

    }

    @Test
    void test_MyKaryNodeGetChild() {

    }

    @Test
    void test_MyKaryNodeGetChildren() {

    }

    @Test
    void test_MyKaryNodeSetChildren() {

    }

    @Test
    void test_MyKaryNodeHasChildren() {

    }

    @Test
    void test_MyKaryNodeIsLeaf() {
        
    }

//    @Test
//    void test_MyKaryTreeInstantiationNull() {
//        MyKaryTree<MyKaryNode<Integer>> sut = new MyKaryTree<>();
//        var actualNull = sut.getRoot();
//        assertNull(actualNull);
//    }
//
//    @Test
//    void test_MyKaryTreeAddRootNode() {
//        Integer expectedValue = 11;
//        var rootNode = new MyKaryNode<>(expectedValue);
//        var sut = new MyKaryTree<MyKaryNode<Integer>>();
//        sut.setRoot(rootNode);
//    }
}
