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

    }

    @Test
    void test_MyKaryTreeInstantiationNull() {
        MyKaryTree<MyKaryNode<Integer>> sut = new MyKaryTree<>();
        var actualNull = sut.getRoot();
        assertNull(actualNull);
    }
}
