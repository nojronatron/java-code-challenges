package myJava.code.models;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestQueueLibrary {
    @Test void testQueue_CanInstantiateEmptyQueue() {
        MyQueue<String> sut = new MyQueue<>();
        assertNotNull(sut);
    }

    @Test void testQueue_IsEmptyReturnsTrue() {
        MyQueue<String> sut = new MyQueue<>();
        assertTrue(sut.isEmpty());
    }

    @Test void testQueue_CanEnqueueSingleValue() {
        MyQueue<Integer> sut = new MyQueue<>();
        assertTrue(sut.isEmpty());
        sut.enqueue(11);
        assertFalse(sut.isEmpty());
    }

    @Test void testQueue_CanDequeueSingleValue() {
        int expectedResult = 11;
        MyQueue<Integer> sut = new MyQueue<>();
        sut.enqueue(expectedResult);
        assertFalse(sut.isEmpty());
        int actualResult = sut.dequeue();
        assertEquals(expectedResult, actualResult);
        assertTrue(sut.isEmpty());
    }

    @Test void testQueue_CanPeekSingleValue() {
        int expectedResult = 11;
        MyQueue<Integer> sut = new MyQueue<>();
        sut.enqueue(expectedResult);
        assertFalse(sut.isEmpty());
        int actualResult = sut.peek();
        assertEquals(expectedResult, actualResult);
        assertFalse(sut.isEmpty());
    }

    @Test void testQueue_GrowAndShrinkQueue() {
        int firstExpectedResult = 11;
        int secondExpectedResult = 12;
        int thirdExpectedResult = 13;
        int fourthExpectedResult = 14;

        MyQueue<Integer> sut = new MyQueue<>();
        sut.enqueue(firstExpectedResult);
        sut.enqueue(secondExpectedResult);
        sut.enqueue(thirdExpectedResult);
        sut.enqueue(fourthExpectedResult);
        assertFalse(sut.isEmpty());
        assertEquals(firstExpectedResult, sut.peek());
        assertFalse(sut.isEmpty());
        assertEquals(firstExpectedResult, sut.dequeue());
        assertFalse(sut.isEmpty());
        assertEquals(secondExpectedResult, sut.dequeue());
        assertFalse(sut.isEmpty());
        assertEquals(thirdExpectedResult, sut.dequeue());
        assertFalse(sut.isEmpty());
        assertEquals(fourthExpectedResult, sut.dequeue());
        assertTrue(sut.isEmpty());
    }

    // start throws exception tests
    @Test void testQueue_PeekEmptyQueueThrowsNullPointerException() {
        MyQueue<String> sut = new MyQueue<>();
        assertThrows(NullPointerException.class, sut::peek); // uses method reference instead of lambda
    }

    @Test void testQueue_DequeueEmptyThrowsNullPointerException() {
        MyQueue<String> sut = new MyQueue<>();
        assertThrows(NullPointerException.class, sut::dequeue);
    }
    // end throws exception tests
}
