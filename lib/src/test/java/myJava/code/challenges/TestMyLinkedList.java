package myJava.code.challenges;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestMyLinkedList {
    @Test
    void test_InstantiateNewEmptyLinkedList() {
        MyLinkedList sut = new MyLinkedList();
        assertEquals(MyLinkedList.class, sut.getClass());
    }

    @Test
    void test_InstantiateNewNodeWithValue() {
        int expectedValue = 11;
        MyLinkedListNode sut = new MyLinkedListNode(11);
        assertEquals(expectedValue, sut.getValue());
    }

    @Test
    void test_LLNodeSetNextAndGetNext() {
        int expectedInitialValue = 11;
        int expectedSecondValue = 22;
        MyLinkedListNode sut = new MyLinkedListNode(expectedInitialValue);
        MyLinkedListNode second = new MyLinkedListNode(expectedSecondValue);
        assertNull(sut.getNext());
        assertNull(second.getNext());
        sut.setNext(second);
        assertNotNull(sut.getNext());
    }

    @Test
    void test_LLNodeSetAndGetValue() {
        int expectedInitialValue = 11;
        int expectedSecondValue = 22;
        MyLinkedListNode sut = new MyLinkedListNode(expectedInitialValue);
        assertEquals(expectedInitialValue, sut.getValue());
        sut.setValue(expectedSecondValue);
        assertEquals(expectedSecondValue, sut.getValue());
    }
}
