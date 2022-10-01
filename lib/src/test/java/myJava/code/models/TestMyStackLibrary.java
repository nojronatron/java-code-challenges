package myJava.code.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestMyStackLibrary {
    @Test
    public void test_canInstantiateMyStackClass() {
        MyStack sut = new MyStack();
        assertNotNull(sut);
    }
    @Test
    public void test_isEmptyTrueWhenEmpty() {
        MyStack sut = new MyStack();
        assertTrue(sut.isEmpty());
    }
    @Test
    public void test_pushAddsItem() {
        String expectedValue = "alpha";
        MyStack sut = new MyStack();
        sut.push(expectedValue);
        assertFalse(sut.isEmpty());
    }
    @Test
    public void test_popRemovesTopValue() {
        String expectedValue = "alpha";
        MyStack sut = new MyStack();
        sut.push(expectedValue);
        assertFalse(sut.isEmpty());
        String actualResult = (String)sut.pop(); // boxing happening here in this manual cast op
        assertTrue(sut.isEmpty());
        assertEquals(expectedValue, actualResult);
    }
    @Test
    public void test_peekReturnsValueButItemRemains() {
        String expectedValue = "alpha";
        MyStack sut = new MyStack();
        sut.push(expectedValue);
        assertFalse(sut.isEmpty());
        String actualResult = (String)sut.peek();
        assertFalse(sut.isEmpty());
        assertEquals(expectedValue, actualResult);
        actualResult = (String)sut.peek();
        assertFalse(sut.isEmpty());
        assertEquals(expectedValue, actualResult);
    }
    @Test
    public void test_peekThrowsNullPointerExceptionWhenIsEmptyIsTrue() {
        MyStack sut = new MyStack();
        assertTrue(sut.isEmpty());
        assertThrows(NullPointerException.class, ()->{
            sut.peek();
        });
    }
    @Test
    public void test_popThrowsNullPointerExceptionWhenIsEmptyIsTrue() {
        MyStack sut = new MyStack();
        assertTrue(sut.isEmpty());
        assertThrows(NullPointerException.class, ()->{
            sut.pop();
        });
    }
    @Test
    public void test_manyPushCallsAddMoreItems() {
        String expectedValue1 = "Alpha";
        String expectedValue2 = "Bravo";
        String expectedValue3 = "Charlie";
        String expectedValue4 = "Delta";
        MyStack sut = new MyStack();

        sut.push(expectedValue1);
        assertFalse(sut.isEmpty());
        assertEquals(expectedValue1, sut.peek());

        sut.push(expectedValue2);
        assertFalse(sut.isEmpty());
        assertEquals(expectedValue2, sut.peek());

        sut.push(expectedValue3);
        assertFalse(sut.isEmpty());
        assertEquals(expectedValue3, sut.peek());

        sut.push(expectedValue4);
        assertFalse(sut.isEmpty());
        assertEquals(expectedValue4, sut.peek());
    }
    @Test
    public void test_fourPushesFourPopsLeavesNullTopAndBottomAndExpectedLifoReturnOrder() {
        String expectedValue1 = "Alpha";
        String expectedValue2 = "Bravo";
        String expectedValue3 = "Charlie";
        String expectedValue4 = "Delta";
        MyStack sut = new MyStack();
        sut.push(expectedValue1);
        sut.push(expectedValue2);
        sut.push(expectedValue3);
        sut.push(expectedValue4);

        assertFalse(sut.isEmpty());
        assertEquals(expectedValue4, sut.pop());

        assertFalse(sut.isEmpty());
        assertEquals(expectedValue3, sut.pop());

        assertFalse(sut.isEmpty());
        assertEquals(expectedValue2, sut.pop());

        assertFalse(sut.isEmpty());
        assertEquals(expectedValue1, sut.pop());

        assertTrue(sut.isEmpty());
        assertThrows(NullPointerException.class, ()->{
            sut.pop();
        });
    }
}
