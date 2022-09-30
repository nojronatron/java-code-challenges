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
}
