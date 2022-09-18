package myJava.code.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestMyLinkedList {
    @Test
    void test_InstantiateNewEmptyLinkedList() {
        MyLinkedList sut = new MyLinkedList();
        assertEquals(MyLinkedList.class, sut.getClass());
    }

    @Test
    void test_MyLinkedListGetAndSetHead() {
        int expectedHeadValue = 11;
        MyLinkedListNode headNode = new MyLinkedListNode(expectedHeadValue);
        MyLinkedList sut = new MyLinkedList();
        assertNull(sut.getHead());
        sut.setHead(headNode);
        assertNotNull(sut.getHead());
        assertEquals(expectedHeadValue, sut.getHead().getValue());
    }

    @Test
    void test_MyLinkedListPrintNodes() {
        String expectedResult = "[14]->[13]->[12]->[11]->NULL";
        String expectedEmptyResult = "NULL";

        MyLinkedList sut = new MyLinkedList();
        assertEquals(sut.print(), expectedEmptyResult);

        int expectedElevenValue = 11;
        int expectedTwelveValue = 12;
        int expectedThirteenValue = 13;
        int expectedFourteenValue = 14;

        sut.add(expectedElevenValue);
        sut.add(expectedTwelveValue);
        sut.add(expectedThirteenValue);
        sut.add(expectedFourteenValue);

        assertEquals(expectedResult, sut.print());
    }

    @Test
    void test_MyLinkedListIncludesFalseAndTrue() {
        int expectedElevenValue = 11;
        int expectedTwelveValue = 12;
        int expectedThirteenValue = 13;
        int expectedFourteenValue = 14;
        int missingFifteenValue = 15;

        MyLinkedList sut = new MyLinkedList();
        sut.add(expectedElevenValue);
        sut.add(expectedTwelveValue);
        sut.add(expectedThirteenValue);
        sut.add(expectedFourteenValue);

        assertFalse(sut.includes(missingFifteenValue));
        assertTrue(sut.includes(expectedElevenValue));
    }

    @Test
    void test_MyLinkedListAdd() {
        String expectedEmptyResult = "NULL";
        String expectedSecondResult = "[11]->NULL";
        String expectedThirdResult = "[12]->[11]->NULL";
        String expectedFourthResult = "[13]->[12]->[11]->NULL";

        MyLinkedList sut = new MyLinkedList();
        assertEquals(sut.print(), expectedEmptyResult);

        int expectedElevenValue = 11;
        int expectedTwelveValue = 12;
        int expectedThirteenValue = 13;

        sut.add(expectedElevenValue);
        assertEquals(sut.print(), expectedSecondResult);

        sut.add(expectedTwelveValue);
        assertEquals(sut.print(), expectedThirdResult);

        sut.add(expectedThirteenValue);
        assertEquals(sut.print(), expectedFourthResult);
    }

    @Test
    void test_MyLinkedListGetCount() {
        int expectedElevenValue = 11;
        int expectedTwelveValue = 12;
        int expectedThirteenValue = 13;

        int expectedCount = 0;
        MyLinkedList sut = new MyLinkedList();
        assertEquals(expectedCount, sut.getCount());

        expectedCount = 1;
        sut.add(expectedElevenValue);
        assertEquals(expectedCount, sut.getCount());

        expectedCount = 2;
        sut.add(expectedTwelveValue);
        assertEquals(expectedCount, sut.getCount());

        expectedCount = 3;
        sut.addBefore(expectedThirteenValue, expectedTwelveValue);
        assertEquals(expectedCount, sut.getCount());
    }

    @Test
    void test_MyLinkedListAddBefore() {
        String expectedFirstResult = "[13]->[12]->[11]->NULL";
        String expectedAddBeforeResult = "[13]->[12]->[14]->[11]->NULL";

        int expectedElevenValue = 11;
        int expectedTwelveValue = 12;
        int expectedThirteenValue = 13;
        int expectedAddBeforeValue = 14;

        MyLinkedList sut = new MyLinkedList();
        sut.add(expectedElevenValue);
        sut.add(expectedTwelveValue);
        sut.add(expectedThirteenValue);
        assertEquals(sut.print(), expectedFirstResult);

        assertTrue(sut.addBefore(expectedAddBeforeValue, expectedElevenValue));
        assertEquals(sut.print(), expectedAddBeforeResult);
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
